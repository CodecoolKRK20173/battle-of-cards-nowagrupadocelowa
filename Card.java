import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Card{
    private Map<Attributes, Integer> attributes;
    private Races race;
    private String name;
    private String[] randomAdjectives = {"Mighty", "Agile", "Famous", "Common", "Amazing", "Strange",
                                         "Tricky", "Mythical", "Charming", "Sadistic", "Epic", "Dark",
                                         "Wild", "Vivid", "Primal", "Female", "Master"};
    private final int CARD_WIDTH = 30;

    public Card(int health, int strenght, int intelligence, int dexterity, Races race){
        attributes = new HashMap<Attributes, Integer>();
        attributes.put(Attributes.HEALTH, health);
        attributes.put(Attributes.STRENGTH, strenght);
        attributes.put(Attributes.INTELLIGENCE, intelligence);
        attributes.put(Attributes.DEXTERITY, dexterity);

        this.race = race;
        name = GenerateName();
    }

    public int getAttributeValue(Attributes attr){
        return attributes.get(attr).intValue();
    }

    public Races getRace(){
        return race;
    }

    private String GenerateName(){
        String name = "";
        Attributes strongestAttribute = getStrongestAttribute();

        name += getRrandomAdjective();
        name += " ";
        name += race.toString();
        name += " ";
        name += strongestAttribute.toString();

        return name;
    }

    private String getRrandomAdjective(){
        Random generator = new Random();
        return randomAdjectives[generator.nextInt(randomAdjectives.length)];
    }

    private Attributes getStrongestAttribute(){
        Attributes biggestAttribute = Attributes.HEALTH;
        int biggestAttributeValue = 0;

        for (Attributes attr : attributes.keySet()){
            int attrValue = attributes.get(attr);

            if (attrValue >= biggestAttributeValue){
                biggestAttribute = attr;
                biggestAttributeValue = attrValue;
            }
        }

        return biggestAttribute;
    }

    private String center(String string, int width){
        int padSize = width - string.length();
        int padStart = string.length() + (padSize / 2);

        string = String.format("%" + padStart + "s", string);
        string = String.format("%-" + width + "s", string);

        return string;
    }

    private String generateLine(String fill, int width){
        StringBuilder lineBuilder = new StringBuilder();

        for (int i=0; i<width; i++){
            lineBuilder.append(fill);
        }

        return lineBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder cardStringBuilder = new StringBuilder();

        cardStringBuilder.append(" " + generateLine("_", CARD_WIDTH-2) + " \n");
        cardStringBuilder.append("/" + generateLine(" ", CARD_WIDTH-2) + "\\\n");
        cardStringBuilder.append("|" + center(name, CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + center(" ", CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + center("Health: " + getAttributeValue(Attributes.HEALTH), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + center("Strenght: " + getAttributeValue(Attributes.STRENGTH), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + center("Intelligence: " + getAttributeValue(Attributes.INTELLIGENCE), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("|" + center("Dexterity: " + getAttributeValue(Attributes.DEXTERITY), CARD_WIDTH-2) + "|\n");
        cardStringBuilder.append("\\" + generateLine("_", CARD_WIDTH-2) + "/\n");

        return cardStringBuilder.toString();
    }
}