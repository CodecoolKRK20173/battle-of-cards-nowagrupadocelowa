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

        System.out.println(getName() + " select attribute to fight with\n" + "(1) Health\n" + "(2) Intelligence\n" + "(3) Strength\n" + "(4) Dexterity");
        answer = (int)reader.nextInt();

        switch(answer){
            case 1:
                System.out.println("You selected health!");
                return Attributes.HEALTH;
            case 2:
                System.out.println("You selected intelligence");
                return Attributes.INTELLIGENCE;
            case 3:
                System.out.println("You selected strength");
                return Attributes.STRENGTH;
            case 4:
                System.out.println("You selected dexterity");
                return Attributes.DEXTERITY;
        }
        reader.close();
        return null;
    }
}