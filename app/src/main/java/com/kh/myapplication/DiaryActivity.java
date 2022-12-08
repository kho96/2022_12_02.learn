package com.kh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DiaryActivity  extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main);
        findViews();
        setListener();
    }

    // id찾기
    private void findViews() {
        btnLogout = findViewById(R.id.btnLogout);
    }

    // 리스너 달기
    private void setListener() {
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == btnLogout.getId()) { // logout -> finish() -> activity_main으로 이동
            finish();
        }
    }// onClick
}
