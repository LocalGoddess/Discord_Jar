package me.hammer86gn.djartest;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.events.advanced.MessageSentEvent;
import me.hammer86gn.discordjar.events.basic.IBasicEvent;
import me.hammer86gn.djartest.events.MessageEventTest;

public class Main {

    public static final String TOKEN = "ODAxMjgzODUzMjAwNjU0NDA2.YAebvQ.W5JG6fz4weeTjRV4-xagr159asQ";

    public static DJAR djar = new DJAR();

    public static void main(String[] args) {
        djar.registerEvent(new MessageEventTest());
        System.out.println("TEST");
        System.out.println(djar.getAllRegisteredEvents().toString());
        System.out.println("Hello");

        djar.build(TOKEN);

    }
}
