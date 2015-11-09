package model;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public interface Flyable {
    public void updateParametersOfFlight(float lat, float lon, float flightAltitude, float course);
    public void registerOFAirCraft(AirCraft aircraft, String clusterName);
}
