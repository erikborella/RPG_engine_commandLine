package core;

import core.idControl.IdKeeper;

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

    private double maxCarryWeight;

    private GameObject hand;
    private Inventory inv;

    /**
     * Cria um Jogador
     * @param name Nome do jogador
     * @param description Descrição dele
     * @param size Tamanho
     * @param weight Peso
     * @param maxMana Mana maxima no começo
     * @param maxHealth Vida maxima no começo
     * @param maxStamina Stamina maxima no começo
     * @param maxCarryWeight Peso maximo que ele vai caregar no começo
     * @param inv Instancia de um objeto inventario
     */
    public Player(String name, String description, int size, double weight, int maxMana, int maxHealth, int maxStamina,
                  double maxCarryWeight, Inventory inv) {
        super(name, description, size, weight);
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxStamina = maxStamina;
        this.stamina = maxStamina;
        this.maxCarryWeight = maxCarryWeight;
        this.inv = inv;
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
