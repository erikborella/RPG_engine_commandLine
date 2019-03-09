package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Mage extends GameObject {

    //TODO> Criar as magias/outras coisas de mago

    public Mage(String name, String description, int size, double weight) {
        super(name, description, size, weight);
    }

    public ActionLog action()  {
        return new ActionLog("Voce olhou seu mago(?)", 0, 0, 0);
    }
}
