package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        // 内部类实现
        //mBtnEvent.setOnClickListener(new Onclick());
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this, "匿名内部类实现");
//            }
//        });
        // 通过事件源所在类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        // 通过外部类实现
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
        // 页面布局实现
        // todo 注意 给同一事件源添加多种类型监听器 仅最后一个添加生效
        // todo 布局文件内的事件级别最低
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "事件源所在类实现");
                break;
        }
    }

    class Onclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    ToastUtil.showMsg(EventActivity.this, "内部类实现");
                    break;
            }
        }
    }

    public void show(View v){
        switch (v.getId()){
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "页面点击");
                break;
        }
    }
}
