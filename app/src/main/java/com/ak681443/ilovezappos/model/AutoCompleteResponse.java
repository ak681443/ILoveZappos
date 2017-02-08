package com.ak681443.ilovezappos.model;

import java.util.List;

/**
 * Created by arvind on 2/8/17.
 */

/*
  "results": [
    "nic+zoe",
    "nicole miller",
    "nike",
    "nike golf",
    "nike kids",
    "nike sb",
    "nike sb kids",
    "nina",
    "nina kids",
    "nine west"
  ],
  "statusCode": "200"
}
*/

public class AutoCompleteResponse {
    List<String> autocompletedEntries;


    public List<String> getAutocompletedEntries() {
        return autocompletedEntries;
    }

    public void setAutocompletedEntries(List<String> autocompletedEntries) {
        this.autocompletedEntries = autocompletedEntries;
    }
}
