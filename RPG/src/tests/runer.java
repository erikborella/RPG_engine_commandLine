package tests;

import core.Dice;
import core.idControl.LoadObject;
import core.map.Map;
import core.map.MapCreator;
import core.map.MapLink;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runer {

    public static void main(String[] args) throws FileNotFoundException, MapCreator.CurrentMapSerializeExecption {
        Scanner input = new Scanner(System.in);

        LoadObject loadObject = new LoadObject(new File("RPG/src/core/weapons/json"));
        System.out.println(loadObject.getByName("Adaga"));

    }
}
