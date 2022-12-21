package com.kh.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MySqlHelper extends SQLiteOpenHelper {

    public MySqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("myTag", "db생성 완료");
        // 사용할 table 생성
        String sql = "create table tbl_bucketlist(" +
                "           goal varchar(100) primary key," +
                "           progress_rate number(3) default 0 check (progress_rate between 0 and 100)," +
                "           detail_goal varchar(500))";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
