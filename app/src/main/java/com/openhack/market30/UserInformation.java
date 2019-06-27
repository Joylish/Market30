package com.openhack.market30;

public class UserInformation {
    private int Timer;
    private String pictureURL;
    private boolean stream;

    public int getTimer() {
        return Timer;
    }

    public void setTimer(int timer) {
        Timer = timer;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }
}
