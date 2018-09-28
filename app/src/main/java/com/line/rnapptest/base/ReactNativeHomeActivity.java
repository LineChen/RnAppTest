package com.line.rnapptest.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

/**
 * Created by chenliu on 2018/3/6.
 */

public class ReactNativeHomeActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    private static final String TAG = "ReactNativeHomeActivity";

    public static void startReactHomeActivity(Context context, String moduleName, String showPage, Bundle options){
        Intent intent = new Intent(context, ReactNativeHomeActivity.class);
        intent.putExtra("moduleName", moduleName);
        intent.putExtra("showPage", showPage);
        if (options != null) {
            intent.putExtras(options);
        }
        context.startActivity(intent);
    }

    private ReactRootView mReactRootView;

    private ReactInstanceManager mReactInstanceManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String moduleName = intent.getStringExtra("moduleName");
        String showPage = intent.getStringExtra("showPage");

        Bundle bundle = new Bundle();
        bundle.putString("showPage", showPage);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            bundle.putAll(extras);
        }

        Log.e(TAG, "before init mReactRootView");
        mReactRootView = new ReactRootView(this);
        Log.e(TAG, "after init mReactRootView");
        mReactInstanceManager = RnApplication.getInstance().getReactNativeHost().getReactInstanceManager();
        mReactRootView.startReactApplication(mReactInstanceManager,
                moduleName,
                bundle);
        Log.e(TAG, "before setContentView");
        setContentView(mReactRootView);
        Log.e(TAG, "after setContentView");
    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

}
