public enum Attributes{
    HEALTH("Guardian"), 
    INTELLIGENCE("Wizard"), 
    STRENGTH("Berserk"), 
    DEXTERITY("Rouge");

    private String characterClassHavingThisAttributeAsStrongest;

    Attributes(String adj){
        characterClassHavingThisAttributeAsStrongest = adj;
    }

    @Override
    public String toString() {
        return characterClassHavingThisAttributeAsStrongest;
    }
}