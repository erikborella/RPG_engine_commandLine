package core;
import java.util.Random;

public class Dice {

    Random gerador = new Random();

    private int d(int n){
        int dado = gerador.nextInt(n+1);
        return dado;
    }
    public int d4(){
        return this.d(4);
    }
    public int d6(){
        return this.d(6);
    }
    public int d8(){
        return this.d(8);
    }
    public int d10(){
        return this.d(10);
    }
    public int d12(){
        return this.d(12);
    }
    public int d20(){
        return this.d(20);
    }
    public int d100(){
        return this.d(100);
    }


}
