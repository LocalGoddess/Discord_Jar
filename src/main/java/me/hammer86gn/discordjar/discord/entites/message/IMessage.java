package me.hammer86gn.discordjar.discord.entites.message;

import com.google.gson.JsonArray;

public interface IMessage {

    // Message

    String getMessageContent();

    long getMessageID();

    String getMessageType();

    String getMessageSentDate();

    // User

    String getMessageSenderName();

    long getMessageSenderID();

    String getMessageSenderAvatarID();

    String getMessageSenderAvatarURL();

    String getMessageSenderDiscriminator();

    JsonArray getMentionedUsers();



    // Channel

    long getChannelID();

    // Guild

    long getGuildID();

}
