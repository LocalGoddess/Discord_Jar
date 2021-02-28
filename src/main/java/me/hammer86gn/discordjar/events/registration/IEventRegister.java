package me.hammer86gn.discordjar.events.registration;

import me.hammer86gn.discordjar.events.basic.IBasicEvent;

import java.util.List;

public interface IEventRegister {

    void register(Object event);

    void unregister(Object event);

    void eventHandle(IBasicEvent basicEvent);

    List<Object> getAllRegister();

}
