package me.hammer86gn.discordjar.event;

import me.hammer86gn.discordjar.event.message.MessageCreatedEvent;

public abstract class EventListener implements IEventListener {

    public void onMessageSentEvent(MessageCreatedEvent event) {}

    @Override
    public final void onEvent(Event event) {

        if (event instanceof MessageCreatedEvent)
            onMessageSentEvent((MessageCreatedEvent) event);
    }

}
