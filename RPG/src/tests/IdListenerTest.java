package tests;
import core.ActionLog;
import core.idControl.AutoId;
import core.idControl.IdKeeper;
import core.GameObject;
import core.weapons.Melee;
import core.idControl.LoadObject;

import java.io.File;

public class IdListenerTest {
    public void run() {
        Melee a = (Melee) new LoadObject(new File("/home/erik/Documentos/RPG_engine_commandLine/RPG/src/core/weapons/weapons.json")).getByName("Adaga");
        System.out.println(IdKeeper.add(a));

        if (IdKeeper.getGameObjects().length == 1) {
            System.out.println("Funciona");
        } else {
            System.out.println("Não funciona");
        }
    }


}
