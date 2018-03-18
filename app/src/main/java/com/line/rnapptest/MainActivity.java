package com.line.rnapptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.line.rnapptest.base.ReactNativeHomeActivity;
import com.line.rnapptest.base.ReactSupport;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.InternalCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Class<OkHttpClient.Builder> builerClazz = (Class<OkHttpClient.Builder>) Class.forName("okhttp3.OkHttpClient.Builder");
            if (builerClazz != null) {
                OkHttpClient.Builder builder = builerClazz.newInstance();
                if (builder != null) {
                    Method builerClazzMethod = builerClazz.getMethod("setInternalCache", InternalCache.class);
                    builerClazzMethod.setAccessible(true);
                    builerClazzMethod.invoke(builder, new InternalCache() {
                        @Override
                        public Response get(Request request) throws IOException {
                            return null;
                        }

                        @Override
                        public CacheRequest put(Response response) throws IOException {
                            return null;
                        }

                        @Override
                        public void remove(Request request) throws IOException {

                        }

                        @Override
                        public void update(Response cached, Response network) {

                        }

                        @Override
                        public void trackConditionalCacheHit() {

                        }

                        @Override
                        public void trackResponse(CacheStrategy cacheStrategy) {

                        }
                    });
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void gotoFirstRnActivity(View view) {
        startActivity(new Intent(this, FirstRnActivity.class));
    }

    public void gotoM1RnActivity(View view) {
        ReactSupport.getInstance().setModuleName("m1");
        ReactNativeHomeActivity.startReactHomeActivity(this, "m1", "");
    }

    public void gotoM2RnActivity(View view) {
        ReactSupport.getInstance().setModuleName("m2");
        ReactNativeHomeActivity.startReactHomeActivity(this, "m2", "");
    }
}
