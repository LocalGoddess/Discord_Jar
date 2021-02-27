package me.hammer86gn.discordjar.event.message;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.guild.Guild;
import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.event.Event;

public abstract class BaseMessageEvent extends Event {
    private final Message message;

    public BaseMessageEvent(DJAR djar, Message message) {
        super(djar);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    //TODO get the channel

    //TODO makes this work and fix guild
    //FIXME fix this so that it actually gets a guild
//    public Guild getEventGuild() {
//        return new Guild(message.getGuildID());
//    }
}
