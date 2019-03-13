package tests;

import core.CommandInterpreter;
import core.Inventory;
import core.Player;
import core.idControl.IdKeeper;
import core.idControl.IdKeeperInventory;
import core.idControl.LoadJsonObject;
import core.Dice;
import core.map.Map;
import core.map.MapCreator;
import core.map.mapIdControl.MapKeeper;
import core.weapons.Melee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runer {

    public static void main(String[] args) {


        try {
            MapCreator a = new MapCreator(new File("/home/erik/Documentos/RPG_engine_commandLine/map1.map"));
            Map b = a.serializeMap();
            System.out.println(MapKeeper.getMapByName("map1.map"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Digite o nome do seu personagem:");
//        String name = input.nextLine();
//        System.out.println("Agora me conte um pouco dele: ");
//        String desc = input.nextLine();
//
//        Player p = new Player(name, desc, 1000, 100, 100, 100,
//                100, 10, new Inventory(11));
//
//        CommandInterpreter commandInterpreter = new CommandInterpreter(p);
//
//        String command = "";
//        while (!command.equals("sair")) {
//            if (commandInterpreter.isInventoryOpen()) {
//                System.out.println("** Seu iventario esta aberto");
//            }
//            System.out.println("me diga o que fazer");
//            command = input.nextLine();
//            System.out.println(commandInterpreter.run(command));
//        }
    }
}
