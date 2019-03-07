package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Ranged extends GameObject {

    private int distance;
    private Ammunition ammunition;

    public Ranged(String name, String description, int size, double weight, int distance, Ammunition ammunition) {
        super(name, description, size, weight);
        this.distance = distance;
        this.ammunition = ammunition;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou seu arco", 0, 0, 0);
    }
}