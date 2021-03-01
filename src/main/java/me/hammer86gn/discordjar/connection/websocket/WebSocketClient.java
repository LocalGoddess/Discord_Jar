package me.hammer86gn.discordjar.connection.websocket;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.handle.BaseHandle;
import me.hammer86gn.discordjar.handle.MessageSentHandle;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class WebSocketClient extends org.java_websocket.client.WebSocketClient {
    private final String url;
    private final DJAR djar;
    private boolean isConnected;
    private long keepAliveInterval;
    private String sessionID;
    private int closeCode;
    protected final Map<String, BaseHandle> handleMap = new HashMap<>();

    public WebSocketClient(String url, DJAR djar) {
        super(URI.create(url.replace("wss", "wss")));
        this.url = url;
        this.djar = djar;
        this.connect();
        setup();
    }

    protected void setup() {
        final BaseHandle.HandleHandler handleHandler = new BaseHandle.HandleHandler(djar);
        handleMap.put("MESSAGE_CREATE", new MessageSentHandle(djar));

    }

    public Map<String, BaseHandle> getHandleMap() {
        return handleMap;
    }

    public <Type extends BaseHandle> Type getHandle(String type) {
        try {
            return (Type) handleMap.get(type);
        } catch (ClassCastException e) {
            throw new IllegalStateException(e);
        }
    }

    @SuppressWarnings("NullPointerEception")
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Received Handshake: " + serverHandshake.getHttpStatus() + "\nwith message" + serverHandshake.getHttpStatusMessage());

        send(connectionPacket().toString());

        isConnected = true;
    }

    public JsonObject connectionPacket() {
        JsonObject conObject = new JsonObject();

        JsonObject conProperties = new JsonObject();
        conProperties.addProperty("$os", System.getProperty("os.name"));
        conProperties.addProperty("$browser", "DJAR");
        conProperties.addProperty("$device", "");

        JsonObject conDetails = new JsonObject();
        conDetails.addProperty("token", djar.getToken());
        conDetails.addProperty("intents", 513);
        conDetails.add("properties", conProperties);
        conDetails.addProperty("v", 8);

        conObject.addProperty("op", 2);
        conObject.add("d", conDetails);

        return conObject;
    }

    @SuppressWarnings("NullPointerEception")
    @Override
    public void onMessage(String s) {
        System.out.println(s);
        JsonObject contents = JsonParser.parseString(s).getAsJsonObject();
        String requestType = contents.get("t").getAsString();
        JsonObject requestDetails = contents.get("d").getAsJsonObject();

        heartbeatInit(contents, requestType);

//        if (requestType.equals("READY")) {
//            keepAliveInterval = contents.get("heartbeat_interval").getAsLong();
//            new Thread(() -> {
//                while (!getConnection().isClosed()) {
//                    JsonObject heartbeat = new JsonObject();
//                    heartbeat.addProperty("op", 1);
//                    heartbeat.addProperty("d", System.currentTimeMillis());
//                    send(heartbeat.toString());
//                    try {
//                        Thread.sleep(keepAliveInterval);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.exit(0);
//                    }
//                }
//            }).start();
//        }



        switch (requestType) {
            case "READY":

        }

        if (handleMap.get(requestType) instanceof MessageSentHandle) {
            MessageSentHandle messageSentHandle = new MessageSentHandle(djar);
            messageSentHandle.handleInternally(contents);
        }


    }

    private void heartbeatInit(JsonObject requestJson, String requestType) {
        if (requestType.equals("READY")) {
            sessionID = requestJson.get("session_id").getAsString();
            keepAliveInterval = requestJson.get("heartbeat_interval").getAsLong();
            new Thread(() -> {
                while (!getConnection().isClosed()) {
                    JsonObject heartbeat = new JsonObject();
                    heartbeat.addProperty("op", 1);
                    heartbeat.addProperty("d", System.currentTimeMillis() * System.currentTimeMillis());
                    send(heartbeat.toString());
                    try {
                        Thread.sleep(keepAliveInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }
                }
            }).start();
        }
    }

    public void cacheGuilds() {

    }

    public void connectionInit() {

    }



    @Override
    public void onClose(int i, String s, boolean b) {
        closeCode = i;
        System.out.println("Connection Closed " +
                "\nClose Code: " + i +
                "\nClose Reason: " + s +
                "\nClose caused by Remote: " + b);
        isConnected = false;
    }

    private JsonObject connectionResurrect() {
        JsonObject resumeDetails = new JsonObject();
        resumeDetails.addProperty("token",djar.getToken());
        resumeDetails.addProperty("session_id",sessionID);
        resumeDetails.addProperty("seq",1337);


        JsonObject resumePacket = new JsonObject();
        resumePacket.addProperty("op",11);
        resumePacket.add("d",resumeDetails);

        return resumePacket;
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    public boolean isConnected() {
        return isConnected;
    }

    public int getConnectionCloseCode() {
        return closeCode;
    }
}
