package me.hammer86gn.discordjar.events.listener;

import me.hammer86gn.discordjar.events.basic.IBasicEvent;

@FunctionalInterface
public interface IEventsListener {
    void onEvent(IBasicEvent basicEvent);
}
