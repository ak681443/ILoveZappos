package com.ak681443.ilovezappos.activities;

import android.animation.TimeInterpolator;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ak681443.ilovezappos.R;
import com.ak681443.ilovezappos.databinding.ActivityProductPageBinding;
import com.ak681443.ilovezappos.model.ImageResponse;
import com.ak681443.ilovezappos.model.ImageResult;
import com.ak681443.ilovezappos.model.SearchResult;
import com.ak681443.ilovezappos.util.ZAPIUtil;
import com.ak681443.ilovezappos.views.ImageLinearLayout;
import com.android.databinding.library.baseAdapters.BR;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ak681443.ilovezappos.util.Constants.*;

public class ProductPageActivity extends AppCompatActivity {
    ActivityProductPageBinding pageBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchResult searchResult = getIntent().getParcelableExtra(EXTRAS_PRODUCT_POJO);
        ActivityProductPageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product_page);
        binding.setProduct(searchResult);
        pageBinding = binding;

        wireUpImages(searchResult, binding);
        setSupportActionBar(binding.toolbar);
        if(searchResult.getIsOnSale()) {
            binding.priceValue.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added to Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_product_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_to_cart:
                addToCart();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addToCart(){
        SearchResult result = (SearchResult) getIntent().getParcelableExtra(EXTRAS_PRODUCT_POJO);
        View.DragShadowBuilder db = new View.DragShadowBuilder(pageBinding.mainImg);
        ImageView imageView = new ImageView(getApplicationContext());
        Canvas canvas = new Canvas();
        db.onDrawShadow(canvas);
        imageView.draw(canvas);
        pageBinding.imageRoot.addView(imageView);
        imageView.animate().y(0).x(10).alpha(0.0f).setInterpolator(new AccelerateDecelerateInterpolator()).start();;
    }

    private void wireUpImages(final SearchResult searchResult, final ActivityProductPageBinding binding){
        ZAPIUtil.fetchThumbnails(searchResult.getProductId(), new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                final ImageResponse imageResponse = response.body();
                Picasso.with(getApplicationContext())
                        .load(imageResponse.getPrimaryImage(searchResult.getStyleId()).getFilename())
                        .into(binding.mainImg);

                binding.setImageURLList(imageResponse.getThumbnails(searchResult.getStyleId()));
                binding.setStyleURLList(imageResponse.getStyleURLS());

                for(String url : (List<String>)binding.getImageURLList()){
                    ImageView view = new ImageView(binding.imageList.getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(view.getContext())
                            .load(url)
                            .error(R.drawable.zappos_logo)
                            .placeholder(R.drawable.zappos_logo)
                            .into(view);
                    binding.imageList.addView(view);
                }

                for(ImageResult imageResult : (List<ImageResult>)binding.getStyleURLList()){
                    ImageView view = new ImageView(binding.imageList.getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(view.getContext())
                            .load(imageResult.getFilename())
                            .error(R.drawable.zappos_logo)
                            .placeholder(R.drawable.zappos_logo)
                            .into(view);
                    view.setTag(imageResult.getStyleId());
                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binding.setImageURLList(imageResponse.getThumbnails("" + view.getTag()));
                            Picasso.with(getApplicationContext())
                                    .load(imageResponse.getPrimaryImage("" + view.getTag()).getFilename())
                                    .into(binding.mainImg);
                            binding.imageList.removeAllViews();
                            for(String url : (List<String>)binding.getImageURLList()){
                                ImageView v = new ImageView(binding.imageList.getContext());
                                v.setScaleType(ImageView.ScaleType.FIT_XY);
                                Picasso.with(view.getContext())
                                        .load(url)
                                        .error(R.drawable.zappos_logo)
                                        .placeholder(R.drawable.zappos_logo)
                                        .into(v);
                                binding.imageList.addView(v);
                            }
                        }
                    });
                    binding.styleList.addView(view);
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                Toast.makeText(ProductPageActivity.this, "Failed to load images", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
