package tests;

import core.CommandInterpreter;
import core.Inventory;
import core.Player;

public class runer {

    public static void main(String[] args) {
        Player B = new Player("Be", "O que so faz mierda", 1000, 100, 200, 10, 1412, new Inventory(200, 69));
        Sword espada = new Sword("Agamenon", "Super espada", 2, 5);

        CommandInterpreter commandInterpreter = new CommandInterpreter(B);
        System.out.println(commandInterpreter.run("Pegar Agamenon"));
        System.out.println(commandInterpreter.run("Jogar fora Agamenon"));
    }
}
