package core.map;

import core.GameObject;

/**
 * Um link de mapa permite fazer a passagem para outros mapas
 */
public class MapLink extends MapEntity {
    
    private Map link;

    public MapLink(GameObject object, char symbol, Map link) {
        super(object, symbol);
        this.link = link;
    }

    public Map getLinkedMap() {
        return link;
    }
}
