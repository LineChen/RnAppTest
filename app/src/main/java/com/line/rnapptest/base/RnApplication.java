package com.line.rnapptest.base;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;

/**
 * Created by chenliu on 2018/2/26.
 */

public class RnApplication extends Application implements ReactApplication {

    private static RnApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public ReactNativeHost getReactNativeHost() {
        return new MyReactNativeHost(this);
    }

    public static RnApplication getInstance(){
        return instance;
    }
}
