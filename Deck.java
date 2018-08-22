public class Deck{
    private LinkedList<Card> cardsList = new LinkedList<Card>();
    private final int CARDS_PER_PLAYER;
    private int number_of_players;
    
    // public void deck(int players){
    //     cards_per_players = 10;
    //     number_of_players = players;
    //     int all_cards = players * 10;

    //     dealCardsForPlayers();
    // }
    
    public LinkedList<Card> dealCardsForPlayers(){
        CARDS_PER_PLAYER = 10;
            
        LinkedList<Card> cardsList = new LinkedList<Card>();
        for(int j=0; j < CARDS_PER_PLAYER; j++){
            cardsList.add(getCard());
        }

        return cardsList; 
    }
}