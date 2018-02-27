package com.line.rnapptest.reactmodules;

import android.widget.Toast;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
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


    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
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
            Thread.sleep(3000);
            WritableMap map = Arguments.createMap();
            map.putDouble("width", PixelUtil.toDIPFromPixel(10));
            map.putDouble("height", PixelUtil.toDIPFromPixel(20));

            promise.resolve(map);
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}
