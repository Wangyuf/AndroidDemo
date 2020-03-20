package com.example.helloworld.jump;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;
import com.example.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump = findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1、显示调用
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "小米");
                bundle.putInt("price", 999);
                intent.putExtras(bundle);
//                startActivity(intent);

                startActivityForResult(intent, 0);
                // 2、显示调用
                //Intent intent = new Intent();
                //intent.setClass(AActivity.this, BActivity.class);
                //startActivity(intent);
                // 3、显示调用
                //Intent intent = new Intent();
                // intent.setClassName(AActivity.this, "com.example.helloworld.jump.BActivity");
                //startActivity(intent);
                // 4、显示调用
                //Intent intent = new Intent();
                //intent.setComponent(new ComponentName(AActivity.this, "com.example.helloworld.jump.BActivity"));
                //startActivity(intent);
                // 5、隐式调用
                //Intent intent = new Intent();
                //intent.setAction("com.example.test.BActivity");
                //startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }


}
