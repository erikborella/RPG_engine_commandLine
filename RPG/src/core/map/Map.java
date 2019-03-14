package core.map;

import core.idControl.AutoId;
import core.map.mapIdControl.MapKeeper;

/**
 * Classe que serve como um mapa.
 * Principalmente é apenas uma matriz de MapEntity
 */
public class Map {

    private MapEntity[][] mapEntities;
    private String name;
    private int id;

    public Map(MapEntity[][] mapEntities, String name) {
        this.mapEntities = mapEntities;
        this.name = name;
        this.id = AutoId.getNewId();

        MapKeeper.add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public MapEntity[][] getMapEntities() {
        return mapEntities;
    }

    public void setMapEntities(MapEntity[][] mapEntities) {
        this.mapEntities = mapEntities;
    }
}