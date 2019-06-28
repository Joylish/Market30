package com.openhack.market30;

import android.net.Uri;

public class ProductInfomation {
    private int timer;
    private String pictureURL;
    private String productName;
    private int price;
    private String marketName;

    private Uri imgUri;

    private int year;
    private int month;
    private int date;

    private int hour;
    private int min;
    private int sec;

    private int distance;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public void setImageURI(Uri uri) {
        this.imgUri = uri;
    }

    public String getUri() {
        return this.imgUri.toString();
    }

    public Uri getPictureURI() {
        return this.imgUri;
    }

    public void setDeadTime(int year, int month, int date, int hour, int min) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.hour = hour;
        this.min = min;
        this.sec = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int d) {
        this.distance = d;
    }
}