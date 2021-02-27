package me.hammer86gn.discordjar.event;

import me.hammer86gn.discordjar.DJAR;

public abstract class Event implements IEvent {

    protected final DJAR djar;

    public Event(DJAR djar) {
        this.djar = djar;
    }

    @Override
    public DJAR getDJAR() {
        return djar;
    }
}
