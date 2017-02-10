package com.ak681443.ilovezappos.application;

import android.app.Application;

import static com.ak681443.ilovezappos.util.ZAPIUtil.*;

/**
 * Created by arvind on 2/9/17.
 */

public class AppInstance extends Application {
    private static AppInstance currInstance = null;

    @Override
    public void onCreate() {
        initializeAPI();
        currInstance = this;
    }

    public static AppInstance getInstance(){
        return currInstance;
    }
}