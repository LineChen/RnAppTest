package com.line.rnapptest.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

/**
 * Created by chenliu on 2018/3/6.
 */

public class ReactNativeHomeActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {

    public static void startReactHomeActivity(Context context, String moduleName, String initModule){
        Intent intent = new Intent(context, ReactNativeHomeActivity.class);
        intent.putExtra("moduleName", moduleName);
        intent.putExtra("initModule", initModule);
        context.startActivity(intent);
    }

    private ReactRootView mReactRootView;

    private ReactInstanceManager mReactInstanceManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String moduleName = intent.getStringExtra("moduleName");
        String initModule = intent.getStringExtra("initModule");

        Bundle bundle = new Bundle();
        bundle.putString("initModule", initModule);

        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = RnApplication.getInstance().getReactNativeHost().getReactInstanceManager();
        mReactRootView.startReactApplication(mReactInstanceManager,
                moduleName,
                bundle);

        setContentView(mReactRootView);

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
