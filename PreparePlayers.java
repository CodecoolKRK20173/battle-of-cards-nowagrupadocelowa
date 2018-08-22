public class PreparePlayers{
 
    String name;
    LinkedList<Card> cards;

    public Player(String name, ArrayList cards){
        this.name = name;
        this.cards = cards;
    }

    public ArrayList createPlayers(){
        
        String numOfHumansInput = input("How many human players are going to play?");
        String numOfAIInput = input("How many AI players are going to play?");
        int numOfHumans = Integer.parseInt(numOfHumansInput);
        int numOfAI = Integer.parseInt(numOfAIInput); 
        // int allPlayers = numOfHumans + numOfAI;

        ArrayList<MyObject> listOfPlayers = new ArrayList<MyObject>();

        for (int i=0; i<numOfHumans; i++){
                String name = input("What's your nickname?");
                listOfPlayers.add(new Player(name, dealCardsForPlayer()));
        }
        for (int i=0; i<numOfAI; i++){
            String name = "bot" + Integer.toString(i);
            listOfPlayers.add(new Player(name, dealCardsForPlayer()));
        }

        return listOfPlayers;
    }
}