package me.hammer86gn.discordjar.discord;

import com.google.gson.JsonObject;

public enum GatewayIntents {
    GUILD_CREATE("GUILDS", "(1 << 0)"),
    GUILD_UPDATE("GUILDS", "(1 << 0)"),
    GUILD_DELETE("GUILDS", "(1 << 0)"),
    GUILD_PRESENCES("GUILDS", "(1 << 0)",true),
    GUILD_ROLE_CREATE("GUILDS", "(1 << 0)"),
    GUILD_ROLE_UPDATE("GUILDS", "(1 << 0)"),
    GUILD_ROLE_DELETE("GUILDS", "(1 << 0)"),
    CHANNEL_CREATE("GUILDS", "(1 << 0)"),
    CHANNEL_UPDATE("GUILDS", "(1 << 0)"),
    CHANNEL_DELETE("GUILDS", "(1 << 0)"),
    CHANNEL_PINS_UPDATE("GUILDS", "(1 << 0)"),

    GUILD_MEMBER_ADD("GUILD_MEMBERS","(1 << 1)"),
    GUILD_MEMBER_UPDATE("GUILD_MEMBERS","(1 << 1)"),
    GUILD_MEMBER_REMOVE("GUILD_MEMBERS","(1 << 1)"),
    GUILD_MEMBERS("GUILD_MEMBERS","(1 << 1)",true),

    GUILD_BANS_ADD("GUILDS_BANS","(1 << 2)"),
    GUILD_BANS_REMOVE("GUILDS_BANS","(1 << 2)"),

    GUILD_EMOJI_UPDATE("GUILD_EMOJIS","(1 << 3"),

    GUILD_INTEGRATIONS_UPDATE("GUILD_INTEGRATIONS","(1 << 4)"),

    WEBHOOK_UPDATE("GUILD_WEBHOOKS","(1 << 5)"),

    INVITE_CREATE("GUILD_INVITES","(1 << 6)"),
    INVITE_DELETE("GUILD_INVITES","(1 << 6)"),

    VOICE_STATE_UPDATES("GUILD_VOICE_STATES","(1 << 7)"),

    PRESENCE_UPDATE("GUILD_PRESENCE","(1 << 8)"),

    MESSAGE_CREATE("GUILD_MESSAGES","(1 << 9"),
    MESSAGE_UPDATE("GUILD_MESSAGES","(1 << 9"),
    MESSAGE_DELETE("GUILD_MESSAGES","(1 << 9"),
    MESSAGE_DELETE_BULK("GUILD_MESSAGES","(1 << 9"),

    MESSAGE_REACTION_ADD("GUILD_MESSAGE_REACTIONS","(1 << 10)"),
    MESSAGE_REACTION_REMOVE("GUILD_MESSAGE_REACTIONS","(1 << 10)"),
    MESSAGE_REACTION_REMOVE_ALL("GUILD_MESSAGE_REACTIONS","(1 << 10)"),
    MESSAGE_REACTION_REMOVE_EMOJI("GUILD_MESSAGE_REACTIONS","(1 << 10)"),

    TYPING_START("GUILD_MESSAGE_TYPING","(1 << 11)"),

    DM_MESSAGE_CREATE("DIRECT_MESSAGES","(1 << 12)"),
    DM_MESSAGE_UPDATE("DIRECT_MESSAGES","(1 << 12)"),
    DM_MESSAGE_DELETE("DIRECT_MESSAGES","(1 << 12)"),
    DM_CHANNEL_PINS_UPDATE("DIRECT_MESSAGES","(1 << 12)"),

    DM_REACTION_ADD("DIRECT_MESSAGE_REACTIONS","(1 << 13)"),
    DM_REACTION_REMOVE("DIRECT_MESSAGE_REACTIONS","(1 << 13)"),
    DM_REACTION_REMOVE_ALL("DIRECT_MESSAGE_REACTIONS","(1 << 13)"),
    DM_REACTION_REMOVE_EMOJI("DIRECT_MESSAGE_REACTIONS","(1 << 13)"),

    DM_TYPING_START("DIRECT_MESSAGE_TYPING","(1 << 14)");



    private String category;
    private String header;
    private boolean privileged;

    GatewayIntents(String category, String header) {
        this.category = category;
        this.header = header;
    }

    GatewayIntents(String category, String header,boolean privileged){

    }

    public String getCategory() {
        return category;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return "GatewayIntents{" +
                "category='" + category + '\'' +
                ", header='" + header + '\'' +
                '}';
    }
}
