package com.ak681443.ilovezappos.model;

import retrofit2.Retrofit;

/**
 * Created by arvind on 2/8/17.
 */

/*
    {
      "brandName": "Nike",
      "thumbnailImageUrl": "http://www.zappos.com/images/z/3/6/2/0/0/6/3620061-t-THUMBNAIL.jpg",
      "productId": "8361239",
      "originalPrice": "$22.00",
      "styleId": "3620061",
      "colorId": "353157",
      "price": "$22.00",
      "percentOff": "0%",
      "productUrl": "http://www.zappos.com/product/8361239/color/353157",
      "productName": "Nike Long-Length Medium Resistance Band 2.0"
    }
 */

public class SearchResult {
    String brandName;
    String thumbnailImageUrl;
    long productID;
    String originalPrice;
    String styleId;
    String colorId;
    String price;
    String percentOff;
    String productUrl;
    String productName;

    //AUTO GENERATED GETTTERS & SETTERS FOLLOW


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
