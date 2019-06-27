package com.openhack.market30;

import android.app.Activity;
import android.widget.Toast;

public class BackPressCloseHandler {
    private long backKeyPressedTime =0;
    private Toast toast;
    private Activity activity;

    public BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public void onBackPressed(){
        if(System.currentTimeMillis()>backKeyPressedTime +2000){
            backKeyPressedTime = System.currentTimeMillis();
            ConfirmToClose();
            return;
        }
        if(System.currentTimeMillis() <= backKeyPressedTime + 2000){
            activity.finishAffinity();
            toast.cancel();
        }
    }

    public void ConfirmToClose(){
        toast =Toast.makeText(activity, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }

}
