import java.util.HashMap;
import java.util.Map;

public class Card{
    private Map<Attribute, Integer> attributes;
    private Races race;

    public Card(int health, int strenght, int intelligence, int dexterity, int race){
        attributes = new HashMap<Attribute, Integer>();
        attributes.put(Attributes.HEALTH, health);
        attributes.put(Attributes.STRENGHT, strenght);
        attributes.put(Attributes.INTELLIGENCE, intelligence);
        attributes.put(Attributes.DEXTERITY, dexterity);

        this.race = race;
    }

    public int getAttributeValue(Attribute attr){
        return attributes.get(attr).intValue();
    }

    public Races getRace(){
        return race;
    }
}