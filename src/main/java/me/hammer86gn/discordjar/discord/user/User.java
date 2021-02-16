package me.hammer86gn.discordjar.discord.user;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.hammer86gn.discordjar.DJAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class User {

    private final String id;
    private final String username;
    private final String discriminator;
    private final String avatar;
    private final boolean verified;
    private final String email;
    private final int flags;
    private final PremiumType premium_type;
    private final int public_flags;
    private final JsonObject object;

    public User(String id, String username, String discriminator, String avatar, boolean verified, String email, int flags, PremiumType premium_type, int public_flags) {
        this.id = id;
        this.username = username;
        this.discriminator = discriminator;
        this.avatar = avatar;
        this.verified = verified;
        this.email = email;
        this.flags = flags;
        this.premium_type = premium_type;
        this.public_flags = public_flags;
        object = new JsonObject();

        object.addProperty("id",id);
        object.addProperty("username",username);
        object.addProperty("discriminator",discriminator);
        object.addProperty("avatar",avatar);
        object.addProperty("verified",verified);
        object.addProperty("email",email);
        object.addProperty("flags",flags);
        object.addProperty("premium_type",premium_type.getValue());
        object.addProperty("public_flags",public_flags);
    }

    public User getUser(String id) throws IOException {
        String getUrl = DJAR.API_URL + "/users/" + id;
        URL url = new URL(getUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {
            content.append(inputLine);
        }
        reader.close();

        JsonObject object = JsonParser.parseString(content.toString()).getAsJsonObject();

        User user = new User(object.get("id").getAsString(), object.get("username").getAsString(), object.get("discriminator").getAsString(), object.get("avatar").getAsString(),
                object.get("verified").getAsBoolean(), object.get("email").getAsString(), object.get("flags").getAsInt(), PremiumType.getPremiumType(object.get("premium_type").getAsInt()) ,
                object.get("public_flags").getAsInt());
        return user;
    }

        /*
{
  "id": "80351110224678912",
  "username": "Nelly",
  "discriminator": "1337",
  "avatar": "8342729096ea3675442027381ff50dfe",
  "verified": true,
  "email": "nelly@discord.com",
  "flags": 64,
  "premium_type": 1,
  "public_flags": 64
}
         */
}
