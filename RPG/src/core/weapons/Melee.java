package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Melee extends GameObject {

    private String damage;

    public Melee(String name, String description, int size, double weight, String damage) {
        super(name, description, size, weight);
        this.damage = damage;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua espada", 0, 0, 0);
    }
}