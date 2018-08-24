import java.util.Scanner;
import java.util.InputMismatchException;
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
        Attributes attribute;

        while(answer <=0 || answer > 4){
            UserInterface.SINGLETON.println(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Strength\n" + "(3) Intelligence\n" + "(4) Dexterity");
            try{
                UserInterface.SINGLETON.print("Enter: ");
                answer = (int)reader.nextInt();
            }catch(InputMismatchException e){
                reader = new Scanner(System.in);
                UserInterface.SINGLETON.println("Choose number!");
            }
        }

        switch(answer){
            case 1:
                message = "You selected health\n";
                attribute = Attributes.HEALTH;
            case 2:
                message = "You selected strength\n";
                attribute = Attributes.STRENGTH;
            case 3:
             message = "You selected intelligence\n";
                attribute = Attributes.INTELLIGENCE;
            case 4:
                message = "You selected dexterity\n";
                attribute = Attributes.DEXTERITY;
            default:
                message = "";
                attribute = null;
        }

        UserInterface.SINGLETON.println(message);
        reader.close();        
        return attribute;
    }
}