package tests;
import core.idControl.AutoId;
import core.idControl.IdListener;
import core.GameObject;

import java.net.IDN;

public class IdListenerTest {
    public class ed extends GameObject {
        public ed(String name, String description, int id, double size) {
            super(name, description, size);
        }
    }

    public void run() {
        ed a = new ed("a", "a", AutoId.getNewId(), 10);
        ed b = new ed("a", "s", AutoId.getNewId(), 10);
        IdListener.add(a);
        IdListener.add(a);

        if (IdListener.getGameObjects().length == 1) {
            System.out.println("Funciona");
        } else {
            System.out.println("Não funciona");
        }
    }
}
