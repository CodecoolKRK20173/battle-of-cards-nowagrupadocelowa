import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PreparePlayers{

    public ArrayList createPlayers(){
        UserInterface userInterface = new UserInterface();
        boolean isNum = false;
        int numOfHumans=0;
        int numOfAI=0;
        Scanner scanner = new Scanner(System.in);

        while(!isNum)
        {
            try
            {
                numOfHumans = scanner.nextInt();
                numOfAI = scanner.nextInt();
                isNum=true;
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Integers only, please.");
            }
        }        
        
        Deck deck = new Deck();

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