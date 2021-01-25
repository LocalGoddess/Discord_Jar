package me.hammer86gn.discordjar.discord.user.role;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Role {

    private final String id;
    private final String name;
    private final int color;
    private final boolean hoist;
    private final int position;
    private final String permissions;
    private final boolean webhookManaged;
    private final boolean mentionable;
    private JsonObject roleOBJ;

    /**
     *
     * @param id role id
     * @param name 	role name
     * @param color integer representation of hexadecimal color code
     * @param hoist if this role is pinned in the user listing
     * @param position position of this role
     * @param permissions permission bit set
     * @param webhookManaged whether this role is managed by an integration
     * @param mentionable whether this role is mentionable
     */

    public Role(String id, String name, int color, boolean hoist, int position, String permissions, boolean webhookManaged, boolean mentionable) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.hoist = hoist;
        this.position = position;
        this.permissions = permissions;
        this.webhookManaged = webhookManaged;
        this.mentionable = mentionable;
        JsonObject roleOBJ = new JsonObject();
        roleOBJ.addProperty("id",id);
        roleOBJ.addProperty("name",name);
        roleOBJ.addProperty("color",color);
        roleOBJ.addProperty("hoist",hoist);
        roleOBJ.addProperty("position",position);
        roleOBJ.addProperty("permissions",permissions);
        roleOBJ.addProperty("managed",webhookManaged);
        roleOBJ.addProperty("mentionable",mentionable);
        this.roleOBJ = roleOBJ;

    }

    public JsonObject toJson(){
        return roleOBJ;
    }

    public static Role toRole(JsonObject jsonData) {
        return new Role(jsonData.get("id").getAsString(), jsonData.get("name").getAsString(), jsonData.get("color").getAsInt(), jsonData.get("hoist").getAsBoolean(), jsonData.get("position").getAsInt(), jsonData.get("permissions").getAsString(), jsonData.get("managed").getAsBoolean(), jsonData.get("mentionable").getAsBoolean());
    }

}

/*
{
  "id": "41771983423143936",
  "name": "WE DEM BOYZZ!!!!!!",
  "color": 3447003,
  "hoist": true,
  "position": 1,
  "permissions": "66321471",
  "managed": false,
  "mentionable": false
}
 */