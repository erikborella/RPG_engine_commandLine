package tests;

import core.CommandInterpreter;
import core.Inventory;
import core.Player;
import core.idControl.LoadJsonObject;

import java.io.File;
import java.util.Scanner;

public class runer {

    public static void main(String[] args) {
        Sword espada1 = new Sword("Agameno", "uma coisa foda", 10, 20);
        Sword espada2 = new Sword("Agameno1", "uma coisa foda", 10, 20);
        Sword espada3 = new Sword("Agameno2", "uma coisa foda", 10, 20);
        Sword espada4 = new Sword("Agameno3", "uma coisa foda", 10, 20);

        LoadJsonObject loadJsonObject = new LoadJsonObject(new File("/home/erik/Documentos/RPG_engine_commandLine/RPG/src/core/weapons.json"));
        loadJsonObject.load();

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem:");
        String name = input.nextLine();
        System.out.println("Agora me conte um pouco dele: ");
        String desc = input.nextLine();

        Player p = new Player(name, desc, 1000, 100, 100, 100,
                100, 10, new Inventory(11));

        CommandInterpreter commandInterpreter = new CommandInterpreter(p);

        String command = "";
        while (!command.equals("sair")) {
            if (commandInterpreter.isInventoryOpen()) {
                System.out.println("** Seu iventario esta aberto");
            }
            System.out.println("me diga o que fazer");
            command = input.nextLine();
            System.out.println(commandInterpreter.run(command));
        }
    }
}
