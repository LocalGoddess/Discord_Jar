package me.hammer86gn.discordjar.discord.channel;

import com.google.gson.JsonObject;

import java.security.InvalidParameterException;

public class Overwrite {

    private final String id;
    private final int type;
    private final String allow;
    private final String deny;
    private final JsonObject object;

    /**
     * Permission Overwrites for Channels and others
     *
     * @param id role or user id
     * @param type either 0 (role) or 1 (member)
     * @param allow permission bit set
     * @param deny permission bit set
     */
    public Overwrite(String id, int type, String allow, String deny) {
        this.id = id;
        this.type = type;
        this.allow = allow;
        this.deny = deny;

        if (type != 1 && type != 0) {
            throw new InvalidParameterException("Overwrite Type cannot be any int other than 0 or 1 see documentation for more info");
        }

        this.object = new JsonObject();
        object.addProperty("id",id);
        object.addProperty("type",type);
        object.addProperty("allow",allow);
        object.addProperty("deny",deny);
    }

    JsonObject getAsJson() {
        return object;
    }

}
