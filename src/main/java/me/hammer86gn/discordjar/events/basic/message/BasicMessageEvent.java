package me.hammer86gn.discordjar.events.basic.message;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.events.basic.BasicEvent;

public abstract class BasicMessageEvent extends BasicEvent {

    DJAR djar;
    Message message;

    public BasicMessageEvent(DJAR djar, Message message) {
        super(djar);
        this.djar = djar;
        this.message = message;
    }

    public String getMessageContent() {
        return message.getMessageContent();
    }

    public Message getMessage() {
        return message;
    }
}
