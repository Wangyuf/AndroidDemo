package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button mDialog1,mDialog2,mDialog3,mDialog4,mDialog5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mDialog1 = findViewById(R.id.btn_dialog1);
        mDialog2 = findViewById(R.id.btn_dialog2);
        mDialog3 = findViewById(R.id.btn_dialog3);
        mDialog4 = findViewById(R.id.btn_dialog4);
        mDialog5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mDialog1.setOnClickListener(onClick);
        mDialog2.setOnClickListener(onClick);
        mDialog3.setOnClickListener(onClick);
        mDialog4.setOnClickListener(onClick);
        mDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogActivity.this);
                    builder1.setTitle("请回答").setIcon(R.drawable.bg_checkbox_true).setMessage("你觉得课程如何?").setPositiveButton("棒", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"你很诚实");
                        }
                    }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"再看看");
                        }
                    }).setNegativeButton("不好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this,"真的么?");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    final String[] array2 = new String[]{"男", "女"};
                    builder2.setTitle("性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    final String[] array3 = new String[]{"男", "女"};
                    builder3.setTitle("性别").setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    final String[] array4 = new String[]{"唱歌", "跳舞", "篮球"};
                    boolean[] check = new boolean[]{false, true, true};
                    builder4.setTitle("性别").setMultiChoiceItems(array4, check, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this, array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);

                    EditText etUserName = view.findViewById(R.id.et_username);
                    EditText etPassword = view.findViewById(R.id.et_password);
                    Button btnLogin = view.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();

                    break;
            }

        }
    }
}
