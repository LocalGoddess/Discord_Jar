package me.hammer86gn.discordjar.discord.entites.guild;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.connection.request.Requester;

import java.io.IOException;
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
        return guildObject.get("id").getAsString();
    }

    @Override
    public long getGuildIDLong() {
        return guildObject.get("id").getAsLong();
    }

    @Override
    public String getGuildIconID() {
        return guildObject.get("icon").getAsString();
    }

    @Override
    public String getGuildIconURL() {
        return "https://cdn.discordapp.com/icons/" + getGuildID() + "/" + getGuildIconID() + ".webp" ;
    }

    @Override
    public String getGuildName() {
        return guildObject.get("name").getAsString();
    }

    @Override
    public String getGuildRegion() {
        return guildObject.get("region").getAsString();
    }

    @Override
    public String getOwnerID() {
        return guildObject.get("owner_id").getAsString();
    }
}
