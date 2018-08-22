import java.util.ArrayList;
import java.util.List;

public class CardComparator {

    public ArrayList<Player> compareCards(ArrayList<Player> thisTurnPlayers, Attributes attribute){
        int highestAttribute = 0;
        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : thisTurnPlayers){
            if (player.getAttributeValue(attribute) > highestAttribute) {
                highestAttribute = player.getAttributeValue(attribute);
                winners.clear();
                winners.add(player);
            }
            else if (player.getAttributeValue(attribute) == highestAttribute) {
                winners.add(player);
            }
        }

        return winners;
    }

    
}