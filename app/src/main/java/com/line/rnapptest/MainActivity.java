package com.line.rnapptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.line.rnapptest.base.ReactNativeHomeActivity;
import com.line.rnapptest.base.ReactSupport;

public class MainActivity extends AppCompatActivity {
    EditText etShowPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etShowPage = findViewById(R.id.et_show_page);
    }

    public void gotoFirstRnActivity(View view) {
        String showPage = etShowPage.getText().toString().trim();
        ReactNativeHomeActivity.startReactHomeActivity(this, "RnTest", showPage);
//        startActivity(new Intent(this, FirstRnActivity.class));
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
