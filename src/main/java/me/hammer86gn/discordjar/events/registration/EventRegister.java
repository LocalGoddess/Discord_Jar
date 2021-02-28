package me.hammer86gn.discordjar.events.registration;

import me.hammer86gn.discordjar.events.basic.IBasicEvent;
import me.hammer86gn.discordjar.events.listener.IEventsListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventRegister implements IEventRegister {
    private final CopyOnWriteArrayList<IEventsListener> registered = new CopyOnWriteArrayList<>();

    public EventRegister() {

    }


    @Override
    public void register(Object event) {
        if (!(event instanceof IEventsListener)) {
            throw new IllegalArgumentException("Events must implement IEventsListener");
        }
        registered.add((IEventsListener) event);
    }

    @Override
    public void unregister(Object event) {
        if (!(event instanceof IEventsListener)) {
            if (event == null) {
                System.out.println("null");
            }
            registered.remove(event);
        }
    }

    @Override
    public void eventHandle(IBasicEvent basicEvent) {
        for (IEventsListener registeredEvent : registered) {
            try {
                registeredEvent.onEvent(basicEvent);
            } catch (Throwable t) {
                String message =  t.getMessage();
                System.out.println("One event had an exception" + "\nException: " + message);
                if (t instanceof Error) {
                    throw (Error) t;
                }
            }

        }
    }

    @Override
    public List<Object> getAllRegister() {
        return Collections.unmodifiableList(new ArrayList<>(registered));
    }
}
