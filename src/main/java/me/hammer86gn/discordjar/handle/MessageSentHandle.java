package me.hammer86gn.discordjar.handle;

import com.google.gson.JsonObject;
import me.hammer86gn.discordjar.DJAR;
import me.hammer86gn.discordjar.discord.entites.message.Message;
import me.hammer86gn.discordjar.events.advanced.MessageSentEvent;

public class MessageSentHandle extends BaseHandle {
    public MessageSentHandle(DJAR djar) {
        super(djar);
    }

    @Override
    public Long handleInternally(JsonObject object) {
        Message message;
        DJAR djar;

        message = Message.getFromJson(object);
        djar = getDJAR();

        switch (message.getMessageType()) {
            case "0":
                djar.handleEvent(new MessageSentEvent(djar, message));
                System.out.println("Messager");
                break;
        }

        return null;
    }

}
