package core.map.mapIdControl;

import core.map.Map;

import java.util.ArrayList;

public class MapKeeper {
    private static ArrayList<Map> idMapList = new ArrayList<Map>();

    public static boolean add(Map map) {
        if (!existId(map)) {
            idMapList.add(map);
            return true;
        } else {
            return false;
        }
    }

    public static boolean existId(Map map) {
        for (Map compare : idMapList) {
            if (compare.getId() == map.getId()) {
                return true;
            }
        }
        return false;
    }

    public static Map[] getMaps() {
        Map[] arr = new Map[idMapList.size()];
        for (int i = 0; i < idMapList.size(); i++) {
            arr[i] = idMapList.get(i);
        }
        return arr;
    }

    public static Map getMapByName(String name) {
        for (Map arr : getMaps()) {
            if (arr.getName().equals(name)) {
                return arr;
            }
        }
        return null;
    }
}
