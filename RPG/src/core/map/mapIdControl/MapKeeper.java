package core.map.mapIdControl;

import core.map.Map;
import core.map.MapEntity;
import core.map.MapLink;

import java.util.ArrayList;

/**
 * Mantem uma lista com todos os mapas gerados
 */
public class MapKeeper {
    private static ArrayList<Map> idMapList = new ArrayList<Map>();

    /**
     * Adiciona um mapa verificando se ele já esta adicionado ou não
     * @param map Mapa a ser adicionado
     * @return true = sucesso, false = mapa já adicionado
     */
    public static boolean add(Map map) {
        if (!existId(map)) {
            idMapList.add(map);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se um mapa já esta adicionado
     * @param map Mapa a ser comparado
     * @return true = ja esta adicionado, false = não esta
     */
    public static boolean existId(Map map) {
        for (Map compare : idMapList) {
            if (compare.getId() == map.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna um vetor com todos os mapas existentes
     * @return Vetor de mapas
     */
    public static Map[] getMaps() {
        Map[] arr = new Map[idMapList.size()];
        for (int i = 0; i < idMapList.size(); i++) {
            arr[i] = idMapList.get(i);
        }
        return arr;
    }

    /**
     * Busca por um mapa pelo nome dele
     * @param name Nome do mapa a ser buscado
     * @return Mapa encontrado, ou não
     */
    public static Map getMapByName(String name) {
        for (Map arr : getMaps()) {
            if (arr.getName().equals(name)) {
                return arr;
            }
        }
        return null;
    }

    /**
     * Busca por um mapa pelo o seu id
     * @param id Id do mapa a ser buscado
     * @return Mapa encontrado, ou não
     */
    public static Map getMapById(int id) {
        for (Map arr : getMaps()) {
            if (arr.getId() == id) {
                return arr;
            }
        }
        return null;
    }

    /**
     * Gera uma arvore com todos os mapas e seus links
     * @return Arvore gerada
     */
    public static String getTreeLinks() {
        StringBuilder temp = new StringBuilder("");
        Map[] mapArr = getMaps();

        for (Map map : mapArr) {
            temp.append(map.getName() + "\n");
            MapEntity[][] mapEntities = map.getMapEntities();

            for (int i = 0; i < mapEntities.length; i++) {
                for (int j = 0; j < mapEntities[i].length; j++) {
                    if (mapEntities[i][j] instanceof MapLink) {
                        MapLink prop = (MapLink)mapEntities[i][j];
                        temp.append("\t");
                        temp.append(prop.getLinkedMap().getName());
                        temp.append("\t");
                        temp.append(String.format("ID: %d\t", prop.getLinkedMap().getId()));
                        temp.append(String.format("P: %d,%d\n", i, j));
                    }
                }
            }
            temp.append("\n");
        }

        return temp.toString();
    }
}
