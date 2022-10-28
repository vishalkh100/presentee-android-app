package com.pantherstudios.presentee.Functions;

import android.app.Application;
import android.content.Context;

public class ApplContext extends Application {

    private static Context mContext;

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return mContext;
    }

}