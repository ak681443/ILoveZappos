package com.ak681443.ilovezappos.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by arvind on 2/8/17.
 */


public class ImageResponse extends BaseObservable{
    private static final int MAX_ELEMENTS = 10;

    HashMap<String, ArrayList<ImageResult>> images;

    public ArrayList<String> getThumbnails(String styleId){
        ArrayList<String> urls = new ArrayList<>();
        for(ImageResult result : images.get(styleId)){
            if(result.getFormat().equals("jpg") && result.getRecipeName().equals("MOBILETHUMB")) {
                urls.add(result.getFilename());
                if(urls.size() > MAX_ELEMENTS){
                    break;
                }
            }
        }
        return urls;
    }

    public ImageResult getPrimaryImage(String styleId){
        for(ImageResult result : images.get(styleId)){
            if(result.getFormat().equals("jpg") && result.getRecipeName().equals("MOBILE")) {
                return result;
            }
        }
        return images.get(styleId).get(0);
    }


    public ImageResult getTinyImage(String styleId){
        for(ImageResult result : images.get(styleId)){
            if(result.getFormat().equals("jpg") && result.getRecipeName().equals("TINY")) {
                return result;
            }
        }
        return images.get(styleId).get(0);
    }

    public ArrayList<ImageResult> getStyleURLS(){
        ArrayList<ImageResult> urls = new ArrayList<>();
        for(String styleID : images.keySet()) {
            for (ImageResult result : images.get(styleID)) {
                if (result.getFormat().equals("jpg") && result.getRecipeName().equals("MOBILETHUMB")) {
                    urls.add(result);
                    break;
                }
            }
        }
        return urls;
    }
}
