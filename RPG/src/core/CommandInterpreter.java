package core;

import core.idControl.IdKeeper;

import java.awt.*;

/**
 * Classe intepretadora de commandos
 */
public class CommandInterpreter {

//    private Player control;
//    private boolean isInventoryOpen = false;
//
//    /**
//     * Recebe um Player no qual as ações sera executadas
//     * @param control Player a ser controlado
//     */
//    public CommandInterpreter(Player control) {
//        this.control = control;
//    }
//
//    /**
//     * Faz a execução dos comandos
//     * @param command Comandos a serem executados
//     * @return Mensagem de status
//     */
//    public String run(String command) {
//        String[] commandsSepared = command.split(" ");
//        try {
//            if (isInventoryOpen) {
//                switch (commandsSepared[0].toLowerCase()) {
//                    case "pegar":
//                        return this.getFromInventory(commandsSepared[1]);
//                    case "jogar":
//                        if (commandsSepared[1].toLowerCase().equals("fora")) {
//                            return this.removeFromInventoryAndHand(commandsSepared[2]);
//                        }
//                        return "jogar" + commandsSepared[1] + "nao encontrado";
//                    case "mostrar": case "ver":
//                        if (commandsSepared[1].toLowerCase().equals("itens")) {
//                            return this.showInventoryItens();
//                        }
//                        return "mostrar" + commandsSepared[1] + "nao encontrado";
//                    case "fechar":
//                        if (commandsSepared[1].toLowerCase().equals("inventario")) {
//                            this.closeInventory();
//                            return "Inventario fechado";
//                        }
//                    case "mudar":
//                        if (commandsSepared[1].toLowerCase().equals("nome")
//                                && commandsSepared[2].toLowerCase().equals("de")
//                                && commandsSepared[4].toLowerCase().equals("para")) {
//                            return this.renameInventoryObject(commandsSepared[3], commandsSepared[5]);
//                        }
//                        return command + " nao reconhecido";
//                }
//            } else {
//                switch (commandsSepared[0].toLowerCase()) {
//                    case "abrir":
//                        if (commandsSepared[1].toLowerCase().equals("inventario")) {
//                            this.openInventory();
//                            return "Inventario aberto";
//                        }
//                    case "pegar":
//                        return this.getFromWorld(commandsSepared[1]);
//                    case "mostrar": case "ver":
//                        if (commandsSepared[1].toLowerCase().equals("itens")
//                                && commandsSepared[2].toLowerCase().equals("do")
//                                && commandsSepared[3].toLowerCase().equals("inventario")) {
//                            return this.showInventoryItens();
//                        }
//                        return command + " nao reconhecido";
//                }
//            }
//            return  command + " nao reconhecido";
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return  command + " nao reconhecido 12";
//        }
//    }
//
//    private String getFromWorld(String obj) {
//        GameObject object = IdKeeper.getObjectByName(obj);
//
//        if (object == null) {
//            return obj + " Nao encontrado";
//        } else {
//            int status = this.control.getInv().addItem(object);
//
//            if (status == this.control.getInv().SUCCESS) {
//                return obj + " Pego com sucesso no inventario";
//            } else if (status == this.control.getInv().NO_SIZE) {
//                return "Sem espaco para colocar objeto no inventario";
//            } else if (status == this.control.getInv().OBJECT_ALREDY_EXIST) {
//                return obj + " Ja esta no seu inventario";
//            }
//
//            return "Erro: " + status;
//        }
//    }
//
//    private String getFromInventory(String obj) {
//        GameObject object = IdKeeper.getObjectByName(obj);
//
//        if (object == null) {
//            return obj + "nao esta no seu inventario";
//        }
//
//        if (object == this.control.getHand()) {
//            return "Voce ja esta segurando " + obj;
//        }
//
//        if (this.control.getInv().existId(object.getId())) {
//            this.control.setHand(object);
//            return "Voce pegou: " + obj;
//        } else {
//            return obj + "nao esta no seu inventario";
//        }
//    }
//
//    private String removeFromInventoryAndHand(String obj) {
//        GameObject object = IdKeeper.getObjectByName(obj);
//        if (object == null) {
//            return obj + " Nao encontrado";
//        } else {
//            int status = this.control.removeItem(object);
//
//            if (status == this.control.getInv().SUCCESS) {
//                return obj + " Jogado fora com sucesso";
//            } else if (status == this.control.getInv().OBJECT_NO_IN_INVENTORY) {
//                return obj + " Nao encontrado no invetario";
//            }
//            return "Erro: " + status;
//        }
//    }
//
//    private String showInventoryItens() {
//        GameObject[] objects = control.getInv().getItens();
//        String temp = "\n------------------------------------------------------------\n";
//
//        if (objects.length == 0) {
//            return "Seu inventario esta vazio";
//        }
//
//        for (GameObject object : objects) {
//            temp += object.getName() + " : " + object.getDescription();
//            temp += "\n------------------------------------------------------------\n";
//        }
//
//        return temp;
//    }
//
//    private String renameInventoryObject(String obj, String newName) {
//        GameObject object = IdKeeper.getObjectByName(obj);
//
//        if (object == null) {
//            return obj + "nao esta no seu inventario";
//        }
//        if (!control.getInv().existId(object.getId())) {
//            return obj + "nao esta no seu inventario";
//        }
//        if (newName.contains(" ")) {
//            return "O nome nao pode conter espacos";
//        }
//        object.setName(newName);
//        return obj + " agora se chama " + object.getName();
//    }
//
//    private void openInventory() {
//        this.isInventoryOpen = true;
//    }
//
//    private void closeInventory() {
//        this.isInventoryOpen = false;
//    }
//
//    public Player getControl() {
//        return control;
//    }
//
//    public void setControl(Player control) {
//        this.control = control;
//        this.isInventoryOpen = false;
//    }
//
//    public boolean isInventoryOpen() {
//        return isInventoryOpen;
//    }
}
