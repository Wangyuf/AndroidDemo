package com.example.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.helloworld.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText mEtName;
    private Button mBtnSave, mBtnShow;
    private TextView mTvContent;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        mEtName = findViewById(R.id.et_name);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvContent = findViewById(R.id.tv_content);

        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("name", mEtName.getText().toString());
                mEditor.apply();
            }
        });

        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mSharedPreferences.getString("name", "hello");
                mTvContent.setText(content);
            }
        });
        // todo 数据是以键值对形式存储 安卓系统内查看存在的文件
        // adb shell
        //run-as com.example.helloworld
        //  cat data.xml
    }
}
