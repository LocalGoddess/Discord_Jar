/*

    Licensed under the GNU General Public License

    Code Written by Hammer86gn (https://www.github.com/Hammer86gn)


 */

package me.hammer86gn.discordjar.connection.websocket;



import com.google.gson.JsonObject;
import me.hammer86gn.discordjar.DJAR;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient{

    private String url;
    private boolean isConnected = false;
    private long heartbeatInterval = 45000;
    public DJAR djar;

    public WebSocketClient(String url, DJAR djar) {
        super(URI.create(url));
        this.url = url;
        this.djar = djar;
        this.connect();
    }



    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        JsonObject identifyConnectionPacket = new JsonObject();
        JsonObject identifyD = new JsonObject();
        JsonObject identifyDProperties = new JsonObject();

        identifyDProperties.addProperty("$os","Windows");
        identifyDProperties.addProperty("$browser","Discord.jar");
        identifyDProperties.addProperty("$device","Discord.jar");

        identifyD.addProperty("token",djar.getToken());
        identifyD.addProperty("intents",513);
        identifyD.add("properties",identifyDProperties);


        identifyConnectionPacket.addProperty("op",2);
        identifyConnectionPacket.add("d",identifyD);

        send(identifyConnectionPacket.toString());
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("Closed" + " Code: " + i + " Reason: " + s + " What does the bool do: " + b);
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}
