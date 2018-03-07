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
        return true;
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

    @Override
    protected String getJSMainModuleName() {
        return "index";
    }

    @Nullable
    @Override
    protected String getBundleAssetName() {
//        if("m1".equals(ReactSupport.getInstance().getModuleName())){
//            return "index.android.jsbundle";
//        } else if("m2".equals(ReactSupport.getInstance().getModuleName())){
//            return "index2.android.jsbundle";
//        }
        return "index.android.jsbundle";
    }
}
