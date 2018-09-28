package com.line.rnapptest;

import android.content.Context;
import android.content.res.AssetManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.line.processor_annotation.JsbundleBuildAnnatation;
import com.line.rnapptest.base.ReactNativeHomeActivity;
import com.line.rnapptest.base.ReactSupport;
import com.line.rnapptest.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@JsbundleBuildAnnatation
public class MainActivity extends AppCompatActivity {
    EditText etShowPage;

    MainViewModel viewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        viewModel.show1.set(true);
        viewModel.show2.set(false);
        etShowPage = findViewById(R.id.et_show_page);
    }

    public void gotoFirstRnActivity(View view) {
//        String showPage = etShowPage.getText().toString().trim();
//        Bundle options = new Bundle();
//        options.putString("pageId", "520ee");
//        options.putString("pageName", "来自火星的你");
//        ReactNativeHomeActivity.startReactHomeActivity(this, "RnTest", showPage, options);
        String assetFileContent = getAssetFileContent(this, "test2.json");
        Toast.makeText(this, "assetCotent:" + assetFileContent, Toast.LENGTH_SHORT).show();
    }

    public void gotoM1RnActivity(View view) {
//        ReactSupport.getInstance().setModuleName("classcourse");
//        ReactNativeHomeActivity.startReactHomeActivity(this, "ClassCourse", "ClassManage", null);
        ReactSupport.getInstance().setModuleName("m1");
        ReactNativeHomeActivity.startReactHomeActivity(this, "m1", "", null);
    }

    public void gotoM2RnActivity(View view) {
        ReactSupport.getInstance().setModuleName("shop");
        ReactNativeHomeActivity.startReactHomeActivity(this, "ReactNativeApp", "", null);
    }

    public void gotoBig(View view) {
        ReactSupport.getInstance().setModuleName("big");
        ReactNativeHomeActivity.startReactHomeActivity(this, "Big", "", null);
    }

    private String getAssetFileContent(Context context, String fileName) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
