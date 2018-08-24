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

    public Game() throws InterruptedException {
        PreparePlayers preparePlayers = new PreparePlayers();
        this.players = preparePlayers.createPlayers();
        this.currentTurnPlayers = new ArrayList<Player>();
        currentTurnPlayers.addAll(players);
        this.activePlayer = this.players.get(0);
        this.gamePile = new ArrayList<Card>();
        
    }

    public void playGame() throws InterruptedException {
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

    private void playTurn(ArrayList<Player> currentTurnPlayers, Player activePlayer) throws InterruptedException {

        Thread.sleep(3000);
        UserInterface.SINGLETON.clearScreen();
        UserInterface.SINGLETON.println(activePlayer.getHand().getFirst().toString());
        Attributes attribute = activePlayer.selectCardAttribute();
        turnWinners = cardComparator.compareCards(currentTurnPlayers, attribute);
        // draw
        if (turnWinners.size() > 1) {
            System.out.println("Draw! play again between players with highest attributes");
            cardsToPile(turnWinners);
            playTurn(turnWinners, activePlayer);
        // 1 player winner
        } else {
            UserInterface.SINGLETON.println(turnWinners.get(0).getName() + " has won this turn \n");
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


    private void winnerChecker() throws InterruptedException {
        for(int i = 0; i < players.size(); i++) {
            Player tempPlayer = players.get(i);
            UserInterface.SINGLETON.print(tempPlayer.getName() + " " + tempPlayer.getHand().size() + " Cards on hand\n");
            if(tempPlayer.getHand().size() == 0) {
                isWinner = true;
            }
        }
        if(isWinner) {
            Collections.sort(players, Collections.reverseOrder());
            UserInterface.SINGLETON.print("Congratullations " + players.get(0).getName() + " You have won!\n");
            Thread.sleep(3000);
        }
    }
}