package com.example.market30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        try {
            Thread.sleep(4000); // 4초 인트로 화면 보여주기

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // next Activity 기재.

        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}