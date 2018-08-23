import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class PreparePlayers{

    public ArrayList createPlayers(){
        
        UserInterface userInterface = new UserInterface();
        String numOfHumansInput = userInterface.input("How many human players are going to play?");
        String numOfAIInput = userInterface.input("How many AI players are going to play?");
        int numOfHumans = Integer.parseInt(numOfHumansInput);
        int numOfAI = Integer.parseInt(numOfAIInput);
        Deck deck = new Deck();
        // int allPlayers = numOfHumans + numOfAI;

        ArrayList<Player> listOfPlayers = new ArrayList<Player>();

        for (int i=0; i<numOfHumans; i++){
                String name = userInterface.input("What's your nickname?");
                listOfPlayers.add(new HumanPlayer(name, deck.dealCardsForPlayers()));
        }
        for (int i=0; i<numOfAI; i++){
            String name = "bot" + Integer.toString(i);
            listOfPlayers.add(new AIPlayer(name, deck.dealCardsForPlayers()));
        }

        return listOfPlayers;
    }
}