package core.weapons;

import core.ActionLog;
import core.GameObject;
/**
 * Objetos para ranged
 */
public class Ranged extends GameObject {

    private int distance;
    private String damage;

    public Ranged(String name, String description, int size, double weight, int distance, String damage) {
        super(name, description, size, weight);
        this.distance = distance;
        this.damage = damage;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou seu arco", 0, 0, 0);
    }
}