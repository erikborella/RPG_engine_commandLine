package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Melee extends GameObject {

    private double damage;

    public Melee(String name, String description, int size, double weight, double damage) {
        super(name, description, size, weight);
        this.damage = damage;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua espada", 0, 0, 0);
    }
}