/*
package com.kh.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CheckableLinearLayout extends LinearLayout implements Checkable {

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.itemCheckBox) ;
        // 체크상태가 true가 아니면...
        if (checkBox.isChecked() != checked) {
            checkBox.setChecked(checked) ;
        }
    }

    @Override
    public boolean isChecked() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.itemCheckBox);
        return checkBox.isChecked(); // 체크상태
    }

    @Override
    public void toggle() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.itemCheckBox) ;
        setChecked(checkBox.isChecked() ? false : true); // 체크 변할  때 체크상태 변화
    }
}
*/
