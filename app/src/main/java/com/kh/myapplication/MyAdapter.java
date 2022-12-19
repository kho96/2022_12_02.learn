package com.kh.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<BucketListVo> list;

    public MyAdapter(List<BucketListVo> list) {
        this.list = list;
    }

    // 데이터의 수
    @Override
    public int getCount() {
        return list.size();
    }

    // i 번째 아이템
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i 번째의 아이디
    @Override
    public long getItemId(int i) {
        return i;
    }

    // 뷰 (item의 갯수 만큼 실행된다.)
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 레이아웃 가져와서 view로 설정하기 (Activity가 아닌 경우 레이아웃을 로드하는 방법)
        view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.listview, viewGroup, false);
        // itemText 찾기
        TextView itemText = view.findViewById(R.id.itemText);

        // BucketListVo 얻기 -> 리스터 뷰의 데이터 설정
        BucketListVo bucketListVo = list.get(i);
        itemText.setText(bucketListVo.getGoal());
        return view;
    }
}
