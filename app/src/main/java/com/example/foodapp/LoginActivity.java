package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.Database.DataSource.UserDataSource;
import com.example.foodapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding bindingctivity;
    UserDataSource userDataSource ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingctivity = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bindingctivity.getRoot());
        userDataSource = new UserDataSource(this);
        bindingctivity.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer pn = Integer.parseInt(bindingctivity.txtPN.getText().toString());
                String pw = bindingctivity.txtPW.getText().toString();

                if(userDataSource.checkPNPW(pn,pw)==true){
                    Toast.makeText(LoginActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không đúng",Toast.LENGTH_LONG).show();

            }
        });

    }
}