package core;
import java.util.Random;

/**
 * Classe que simula dados de RPG
 */
public class Dice {

    private Random gerador = new Random();

    private int d(int n){
        int dado = gerador.nextInt(n+1);
        return dado;
    }

    /**
     * Um dado d4
     * @return numero de 1 a 4
     */
    public int d4(){
        return this.d(4);
    }

    /**
     * Um dado d6
     * @return numero de 1 a 6
     */
    public int d6(){
        return this.d(6);
    }

    /**
     * Um dado d8
     * @return numero de 1 a 8
     */
    public int d8(){
        return this.d(8);
    }

    /**
     * Um dado d10
     * @return numero de 1 a 10
     */
    public int d10(){
        return this.d(10);
    }

    /**
     * Um dado d12
     * @return numero de 1 a 12
     */
    public int d12(){
        return this.d(12);
    }

    /**
     * Um dado d20
     * @return numero de 1 a 20
     */
    public int d20(){
        return this.d(20);
    }

    /**
     * Um dado d100
     * @return numero de 1 a 100
     */
    public int d100(){
        return this.d(100);
    }


}
