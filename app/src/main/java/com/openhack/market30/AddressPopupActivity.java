package com.openhack.market30;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.android.volley.AuthFailureError;
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

import javax.net.ssl.HttpsURLConnection;

public class AddressPopupActivity extends Activity implements AdapterView.OnItemClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_popup);

        List<String> items = new ArrayList<String>();
        // 리소스 파일에 정의된 id_list 라는 ID 의 리스트뷰를 얻는다.
        ListView listview = (ListView) findViewById(R.id.listView1);

        // ArrayAdapter 객체를 생성한다.
        ArrayAdapter<String> adapter;

        // 리스트뷰가 보여질 아이템 리소스와 문자열 정보를 저장한다
        // 객체명 = new ArrayAdapter<데이터형>(참조할메소드, 보여질아이템리소스, 보여질문자열);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        /*
         *
         * 안드로이드에서 제공하는 기본적인 리스트뷰 아이템 리소스
         *
         * simple_list_item_1
         * simple_list_item_2
         * simple_list_item_activated_1
         * simple_list_item_activated_2
         * simple_list_item_checked
         * simple_list_item_multiple_choice
         * simple_list_item_single_choice
         * simple_selectable_list_item
         */

        // 리스트뷰에 ArrayAdapter 객체를 설정하여 리스트뷰에 데이터와 출력 형태를 지정한다.
        listview.setAdapter(adapter);

        // 리스트뷰 선택 시 이벤트를 설정한다.
        listview.setOnItemClickListener(this);

        Button search_address_btn = (Button) findViewById(R.id.search_address_btn);
        final List<String> tmpList = items;
        search_address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        // All your networking logic
                        // should be here
                        try {

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
                            } catch (Exception e) {
                                // check e
                                Log.d("BarcodeRequest", e.getMessage());
                            }

                            final TextView textView = (TextView)findViewById(R.id.address_txt);
                            JsonObjectRequest postStringRequest = new JsonObjectRequest(
                                    Request.Method.GET,
                                    //"https://dapi.kakao.com/v2/local/search/keyword.json?y=37.514322572335935&x=127.06283102249932&radius=20000&query=" + URLEncoder.encode("마트", "UTF-8"),
                                    "https://dapi.kakao.com/v2/local/search/address.json?query=" + URLEncoder.encode(textView.getText().toString(), "UTF-8"),
                                    requestBody,
                                    new Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject response) {
                                            Log.d("BarcodeRequest", response.toString());
                                            String a = response.optString("meta");
                                            try {
                                                JSONObject meta = response.getJSONObject("meta");
                                                int length = meta.getInt("total_count");
                                                JSONArray documents = response.getJSONArray("documents");
                                                tmpList.clear();
                                                for (int i = 0; i < length; i++) {
                                                    tmpList.add(documents.getJSONObject(i).getString("place_name"));
                                                    Log.d("Information", documents.getJSONObject(i).getString("place_name"));
                                                }
                                            } catch (Exception e) {

                                            }
                                            Log.d("TEST", a);
//                                            textView.append(a);
                                            //List<String> list = new ArrayList<String>();
                                            // JSONArray array = response.getJSONArray("data");
                                        }

                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("BarcodeRequest", error.getMessage());
                                }

                            }) {
                                @Override
                                public Map<String, String> getHeaders() throws AuthFailureError {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("Content-Type", "application/json; charset=UTF-8");
                                    params.put("Authorization", "KakaoAK 1f829e297bbe8b7d7d82539492384a95");
                                    return params;
                                }
                            };

                            requestQueue.add(postStringRequest);
                        } catch (Exception e) {
                            Log.d("Information", e.toString());
                        }
                    }
                });

                finish();
            }
        });
    }

    // 리스트뷰 선택 시 이벤트 처리 메소드
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub
        // arg1는 현재 리스트에 뿌려지고 있는 정보
        // arg2는 현재 리스트에 뿌려지고 있는 해당 id 값

        // 값 출력을 위해 불러온 도구를 id값을 통해 불러옴
        TextView a = (TextView) findViewById(R.id.address_txt);

        // 현재 리스트뷰에 있는 해당 값을 보기
        TextView tv = (TextView) arg1;

        // 현재 리스트뷰에 나오는 문자열과 해당 라인의 id값을 확인
        a.setText(tv.getText());
    }
}
