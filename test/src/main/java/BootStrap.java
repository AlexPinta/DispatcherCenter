import dao.InMemory;
import jms.jGroupsUtils.ChannelService;
import jms.MessageUtils.MessageService;
import model.*;
import org.jgroups.JChannel;
import org.jgroups.util.Util;
import server.DispatcherCenter;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class BootStrap {
    public static final String PATH_GSON = System.getProperty("user.dir") + "/resources/";
    public static final long SLLEP_TIME = 100;

    public static void main(String[] args) {

        InMemory source = new InMemory();
        source.load();
        try {
            DispatcherCenter receiver = source.getReceiver();
            receiver.setChannel(ChannelService.getChannel(receiver.getClusterName()));
            Thread serverThread = new Thread(receiver);
            serverThread.setDaemon(true);
            serverThread.start();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't launch server part!");
        }


        int bounderOfRandom = source.getAirCraftList().size();
        Random randomiser = new Random();
        while (true) {
            AirNodeOfCluster tmpAirNode = source.getAirCraftList().get(Math.max(randomiser.nextInt(bounderOfRandom) - 1, 0));
            tmpAirNode.updateParametersOfFlight(tmpAirNode.getLat() + randomiser.nextFloat(), tmpAirNode.getLon() + randomiser.nextFloat(),
                    tmpAirNode.getFlightAltitude() + randomiser.nextFloat(), tmpAirNode.getCourse() + randomiser.nextFloat());

            String JsonDescribing = MessageService.makeGSON(tmpAirNode);
            try {
                JChannel channel = ChannelService.getChannel(tmpAirNode.getClusterName());
                ChannelService.sendMessage(JsonDescribing, channel);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Message didn't send!");
            }
            Util.sleep(SLLEP_TIME);
        }
    }
}
