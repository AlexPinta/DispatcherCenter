package jms.jGroupsUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jgroups.JChannel;
import org.jgroups.Message;
import server.Receivable;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class ChannelService {
    public static final long WAITING_TIME = 10000;
    private final static Logger logger = Logger.getLogger("flight_data");

    public static void sendMessage(String JsonDescribing, JChannel channel)  throws Exception {
        channel.send(new Message(null, JsonDescribing));
        channel.close();

    }

    public static void receiveMessage(Receivable receiverAdapter) {
        Message msg = receiverAdapter.getMessage();

        if (msg != null){
            logger.info(msg.getSrc() + " : " + msg.getObject());
        }
    }

    public static JChannel getChannel(String ClusterName) throws Exception {
        JChannel channel = new JChannel(ChannelService.class.getResource("tcp.xml").toString());
        channel.connect(ClusterName);
        return channel;
    }

}
