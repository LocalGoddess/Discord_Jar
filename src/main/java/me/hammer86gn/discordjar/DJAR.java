/*

    Licensed under the GNU General Public License

    Code Written by Hammer86gn (https://www.github.com/Hammer86gn)


 */

package me.hammer86gn.discordjar;

import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.connection.websocket.WebSocketClient;

import java.io.IOException;


public class DJAR {

    public static DJAR instance;
    private String token;
    public static JsonParser JSON_PARSER;
    //URL: wss://gateway.discord.gg/?v=8&encoding=json

    public DJAR() {
        instance = this;
    }

    public void build(String token) {
        this.token = token;
        WebSocketClient client = new WebSocketClient("wss://gateway.discord.gg/?v=8&encoding=json",instance);
        client.connect();
    }

    public String getToken() {
        return token;
    }

    public static DJAR getInstance() {
        return instance;
    }
}
