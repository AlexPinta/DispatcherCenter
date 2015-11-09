package model;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class AirCraft {
    private String number;
    private TypeOfAircraft typeOfAircraft;

    public AirCraft(String number, TypeOfAircraft typeOfAircraft) {
        this.number = number;
        this.typeOfAircraft = typeOfAircraft;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TypeOfAircraft getTypeOfAircraft() {
        return typeOfAircraft;
    }

    public void setTypeOfAircraft(TypeOfAircraft typeOfAircraft) {
        this.typeOfAircraft = typeOfAircraft;
    }
}
