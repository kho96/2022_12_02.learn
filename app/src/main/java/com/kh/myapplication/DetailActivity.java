package com.kh.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack_detail, bntAdd;
    //ListView listView_detail;
    ProgressBar progressBar;
    TextView detail_title, tv_detail_goal;
    View dialogView;
    MySqlHelper helper;
    String goal;
    int progress_rate;
    String detail_goal;
    private BucketListDao bucketListDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        helper = new MySqlHelper(this, "bucketlistDB", null, 1);
        findViews();
        setListener();
        // intent 얻어오기
        Intent intent = getIntent();
        // intent에서 값(goal) 가져오기
        goal = intent.getStringExtra("goal");
        // title에 가져온 값 설정
        detail_title.setText(goal);
        // Dao에서 정보 받기
        BucketListVo bucketListVo = bucketListDao.getDetail(goal, helper);
        detail_goal = bucketListVo.getDetail_goal();
        progress_rate = bucketListVo.getProgress_rate();

        // 버킷리스트 진행률 설정
        progressBar.setProgress(progress_rate);

        // 버킷리스트 세부 계획 설정
        tv_detail_goal.setText(detail_goal);


    }

    // listener
    private void setListener() {
        btnBack_detail.setOnClickListener(this);
        bntAdd.setOnClickListener((View.OnClickListener) this);
    }

    // activity_detail.xml 에서 id 찾기
    private void findViews() {
        btnBack_detail = findViewById(R.id.btnBack_detail);
        bntAdd = findViewById(R.id.bntAdd);
        //listView_detail = findViewById(R.id.listView_detail);
        progressBar = findViewById(R.id.progressBar);
        detail_title = findViewById(R.id.detail_title);
        tv_detail_goal = findViewById(R.id.tv_detail_goal);
    }

    @Override
    public void onClick(View view) {

        if (view == btnBack_detail) {
            finish(); // 현재 액티비티 종료
        } else if (view == bntAdd) {
            // dialogView 정의
            dialogView = View.inflate(DetailActivity.this,R.layout.detail_dialog, null);
            // dialog 생성
            AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);
            dialog.setIcon(R.drawable.write);
            dialog.setTitle("  버킷리스트를 이루기 위한 세부 계획을 설정하세요.");
            dialog.setView(dialogView);
            dialog.setNegativeButton("취소",null);
            dialog.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // dialog EditText 값 받아오기
                    EditText dialEdt_detail = dialogView.findViewById(R.id.dialEdt_detail);
                    detail_goal = dialEdt_detail.getText().toString();
                    EditText dialEdt_progress = dialogView.findViewById(R.id.dialEdt_progress);
                    String progress_rate_str = dialEdt_progress.getText().toString();

                    if (progress_rate_str.equals("")) {
                        progress_rate = 0;
                    } else {
                        try {
                            progress_rate = Integer.parseInt(dialEdt_progress.getText().toString());
                            if (progress_rate<1 || progress_rate>100) {
                                // 숫자가 1~100 범위를 벗어나는 경우도 0으로 처리
                                progress_rate = 0;
                            }
                        } catch (NumberFormatException ne) {
                            // 숫자가 아닌 값을 입력하여 오류나는 경우 0으로 처리
                            progress_rate = 0;
                        }
                    }
                    BucketListVo bucketListVo = new BucketListVo(goal, progress_rate, detail_goal);

                    if (!detail_goal.equals("")) {
                        // 불러온 값 Dao 실행시켜 등록하기
                        boolean result = bucketListDao.addDetailGoal(bucketListVo, helper);
                        if (result) {
                            // 화면 새로고침
                            Intent intent = getIntent(); // 현재 intent얻어오기
                            finish(); // 종료
                            overridePendingTransition(0, 0); // intent애니메이션 제거
                            startActivity(intent); // 재시작
                            overridePendingTransition(0, 0);  // intent애니메이션 제거
                        } else {
                            Toast.makeText(DetailActivity.this, "등록 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                }// positive onClick
            }); // positive btn listener
            dialog.setCancelable(false);
            dialog.show();
        }//else if
    }//onClick
}//Activity
