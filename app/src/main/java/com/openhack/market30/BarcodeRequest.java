package com.openhack.market30;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;


public class BarcodeRequest extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcoderequest);
        Intent intent = new Intent(this.getIntent());
        String product_name = intent.getStringExtra("product_name");
        String img_url = intent.getStringExtra("img_url");
        Uri imgURI = Uri.parse(img_url);

        final TextView tv1 = (TextView)findViewById(R.id.product_name);
        final TextInputEditText tv2 = (TextInputEditText)findViewById(R.id.tv2);
        final TextView tv3 = (TextView)findViewById(R.id.tv3);
        final TextInputEditText tv4 = (TextInputEditText)findViewById(R.id.tv4);
        final TextInputEditText tv5 = (TextInputEditText)findViewById(R.id.tv5);

        TextView tv_product_name = (TextView)findViewById(R.id.productName);
        ImageView iv_img_url = (ImageView)findViewById(R.id.imgURI);

        tv_product_name.setText(product_name);
        iv_img_url.setImageURI(imgURI);
//        iv_img_url.setImageBitmap(getBitmapFromURL(img_url));
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue;
                Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
                Network network = new BasicNetwork(new HurlStack());
                requestQueue = new RequestQueue(cache, network);
                requestQueue.start();
                JSONObject requestBody = new JSONObject();

                try {
                    requestBody.put("name", tv1.getText());
                    requestBody.put("seller_id", "market30");
                    requestBody.put("price", tv4.getText());
                    requestBody.put("count", tv3.getText());
                    requestBody.put("comment", tv2.getText());
//                requestBody.put("image", re);

                } catch(Exception e) {
                    // check e
                    Log.d("BarcodeRequest", e.getMessage());
                }

                JsonObjectRequest postStringRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        "http://ec2-13-209-77-121.ap-northeast-2.compute.amazonaws.com:6001/api/v1/users/register_product",
                        requestBody,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Intent intent = new Intent(BarcodeRequest.this, BarcodeScan.class);
                                startActivity(intent);
                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("BarcodeRequest", error.getMessage());
                    }
                });

                requestQueue.add(postStringRequest);
            }
        };

        Button register_button = (Button)findViewById(R.id.registerBtn);
        register_button.setOnClickListener(listener);

    }
}