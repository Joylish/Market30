package com.openhack.market30.model;

public class ItemInCard {

    private int imageSrc;
    private String title;

    public ItemInCard(int imageSrc, String title)
    {
        this.imageSrc = imageSrc;
        this.title = title;
    }

    public int getImage() {
        return imageSrc;
    }

    public String getTitle() {
        return title;
    }
}
