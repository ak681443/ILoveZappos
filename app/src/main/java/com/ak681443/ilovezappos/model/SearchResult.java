package com.ak681443.ilovezappos.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class SearchResult implements Parcelable{

    String brandName;
    String thumbnailImageUrl;
    String productId;
    String originalPrice;
    String styleId;
    String colorId;
    String price;
    String percentOff;
    String productUrl;
    String productName;

    //AUTO GENERATED GETTTERS & SETTERS FOLLOW

    public SearchResult(){
        //NO OP
    }

    public SearchResult(Parcel parcel){
        brandName = parcel.readString();
        thumbnailImageUrl = parcel.readString();
        productId = parcel.readString();
        originalPrice = parcel.readString();
        styleId =parcel.readString();
        colorId = parcel.readString();
        price = parcel.readString();
        percentOff = parcel.readString();
        productUrl = parcel.readString();
        productName = parcel.readString();
    }

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public boolean getIsOnSale(){
        return percentOff!=null && !percentOff.equals("0%");
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(brandName);
        parcel.writeString(thumbnailImageUrl);
        parcel.writeString(productId);
        parcel.writeString(originalPrice);
        parcel.writeString(styleId);
        parcel.writeString(colorId);
        parcel.writeString(price);
        parcel.writeString(percentOff);
        parcel.writeString(productUrl);
        parcel.writeString(productName);
    }

    @Override
    public String toString() {
        return productName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static Creator<SearchResult> CREATOR = new Creator<SearchResult>() {
        @Override
        public SearchResult createFromParcel(Parcel parcel) {
            return new SearchResult(parcel);
        }

        @Override
        public SearchResult[] newArray(int i) {
            return new SearchResult[0];
        }
    };
}
