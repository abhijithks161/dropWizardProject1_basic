package com.dexlock.itemcart;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ItemApplication extends Application<ItemAppConfig> {


    public void run(ItemAppConfig itemAppConfig, Environment environment) throws Exception {
        environment.jersey().register(new ItemResource());
    }

    public static void main(String[] args) throws Exception {
        new ItemApplication().run(args);

    }
}

