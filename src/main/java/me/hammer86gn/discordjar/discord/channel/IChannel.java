package me.hammer86gn.discordjar.discord.channel;

import com.google.gson.JsonObject;

public interface IChannel {

    JsonObject toJson(JsonObject object);

    String getChannelID();

    String getChannelGuildID();

    String getChannelName();

    int getChannelType();

    int getChannelPosition();

    String[] getPermissionOverwrites();

    boolean isNSFW();

    String getParentID();

}
