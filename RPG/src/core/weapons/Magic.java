package core.weapons;

import core.ActionLog;
import core.GameObject;

/**
 * Objetos para magias
 */
public class Magic extends Ranged {

    private double mana;

    public Magic(String name, String description, int size, double weight, int distance, String damage, double mana) {
        super(name, description, size, weight, distance, damage);
        this.mana = mana;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public ActionLog action()  {
        return new ActionLog("Voce olhou sua Magia(?)", 0, 0, 0);
    }
}
