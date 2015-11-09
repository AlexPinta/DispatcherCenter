package dao;

import model.*;
import server.DispatcherCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class InMemory {
    public static final String EXAMPLE_CLUSTER = "MyCluster";
    private List<AirNodeOfCluster> airCraftList = new ArrayList<>();
    private DispatcherCenter receiver;
    public void load(){
        TypeOfAircraft modelHelicopterOne   = new TypeOfAircraft("Mi-17", TypeOfAircraft.TYPE.HELICOPTER);
        TypeOfAircraft modelHelicopterTwo   = new TypeOfAircraft("Mi-2", TypeOfAircraft.TYPE.HELICOPTER);
        TypeOfAircraft modelPlaneOne        = new TypeOfAircraft("L39", TypeOfAircraft.TYPE.PLANE);
        TypeOfAircraft modelPlaneTwo        = new TypeOfAircraft("B777", TypeOfAircraft.TYPE.PLANE);

        Helicopter helicopterOne            = new Helicopter("A-1135",modelHelicopterOne);
        Helicopter helicopterTwo            = new Helicopter("B-567890",modelHelicopterTwo);
        Plane planeOne                      = new Plane("SD-06767",modelPlaneOne);
        Plane planeTwo                      = new Plane("BH-00590",modelPlaneTwo);

//        Cluster cluster                     = new Cluster();
//        cluster.setDispatcherCenter(dispatcherCenter);
        receiver = new DispatcherCenter("Kiev Borispol", EXAMPLE_CLUSTER);
        AirNodeOfCluster airNodeHelicopterOne      = new AirNodeOfCluster();
        airNodeHelicopterOne.registerOFAirCraft(helicopterOne, EXAMPLE_CLUSTER);
        AirNodeOfCluster airNodeHelicopterTwo      = new AirNodeOfCluster();
        airNodeHelicopterTwo.registerOFAirCraft(helicopterTwo, EXAMPLE_CLUSTER);
        AirNodeOfCluster airNodePlaneOne      = new AirNodeOfCluster();
        airNodePlaneOne.registerOFAirCraft(planeOne, EXAMPLE_CLUSTER);
        AirNodeOfCluster airNodePlaneTwo      = new AirNodeOfCluster();
        airNodePlaneTwo.registerOFAirCraft(planeTwo, EXAMPLE_CLUSTER);

        airCraftList.add(airNodeHelicopterOne);
        airCraftList.add(airNodeHelicopterTwo);
        airCraftList.add(airNodePlaneOne);
        airCraftList.add(airNodePlaneTwo);
    }

    public List<AirNodeOfCluster> getAirCraftList() {
        return airCraftList;
    }

    public DispatcherCenter getReceiver() {
        return receiver;
    }
}
