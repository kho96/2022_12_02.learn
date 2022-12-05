package com.kh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            // id 중복값 확인 test : admin
            String userId = String.valueOf(edtId.getText());
            if (userId.equals("admin")) {
                Toast.makeText(this, "사용할 수 없는 아이디입니다.", Toast.LENGTH_SHORT).show();
                edtId.setText("");
            } else if (userId.equals("")) {
                Toast.makeText(this, "사용하실 아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (id == btnRegister.getId()) {
            String userName = String.valueOf(edtName.getText());
            String userId = String.valueOf(edtId.getText());
            String userPwd = String.valueOf(edtPwd.getText());
            String userPwd2 = String.valueOf(edtPwd2.getText());

            // 빈칸 확인
            if(userName.trim().equals("") || userId.trim().equals("") ||
                    userPwd.trim().equals("") || userPwd2.trim().equals("")) {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            } else if (!userPwd.equals(userPwd2)) { // 비밀번호, 비밀번호확인 일치하지 않는 경우
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            // 문제 없는 경우
            Toast.makeText(this, "가입성공!!!", Toast.LENGTH_SHORT).show();
            finish();
        } else if (id == btnBack.getId()) { //현재 activity종료
            finish();
        }
    }
}
