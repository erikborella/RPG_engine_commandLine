package core.map;

import core.map.mapIdControl.MapAutoId;
import core.map.mapIdControl.MapKeeper;

public class Map {
    private MapEntity[][] mapEntities;
    private String name;
    private int id;

    public Map(MapEntity[][] mapEntities, String name) {
        this.mapEntities = mapEntities;
        this.name = name;
        this.id = MapAutoId.getNewId();

        MapKeeper.add(this);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}