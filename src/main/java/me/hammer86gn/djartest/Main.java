package me.hammer86gn.djartest;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.events.advanced.MessageSentEvent;
import me.hammer86gn.discordjar.events.basic.IBasicEvent;
import me.hammer86gn.djartest.events.MessageEventTest;

public class Main {

    public static final String TOKEN = "ODAxMjgzODUzMjAwNjU0NDA2.YAebvQ.iB5C7myevMt8g0DIC-QxALeTs9k";

    public static DJAR djar = new DJAR();

    public static void main(String[] args) {
        djar.registerEvent(new MessageEventTest());

        djar.build(TOKEN);

    }
}
