package com.example.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.broadcast.BroadActivity;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSharedPreferences,mBtnFile,mBtnFileMount,mBtnBroad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnFileMount = findViewById(R.id.btn_file_mount);
        mBtnBroad = findViewById(R.id.btn_broad);
        mBtnSharedPreferences.setOnClickListener(DataStorageActivity.this);
        mBtnFile.setOnClickListener(DataStorageActivity.this);
        mBtnFileMount.setOnClickListener(DataStorageActivity.this);
        mBtnBroad.setOnClickListener(DataStorageActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
            case R.id.btn_file_mount:
                intent = new Intent(DataStorageActivity.this, FileMountActivity.class);
                break;
            case R.id.btn_broad:
                intent = new Intent(DataStorageActivity.this, BroadActivity.class);
                break;

        }
        startActivity(intent);
    }
}
