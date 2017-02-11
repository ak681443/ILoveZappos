package com.ak681443.ilovezappos.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ak681443.ilovezappos.R;
import com.ak681443.ilovezappos.views.DataBoundImageView;
import com.ak681443.ilovezappos.views.DataBoundImageViewList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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

        @Override
        public DataBoundImageViewList getDataBoundImageViewList(){
            return new DataBoundImageViewList() {
                @Override
                public void loadImageList(LinearLayout layout, ArrayList<String> imageURLList) {
                    for(String url : imageURLList){
                        ImageView view = new ImageView(layout.getContext());
                        Picasso.with(view.getContext()).load(url).error(R.drawable.zappos_logo).placeholder(R.drawable.zappos_logo).into(view);
                        layout.addView(view);
                    }
                }
            };
        }
    }

}
