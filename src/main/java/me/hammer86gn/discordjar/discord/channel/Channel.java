package me.hammer86gn.discordjar.discord.channel;

import com.google.gson.JsonObject;

public class Channel {

    private final String id;
    private final String guildId;
    private final String name;
    private final int type;
    private final int position;
    private final int rateLimitPerUser;
    private final boolean nsfw;
    private final String topic;
    private final String lastMessageId;
    private final String parentId;
    private final String[] permission_overrides;
    private final JsonObject channelObject;

    public Channel(String id, String guildId, String name, int type, int position, int rateLimitPerUser, boolean nsfw, String topic, String LastMessageId, String parentId, String[] permissionOverrides) throws IllegalArgumentException {
        this.id = id;
        this.guildId = guildId;
        this.name = name;
        this.type = type;
        this.position = position;
        this.rateLimitPerUser = rateLimitPerUser;
        this.nsfw = nsfw;
        this.topic = topic;
        lastMessageId = LastMessageId;
        this.parentId = parentId;
        this.permission_overrides = permissionOverrides;

        if(name.length() > 100) {
            throw new IllegalArgumentException("Channel name is too long (MAX: 100 Characters)");
        } else if(name.length() < 2) {
            throw new IllegalArgumentException("Channel name is too short (MIN: 2 Characters)");
        }
        if(topic.length() > 1024) {
            throw new IllegalArgumentException("Channel topic is too long (MAX: 1024 Characters)");
        }

        this.channelObject = new JsonObject();
        channelObject.addProperty("id",id);
        channelObject.addProperty("guild_id",guildId);
        channelObject.addProperty("name",name);
        channelObject.addProperty("type",type);
        channelObject.addProperty("position",position);
        channelObject.addProperty("permission_overwrites",permissionOverrides.toString());
        channelObject.addProperty("rate_limit_per_user",rateLimitPerUser);
        channelObject.addProperty("nsfw",nsfw);
        channelObject.addProperty("topic",topic);
        channelObject.addProperty("last_message_id",LastMessageId);
        channelObject.addProperty("parent_id",parentId);


    }

}


/*
{
  "id": "41771983423143937",
  "guild_id": "41771983423143937",
  "name": "general",
  "type": 0,
  "position": 6,
  "permission_overwrites": [],
  "rate_limit_per_user": 2,
  "nsfw": true,
  "topic": "24/7 chat about how to gank Mike #2",
  "last_message_id": "155117677105512449",
  "parent_id": "399942396007890945"
}
 */