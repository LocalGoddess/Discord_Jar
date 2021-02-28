package me.hammer86gn.discordjar.discord.entites.message;

import com.google.gson.JsonObject;

public class Message implements IMessage{

    private long id;

    private JsonObject messageObject;
    private JsonObject messageDetails;

    public Message(long id) {
        this.id = id;
    }

    public Message(JsonObject messageObject) {
        this.messageObject = messageObject;
        this.messageDetails = messageObject.get("d").getAsJsonObject();
        this.id = getMessageID();
    }

    @Override
    public String getMessageContent() {
        return messageDetails.get("content").getAsString();
    }

    @Override
    public String getMessageSenderName() {
        JsonObject authorObject = messageDetails.get("author").getAsJsonObject();
        return authorObject.get("username").getAsString();
    }

    @Override
    public long getMessageSenderID() {
        JsonObject authorObject = messageDetails.get("author").getAsJsonObject();
        return authorObject.get("id").getAsLong();
    }

    @Override
    public String getMessageSenderAvatarID() {
        JsonObject authorObject = messageDetails.get("author").getAsJsonObject();
        return authorObject.get("avatar").getAsString();
    }

    @Override
    public String getMessageSenderAvatarURL() {
        return "https://cdn.discordapp.com/avatars/" + getMessageSenderID() + "/" + getMessageSenderAvatarID() + ".webp";
    }

    @Override
    public String getMessageSenderDiscriminator() {
        JsonObject authorObject = messageDetails.get("author").getAsJsonObject();
        return authorObject.get("discriminator").getAsString();
    }

    @Override
    public long getMessageID() {
        return messageDetails.get("id").getAsLong();
    }

    @Override
    public String getMessageType() {
        return messageDetails.get("type").getAsString();
    }

    @Override
    public long getChannelID() {
        return messageDetails.get("channel_id").getAsLong();
    }

    @Override
    public long getGuildID() {
        return messageDetails.get("guild_id").getAsLong();
    }

    public static Message getFromJson(JsonObject jsonObject) {
        return new Message(jsonObject);
    }
}
