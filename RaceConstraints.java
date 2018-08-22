import java.util.Random;

public class RaceConstraints{
    private final int minHealth;
    private final int maxHealth;
    private final int minStrenght;
    private final int maxStrenght;
    private final int minIntelligence;
    private final int maxIntelligence;
    private final int minDexterity;
    private final int maxDexterity;
    private Random generator;

    private RaceConstraints(RaceConstraintsBuilder builder){
        this.minHealth = builder.minHealth;
        this.maxHealth = builder.maxHealth;
        this.minStrenght = builder.minStrenght;
        this.maxStrenght = builder.maxStrenght;
        this.minIntelligence = builder.minIntelligence;
        this.maxIntelligence = builder.maxIntelligence;
        this.minDexterity = builder.minDexterity;
        this.maxDexterity = builder.maxDexterity;

        generator = new Random();
    }

    public String getTest(){
        return minHealth + " " + maxHealth;
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
        int value = generator.nextInt(max - min + 1) + min;
        return value;
    }

    public static class RaceConstraintsBuilder{
        public int minHealth;
        public int maxHealth;
        private int minStrenght;
        private int maxStrenght;
        private int minIntelligence;
        private int maxIntelligence;
        private int minDexterity;
        private int maxDexterity;

        public RaceConstraintsBuilder(){
            minHealth = 0;
            maxHealth = 100;
            minStrenght = 0;
            maxStrenght = 20;
            minIntelligence = 0;
            maxIntelligence = 20;
            minDexterity = 0;
            maxDexterity = 20;
        }

        public RaceConstraintsBuilder minHealth(int minHealth){
            this.minHealth = minHealth;
            return this;
        }

        public RaceConstraintsBuilder maxHealth(int maxHealth){
            this.maxHealth = maxHealth;
            return this;
        }

        public RaceConstraintsBuilder minStrenght(int minStrenght){
            this.minStrenght = minStrenght;
            return this;
        }

        public RaceConstraintsBuilder maxStrenght(int maxStrenght){
            this.maxStrenght = maxStrenght;
            return this;
        }

        public RaceConstraintsBuilder minIntelligence(int minIntelligence){
            this.minIntelligence = minIntelligence;
            return this;
        }

        public RaceConstraintsBuilder maxIntelligence(int maxIntelligence){
            this.maxIntelligence = maxIntelligence;
            return this;
        }

        public RaceConstraintsBuilder minDexterity(int minDexterity){
            this.minDexterity = minDexterity;
            return this;
        }

        public RaceConstraintsBuilder maxDexterity(int maxDexterity){
            this.maxDexterity = maxDexterity;
            return this;
        }

        public RaceConstraints build(){
            return new RaceConstraints(this);
        }
    }
}