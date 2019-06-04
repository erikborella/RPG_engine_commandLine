package tests;

import core.GameObject;
import core.idControl.LoadObject;
import core.map.Map;
import core.map.MapCreator;
import core.map.mapIdControl.MapKeeper;

import java.io.File;
import java.io.FileNotFoundException;

public class runer {

    public static void main(String[] args) {

        LoadObject a = new LoadObject(new File("/home/erik/Documentos/RPG_engine_commandLine/RPG/src/core/weapons/weapons.json"));

        GameObject b = a.getByName("Adaga");
        System.out.println(b);
        b = a.getByName("Arco_Curto_de_Madeira");
        System.out.println(b);

    }
}
