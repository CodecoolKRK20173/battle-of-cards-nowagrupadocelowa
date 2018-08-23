import java.util.List;
import java.util.LinkedList;

public class Deck{
    private LinkedList<Card> cardsList;
    private final int CARDS_PER_PLAYER = 10;
    private CardBuilder cardBuilder;
    
    // public void deck(int players){
    //     cards_per_players = 10;
    //     number_of_players = players;
    //     int all_cards = players * 10;

    //     dealCardsForPlayers();
    // }
    
    public LinkedList<Card> dealCardsForPlayers(){
            
        cardBuilder = new CardBuilder();
        LinkedList<Card> cardsList = new LinkedList<Card>();
        for(int j=0; j < CARDS_PER_PLAYER; j++){
            cardsList.add(cardBuilder.makeCard());
        }

        return cardsList; 
    }

    public LinkedList<Card> getCardList() {
        return cardsList;
    }
}