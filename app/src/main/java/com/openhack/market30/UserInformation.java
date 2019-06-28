package com.openhack.market30;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserInformation extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumerorseller);
        TextView consumer_btn = (TextView) findViewById(R.id.consumer_textview);
        TextView seller_btn = (TextView) findViewById(R.id.selle_textview);
//
        consumer_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent register_intent = new Intent(UserInformation.this, MainActivity.class);
                startActivity(register_intent);
            }
        });
        seller_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent Main_intent = new Intent(UserInformation.this, BarcodeScan.class);
                startActivity(Main_intent);
            }
        });
    }
}
