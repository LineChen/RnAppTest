package com.line.rnapptest.base;

import android.app.Application;
import android.util.Log;

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

    private static final String TAG = "MyReactNativeHost";

    protected MyReactNativeHost(Application application) {
        super(application);
    }

    @Override
    public boolean getUseDeveloperSupport() {
        Log.e(TAG, "getUseDeveloperSupport");
        return true;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        Log.e(TAG, "getPackages");
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new MyJSBridgeReactPackage()
        );
    }

    @Nullable
    @Override
    protected String getJSBundleFile() {
        Log.e(TAG, "getJSBundleFile");
        return super.getJSBundleFile();
    }

    @Override
    protected String getJSMainModuleName() {
        Log.e(TAG, "getJSMainModuleName");
        if("m1".equals(ReactSupport.getInstance().getModuleName())){
            return "index.m1";
        } else if("m2".equals(ReactSupport.getInstance().getModuleName())){
            return "index.m2";
        }
        return "index";
    }

    @Nullable
    @Override
    protected String getBundleAssetName() {
        Log.e(TAG, "getBundleAssetName");
        if("m1".equals(ReactSupport.getInstance().getModuleName())){
            return "m1.android.jsbundle";
        } else if("m2".equals(ReactSupport.getInstance().getModuleName())){
            return "m2.android.jsbundle";
        }
        return "index.android.jsbundle";
    }
}
