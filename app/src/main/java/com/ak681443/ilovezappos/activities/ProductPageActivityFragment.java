package com.ak681443.ilovezappos.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ak681443.ilovezappos.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ProductPageActivityFragment extends Fragment {

    public ProductPageActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_page, container, false);
    }
}
