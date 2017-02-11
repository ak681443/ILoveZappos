package com.ak681443.ilovezappos.model;

import java.util.List;

/**
 * Created by arvind on 2/8/17.
 */

public class RecomendationResponse {

    List<Recommendation> recommendationList;

    public List<Recommendation> getRecommendationList() {
        return recommendationList;
    }

    public void setRecommendationList(List<Recommendation> recommendationList) {
        this.recommendationList = recommendationList;
    }
}
