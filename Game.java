import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.smartcardio.Card;

public class Game {


    private ArrayList<PLayer> players;
    private Player activePlayer;
    private ArrayList<Players> thisTurnPlayers;
    private ArrayList<Card> gamePile;

    public Game(){
        this.players = createPlayers();
        this.thisTurnPLayers = new ArrayList<PLayer>();
        thisTurnPlayers.addAll(players);
        this.activePlayer = this.players[0];
        this.gamePile = new ArrayList<Card>();
    }

    private void playTurn(ArrayList<Player> thisTurnPlayers, Player activePlayer) {

        ArrayList<Player> turnWinners = new ArrayList<Player>();
        Enum attribute = activePlayer.selectCardAttribute();
        turnWinners = cardComparator.compareCards(thisTurnPlayers, attribute);
        // draw
        if (turnWinners.length() > 1) {
            cardsToPile(turnWinners);
            playTurn(turnWinners, activePlayer);
        // 1 player winner
        } else {
            cardsToPile(thisTurnPlayers);
            giveAwardedCards(turnWinners.get(0));
            activePlayer = turnWinners.get(0);
        }
    }

    private void cardsToPile(ArrayList<Player> thisTurnPlayers) {
        for(int i = 0; i < thisTurnPlayers.length(); i++) {
            gamePile.add(thisTurnPlayers.get(i).getHand().pollFirst());
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
            if(thisTurnPlayers.length() < players.length()) {
                thisTurnPlayers.clear();
                thisTurnPlayers.addAll(players);
            }
            playTurn(thisTurnPlayers, activePlayer);
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