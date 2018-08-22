import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
class CardBuilder{
    private HashMap<Races, RaceConstraints> constraintsMap;

    CardBuilder(){
        constraintsMap = new HashMap<Races, RaceConstraints>();

    }

    
    private void makeConstraintsMap(){
        constraintsMap.put(Races.HUMAN, new RaceConstraints()); //dopisac statystyki
        constraintsMap.put(Races.ELF, new RaceConstraints());
        constraintsMap.put(Races.DWARF, new RaceConstraints());
        constraintsMap.put(Races.ORC, new RaceConstraints());
    }


    public Races randomRace(){
        Random generator = new Random();
        ArrayList<Races> keys = new ArrayList<Races>(constraintsMap.keySet().toArray());
        return keys.get(generator.nextInt(3));
    }


    public Card makeCard(){
        Races race = randomRace();
        RaceConstraints tempConstraint = constrainsMap.get(race);
        return new Card(tempConstraint.getRandomHealth(), tempConstraint.getRandomStrenght(), tempConstraint.getRandomIntelligence(), tempConstraint.getRandomDexterity(), race);
    }
    //losowanie rasy i losowanie statystyk karty i jej zwrocenie, podac statystyki w konstruktorze
}
