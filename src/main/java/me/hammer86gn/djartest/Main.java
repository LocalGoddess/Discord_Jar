package me.hammer86gn.djartest;

import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.djartest.events.MessageSentEvent;

import java.io.IOException;

public class Main {

    public static final String TOKEN = "";

    public static DJAR djar = new DJAR();

    public static void main(String[] args) {
        djar.build(TOKEN);
        djar.addListener(new MessageSentEvent());
    }
}
