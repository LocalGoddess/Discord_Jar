package me.hammer86gn.discordjar.events.advanced;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.events.basic.message.BasicMessageEvent;

public class MessageSentEvent extends BasicMessageEvent {
    public MessageSentEvent(DJAR djar, Message message) {
        super(djar, message);
    }
}
