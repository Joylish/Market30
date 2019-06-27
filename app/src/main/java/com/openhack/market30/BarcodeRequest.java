package com.openhack.market30;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import org.json.JSONObject;


public class BarcodeRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcoderequest);

        final TextView textView = (TextView)findViewById(R.id.textView);

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
            requestBody.put("barcode", 40111896);
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
                        Log.d("BarcodeRequest", response.toString());
                        String a =response.optString("data");
                        textView.append(a);
                        //List<String> list = new ArrayList<String>();
                        // JSONArray array = response.getJSONArray("data");
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