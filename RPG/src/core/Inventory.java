package core;

import core.idControl.IdKeeper;

import java.util.ArrayList;

/**
 * Essa classe é um inventario para GameObjects
 */
public class Inventory {
    private int maxSize;
    private double maxWeight;
    private ArrayList<GameObject> itens = new ArrayList<GameObject>();

    /**
     * Objeto adicionado ou removido com sucesso
     */
    public final int SUCCESS = 0;

    /**
     * Sem espaço suficiente para adicionar
     */
    public final int NO_WEIGHT = 1;

    /**
     * Objeto já se encontra adicionado
     */
    public final int OBJECT_ALREDY_EXIST = 2;

    /**
     * Objeto não encontrado no IdKeeper
     */
    public final int NULL_OBJECT = 3;

    /**
     * Objeto não esta adicionado no inventario
     */
    public final int OBJECT_NO_IN_INVENTORY = 4;

    /**
     * Cria um novo inventario com um tamnho maximo e um peso maximo
     * @param maxSize Tamanho maximo de itens que podem ser colocados
     * @param maxWeight Peso maximo que voce pode caregar ate ficar pesada
     */
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

    public boolean existId(int objectId) {
        for (GameObject compare : this.itens) {
            if (compare.getId() == objectId) {
                return true;
            }
        }
        return false;
    }

    public int addItem(GameObject objectAdd) {
        if (this.getActualSize() + objectAdd.getSize() > this.maxSize) {
            return NO_WEIGHT;
        } else if (this.existId(objectAdd.getId())) {
            return OBJECT_ALREDY_EXIST;
        } else {
            this.itens.add(objectAdd);
            return SUCCESS;
        }
    }

    public int addItem(int id) {
        GameObject newObject = IdKeeper.getObjectById(id);
        if (newObject == null) {
            return NULL_OBJECT;
        } else  {
            return this.addItem(newObject);
        }
    }

    public int removeItem(GameObject objectRemove) {
        for (GameObject object : this.itens) {
            if (objectRemove == object) {
                this.itens.remove(object);
                return SUCCESS;
            }
        }
        return OBJECT_NO_IN_INVENTORY;
    }

    public int removeItem(int id) {
        GameObject newObject = IdKeeper.getObjectById(id);
        if (newObject == null) {
            return NULL_OBJECT;
        } else {
            return this.removeItem(newObject);
        }
    }


}
