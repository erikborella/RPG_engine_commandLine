package core;

public abstract class GameObject {
    private String name;
    private String description;
    private int id;
    private double size;

    public GameObject(String name, String description, int id, double size) {
        this.name = name;
        this.description = description;
        this.id = id; //TODO: fazer verificação de id
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getSize() {
        return size;
    }
}
