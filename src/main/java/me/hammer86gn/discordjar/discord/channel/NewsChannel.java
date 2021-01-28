package me.hammer86gn.discordjar.discord.channel;

import com.google.gson.JsonObject;

public class NewsChannel {
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
    private final JsonObject newsChannelOBJ;

    public NewsChannel(String id, String guild_id, String name, int type, int position, String[] permission_overwrites, boolean nsfw, String topic, String last_message_id, String parent_id){
        this.id = id;
        this.guild_id = guild_id;
        this.name = name;
        this.type = type;
        this.position = position;
        this.permission_overwrites = permission_overwrites;
        this.nsfw = nsfw;
        this.topic = topic;
        this.last_message_id = last_message_id;
        this.parent_id = parent_id;
        newsChannelOBJ = new JsonObject();
        newsChannelOBJ.addProperty("id",id);
    }
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