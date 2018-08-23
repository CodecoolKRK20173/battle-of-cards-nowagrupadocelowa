import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class CardBuilder{
    private HashMap<Races, RaceConstraints> constraintsMap;
    private RaceConstraints elfConstraints;
    private RaceConstraints humanConstraints;
    private RaceConstraints orcConstraints;
    private RaceConstraints dwarfConstraints;

    CardBuilder(){
        constraintsMap = new HashMap<Races, RaceConstraints>();
        initializeRaceConstraints();
        makeConstraintsMap();
    }
        
    private void makeConstraintsMap(){
        constraintsMap.put(Races.HUMAN, humanConstraints); //dopisac statystyki
        constraintsMap.put(Races.ELF, elfConstraints);
        constraintsMap.put(Races.DWARF, dwarfConstraints);
        constraintsMap.put(Races.ORC, orcConstraints);
    }

    public Races randomRace(){
        Random generator = new Random();
        List<Races> keys = new ArrayList<Races>();
        keys.addAll(constraintsMap.keySet());
        return keys.get(generator.nextInt(3));
    }

    public Card makeCard(){
        Races race = randomRace();
        RaceConstraints tempConstraint = constraintsMap.get(race);
        return new Card(tempConstraint.getRandomHealth(), tempConstraint.getRandomStrenght(), tempConstraint.getRandomIntelligence(), tempConstraint.getRandomDexterity(), race);
    }
    
    
    public void initializeRaceConstraints(){
        elfConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(40)
                        .minDexterity(50)
                        .minIntelligence(60)
                        .minStrenght(30)
                        .build();
        humanConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(30)
                        .minDexterity(60)
                        .minIntelligence(50)
                        .minStrenght(40)
                        .build();
        dwarfConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(60)
                        .minDexterity(30)
                        .minIntelligence(40)
                        .minStrenght(50)
                        .build();
        orcConstraints = new RaceConstraints.RaceConstraintsBuilder()
                        .minHealth(50)
                        .minIntelligence(30)
                        .minDexterity(40)
                        .minStrenght(60)
                        .build();
    }
}
