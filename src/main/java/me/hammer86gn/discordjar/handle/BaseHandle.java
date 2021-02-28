package me.hammer86gn.discordjar.handle;

import com.google.gson.JsonObject;
import me.hammer86gn.discordjar.DJAR;

public abstract class BaseHandle {

    private final DJAR djar;
    private JsonObject object;


    public BaseHandle(DJAR djar) {
        this.djar = djar;
    }

    public final synchronized void handle(JsonObject object) {
        this.object = object;
        JsonObject details = object.get("d").getAsJsonObject();
        final long guild_ID = details.get("guild_id").getAsLong();

    }

    public abstract Long handleInternally(JsonObject object);


    protected DJAR getDJAR() {
        return djar;
    }

    public static class HandleHandler extends BaseHandle {

        public HandleHandler(DJAR djar) {
            super(djar);
        }

        @Override
        public Long handleInternally(JsonObject object) {
            return null;
        }
    }

}
