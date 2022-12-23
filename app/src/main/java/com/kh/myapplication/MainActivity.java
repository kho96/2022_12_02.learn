package com.kh.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtId, edtPwd;
    //Button btnLogin, btnRegister;
    ImageView imgCenter;
    View dialogView;
    boolean dialState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }



    // 리스너 달기
    private void setListener() {
//        btnLogin.setOnClickListener(this);
//        btnRegister.setOnClickListener(this);
        imgCenter.setOnClickListener(this);
    }

    // 아이디 찾기
    private void findViews() {
        edtId = findViewById(R.id.edtId);
        edtPwd = findViewById(R.id.edtPwd);
        imgCenter = findViewById(R.id.imgCenter);
        //btnLogin = findViewById(R.id.btnLogin);
        //btnRegister = findViewById(R.id.btnRegister);
    }

    // 클릭 이벤트
    @Override
    public void onClick(View view) {
        if (view == imgCenter) {
            // intent 얻기
            Intent intent = new Intent(getApplicationContext(), BucketListActivity.class);
            startActivity(intent);
        }
        /*if (view == imgCenter) {
            // dialogView 정의
            dialogView = View.inflate(this,R.layout.login_dialog, null);
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("  로그인을 해주세요.");
            dialog.setIcon(R.drawable.icon1);
            dialog.setView(dialogView);
            dialog.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialState = true; // dialog 사라짐 방지용 플래그 변수
                    // test (id = admin / pwd = 1234)
                    EditText edtId = dialogView.findViewById(R.id.edtId);
                    EditText edtPwd = dialogView.findViewById(R.id.edtPwd);
                    String id = edtId.getText().toString();
                    String pwd = edtPwd.getText().toString();
                    if (id.equals("admin") && pwd.equals("1234")) {
                        dialState = false;
                        Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                         // intent 얻어서 실행하기 -> diary_main 실행하기
                        Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
                        startActivity(intent);
                    } else if (id.equals("") || pwd.equals("")) {
                        Toast.makeText(MainActivity.this, "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.setNegativeButton("닫기", null );
            dialog.setNeutralButton("회원 가입", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                     //intent 얻어서 실행하기 -> RegisterActivity 실행하기
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                }
            });
            dialog.setCancelable(false); // 뒤로가기, 화면 외 터치시 나가짐 방지
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if(dialState) {imgCenter.callOnClick(); dialState = false;}
                }
            });
            dialog.show();

        }
        int id = view.getId();
        if (id == btnLogin.getId()) {
            // intent 얻어서 실행하기 -> diary_main 실행하기
            Intent intent = new Intent(getApplicationContext(), DiaryActivity.class);
            startActivity(intent);
        } else if (id == btnRegister.getId()) {
            // intent 얻어서 실행하기 -> RegisterActivity 실행하기
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        } */
    }
}