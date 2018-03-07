package com.line.rnapptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.line.rnapptest.base.ReactNativeHomeActivity;
import com.line.rnapptest.base.ReactSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
