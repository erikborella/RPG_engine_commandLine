package core.weapons;

import core.ActionLog;
import core.GameObject;

public class Magic extends GameObject {

    //TODO> Criar as magias/outras coisas de mago

    public Magic(String name, String description, int size, double weight) {
        super(name, description, size, weight);
    }

    public ActionLog action()  {
        return new ActionLog("Voce olhou sua Magia(?)", 0, 0, 0);
    }
}
