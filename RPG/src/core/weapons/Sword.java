package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Sword extends GameObject {
    public Sword(String name, String description, int size, double weight) {
        super(name, description, size, weight);
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou sua espada", 0, 0, 0);
    }
}