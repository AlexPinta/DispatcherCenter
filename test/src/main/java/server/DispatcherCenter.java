package server;

import jms.jGroupsUtils.ChannelService;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class DispatcherCenter extends ReceiverAdapter implements Receivable, Runnable{
    public static final long SLLEP_TIME = 10000;
    private Message msg;
    private JChannel channel;
    private String name;
    private String clusterName;


    public JChannel getChannel() {
        return channel;
    }

    public DispatcherCenter(String name, String clusterName) {
        this.name = name;
        this.clusterName = clusterName;
    }

    @Override
    public void receive(Message msg) {
        super.receive(msg);
        this.msg = msg;
    }

    @Override
    public void viewAccepted(View view) {
        super.viewAccepted(view);
        System.out.println("** view: " + view);

    }

    @Override
    public void setState(InputStream input) throws Exception {
        super.setState(input);
    }

    @Override
    public void run() {
        while (channel.isConnected()){
            ChannelService.receiveMessage(this);
            Util.sleep(SLLEP_TIME);
        }
    }
    @Override
    public Message getMessage() {
        this.receive(msg);
        return this.msg;
    }

    @Override
    public void setChannel(JChannel channel) throws Exception{
        this.channel = channel;
        this.channel.setReceiver(this);
        this.channel.getState(null, 10000);
    }

    public String getName() {
        return name;
    }

    public String getClusterName() {
        return clusterName;
    }
}
