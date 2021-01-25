package me.hammer86gn.discordjar.discord.user.permissions;

import me.hammer86gn.discordjar.discord.channel.ChannelTypes;

public enum Permission {
    CREATE_INSTANT_INVITE("0x00000001","Allows creation of instant invites",ChannelTypes.ALL,false),
    KICK_MEMBERS("0x00000002","Allows kicking members",ChannelTypes.NULL,true),
    BAN_MEMBERS("0x00000004","Allows banning members",ChannelTypes.NULL,true),
    ADMINISTRATOR("0x00000008","Allows all permissions and bypasses channel permission overwrites",ChannelTypes.NULL,true),
    MANAGE_CHANNELS("0x00000010","Allows management and editing of channels",ChannelTypes.ALL,true),
    MANAGE_GUILD("0x00000020","Allows management and editing of the guild",ChannelTypes.NULL,true),
    ADD_REACTION("0x00000040","Allows for the addition of reactions to messages",ChannelTypes.TEXT,false),
    VIEW_AUDIT_LOG(	"0x00000080","Allows for viewing of audit logs",ChannelTypes.NULL,false),
    PRIORITY_SPEAKER("0x00000100","Allows for using priority speaker in a voice channel",ChannelTypes.VOICE,false),
    STREAM("0x00000200","Allows the user to go live",ChannelTypes.VOICE,false),
    VIEW_CHANNEL("0x00000400","Allows guild members to view a channel, which includes reading messages in text channels",ChannelTypes.ALL,false),
    SEND_MESSAGES("0x00000800","Allows for sending messages in a channel",ChannelTypes.TEXT,false),
    SEND_TTS_MESSAGES("0x00001000","Allows for sending of /tts messages",ChannelTypes.TEXT,false),
    MANAGE_MESSAGES("0x00002000","Allows for deletion of other users messages",ChannelTypes.TEXT,true),
    EMBED_LINKS("0x00004000","Links sent by users with this permission will be auto-embedded",ChannelTypes.TEXT,false),
    ATTACH_FILES("0x00008000","Allows for uploading images and files",ChannelTypes.TEXT,false),
    READ_MESSAGE_HISTORY("0x00010000","Allows for reading of message history",ChannelTypes.TEXT,false),
    MENTION_EVERYONE("0x00020000","Allows for using the @everyone tag to notify all users in a channel, and the @here tag to notify all online users in a channel",ChannelTypes.TEXT,false),
    USE_EXTERNAL_EMOJIS("0x00040000","Allows the usage of custom emojis from other servers",ChannelTypes.TEXT,false),
    VIEW_GUILD_INSIGHTS("0x00080000","Allows for viewing guild insights",ChannelTypes.NULL,false),
    CONNECT("0x00100000","Allows for joining of a voice channel",ChannelTypes.VOICE,false),
    SPEAK("0x00200000","Allows for speaking in a voice channel",ChannelTypes.VOICE,false),
    MUTE_MEMBERS("0x00400000","Allows for muting members in a voice channel",ChannelTypes.VOICE,false),
    DEAFEN_MEMBERS("0x00800000","Allows for deafening of members in a voice channel",ChannelTypes.VOICE,false),
    MOVE_MEMBERS("0x01000000","Allows for moving of members between voice channels",ChannelTypes.VOICE,false),
    USE_VAD("0x02000000","Allows for using voice-activity-detection in a voice channel",ChannelTypes.VOICE,false),
    CHANGE_NICKNAME("0x04000000","Allows for modification of own nickname",ChannelTypes.NULL,false),
    MANAGE_NICKNAMES("0x08000000","Allows for modification of other users nicknames",ChannelTypes.NULL,false),
    MANAGE_ROLES("0x10000000","Allows management and editing of roles",ChannelTypes.ALL,true),
    MANAGE_WEBHOOKS("0x20000000","Allows management and editing of webhooks",ChannelTypes.ALL,true),
    MANAGE_EMOJIS("0x40000000","Allows management and editing of emojis",ChannelTypes.NULL,true);



    private final String value;
    private final String description;
    private final ChannelTypes channelType;
    private final boolean requires2FA;

    Permission(String value, String description, ChannelTypes channelType,boolean requires2FA) {
        this.value = value;
        this.description = description;
        this.channelType = channelType;
        this.requires2FA = requires2FA;
    }

}
