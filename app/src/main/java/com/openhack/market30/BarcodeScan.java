package com.openhack.market30;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.openhack.market30.adapter.ItemInCardAdapter;
import com.openhack.market30.model.ItemInCard;

import java.util.ArrayList;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class BarcodeScan extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ItemInCard> items = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Activity activity = this;

    FloatingActionButton btnShowBarcodeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_main);
        btnShowBarcodeScreen = findViewById(R.id.btn_show_barcode_screen);
        mRecyclerView = findViewById(R.id.recycler_view_item_card);

        layoutManager = new GridLayoutManager(this, 2);
        adapter = new ItemInCardAdapter(items, this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        btnShowBarcodeScreen.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setCaptureActivity(CustomScannerActivity.class);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        if(resultCode == Activity.RESULT_OK){
            IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
            String re = scanResult.getContents();
//////////////////////////////////////////////////
            RequestQueue requestQueue;

// Instantiate the cache
            Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
            Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
            requestQueue = new RequestQueue(cache, network);

            requestQueue.start();

            JSONObject requestBody = new JSONObject();
            try {
                requestBody.put("barcode", re);
            } catch(Exception e) {
                // check e
                Log.d("BarcodeRequest", e.getMessage());
            }

            JsonObjectRequest postStringRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    "http://ec2-13-209-77-121.ap-northeast-2.compute.amazonaws.com:6001/api/v1/users/verify_barcode",
                    requestBody,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String product_name = response.getString("product_name");
                                String img_url = response.getString("img_url");

                                Log.d("BarcodeRequest", product_name);
                                Log.d("BarcodeResponse", img_url);
                                Intent intent = new Intent(BarcodeScan.this, BarcodeRequest.class);
                                intent.putExtra("product_name", product_name);
                                intent.putExtra("img_url", img_url);
                                startActivity(intent);



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("BarcodeRequest", error.getMessage());
                }
            });

            requestQueue.add(postStringRequest);
        }
    }
}