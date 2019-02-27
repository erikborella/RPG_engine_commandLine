package core;

public class Player extends GameObject {

    public Player(String name, String description, int size, double weight, int maxMana, int maxHealth, int maxStamina, Inventory inv) {
        super(name, description, size, weight);
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
        this.inv = inv;
    }
    private int maxMana;
    private int maxHealth;
    private int maxStamina;

    private double mana;
    private double health;
    private double stamina;

    private GameObject hand;
    private Inventory inv;

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

    public Inventory getInv() {
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

    @Override
    public ActionLog action(){
        return new ActionLog("Você tá vivão", 0,0,0);
    }
}
