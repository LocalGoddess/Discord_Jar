package me.hammer86gn.discordjar.discord.channel.guild;

import com.google.gson.JsonObject;
import me.hammer86gn.discordjar.discord.channel.IChannel;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class VoiceChannel implements IChannel {

    private final String id;
    private final String guild_id;
    private final String name;
    private final int type;
    private final boolean nsfw;
    private final int position;
    private final String[] permission_overwrites;
    private final int bitrate;
    private final int user_limit;
    private final String parent_id;
    private final JsonObject channelObject;

    public VoiceChannel(String id, String guild_id, String name, boolean nsfw, int position, String[] permission_overwrites, int bitrate, int user_limit, String parent_id) {
        this.id = id;
        this.guild_id = guild_id;
        this.name = name;
        this.type = 2;
        this.nsfw = nsfw;
        this.position = position;
        this.permission_overwrites = permission_overwrites;
        this.bitrate = bitrate;
        this.user_limit = user_limit;
        this.parent_id = parent_id;
        this.channelObject = new JsonObject();

        if (name.toCharArray().length > 100) {
            throw new InvalidParameterException("GuildVoiceChannel names can only be a maximum of 100 characters");
        }

        channelObject.addProperty("id",id);
        channelObject.addProperty("guild_id",guild_id);
        channelObject.addProperty("name", name);
        channelObject.addProperty("type",type);
        channelObject.addProperty("nsfw",nsfw);
        channelObject.addProperty("position",position);
        channelObject.addProperty("permission_overwrites", Arrays.toString(permission_overwrites));
        channelObject.addProperty("bitrate",bitrate);
        channelObject.addProperty("user_limit",user_limit);
        channelObject.addProperty("parent_id",parent_id);
    }

    /*
{
  "id": "155101607195836416",
  "guild_id": "41771983423143937",
  "name": "ROCKET CHEESE",
  "type": 2,
  "nsfw": false,
  "position": 5,
  "permission_overwrites": [],
  "bitrate": 64000,
  "user_limit": 0,
  "parent_id": null
}
     */

    @Override
    public JsonObject toJson(JsonObject object) {
        return channelObject;
    }

    @Override
    public String getChannelID() {
        return id;
    }

    @Override
    public String getChannelGuildID() {
        return guild_id;
    }

    @Override
    public String getChannelName() {
        return name;
    }

    @Override
    public int getChannelType() {
        return type;
    }

    @Override
    public int getChannelPosition() {
        return position;
    }

    @Override
    public String[] getPermissionOverwrites() {
        return permission_overwrites;
    }

    @Override
    public boolean isNSFW() {
        return nsfw;
    }

    @Override
    public String getParentID() {
        return parent_id;
    }

    public int getBitrate() {
        return bitrate;
    }

    public int getUserLimit() {
        return user_limit;
    }
}
