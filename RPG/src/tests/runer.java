package tests;

import core.Chest;
import core.Dice;
import core.GameObject;
import core.Player;
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
        Player erik = new Player("Erik", "Lixo", 100, 60, 10, 10, 20,
                10, new Chest("Inventario de Erik", "Seu fiel bau", 0, 0, 10));

    }
}
