package core.idControl;

import core.GameObject;

import java.util.ArrayList;

/**
 * Essa classe vai manter uma informação de todos os objetos criados no jogo
 */
public class IdListener {

    private static ArrayList<GameObject> idList = new ArrayList<GameObject>();

    /**
     * Adiciona o objeto passado como parametro no listener
     * @param newObject Objeto novo a ser adicionado
     * @return boolean - true se o objeto foi adicionado com sucesso, false se um objeto com o mesmo id já esta adicionado
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
     * @return boolean - true se existe, false se não existe
     */
    public static boolean existId(GameObject object) {
        for (GameObject compare : idList) {
            if (compare.getId() == object.getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean existId(int objectId) {
        for (GameObject compare : idList) {
            if (compare.getId() == objectId) {
                return true;
            }
        }
        return false;
    }



}
