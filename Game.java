import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Game {

    private ArrayList<Player> players;
    private Player activePlayer;
    private ArrayList<Player> currentTurnPlayers;
    private ArrayList<Card> gamePile;
    private boolean isWinner = false;
    private CardComparator cardComparator;
    private ArrayList<Player> turnWinners;
    private UserInterface userInterface;

    public Game(){
        PreparePlayers preparePlayers = new PreparePlayers();
        this.players = preparePlayers.createPlayers();
        this.currentTurnPlayers = new ArrayList<Player>();
        currentTurnPlayers.addAll(players);
        this.activePlayer = this.players.get(0);
        this.gamePile = new ArrayList<Card>();
        this.userInterface = new UserInterface();
        
    }

    public void playGame() {
        cardComparator = new CardComparator();

        while(!isWinner) {
            if(currentTurnPlayers.size() < players.size()) {
                currentTurnPlayers.clear();
                currentTurnPlayers.addAll(players);
            }
            playTurn(currentTurnPlayers, activePlayer);
            winnerChecker();
        }
    }

    private void playTurn(ArrayList<Player> currentTurnPlayers, Player activePlayer) {

        userInterface.SINGLETON.print(activePlayer.getName());
        userInterface.SINGLETON.print(activePlayer.getHand().getFirst());
        Attributes attribute = activePlayer.selectCardAttribute();
        turnWinners = cardComparator.compareCards(currentTurnPlayers, attribute);
        // draw
        if (turnWinners.size() > 1) {
            System.out.println("Draw! play again between players with highest attributes");
            cardsToPile(turnWinners);
            playTurn(turnWinners, activePlayer);
        // 1 player winner
        } else {
            userInterface.SINGLETON.print(" has won this turn");
            cardsToPile(currentTurnPlayers);
            giveAwardedCards(turnWinners.get(0));
            this.activePlayer = turnWinners.get(0);
        }
    }

    private void cardsToPile(ArrayList<Player> currentTurnPlayers) {
        for(int i = 0; i < currentTurnPlayers.size(); i++) {
            gamePile.add(currentTurnPlayers.get(i).getHand().pollFirst());
        }
    }

    private void giveAwardedCards(Player player) {
        Iterator<Card> gamePileIterator = gamePile.iterator();
        while(gamePileIterator.hasNext()) {
            player.getHand().add(gamePileIterator.next());
        }
        gamePile.clear();
    }


    private void winnerChecker() {
        for(int i = 0; i < players.size(); i++) {
            Player tempPlayer = players.get(i);
            userInterface.SINGLETON.print(tempPlayer.getName());
            userInterface.SINGLETON.print(tempPlayer.getHand().size());
            if(tempPlayer.getHand().size() == 0) {
                isWinner = true;
                Collections.sort(players);
            }
        }
    }
}