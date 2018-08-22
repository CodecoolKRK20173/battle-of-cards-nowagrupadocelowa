import java.util.Scanner;
class HumanPlayer extends Player{


    protected Attributes selectCardAttribute(){
        Scanner reader = new Scanner(System.in);
        int answer = null;

        System.out.println(name + " select attribute to fight with\n" + "(1) Health\n" + "(2) Intelligence\n" + "(3) Strength\n" + "(4) Dexterity");
        answer = reader.nextInt();

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

    }
}