package me.hammer86gn.discordjar.discord.entites.guild;

import com.google.gson.JsonObject;

public class Guild implements IGuild {

    private long id;
    private String ID;
    private JsonObject guildObject;
    private JsonObject guildDetails;

    @Deprecated
    public Guild(long id) {
        this.id = id;
    }

    @Deprecated
    public Guild(String ID) {
        this.ID = ID;
    }

    public Guild(JsonObject object) {
        guildObject = object;
        guildDetails = object.get("d").getAsJsonObject();
        this.id = guildDetails.get("id").getAsLong();
    }


    @Override
    public String getGuildID() {
        return guildDetails.get("id").getAsString();
    }

    @Override
    public long getGuildIDLong() {
        return guildDetails.get("id").getAsLong();
    }

    @Override
    public String getGuildIconID() {
        return guildDetails.get("icon").getAsString();
    }

    @Override
    public String getGuildIconURL() {
        return "https://cdn.discordapp.com/icons/" + getGuildID() + "/" + getGuildIconID() + ".webp";
    }

    @Override
    public String getGuildName() {
        return guildDetails.get("name").getAsString();
    }

    @Override
    public String getGuildRegion() {
        return guildDetails.get("region").getAsString();
    }

    @Override
    public String getOwnerID() {
        return guildDetails.get("owner_id").getAsString();
    }

    public static Guild getGuildFromJson(JsonObject object) {
        return new Guild(object.get("id").getAsString());
    }

}
