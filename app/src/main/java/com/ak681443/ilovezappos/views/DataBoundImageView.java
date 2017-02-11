package com.ak681443.ilovezappos.views;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ak681443.ilovezappos.application.AppInstance;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by arvind on 2/10/17.
 */

public interface DataBoundImageView {
    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public  void loadImage(ImageView view, String url, Drawable error);
}
