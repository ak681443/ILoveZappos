package com.ak681443.ilovezappos.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.ak681443.ilovezappos.R;

import java.util.ArrayList;

/**
 * Created by arvind on 2/10/17.
 */

public class ImageLinearLayout extends LinearLayout {

    public ImageLinearLayout(Context context) {
        super(context, null, 0);
    }

    public ImageLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ImageLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, 0, 0);
    }

    ArrayList<String> urlList;

    public ArrayList<String> getImageURLList() {
        return urlList;
    }

    public void setImageURLList(ArrayList urlList) {
        this.urlList = urlList;
    }

    @Override
    public void addView(View child) {
        final int margin = child.getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        final int size = child.getResources().getDimensionPixelSize(R.dimen.thumbnail_size);
        LayoutParams layoutParams = new LayoutParams(size, size);
        layoutParams.setMargins(margin, margin, margin, margin);
        child.setLayoutParams(layoutParams
        );
        super.addView(child);
    }
}
