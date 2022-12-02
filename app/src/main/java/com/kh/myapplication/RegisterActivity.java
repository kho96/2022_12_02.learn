package com.kh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDupId, btnBack, btnRegister;
    EditText edtName, edtId, edtPwd, edtPwd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        findviews();
        setListener();
    }

    // 리스너 달기
    private void setListener() {
        btnDupId.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    // 아이디 찾기
    private void findviews() {
        btnDupId = findViewById(R.id.btnDupId);
        btnBack = findViewById(R.id.btnBack);
        btnRegister = findViewById(R.id.btnRegister);
        edtName = findViewById(R.id.edtName);
        edtId = findViewById(R.id.edtId);
        edtPwd = findViewById(R.id.edtPwd);
        edtPwd2 = findViewById(R.id.edtPwd2);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == btnDupId.getId()) {

        } else if (id == btnRegister.getId()) {

        } else if (id == btnBack.getId()) { //현재 activity종료
            finish();
        }
    }
}
