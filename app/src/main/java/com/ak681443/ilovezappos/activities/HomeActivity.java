package com.ak681443.ilovezappos.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.ak681443.ilovezappos.R;
import com.ak681443.ilovezappos.adapters.AutoCompleteAdapter;

import com.ak681443.ilovezappos.model.SearchResult;
import com.ak681443.ilovezappos.views.SearchBar;
import static com.ak681443.ilovezappos.util.Constants.*;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupSearchBar();
    }

    private void setupSearchBar(){
        final SearchBar textView =(SearchBar) findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(new AutoCompleteAdapter(this));
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final SearchBar textView =(SearchBar) findViewById(R.id.autoCompleteTextView);
                textView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("");
                        textView.clearFocus();
                    }
                }, 1000);
                Intent productPageIntent = new Intent(getApplicationContext(), ProductPageActivity.class);
                productPageIntent.putExtra(EXTRAS_PRODUCT_POJO, (SearchResult) adapterView.getItemAtPosition(i));
                startActivity(productPageIntent);
            }
        });

        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    findViewById(R.id.imageView).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.imageView).setVisibility(View.VISIBLE);
                }
                toggleActionBar();
            }
        });
    }


    private void toggleActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            if(actionBar.isShowing()){
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }
}
