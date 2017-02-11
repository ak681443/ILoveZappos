package com.ak681443.ilovezappos.views;

import android.databinding.BindingAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by arvind on 2/10/17.
 */

public interface DataBoundImageViewList {
    @BindingAdapter({"bind:imageURLList"})
    public  void loadImageList(LinearLayout layout, ArrayList<String> imageURLList);
}
