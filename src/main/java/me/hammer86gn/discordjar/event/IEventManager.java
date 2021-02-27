package me.hammer86gn.discordjar.event;

public interface IEventManager {

    void register(Object listener);

    void unregister(Object listener);

}
