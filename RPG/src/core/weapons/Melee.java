package core.weapons;

import core.ActionLog;
import core.GameObject;

/**
 * Objetos para Melees
 */
public class Melee extends GameObject {

    private String damage;

    public Melee(String name, String description, int size, double weight, String damage) {
        super(name, description, size, weight);
        this.damage = damage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua espada", 0, 0, 0);
    }
}