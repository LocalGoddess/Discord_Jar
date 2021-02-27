package me.hammer86gn.discordjar.event.message;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.message.Message;

public class MessageCreatedEvent extends BaseMessageEvent{

    public MessageCreatedEvent(DJAR djar, Message message) {
        super(djar, message);
    }

    @Override
    public Message getMessage() {
        return super.getMessage();
    }

    @Override
    public DJAR getDJAR() {
        return super.getDJAR();
    }
}
