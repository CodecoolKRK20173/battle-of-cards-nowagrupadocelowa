
abstract class Player{
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


    public setHand(LinkedList<Card> hand){
        this.hand = hand;
    }


    public int getAttributeValue(Attributes attribute){
        return hand.get(0).getAttributeValue(attribute);
    }


    abstract protected Attributes selectCardAttribute();
}