import java.util.ArrayList;

public class CardComparator {

    public ArrayList<Player> compareCards(Player[] thisTurnPlayers, Enum attribute){
        int highestAttribute = 0;
        Player[] winners = new ArrayList<Player>();
        for (Player player : thisTurnPlayers){
            if (player.hand.getFirst().get(attribute) > highestAttribute) {
                highestAttribute = player.hand.getFirst().get(attribute);
                winners.clear();
                winners.add(player);
            }
            else if (player.hand.getFirst().get(attribute) == highestAttribute) {
                winners.add(player);
            }
        }

        return winners;
    }

    
}