package me.hammer86gn.djartest;

import me.hammer86gn.discordjar.DJAR;

public class Main {

    public static final String TOKEN = "ODAxMjgzODUzMjAwNjU0NDA2.YAebvQ.cFvTk_JJINzUcnXSsA8XqadtOrc";

    public static DJAR djar = new DJAR();

    public static void main(String[] args) {
        djar.build(TOKEN);
        System.out.println("Hello");
    }
}
