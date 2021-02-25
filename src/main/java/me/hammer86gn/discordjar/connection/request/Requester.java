package me.hammer86gn.discordjar.connection.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {

    private HttpURLConnection connection;
    private URL url;

    public Requester(URL url) throws IOException {
        this.url = url;
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(RequestMethods.GET.toString());
    }

    public int getStatusCode() throws IOException {
        return connection.getResponseCode();
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
        return "[Requester] Requested Data from " + url.toString() + "; Responded with code:" + getStatusCode() + "; With data" + readResponse();
    }

    public HttpURLConnection getConnection() {
        return connection;
    }
}
