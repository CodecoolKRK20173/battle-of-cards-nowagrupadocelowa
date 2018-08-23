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
        Scanner reader;
        int answer = 0;
        Attributes attribute = null;
        
        while(answer <=0 || answer > 4){
            reader = new Scanner(System.in);
            System.out.println(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Intelligence\n" + "(3) Strength\n" + "(4) Dexterity");
            try{
                System.out.print("Enter: ");
                answer = (int)reader.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Choose number!");
            }
            
        }

        switch(answer){
            case 1:
                System.out.println("\nYou selected health!\n");
                attribute = Attributes.HEALTH;
                break;
            case 2:
                System.out.println("\nYou selected intelligence\n");
                attribute = Attributes.INTELLIGENCE;
                break;
            case 3:
                System.out.println("\nYou selected strength\n");
                attribute = Attributes.STRENGTH;
                break;
            case 4:
                System.out.println("\nYou selected dexterity\n");
                attribute = Attributes.DEXTERITY;
                break;
        }
                  
        return attribute;
    }
}