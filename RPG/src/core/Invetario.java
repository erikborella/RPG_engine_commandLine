package core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Invetario {
    private int maxSize;
    private int maxWeight;
    private ArrayList<GameObject> itens = new ArrayList<GameObject>();

    public Invetario(int maxSize, int maxWeight) {
        this.maxSize = maxSize;
        this.maxWeight = maxWeight;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public GameObject[] getItens() {
        GameObject[] inv = new GameObject[itens.size()];
        for (int i = 0; i < inv.length; i++) {
            inv[i] = itens.get(i);
        }
        return inv;
    }
}
