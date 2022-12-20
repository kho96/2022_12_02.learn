package com.kh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack_detail, bntModify;
    ListView listView_detail;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViews();
        setListener();
    }

    // listener
    private void setListener() {
        btnBack_detail.setOnClickListener(this);
        bntModify.setOnClickListener((View.OnClickListener) this);
    }

    // activity_detail.xml 에서 id 찾기
    private void findViews() {
        btnBack_detail = findViewById(R.id.btnBack_detail);
        bntModify = findViewById(R.id.btnModify);
        listView_detail = findViewById(R.id.listView_detail);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View view) {

        if (view == btnBack_detail) {
            finish(); // 현재 액티비티 종료
        } else if (view == bntModify) {

        }
    }
}