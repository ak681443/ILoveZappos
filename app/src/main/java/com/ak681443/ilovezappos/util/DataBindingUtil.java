package com.ak681443.ilovezappos.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.ak681443.ilovezappos.R;
import com.ak681443.ilovezappos.views.DataBoundImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by arvind on 2/10/17.
 */

public class DataBindingUtil {

    public static class DefaultDataBindingComponent implements android.databinding.DataBindingComponent{

        @Override
        public DataBoundImageView getDataBoundImageView() {
                return new DataBoundImageView() {
                    @Override
                    public void loadImage(ImageView view, String url, Drawable error) {
                        Picasso.with(view.getContext()).load(url).error(error).placeholder(R.drawable.zappos_logo).into(view);
                    }
                };
        }
    }

}
