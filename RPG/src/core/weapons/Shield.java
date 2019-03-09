package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Shield extends GameObject {

    private int defence;

    public Shield(String name, String description, int size, double weight, int defence) {
        super(name, description, size, weight);
        this.defence = defence;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou seu escudo", 0, 0, 0);
    }
}