package com.ak681443.ilovezappos.model;

import java.util.List;

/**
 * Created by arvind on 2/8/17.
 */

public class SearchResponse {
    List<SearchResult> searchResults;

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }
}
