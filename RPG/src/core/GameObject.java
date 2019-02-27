package core;

import core.idControl.AutoId;
import core.idControl.IdListener;

/**
 * Classe que serve como base para todos os objetos interajiveis no jogo
 * @version 1.0
 */
public abstract class GameObject {
    private String name;
    private String description;
    private int id;
    private int size;
    private double weight;

    /**
     * Construtor que gera um ID automatico para o objeto
     * @param name nome do objeto
     * @param description descrição do objeto
     * @param size tamanho que um objeto vai ocupar em um inventario
     * @param weight Peso do objeto
     */
    public GameObject(String name, String description, int size, double weight) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.weight = weight;
        this.id = AutoId.getNewId();
    }

    /**
     * Retorna o nome
     * @return Nome
     */
    public String getName() {
        return name;
    }

    /**
     * Seta o nome
     * @param name Nome a ser setado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retornar a descrição
     * @return descrição
     */
    public String getDescription() {
        return description;
    }

    /**
     * Seta a descrição de um objeto
     * @param description nova descrição do objeto
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o ID do objeto
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o tamanho do objeto
     * @return tamanho
     */
    public int getSize() {
        return size;
    }

    public abstract ActionLog action();
}
