package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Ammunition extends GameObject {

    private double damage;
    private int quantity;

    public Ammunition(String name, String description, int size, double weight, double damage, int quantity) {
        super(name, description, size, weight);
        this.damage = damage;
        this.quantity = quantity;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua munição", 0, 0, 0);
    }
}
