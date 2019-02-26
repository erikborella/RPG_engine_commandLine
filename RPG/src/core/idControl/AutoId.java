package core.idControl;

/**
 * Classe que sempre nos retornar um novo ID unico
 * De preferencia a usar essa classe ao inves de um ID manual
 */
public class AutoId {

    private static int idCont = 0;

    /**
     * Retorna um novo ID unico
     * @return int - novo ID
     */
    public static int getNewId() {
        return  idCont++;
    }

}
