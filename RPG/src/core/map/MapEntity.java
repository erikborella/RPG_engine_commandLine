package core.map;

import core.GameObject;

public class MapEntity {
    private GameObject object;
    private char symbol;

    public MapEntity(GameObject object, char symbol) {
        this.object = object;
        this.symbol = symbol;
    }
}
