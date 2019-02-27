package core;

public class Player extends GameObject {

    public Player(String name, String description, int id, double size) {
        super(name, description, id, size);
    }


    private int maxMana;
    private int maxHealth;
    private int maxStamina;

    private double mana;
    private double health;
    private double stamina;

    private GameObject hand;
}
