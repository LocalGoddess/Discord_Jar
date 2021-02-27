/*

    Licensed under the GNU General Public License

    Code Written by Hammer86gn (https://www.github.com/Hammer86gn)


 */

package me.hammer86gn.discordjar.connection.websocket;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.event.message.BaseMessageEvent;
import me.hammer86gn.discordjar.event.message.MessageCreatedEvent;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import static me.hammer86gn.discordjar.DJAR.JSON_PARSER;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient{

    private String url;
    private boolean isConnected = false;
    private long heartbeatInterval;
    public DJAR djar;

    public WebSocketClient(String url, DJAR djar) {
        super(URI.create(url));
        this.url = url;
        this.djar = djar;

    }



    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        JsonObject identifyConnectionPacket = new JsonObject();
        JsonObject identifyD = new JsonObject();
        JsonObject identifyDProperties = new JsonObject();

        /*
         * The 'D' Value Properties Constructor for the Identification payload
         */
        identifyDProperties.addProperty("$os","Windows");
        identifyDProperties.addProperty("$browser","Discord.jar");
        identifyDProperties.addProperty("$device","Discord.jar");

        /*
         * The 'D' Value Constructor for the Identification payload
         */
        identifyD.addProperty("token",djar.getToken());
        identifyD.addProperty("intents",513);
        identifyD.add("properties",identifyDProperties);

        /*
         * The Constructor for the Identification payload
         */
        identifyConnectionPacket.addProperty("op",2);
        identifyConnectionPacket.add("d",identifyD);

        send(identifyConnectionPacket.toString());

        isConnected = true;
    }

    @Override
    public void onMessage(String s) {
        System.out.println(s);

        JsonObject receivedData = JsonParser.parseString(s).getAsJsonObject();
        String type = receivedData.get("t").toString();
        JsonObject details = receivedData.get("d").getAsJsonObject();

        if (type.equals("MESSAGE_CREATE")) {
            System.out.println("EVENT STARTED? " + receivedData);
            new MessageCreatedEvent(djar, Message.getFromJson(receivedData));
        }

        if (type.equals("READY")) {
            heartbeatInterval = receivedData.get("heartbeat_interval").getAsLong();
            new Thread(() -> {
                while (!getConnection().isClosed()) {
                    JsonObject heartbeat = new JsonObject();
                    heartbeat.addProperty("op",1);
                    heartbeat.addProperty("d",System.currentTimeMillis());
                    send(heartbeat.toString());
                    try {
                        Thread.sleep(heartbeatInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                }
            }).start();
        }
        switch (type) {
            case "READY":
                System.out.println("Ready");
                break;
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("Closed" + " Code: " + i + " Reason: " + s + " What does the bool do: " + b);
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    public boolean isConnected() {
        return isConnected;
    }
}
