package com.kh.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BucketListDao {
    private static BucketListDao instance;

    private BucketListDao() {  }

    public static BucketListDao getInstance() {
        if(instance == null) {
            instance = new BucketListDao();
        }
        return instance;
    }

    // 전체 조회
    public List<BucketListVo> getList(MySqlHelper helper) {
        SQLiteDatabase sqlDB = helper.getReadableDatabase();
        Cursor cursor;
        String sql = "select * from tbl_bucketlist";
        cursor = sqlDB.rawQuery(sql, null);
        List<BucketListVo> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            String goal = cursor.getString(0);
            int progress_rate = cursor.getInt(1);
            String detail_goal = cursor.getString(2);
            BucketListVo bucketListVo = new BucketListVo(goal, progress_rate, detail_goal);
            list.add(bucketListVo);
        }
        cursor.close();
        sqlDB.close();
        return list;
    }

    // 등록하기
    public boolean writeBucketList(String goal, MySqlHelper helper) {
        SQLiteDatabase sqlDB = helper.getWritableDatabase();
        String sql = "insert into tbl_bucketlist(goal)" +
                "     values(?) ";
        try {
            SQLiteStatement stmt = sqlDB.compileStatement(sql);
            stmt.bindString(1, goal);
            long count = stmt.executeInsert();
            if (count > 0) {
                return true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sqlDB.close();
        }
        return false;
    }


}
