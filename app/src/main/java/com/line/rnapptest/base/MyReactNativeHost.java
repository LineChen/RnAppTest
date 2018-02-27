package com.line.rnapptest.base;

import android.app.Application;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by chenliu on 2018/2/26.
 */

public class MyReactNativeHost extends ReactNativeHost {

    protected MyReactNativeHost(Application application) {
        super(application);
    }

    @Override
    public boolean getUseDeveloperSupport() {
        return false;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new MyJSBridgeReactPackage()
        );
    }

    @Nullable
    @Override
    protected String getJSBundleFile() {
        return super.getJSBundleFile();
    }

    @Nullable
    @Override
    protected String getBundleAssetName() {
        return "index.android.jsbundle";
    }
}
