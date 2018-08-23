import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    private ArrayList<PLayer> players;
    private Player activePlayer;
    private ArrayList<Players> currentTurnPlayers;
    private ArrayList<Card> gamePile;

    public Game(){
        CardBuilder cardBuilder = new CardBuilder();
        this.players = cardBuilder.createPlayers();
        this.currentTurnPlayers = new ArrayList<PLayer>();
        currentTurnPlayers.addAll(players);
        this.activePlayer = this.players[0];
        this.gamePile = new ArrayList<Card>();
    }

    private void playTurn(ArrayList<Player> currentTurnPlayers, Player activePlayer) {
        
        ArrayList<Player> turnWinners = new ArrayList<Player>();

        Attributes attribute = activePlayer.selectCardAttribute();
        turnWinners = cardComparator.compareCards(currentTurnPlayers, attribute);
        // draw
        if (turnWinners.length() > 1) {
            cardsToPile(turnWinners);
            playTurn(turnWinners, activePlayer);
        // 1 player winner
        } else {
            cardsToPile(currentTurnPlayers);
            giveAwardedCards(turnWinners.get(0));
            activePlayer = turnWinners.get(0);
        }
    }

    private void cardsToPile(ArrayList<Player> currentTurnPlayers) {
        for(int i = 0; i < currentTurnPlayers.length(); i++) {
            gamePile.add(currentTurnPlayers.get(i).getHand().pollFirst());
        }
    }

    private void giveAwardedCards(Player player) {
        Iterator gamePileIterator = gamePile.gamePileIterator();
        while(gamePileIterator.hasNext()) {
            player.getHand().add(gamePileIterator.next());
        }
        gamePile.clear();
    }

    public playGame() {
        CardComparator cardComparator = new CardComparator();
        boolean noWinner = true;

        while(!noWinner) {
            if(currentTurnPlayers.length() < players.length()) {
                currentTurnPlayers.clear();
                currentTurnPlayers.addAll(players);
            }
            playTurn(currentTurnPlayers, activePlayer);
        }
    }

    private void winnerChecker() {
        for(int i = 0; i < players.length(); i++) {
            Player tempPlayer = players.get(i);
            if(tempPlayer.getHand().length() == 0) {
                noWinner = false;
                Collections.sort(players, new HowManyCardsComparator());
            }
        }
    }
}