class AIPlayer extends Player{
    
    
    public HumanPlayer(String name, LinkedList<Card> hand){
        setName(name);
        setHand(hand);
    }

    protected Attributes selectCardAttribute(){
        int highestValue = 0;
        Attributes highestAttribute = null;

        for(Attributes attribute: Attributes.values()){
            int tempAttributeValue = getHand().getFirst().getAttributeValue(attribute);

            if(highestValue < tempAttributeValue){
                highestValue = tempAttributeValue;
                highestAttribute = attribute;
            }
        }
        return highestAttribute;
    }
}