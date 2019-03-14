package core.map;

import core.GameObject;

public class MapLink extends MapEntity {
    
    private Map link;

    public MapLink(GameObject object, char symbol, Map link) {
        super(object, symbol);
        this.link = link;
    }

    public Map getLink() {
        return link;
    }
}
