package com.line.rnapptest.reactmodules;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.PixelUtil;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by chenliu on 2018/2/27.
 */

public class ToastModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    //从startActivityForResult中获取结果
    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener(){
        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            super.onActivityResult(activity, requestCode, resultCode, data);
        }
    };

    //监听生命周期事件
    private final LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() {
        @Override
        public void onHostResume() {
            Toast.makeText(getReactApplicationContext(), "onHostResume", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onHostPause() {
            Toast.makeText(getReactApplicationContext(), "onHostPause", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onHostDestroy() {
            Toast.makeText(getReactApplicationContext(), "onHostDestroy", Toast.LENGTH_SHORT).show();
        }
    };

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);

        // Add the listener for `onActivityResult`
        reactContext.addActivityEventListener(mActivityEventListener);
        reactContext.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override
    public String getName() {
        return "ToastModule";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String msg, int duration){
        Toast.makeText(getReactApplicationContext(), msg, duration).show();
    }

    @ReactMethod
    public void testCallback(int page, Callback callback){
        callback.invoke("from page " + page);

    }

    @ReactMethod
    public void testPromise(int tag,
                            Promise promise){
        try {
            Thread.sleep(1000);
            WritableMap map = Arguments.createMap();
            map.putDouble("width", PixelUtil.toDIPFromPixel(10));
            map.putDouble("height", PixelUtil.toDIPFromPixel(20));

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }

    /**
     * 测试直接传一个String是不可以的
     * map中的key必须和js中定义的变量名一致，否则js那边获取不到
     * @param tag
     * @param promise
     */
    @ReactMethod
    public void testPromiseString(int tag,
                                  Promise promise){
        WritableMap map = Arguments.createMap();
        map.putString("msg", "testPromiseString");
        promise.resolve(map);
    }

    /**
     * 发送事件到js
     * @param reactContext
     * @param eventName
     * @param params
     */
    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    @ReactMethod
    public void sendEvent1(){
        WritableMap params = Arguments.createMap();
        params.putString("name", "oooo");
        params.putInt("age", 19);
        sendEvent(getReactApplicationContext(), "studentEvent", params);
    }

}
