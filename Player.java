import java.util.List;
import java.util.LinkedList;

abstract class Player implements Comparable<Player> {
    private LinkedList<Card> hand;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public LinkedList<Card> getHand(){
        return hand;
    }

    public void setHand(LinkedList<Card> hand){
        this.hand = hand;
    }

    public int getAttributeValue(Attributes attribute){
        return hand.get(0).getAttributeValue(attribute);
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.getHand().size(), other.getHand().size());
    }

    abstract protected Attributes selectCardAttribute();
}