package me.hammer86gn.discordjar.discord.channel.guild;

import com.google.gson.JsonObject;
import me.hammer86gn.discordjar.discord.channel.IChannel;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class NewsChannel implements IChannel {

    private final String id;
    private final String guild_id;
    private final String name;
    private final int type;
    private final int position;
    private final String[] permission_overwrites;
    private final boolean nsfw;
    private final String topic;
    private final String last_message_id;
    private final String parent_id;
    private final JsonObject channelObject;

    public NewsChannel(String id, String guild_id, String name, int position, String permission_overwrites[], boolean nsfw, String topic, String last_message_id, String parent_id) {
        this.id = id;
        this.guild_id = guild_id;
        this.name = name;
        this.type = 5;
        this.position = position;
        this.permission_overwrites = permission_overwrites;
        this.nsfw = nsfw;
        this.topic = topic;
        this.last_message_id = last_message_id;
        this.parent_id = parent_id;
        this.channelObject = new JsonObject();

        String discordFriendlyName = name.toLowerCase().replace(' ','-');

        if (discordFriendlyName.toCharArray().length > 100) {
            throw new InvalidParameterException("GuildTextChannel names can only be a maximum of 100 characters");
        }
        if (discordFriendlyName.toCharArray().length < 2) {
            throw new InvalidParameterException("GuildTextChannel names can only be a minimum of 2 characters");
        }
        if (topic.toCharArray().length > 1024) {
            throw new InvalidParameterException("GuildTextChannel topics can only be a maximum of 1024 characters");
        }

        channelObject.addProperty("id",id);
        channelObject.addProperty("guild_id",guild_id);
        channelObject.addProperty("name",name);
        channelObject.addProperty("type",type);
        channelObject.addProperty("position",position);
        channelObject.addProperty("permission_overwrites", Arrays.toString(permission_overwrites));
        channelObject.addProperty("nsfw",nsfw);
        channelObject.addProperty("topic",topic);
        channelObject.addProperty("last_message_id",last_message_id);
        channelObject.addProperty("parent_id", parent_id);
    }

    /*
{
  "id": "41771983423143937",
  "guild_id": "41771983423143937",
  "name": "important-news",
  "type": 5,
  "position": 6,
  "permission_overwrites": [],
  "nsfw": true,
  "topic": "Rumors about Half Life 3",
  "last_message_id": "155117677105512449",
  "parent_id": "399942396007890945"
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

    public String getLastMessageID() {
        return last_message_id;
    }

    public String getTopic() {
        return topic;
    }

}
