package com.kh.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BucketListActivity extends AppCompatActivity {
    ImageView btnWrite;
    View dialogView;
    String userBucket;
    MySqlHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);
        helper = new MySqlHelper(this, "bucketlistDB", null, 1);
        btnWrite = findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BucketListActivity.this, "click", Toast.LENGTH_SHORT).show();

                // dialogView 정의
                dialogView = View.inflate(BucketListActivity.this,R.layout.bucket_dialog, null);
                // dialog 생성
                AlertDialog.Builder dialog = new AlertDialog.Builder(BucketListActivity.this);
                dialog.setIcon(R.drawable.write);
                dialog.setTitle("  버킷리스트를 작성해보세요.");
                dialog.setView(dialogView);
                dialog.setNegativeButton("취소",null);
                dialog.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dialog EditText 값 받아오기
                        EditText dialEdt = dialogView.findViewById(R.id.dialEdt);
                        userBucket = dialEdt.getText().toString();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();
            }
        });
    }
}