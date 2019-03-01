package tests;
import core.ActionLog;
import core.idControl.AutoId;
import core.idControl.IdKeeper;
import core.GameObject;

public class IdListenerTest {
    public class ed extends GameObject {
        public ed(String name, String description, int size, double weight) {
            super(name, description, size, weight);
        }
        @Override
        public ActionLog action() {
            return new ActionLog("", 0, 0, 0);
        }
    }

    public void run() {
        ed a = new ed("a", "a", AutoId.getNewId(), 10);
        ed b = new ed("a", "s", AutoId.getNewId(), 10);
        IdKeeper.add(a);
        IdKeeper.add(a);

        if (IdKeeper.getGameObjects().length == 1) {
            System.out.println("Funciona");
        } else {
            System.out.println("Não funciona");
        }
    }


}
