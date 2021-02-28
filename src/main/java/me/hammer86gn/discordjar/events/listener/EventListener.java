package me.hammer86gn.discordjar.events.listener;

import me.hammer86gn.discordjar.events.advanced.MessageSentEvent;
import me.hammer86gn.discordjar.events.basic.IBasicEvent;
import me.hammer86gn.discordjar.events.basic.message.BasicMessageEvent;

public abstract class EventListener implements IEventsListener {

    //BasicEvent
    public void onBasicEvent(IBasicEvent basicEvent) {}
    public void onBasicMessageEvent(BasicMessageEvent basicMessageEvent) {}

    // AdvancedEvent
        // Message
        public void onMessageSentEvent(MessageSentEvent messageSentEvent) {}

    @Override
    public void onEvent(IBasicEvent basicEvent) {
        onBasicEvent(basicEvent);
        if (basicEvent instanceof MessageSentEvent)
            onMessageSentEvent((MessageSentEvent) basicEvent);

        // Advanced


    }
}
