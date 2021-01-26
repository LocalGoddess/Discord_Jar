package me.hammer86gn.discordjar.discord.channel;

public enum ChannelTypes {
    GUILD_TEXT(0,"a text channel within a server"),
    DM(1, "a direct message between users"),
    GUILD_VOICE(2,"a voice channel within a server"),
    GROUP_DM(3,"a direct message between multiple users"),
    GUILD_CATEGORY(4,"an organizational category that contains up to 50 channels"),
    GUILD_NEWS(5,"a channel that users can follow and crosspost into their own server"),
    GUILD_STORE(6,"a channel in which game developers can sell their game on Discord")
    ;


    private final int id;
    private final String description;

    ChannelTypes(int id, String Description){

        this.id = id;
        description = Description;
    }

    public int getId() {
        return id;
    }
}
