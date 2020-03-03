package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button mbtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mRadioButton;
    private Button mCheckBox;
    private Button mBtnImgaeView;
    private Button mBtnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mRadioButton = findViewById(R.id.btn_radiobutton);
        mCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImgaeView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        setListeners();
    }

    private void setListeners(){
        Onclick onclick = new Onclick();
        mbtnTextView.setOnClickListener(onclick);
        mBtnButton.setOnClickListener(onclick);
        mBtnEditText.setOnClickListener(onclick);
        mRadioButton.setOnClickListener(onclick);
        mCheckBox.setOnClickListener(onclick);
        mBtnImgaeView.setOnClickListener(onclick);
        mBtnListView.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
            }
            startActivity(intent);

        }
    }
}
