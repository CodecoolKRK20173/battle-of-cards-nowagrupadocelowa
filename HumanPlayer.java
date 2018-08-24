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
        Attributes attribute = null;

        while(answer <=0 || answer > 4){
            UserInterface.SINGLETON.println(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Strength\n" + "(3) Intelligence\n" + "(4) Dexterity");
            try{
                System.out.print("Enter: ");
                answer = (int)reader.nextInt();
            }catch(InputMismatchException e){
                reader = new Scanner(System.in);
                System.out.println("Choose number!");
            }
            
        }

        switch(answer){
            case 1:
                UserInterface.SINGLETON.println("You selected health\n");
                return Attributes.HEALTH;
            case 2:
                UserInterface.SINGLETON.println("You selected strength\n");
                return Attributes.STRENGTH;
            case 3:
                UserInterface.SINGLETON.println("You selected intelligence\n");
                return Attributes.INTELLIGENCE;
            case 4:
                UserInterface.SINGLETON.println("You selected dexterity\n");
                return Attributes.DEXTERITY;
        }
                  
        return attribute;
    }
}