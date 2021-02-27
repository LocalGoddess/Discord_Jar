package me.hammer86gn.djartest.events;

import me.hammer86gn.discordjar.event.EventListener;
import me.hammer86gn.discordjar.event.message.MessageCreatedEvent;

public class MessageSentEvent extends EventListener {

    @Override
    public void onMessageSentEvent(MessageCreatedEvent event) {
        String messageContent = event.getMessage().getMessageContent();

        System.out.println(messageContent);

    }

}
