package tests;

import core.Inventory;
import core.Player;

public class runer {

    public static void main(String[] args) {
        Player B = new Player("Be", "O que so faz mierda", 1000, 100, 200, 10, 1412, new Inventory(200, 69));
        Sword espada = new Sword("Agamenon", "Super espada", 2, 5);

        System.out.println(B.getInv().addItem(1));
        System.out.println(B.getInv().addItem(1));
    }
}
