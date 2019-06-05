package core;

/**
 * Classe player, representa o jogador com vida, mana, e stamina.
 * Tem um inventario e uma mão para segurar seus itens. E um quantidade de peso maximo que voce pode caregar
 */
public class Player extends GameObject {

    private int maxMana;
    private int maxHealth;
    private int maxStamina;

    private double mana;
    private double health;
    private double stamina;
    private int level;


    /*
    * Stats do player, inicialmente vão setados na criação do personagem
    * e posteriormente são aumentados com o aumento no level do personagem
    * */
    private int strength;
    private int dexterity;
    private int contituition;
    private int inteligence;
    private int wisdom;
    private int charisma;

    private double maxCarryWeight;

    private GameObject hand;
    private Chest inv;

    public Player(String name, String description, int size, double weight, int maxMana, int maxHealth, int maxStamina, double mana, double health, double stamina, int level, int strength, int dexterity, int contituition, int inteligence, int wisdom, int charisma, Chest inv) {
        super(name, description, size, weight);
        this.maxMana = maxMana;
        this.maxHealth = maxHealth;
        this.maxStamina = maxStamina;
        this.mana = mana;
        this.health = health;
        this.stamina = stamina;
        this.level = level;
        this.strength = strength;
        this.dexterity = dexterity;
        this.contituition = contituition;
        this.inteligence = inteligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.inv = inv;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getContituition() {
        return contituition;
    }

    public void setContituition(int contituition) {
        this.contituition = contituition;
    }

    public int getInteligence() {
        return inteligence;
    }

    public void setInteligence(int inteligence) {
        this.inteligence = inteligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public double getMana() {
        return mana;
    }

    public double getHealth() {
        return health;
    }

    public double getStamina() {
        return stamina;
    }

    public GameObject getHand() {
        return hand;
    }

    public Chest getInv() {
        return inv;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public void setHand(GameObject hand) {
        this.hand = hand;
    }

    public double getMaxCarryWeight() {
        return maxCarryWeight;
    }

    public void setMaxCarryWeight(double maxCarryWeight) {
        this.maxCarryWeight = maxCarryWeight;
    }

    public int removeItem(GameObject object) {
        if (object == this.hand) {
            this.hand = null;
        }
        return this.inv.removeItem(object);
    }

    @Override
    public ActionLog action(){
        return new ActionLog("Você tá vivão", 0,0,0);
    }
}
