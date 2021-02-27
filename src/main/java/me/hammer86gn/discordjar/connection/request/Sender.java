package me.hammer86gn.discordjar.connection.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Sender {

    private HttpURLConnection connection;
    private URL url;

    public Sender(URL url) {
        this.url = url;
    }


    public void addProperty(String key, String value) {
        this.connection.addRequestProperty(key, value);
    }

    public void openConnection() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(RequestMethods.GET.toString());
    }

    public String readResponse() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String input;
        StringBuffer content = new StringBuffer();
        while ((input = reader.readLine()) != null) {
            content.append(input);
        }
        return content.toString();
    }

    public void closeConnection() {
        connection.disconnect();
    }

    public String debugger() throws IOException {
        return "[Sender] Sent Data to " + url.toString() + "; Responded with code:" + getStatusCode() + "; With data" + readResponse();
    }

    public int getStatusCode() throws IOException {
        return connection.getResponseCode();
    }

}
