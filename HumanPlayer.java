import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

class HumanPlayer extends Player{
    
    public HumanPlayer(String name, LinkedList<Card> hand){
        setName(name);
        setHand(hand);
    }

    protected Attributes selectCardAttribute(){
        Scanner reader = new Scanner(System.in);
        int answer = 0;
        String message;

        UserInterface.SINGLETON.print(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Strength\n" + "(3) Intelligence\n" + "(4) Dexterity");
        answer = (int)reader.nextInt();

        switch(answer){
            case 1:
                UserInterface.SINGLETON.println("You selected health");
                return Attributes.HEALTH;
            case 2:
                UserInterface.SINGLETON.println("You selected strength");
                return Attributes.STRENGTH;
            case 3:
                UserInterface.SINGLETON.println("You selected intelligence");
                return Attributes.INTELLIGENCE;
            case 4:
                UserInterface.SINGLETON.println("You selected dexterity");
                return Attributes.DEXTERITY;
        }
        return null;

        /// TO DO
        // UserInterface.SINGLETON.println();
        // reader.close();
        // return null;
    }
}