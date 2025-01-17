package com.example.demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class LoginForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private String mphone;
    private String mVerifyCode;
    private EditText et_password_first;
    private EditText et_password_second;
    private EditText et_verifycode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_forget);
        et_password_first = findViewById(R.id.et_password_first);
        et_password_second = findViewById(R.id.et_password_second);
        et_verifycode = findViewById(R.id.et_verifycode);

        //从上一个页面获取需要修改密码的手机号码
        mphone = getIntent().getStringExtra("phone");
        findViewById(R.id.btn_verifycode).setOnClickListener(this);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击获取验证码按钮
            case R.id.btn_verifycode:
                //生成六位随机数字的验证码
                mVerifyCode =String.format("%06d",new Random().nextInt(999999));
                //以下弹出提醒对话框，提示用户记住六位验证码数字
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("请记住验证码");
                builder.setMessage("手机号"+mphone+",本次验证码是"+mVerifyCode+",请输入验证吗");
                builder.setPositiveButton("好的",null);
                AlertDialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.btn_confirm:
                //点击了确定按钮
                String password_first = et_password_first.getText().toString();
                String  password_second = et_password_second.getText().toString();
                if(password_first.length()<6){
                    Toast.makeText(this,"请输入正确密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password_first.equals(password_second)){
                    Toast.makeText(this,"两次输入的新密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!mVerifyCode.equals(et_verifycode.getText().toString())){
                    Toast.makeText(this,"请输入正确的验证码",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this,"密码修改成功",Toast.LENGTH_SHORT).show();
                //以下把修改成功后的密码返回上一个页面
                Intent intent=new Intent();
                intent.putExtra("new_password",password_first);
                setResult(Activity.RESULT_OK,intent);
                finish();
                break;
        }
    }
}