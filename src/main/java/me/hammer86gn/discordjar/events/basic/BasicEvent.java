package me.hammer86gn.discordjar.events.basic;

import me.hammer86gn.discordjar.DJAR;

public abstract class BasicEvent implements IBasicEvent{

    private final DJAR djar;

    public BasicEvent(DJAR djar) {

        this.djar = djar;
    }

    @Override
    public DJAR getDJAR() {
        return djar;
    }

}
