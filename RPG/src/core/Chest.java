package core;

import core.idControl.IdKeeper;

import java.util.ArrayList;

/**
 * Essa classe é um bau para GameObjects
 */
public class Chest extends GameObject {
    private int maxSize;
    private ArrayList<GameObject> itens = new ArrayList<GameObject>();

    /**
     * Objeto adicionado ou removido com sucesso
     */
    public final int SUCCESS = 0;

    /**
     * Sem espaço suficiente para adicionar
     */
    public final int NO_SIZE = 1;

    /**
     * Objeto já se encontra adicionado
     */
    public final int OBJECT_ALREDY_EXIST = 2;

    /**
     * Objeto não encontrado no IdKeeper
     */
    public final int NULL_OBJECT = 3;

    /**
     * Objeto não esta adicionado no bau
     */
    public final int OBJECT_NO_IN_INVENTORY = 4;

    /**
     * Cria um novo bau com um tamnho maximo
     * @param maxSize Tamanho maximo de itens que podem ser colocados
     */
    public Chest(String name, String description, int size, double weight, int maxSize) {
        super(name, description, size, weight);
        this.maxSize = maxSize;
    }

    /**
     * Retorna o tamanho maximo do bau
     * @return tamanho maximo do bau
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * Define o tamanho maximo do bau
     * @param maxSize tamanho maximo do bau
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Retorna um vetor de GameObjests com todos os objetos do bau
     * @return Objetos do bau
     */
    public GameObject[] getItens() {
        GameObject[] inv = new GameObject[itens.size()];
        for (int i = 0; i < inv.length; i++) {
            inv[i] = itens.get(i);
        }
        return inv;
    }

    /**
     * Retorna a soma do tamanho de todos os itens no bau
     * @return tamanho atual do bau
     */
    public int getActualSize() {
        int actualSize = 0;
        for (GameObject object: itens) {
            actualSize += object.getSize();
        }
        return actualSize;
    }

    /**
     * Retorna a soma dos pesos de todos os itens do bau
     * @return peso atual do bau
     */
    public double getActualWeight() {
        double actualWeight = 0;
        for (GameObject object: itens) {
            actualWeight += object.getWeight();
        }
        return actualWeight;
    }

    /**
     * verifica se um objeto esta adicionado no bau pelo id
     * @param objectId id do objeto
     * @return true = existe, false = não existe
     */
    public boolean existId(int objectId) {
        for (GameObject compare : this.itens) {
            if (compare.getId() == objectId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um item ao bau pelo objeto, não permite que um mesmo objeto seja duplicado
     * @param objectAdd Objeto a ser adicionado
     * @return (ver constantes da classe)
     */
    public int addItem(GameObject objectAdd) {
        if (this.getActualSize() + objectAdd.getSize() > this.maxSize) {
            return NO_SIZE;
        } else if (this.existId(objectAdd.getId())) {
            return OBJECT_ALREDY_EXIST;
        } else {
            this.itens.add(objectAdd);
            return SUCCESS;
        }
    }

    /**
     * Adiciona um item ao bau pelo seu id, não permite que um mesmo objeto seja duplicado
     * @param id id do objeto
     * @return (ver constantes da classe)
     */
    public int addItem(int id) {
        GameObject newObject = IdKeeper.getObjectById(id);
        if (newObject == null) {
            return NULL_OBJECT;
        } else  {
            return this.addItem(newObject);
        }
    }

    /**
     * Remove um item do bau
     * @param objectRemove objeto a ser removido
     * @return (ver constantes da classe)
     */
    public int removeItem(GameObject objectRemove) {
        for (GameObject object : this.itens) {
            if (objectRemove == object) {
                this.itens.remove(object);
                return SUCCESS;
            }
        }
        return OBJECT_NO_IN_INVENTORY;
    }

    /**
     * Remove um item do bau pelo seu id
     * **ATENÇÃO: Caso voce remova um objeto do seu bau e algum objeto estiver segurando ele, ele não ira ser largado, para evitar isso usse o metodo removeItem da classe Player
     * @param id id do objeto a ser removido
     * @return (ver constantes da classe)
     */
    public int removeItem(int id) {
        GameObject newObject = IdKeeper.getObjectById(id);
        if (newObject == null) {
            return NULL_OBJECT;
        } else {
            return this.removeItem(newObject);
        }
    }

    @Override
    public ActionLog action() {
        return new ActionLog("Voce olhou para o seu bau", 0, 0, 0);
    }


}
