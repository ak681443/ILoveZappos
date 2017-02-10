package com.ak681443.ilovezappos.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.ak681443.ilovezappos.R;
import com.ak681443.ilovezappos.databinding.SearchResultItemBinding;
import com.ak681443.ilovezappos.model.SearchResponse;
import com.ak681443.ilovezappos.model.SearchResult;
import com.ak681443.ilovezappos.util.ZAPIUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arvind on 2/8/17.
 */
public class AutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private ArrayList<SearchResult> resultList;

    public AutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public SearchResult getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchResultItemBinding binding;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      //      convertView = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
            binding = DataBindingUtil.inflate(inflater, R.layout.search_result_item, parent, false);
            convertView = binding.getRoot();
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        binding.setProduct(getItem(position));
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    try {
                        SearchResponse response = ZAPIUtil.doAutoCompleteSync(constraint.toString());
                        filterResults.values = response.getSearchResults();
                        filterResults.count = response.getSearchResults().size();
                    }catch (Exception e){
                        //TODO Log
                        filterResults.values = resultList;
                        filterResults.count = resultList.size();
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    resultList = (ArrayList<SearchResult>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }
}

