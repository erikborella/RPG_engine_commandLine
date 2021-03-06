package core.weapons;

import core.ActionLog;
import core.GameObject;

/**
 * Objetos para escudos
 */
public class Shield extends GameObject {

    private String defence;

    public Shield(String name, String description, int size, double weight, String defence) {
        super(name, description, size, weight);
        this.defence = defence;
    }

    public String getDefence() {
        return defence;
    }

    public void setDefence(String defence) {
        this.defence = defence;
    }

    public ActionLog action() {
        return new ActionLog("Voce olhou seu escudo", 0, 0, 0);
    }
}