/*

    Licensed under the GNU General Public License

    Code Written by Hammer86gn (https://www.github.com/Hammer86gn)


 */

package me.hammer86gn.discordjar;

import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.connection.websocket.WebSocketClient;
import me.hammer86gn.discordjar.events.basic.IBasicEvent;
import me.hammer86gn.discordjar.events.registration.EventRegister;

import java.util.List;


public class DJAR {

    public static final String CLIENT_ID = "814638406402703383";
    public static DJAR instance;
    private String token;
    public static JsonParser JSON_PARSER;
    private static final EventRegister eventRegister = new EventRegister();
    //URL: wss://gateway.discord.gg/?v=8&encoding=json

    private Object[] listeners;

    public DJAR() {
        instance = this;
    }

    public void build(String token) {
        this.token = token;
        WebSocketClient client = new WebSocketClient("wss://gateway.discord.gg/?v=8&encoding=json",instance);
        client.connect();
    }

    public void registerEvent(Object event) {
        eventRegister.register(event);
    }

    public void unregisterEvent(Object event) {
        eventRegister.register(event);
    }

    public List<Object> getAllRegisteredEvents() {
        return eventRegister.getAllRegister();
    }

    public void handleEvent(IBasicEvent event) {
        eventRegister.eventHandle(event);
    }

    public String getToken() {
        return token;
    }

    public static DJAR getInstance() {
        return instance;
    }
}
