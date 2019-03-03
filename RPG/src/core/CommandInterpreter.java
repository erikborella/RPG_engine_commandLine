package core;

import core.idControl.IdKeeper;

/**
 * Classe intepretadora de commandos
 */
public class CommandInterpreter {

    private Player control;

    /**
     * Recebe um Player no qual as ações sera executadas
     * @param control Player a ser controlado
     */
    public CommandInterpreter(Player control) {
        this.control = control;
    }

    /**
     * Faz a execução dos comandos
     * @param command Comandos a serem executados
     * @return Mensagem de status
     */
    public String run(String command) {
        String[] commandsSepared = command.split(" ");
        switch (commandsSepared[0].toLowerCase()) {
            case "pegar":
                return this.get(commandsSepared[1]);
            case "jogar":
                if (commandsSepared[1].toLowerCase().equals("fora")) {
                    return this.remove(commandsSepared[2]);
                }
        }
        return "";
    }

    private String get(String obj) {
        GameObject object = IdKeeper.getObjectByName(obj);

        if (object == null) {
            return obj + " Nao encontrado";
        } else {
            int status = this.control.getInv().addItem(object);

            if (status == this.control.getInv().SUCCESS) {
                return obj + " Pego com sucesso";
            } else if (status == this.control.getInv().NO_SIZE) {
                return "Sem espaco para colocar objeto no inventario";
            } else if (status == this.control.getInv().OBJECT_ALREDY_EXIST) {
                return obj + " Ja esta no seu inventario";
            }

            return "Erro: " + status;
        }
    }

    private String remove(String obj) {
        GameObject object = IdKeeper.getObjectByName(obj);
        if (object == null) {
            return obj + " Nao encontrado";
        } else {
            int status = this.control.getInv().removeItem(object);

            if (status == this.control.getInv().SUCCESS) {
                return obj + " Jogado fora com sucesso";
            } else if (status == this.control.getInv().OBJECT_NO_IN_INVENTORY) {
                return obj + " Nao encontrado no invetario";
            }
            return "Erro: " + status;
        }
    }

    public Player getControl() {
        return control;
    }

    public void setControl(Player control) {
        this.control = control;
    }

}
