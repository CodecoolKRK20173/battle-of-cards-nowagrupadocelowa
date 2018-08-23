import java.util.List;
import java.util.LinkedList;

class AIPlayer extends Player{
    
    
    public AIPlayer(String name, LinkedList<Card> hand){
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