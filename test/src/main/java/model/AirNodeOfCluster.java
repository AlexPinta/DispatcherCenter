package model;

import model.AirCraft;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class AirNodeOfCluster  implements Flyable{
    private AirCraft aircraft;
    private float lat;
    private float lon;
    private float flightAltitude;
    private float course;
    private String clusterName;

    @Override
    public void registerOFAirCraft(AirCraft aircraft, String clusterName) {
        this.aircraft = aircraft;
        this.clusterName = clusterName;
    }

    @Override
    public void updateParametersOfFlight(float lat, float lon, float flightAltitude, float course) {
        this.lat = lat;
        this.lon = lon;
        this.flightAltitude = flightAltitude;
        this.course = course;
    }

    public AirCraft getAircraft() {
        return aircraft;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public float getFlightAltitude() {
        return flightAltitude;
    }

    public float getCourse() {
        return course;
    }

    public String getClusterName() {
        return clusterName;
    }
}
