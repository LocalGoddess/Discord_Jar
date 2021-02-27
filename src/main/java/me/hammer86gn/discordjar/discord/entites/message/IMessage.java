package me.hammer86gn.discordjar.discord.entites.message;

public interface IMessage {

    // Message

    String getMessageContent();

    long getMessageID();

    // User

    String getMessageSenderName();

    long getMessageSenderID();

    String getMessageSenderAvatarID();

    String getMessageSenderAvatarURL();

    String getMessageSenderDiscriminator();

    // Channel

    long getChannelID();

    // Guild

    long getGuildID();

}
