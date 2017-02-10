package com.ak681443.ilovezappos.views;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by arvind on 2/10/17.
 */

public interface DataBoundImageView {
    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public  void loadImage(ImageView view, String url, Drawable error);
}
