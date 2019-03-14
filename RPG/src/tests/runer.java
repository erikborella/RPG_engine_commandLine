package tests;

import core.map.Map;
import core.map.MapCreator;
import core.map.mapIdControl.MapKeeper;

import java.io.File;
import java.io.FileNotFoundException;

public class runer {

    public static void main(String[] args) {


        try {
            MapCreator a = new MapCreator(new File("/home/erik/Documentos/RPG_engine_commandLine/map1.map"));
            Map b = a.convertMap();
            System.out.println(MapKeeper.getTreeLinks());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MapCreator.CurrentMapSerializeExecption e) {
            System.out.println(e.getMessage());
        }

    }
}
