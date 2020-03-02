package com.dexlock.itemcart;

import io.dropwizard.Configuration;

public class ItemAppConfig extends Configuration  {

    private String type;
    private int port;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private static String defaultName;

    public static String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
