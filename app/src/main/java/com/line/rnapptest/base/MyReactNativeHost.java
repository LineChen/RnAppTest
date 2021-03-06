package com.line.rnapptest.base;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.io.File;
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
        return false;
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
        String path = Environment.getExternalStorageDirectory().getPath() + "/" + "RnSrc/m1.android.jsbundle";
        File file = new File(path);
        String ret = file.exists() ? path : null;
        return ret;
    }

    @Override
    protected String getJSMainModuleName() {
        Log.e(TAG, "getJSMainModuleName");
        if("m1".equals(ReactSupport.getInstance().getModuleName())){
            return "m1.index";
        } else if("m2".equals(ReactSupport.getInstance().getModuleName())){
            return "m2.index";
        }
//        return "index.test";
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
        } else if("classcourse".equals(ReactSupport.getInstance().getModuleName())){
            return "classcourse.android.jsbundle";
        } else if("shop".equals(ReactSupport.getInstance().getModuleName())){
            return "shop.android.jsbundle";
        }else if("big".equals(ReactSupport.getInstance().getModuleName())){
            return "big.android.jsbundle";
        }
        return "index.android.jsbundle";
    }
}
