package core.map.mapIdControl;

public class MapAutoId {
    private static int idCont = 0;

    public static int getNewId() {
        return idCont++;
    }

}
