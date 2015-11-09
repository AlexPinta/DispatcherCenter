package jms.MessageUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Flyable;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 09.11.15
 */
public class MessageService {

    public static String makeGSON(Flyable flight){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(flight);
    }
}
