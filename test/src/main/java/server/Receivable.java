package server;

import org.jgroups.JChannel;
import org.jgroups.Message;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public interface Receivable {
    public Message getMessage();
    public void setChannel(JChannel channel) throws Exception;
}

