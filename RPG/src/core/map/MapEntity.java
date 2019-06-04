package core.map;

import core.GameObject;

/**
 * Uma entidade de mapa, que contem um simbolo para representaçao grafica e um objeto de jogo para interaçoes
 */
public class MapEntity {
    private GameObject object;
    private char symbol;

    public MapEntity(GameObject object, char symbol) {
        this.object = object;
        this.symbol = symbol;
    }

    public GameObject getObject() {
        return object;
    }

    public void setObject(GameObject object) {
        this.object = object;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
