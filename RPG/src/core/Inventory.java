package core;

import core.idControl.IdListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    private int maxSize;
    private double maxWeight;
    private ArrayList<GameObject> itens = new ArrayList<GameObject>();

    public Inventory(int maxSize, int maxWeight) {
        this.maxSize = maxSize;
        this.maxWeight = maxWeight;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public double getMaxWeight() {
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

    public int getActualSize() {
        int actualSize = 0;
        for (GameObject object: itens) {
            actualSize += object.getSize();
        }
        return actualSize;
    }

    public boolean addItem(GameObject objectAdd) {
        if (this.getActualSize() + objectAdd.getSize() > this.maxSize) {
            return false;
        } else {
            this.itens.add(objectAdd);
            return true;
        }
    }

    public boolean addItem(int id) {
        GameObject newObject = IdListener.getObjectById(id);
        if (newObject == null) {
            return false;
        } else  {
            return this.addItem(newObject);
        }
    }


}
