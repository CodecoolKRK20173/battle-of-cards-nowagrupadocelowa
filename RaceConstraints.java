import java.util.Random;

public class RaceConstraints{
    private int minHealth;
    private int maxHealth;
    private int minStrenght;
    private int maxStrenght;
    private int minIntelligence;
    private int maxIntelligence;
    private int minDexterity;
    private int maxDexterity;
    private Random generator;

    public RaceConstraints(int minHealth, int maxHealth, int minStrenght, int maxStrenght, 
            int minIntelligence, int maxIntelligence, int minDexterity, int maxDexterity){
        this.minHealth = minHealth;
        this.maxHealth = maxHealth;
        this.minStrenght = minStrenght;
        this.maxStrenght = maxStrenght;
        this.minIntelligence = minIntelligence;
        this.maxIntelligence = maxIntelligence;
        this.minDexterity = minDexterity;
        this.maxDexterity = maxDexterity;

        generator = new Random();
    }

    public int getRandomHealth(){
        return getRandomNumber(minHealth, maxHealth);
    }

    public int getRandomStrenght(){
        return getRandomNumber(minStrenght, maxStrenght);
    }

    public int getRandomIntelligence(){
        return getRandomNumber(minIntelligence, maxIntelligence);
    }

    public int getRandomDexterity(){
        return getRandomNumber(minDexterity, maxDexterity);
    }

    private int getRandomNumber(int min, int max){
        int value = generator.nextInt() % (max - min + 1) + min;
        return value;
    }
}