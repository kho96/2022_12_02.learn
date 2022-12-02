package com.kh.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtId, edtPwd;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    // 리스너 달기
    private void setListener() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    // 아이디 찾기
    private void findViews() {
        edtId = findViewById(R.id.edtId);
        edtPwd = findViewById(R.id.edtPwd);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    // 클릭 이벤트
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == btnLogin.getId()) {
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        } else if (id == btnRegister.getId()) {
            // intent 얻어서 실행하기 -> RegisterActivity 실행하기
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        }
    }
}