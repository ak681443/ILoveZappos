package com.ak681443.ilovezappos.model;

/**
 * Created by arvind on 2/10/17.
 */

/*
{
        "format": "png",
        "filename": "http://www.zappos.com/images/z/1/4/0/14078-p-OUTFIT_THUMB.png",
        "type": "PAIR",
        "imageId": "54952736",
        "recipeName": "OUTFIT_THUMB",
        "styleId": "14078",
        "productId": "7324204"
}
*/
public class ImageResult {
    String format;
    String filename;
    String type;
    String imageId;
    String recipeName;
    String styleId;
    String productId;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
