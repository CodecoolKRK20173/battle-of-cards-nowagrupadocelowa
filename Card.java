import java.util.HashMap;
import java.util.Map;

public class Card{
    private Map<Attributes, Integer> attributes;
    private Races race;

    public Card(int health, int strenght, int intelligence, int dexterity, Races race){
        attributes = new HashMap<Attributes, Integer>();
        attributes.put(Attributes.HEALTH, health);
        attributes.put(Attributes.STRENGTH, strenght);
        attributes.put(Attributes.INTELLIGENCE, intelligence);
        attributes.put(Attributes.DEXTERITY, dexterity);

        this.race = race;
    }

    public int getAttributeValue(Attributes attr){
        return attributes.get(attr).intValue();
    }

    public Races getRace(){
        return race;
    }

    @Override
    public String toString() {
        String result = "";
        for(Attributes attribute : attributes.keySet()) {
            result += attribute.name() + ": " + attributes.get(attribute) + "\n";
        }
        return result;
    }
}