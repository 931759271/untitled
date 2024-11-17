package com.example.demo1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.ViewUtils;

import java.util.Random;

public class ActivityLoginMain extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private TextView tv_password;
    private EditText et_password;
    private Button btn_forget;
    private CheckBox ck_remember;
    private EditText et_phone;
    private RadioButton rb_password;
    private RadioButton rb_verifycode;
    private ActivityResultLauncher<Intent> register;
    private Button btn_login;
    private String mpassword="111111";
    private String mVerifyCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        RadioGroup rb_login=findViewById(R.id.rb_login);
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        et_phone = findViewById(R.id.et_phone);
        btn_forget = findViewById(R.id.btn_forget);
        ck_remember = findViewById(R.id.ck_remember);
        btn_login = findViewById(R.id.btn_login);


        //单选监听器
        rb_login.setOnCheckedChangeListener(this);
        btn_forget.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        //给et_phone添加文本变更监听器
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone,11));
        et_password.addTextChangedListener(new HideTextWatcher(et_password,6));

        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent intent=result.getData();
                if (intent!=null&&result.getResultCode()== Activity.RESULT_OK){
                    //用户密码已改为新密码，故更新密码变量
                    mpassword=intent.getStringExtra("new_password");
                }

            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            //选择了密码登录
            case R.id.rb_password:
                tv_password.setText(getString(R.string.login_password));
                et_password.setText(getString(R.string.input_password));
                btn_forget.setText(getString(R.string.forget_password));
                ck_remember.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_verifycode:
                tv_password.setText(getString(R.string.verify_code));
                et_password.setText(getString(R.string.input_verifycode));
                btn_forget.setText(getString(R.string.get_verifycode));
                ck_remember.setVisibility(View.GONE);
                break;


        }

    }

    @Override
    public void onClick(View view) {
        String phone=et_phone.getText().toString();
        if(phone.length()<11){
            Toast.makeText(this,"请输入正确的手机号码",Toast.LENGTH_SHORT).show();
            return;
        }
        switch (view.getId()){

            case R.id.btn_forget:

                if(rb_password.isChecked()){
                    //携带手机号码跳转到找回密码界面
                    Intent intent=new Intent(this,LoginForgetActivity.class);
                    intent.putExtra("phone",phone);
                    register.launch(intent);
                } else if (rb_verifycode.isChecked()) {
                    //生成随机六位验证码
                    mVerifyCode = String.format("%06d",new Random().nextInt(999999));
                    //以下弹出提醒对话框，提示用户记住六位验证码数字
                    AlertDialog.Builder builder= new AlertDialog.Builder(this);
                    builder.setTitle("请记住验证码");
                    builder.setMessage("手机号"+phone+",本次验证码是"+ mVerifyCode +"请输入验证码");
                    builder.setPositiveButton("好的",null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                    
                }
                break;
            case R.id.btn_login:
                //如果是密码校验的方式
                if(rb_password.isChecked()){
                    if(!mpassword.equals(et_password.getText().toString())) {
                        Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //提示用户登录成功
                    loginSuccess();
                }else if(rb_verifycode.isChecked()){
                    //验证码方式校验
                    if(!mVerifyCode.equals(et_password.getText().toString())) {
                        Toast.makeText(this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //提示用户登录成功
                    loginSuccess();
                }

                break;
        }
    }

    private void loginSuccess() {
        String desc=String.format("你的手机号码是%s,恭喜你通过登录验证，点击，点击”确定“按钮返回上个页面",
                et_phone.getText().toString());
        //弹出提醒对话框，提醒用户登录成功
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("登录成功");
        builder.setMessage(desc);
        builder.setPositiveButton("确定返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("我在看看",null);
        AlertDialog dialog=builder.create();
        dialog.show();

    }


    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxlength;
        public HideTextWatcher(EditText v, int maxlenghth) {
            this.mView=v;
            this.mMaxlength=maxlenghth;

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(editable.toString().length()==mMaxlength){

            }

        }
    }
}