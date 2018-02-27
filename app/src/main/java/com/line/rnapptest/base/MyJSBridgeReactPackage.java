package com.line.rnapptest.base;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.line.rnapptest.reactmodules.ToastModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenliu on 2018/2/26.
 */

public class MyJSBridgeReactPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new ToastModule(reactContext));
        return modules;
    }


    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return new ArrayList<>();
    }

}
