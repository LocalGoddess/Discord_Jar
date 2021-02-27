package me.hammer86gn.discordjar.event;

import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager implements IEventManager {

    private final CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<>();
    private static EventManager instance;


    public EventManager() {
        instance = this;
    }

    @Override
    public void register(Object listener) {
        if (!(listener instanceof EventListener)) {
            throw new IllegalArgumentException("Please use a DJAR event");
        }
        listeners.add((EventListener) listener);
    }

    @Override
    public void unregister(Object listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public static EventManager getInstance() {
        return instance;
    }
}
