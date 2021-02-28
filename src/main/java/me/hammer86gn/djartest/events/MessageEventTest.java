package me.hammer86gn.djartest.events;

import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.events.advanced.MessageSentEvent;
import me.hammer86gn.discordjar.events.listener.EventListener;

public class MessageEventTest extends EventListener {

    @Override
    public void onMessageSentEvent(MessageSentEvent event) {
        System.out.println("I am being called");
        Message message = event.getMessage();

        System.out.println(message.getMessageContent());
    }
}
