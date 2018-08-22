public class Deck{
    private LinkedList<Card> name = new LinkedList<Card>();
    private int cards_per_player;
    private int number_of_players;
    
    // public void deck(int players){
    //     cards_per_players = 10;
    //     number_of_players = players;
    //     int all_cards = players * 10;

    //     dealCardsForPlayers();
    // }
    
    public LinkedList<Card> dealCardsForPlayers(){
        cards_per_players = 10;
        for(int i=0; i<number_of_players; i++){
            
            LinkedList<Card> name = new LinkedList<Card>();
            for(int j=0; j<cards_per_player; j++){
                name.add(getCard());
            }

            return name; 
        }
    }
}