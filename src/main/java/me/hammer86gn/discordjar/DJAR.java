/*

    Licensed under the GNU General Public License

    Code Written by Hammer86gn (https://www.github.com/Hammer86gn)


 */

package me.hammer86gn.discordjar;

import me.hammer86gn.discordjar.connection.websocket.WebSocketClient;

public class DJAR {
    public static DJAR instance;
    private String token;
    //URL: wss://gateway.discord.gg/?v=8&encoding=json

    public DJAR() {
        instance = this;
    }

    public static void main(String[] args) {
        DJAR djar = new DJAR();
        djar.build("notokenforyou");

        WebSocketClient client = new WebSocketClient("wss://gateway.discord.gg/?v=8&encoding=json",djar);
        client.connect();
    }

    public void build(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static DJAR getInstance() {
        return instance;
    }
}
