import java.util.HashMap;
import java.util.Map;


public class Card{
    private Map<Attribute, Integer> attributes;
    private Races race;

    public Card(int health, int strenght, int intelligence, int dexterity, int race){
        attributes = new HashMap<Attribute, Integer>();
        attributes.put(Attribute.HEALTH, health);
        attributes.put(Attribute.STRENGHT, strenght);
        attributes.put(Attribute.INTELLIGENCE, intelligence);
        attributes.put(Attribute.DEXTERITY, dexterity);

        this.race = race;
    }

    public int getAttributeValue(Attribute attr){
        return attributes.get(attr).intValue();
    }

    public Races getRace(){
        return race;
    }
}