package core.idControl;

import core.GameObject;

import java.util.ArrayList;

/**
 * Essa classe vai manter uma informação de todos os objetos criados no jogo
 * @version 1.0
 */
public class IdListener {

    private static ArrayList<GameObject> idList = new ArrayList<GameObject>();

    /**
     * Adiciona o objeto passado como parametro no listener
     * @param newObject Objeto novo a ser adicionado
     * @return true se o objeto foi adicionado com sucesso, false se um objeto com o mesmo id já esta adicionado
     */
    public static boolean add(GameObject newObject) {
        if (!existId(newObject)) {
            idList.add(newObject);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se o objeto(id) passado como parametro já existe na lista
     * @param object objeto a ser comparado
     * @return true se existe, false se não existe
     */
    public static boolean existId(GameObject object) {
        for (GameObject compare : idList) {
            if (compare.getId() == object.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o ID passado já existe em algum objeto
     * @param objectId id para ser comparado
     * @return true se existe, false se não existe
     */
    public static boolean existId(int objectId) {
        for (GameObject compare : idList) {
            if (compare.getId() == objectId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Serve para retornar um array com todos os ID's
     * @return int[] - lista de Id's
     */
    public static int[] getIdList() {
        int[] arr = new int[idList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = idList.get(i).getId();
        }
        return arr;
     }

    /**
     * Serve para retornar um array com todos os objetos do jogo
     * @return GameObject[] - Lista de objetos
     */
    public static GameObject[] getGameObjects() {
        GameObject[] arr = new GameObject[idList.size()];
         for (int i = 0; i < arr.length; i++) {
             arr[i] = idList.get(i);
         }
         return arr;
     }

     public static GameObject getObjectById(int id) {
        for (GameObject arr : getGameObjects()) {
            if (arr.getId() == id) {
                return arr;
            }
        }
        return null;
     }
}
