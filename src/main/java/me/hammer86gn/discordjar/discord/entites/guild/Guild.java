package me.hammer86gn.discordjar.discord.entites.guild;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.connection.request.Requester;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Guild implements IGuild {

    private long id;
    private String ID;
    private JsonObject guildObject;

    public Guild(long id) {
        this.id = id;
    }

    public Guild(String ID) {
        this.ID = ID;
    }

    public JsonObject getGuildByID(String ID) throws IOException {
        Requester requester = new Requester(new URL("discord.com/api/guilds/" + ID));
        String response = requester.readResponse();
        JsonObject responseObject = JsonParser.parseString(response).getAsJsonObject();
        System.out.println(requester.debugger());
        guildObject = responseObject;
        return responseObject;
    }

    public JsonObject getGuildByID(long ID) throws IOException {
        String strungID = Long.toString(ID);
        Requester requester = new Requester(new URL("discord.com/api/guilds/" + strungID));
        String response = requester.readResponse();
        JsonObject responseObject = JsonParser.parseString(response).getAsJsonObject();
        System.out.println(requester.debugger());
        guildObject = responseObject;
        return responseObject;
    }

    @Override
    public String getGuildID() {
        String id = guildObject.get("id").getAsString();
        return id;
    }

    @Override
    public long getGuildIDLong() {
        long id = guildObject.get("id").getAsLong();
        return id;
    }

    @Override
    public String getGuildIconURL() {
        return null;
    }

    @Override
    public String getGuildName() {
        return null;
    }

    @Override
    public String getGuildRegion() {
        return null;
    }

    @Override
    public String getOwnerID() {
        return null;
    }
}
