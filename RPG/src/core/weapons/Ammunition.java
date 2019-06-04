package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Ammunition extends GameObject {

    private String damage;
    private int quantity;

    public Ammunition(String name, String description, int size, double weight, String damage, int quantity) {
        super(name, description, size, weight);
        this.damage = damage;
        this.quantity = quantity;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua munição", 0, 0, 0);
    }
}
