package model;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class TypeOfAircraft {
    public enum  TYPE {HELICOPTER, PLANE}
    private TYPE type;
    private String name;

    public TypeOfAircraft(String name, TYPE type) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
