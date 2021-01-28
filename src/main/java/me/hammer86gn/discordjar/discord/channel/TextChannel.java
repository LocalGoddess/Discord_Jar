package me.hammer86gn.discordjar.discord.channel;

import com.google.gson.JsonObject;

import java.util.Arrays;

public class TextChannel {

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

    public TextChannel(String id, String guildId, String name, int type, int position, int rateLimitPerUser, boolean nsfw, String topic, String LastMessageId, String parentId, String[] permissionOverrides) throws IllegalArgumentException {
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
        this.perm_overrides = null;

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

    private final String perm_overrides;

    public TextChannel(String id, String guildId, String name, int type, int position, int rateLimitPerUser, boolean nsfw, String topic, String LastMessageId, String parentId, String perm_overrides) throws IllegalArgumentException {
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
        this.perm_overrides = perm_overrides;
        this.permission_overrides = null;

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
        channelObject.addProperty("permission_overwrites",perm_overrides);
        channelObject.addProperty("rate_limit_per_user",rateLimitPerUser);
        channelObject.addProperty("nsfw",nsfw);
        channelObject.addProperty("topic",topic);
        channelObject.addProperty("last_message_id",LastMessageId);
        channelObject.addProperty("parent_id",parentId);


    }

    public JsonObject getChannelObject() {
        return channelObject;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getRateLimitPerUser() {
        return rateLimitPerUser;
    }

    public int getType() {
        return type;
    }

    public String getGuildId() {
        return guildId;
    }

    public String getId() {
        return id;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public String getParentId() {
        return parentId;
    }

    public String getTopic() {
        return topic;
    }

    public String[] getPermission_overrides() {
        return permission_overrides;
    }

    @Override
    public String toString() {
        return this.channelObject.toString();
    }

    public TextChannel toTextChannel(JsonObject jsonObject) {

        return new TextChannel(jsonObject.get("id").getAsString(),jsonObject.get("guild_id").getAsString(),jsonObject.get("name").getAsString(),jsonObject.get("type").getAsInt(),
                jsonObject.get("position").getAsInt(),jsonObject.get("rate_limit_per_user").getAsInt(),jsonObject.get("nsfw").getAsBoolean(),jsonObject.get("topic").getAsString(),
                jsonObject.get("last_message_id").getAsString(),jsonObject.get("parent_id").getAsString(), jsonObject.get("permission_overwrites").getAsString());
    }
}


/*

Regular Text Channel

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