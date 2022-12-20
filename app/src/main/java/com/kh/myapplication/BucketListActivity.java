package com.kh.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BucketListActivity extends AppCompatActivity {
    ImageView btnWrite;
    View dialogView;
    String userBucket;
    MySqlHelper helper;
    ListView listView;
    BucketListDao bucketListDao = BucketListDao.getInstance();

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
                        if(!userBucket.equals("")) {
                            // 불러온 값 Dao 실행시켜 등록하기
                            boolean result = bucketListDao.writeBucketList(userBucket, helper);
                            if (result) {
                                Toast.makeText(BucketListActivity.this, "등록 성공", Toast.LENGTH_SHORT).show();
                                // 화면 새로고침
                                Intent intent = getIntent(); // 현재 intent얻어오기
                                finish(); // 종료
                                overridePendingTransition(0, 0); // intent애니메이션 제거
                                startActivity(intent); // 재시작
                                overridePendingTransition(0, 0);  // intent애니메이션 제거
                            } else {
                                Toast.makeText(BucketListActivity.this, "등록 실패", Toast.LENGTH_SHORT).show();
                            }
                        }// if
                    }
                }); // positive btn listener
                dialog.setCancelable(false);
                dialog.show();
            }
        });//OnclickListener

        // ListView 얻기
        listView = findViewById(R.id.listView);
        // Dao에서 ArrayList얻기 (목록 얻어오기)
        ArrayList<BucketListVo> list = (ArrayList<BucketListVo>) bucketListDao.getList(helper);
        // Adapter 만들기
        MyAdapter adapter = new MyAdapter(list);
        // Adapter 연결하기
        listView.setAdapter(adapter);

        // 체크박스가 있는 경우 ItemClickListener를  set하지 못함
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(BucketListActivity.this, "토스트", Toast.LENGTH_SHORT).show();
                // 보여줄 새 액티비티 인텐트 얻어서 보여주기
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);
            }
        });

        /*// list item 얻기
        TextView itemText =  listView.findViewById(R.id.itemText);
        CheckBox itemCheckBox = listView.findViewById(R.id.itemCheckBox);*/


    }// onCreate
}//activity