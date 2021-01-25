package me.hammer86gn.discordjar.discord.channel;

public enum ChannelTypes {
    VOICE(true,false),
    ALL(true,true),
    NULL(true,true),
    TEXT(false,true);

    private final boolean isVoice;
    private final boolean isText;

    ChannelTypes(boolean isVoice, boolean isText) {
        this.isVoice = isVoice;
        this.isText = isText;
    }


}
