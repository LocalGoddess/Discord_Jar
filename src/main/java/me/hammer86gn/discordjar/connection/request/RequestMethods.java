package me.hammer86gn.discordjar.connection.request;

public enum RequestMethods {
    DELETE("DELETE"),
    HEAD("HEAD"),
    GET("GET"),
    OPTIONS("OPTIONS"),
    POST("POST"),
    PUT("PUT"),
    TRACE("TRACE");

    private final String req;

    RequestMethods(String Req) {
        req = Req;
    }

    public String getString() {
        return req;
    }
}
