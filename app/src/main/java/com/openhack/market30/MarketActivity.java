package com.openhack.market30;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.openhack.market30.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends Activity {
//
//    ListView marketItemView;
//    ListAdapter marketAdapter;
//    List<UserInformation[]> marketItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_type_details);

        String uri = getIntent().getStringExtra("uri");
        ImageView productImage = (ImageView) findViewById(R.id.imageView9);
        productImage.setImageURI(Uri.parse(uri));


//        Button my_btn = (Button) findViewById(R.id.market_btn);
//        my_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
//                View drawerView = (View) findViewById(R.id.slide_menu);
//                drawerLayout.openDrawer(drawerView);
//            }
//        });
//
//        Intent intent = getIntent();
//        TextView type = (TextView)findViewById(R.id.market_type_txt);
//        type.setText(intent.getExtras().getString("MarketType"));
//
//        marketItemView = (ListView)findViewById(R.id.);
//
//        marketItemList = new ArrayList<>();
//        UserInformation[] ary = new UserInformation[2];
//        ary[0] = new UserInformation();
//        ary[0].setStream(true);
//        ary[0].setTimer(30);
//        ary[1] = new UserInformation();
//        ary[1].setStream(false);
//        ary[1].setTimer(10);
//        marketItemList.add(ary);
//        setMarketTypeItemList();
//    }
//
//    public void setMarketTypeItemList() {
//        marketAdapter = new ListAdapter(this, marketItemList);
//        if (marketItemView != null) {
//            marketItemView.setAdapter(marketAdapter);
//        }
//    }
//
//    private class ListAdapter extends BaseAdapter {
//        Context context;
//        List<UserInformation[]> userStreamList;
//
//        public ListAdapter(Context context, List<UserInformation[]> userStreamList) {
//            this.context = context;
//            this.userStreamList = userStreamList;
//        }
//
//        @Override
//        public int getCount() {
//            return this.userStreamList.size();
//        }
//
//        @Override
//        public UserInformation[] getItem(int position) {
//            return this.userStreamList.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder viewHolder;
//            if (convertView == null) {
//                convertView = LayoutInflater.from(context).inflate(R.layout.market_items_listview, null);
//                viewHolder = new ViewHolder();
//                viewHolder.productImageview = (ImageView)convertView.findViewById(R.id.item1_image);
//                viewHolder.endTimeTextview = (TextView)convertView.findViewById(R.id.item1_timer_txt);
//                viewHolder.streamTextview = (TextView)convertView.findViewById(R.id.item1_stream_txt);
//                viewHolder.productImageview2 = (ImageView)convertView.findViewById(R.id.item2_image);
//                viewHolder.endTimeTextview2 = (TextView)convertView.findViewById(R.id.item2_timer_txt);
//                viewHolder.streamTextview2 = (TextView)convertView.findViewById(R.id.item2_stream_txt);
//                convertView.setTag(viewHolder);
//            }
//            else {
//                viewHolder = (ViewHolder)convertView.getTag();
//            }
//
//            viewHolder.productImageview.setImageResource(R.drawable.);
//            //viewHolder.productImageview.setImageURI();
//            viewHolder.endTimeTextview.setText(userStreamList.get(position)[0].getTimer() + "분 전");
//            viewHolder.streamTextview.setText((userStreamList.get(position)[0].isStream() ? "★" : "☆"));
//
//            final int index = position;
//            final ViewHolder tempViewHolder = viewHolder;
//            viewHolder.streamTextview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    userStreamList.get(index)[0].setStream(!userStreamList.get(index)[0].isStream());
//                    tempViewHolder.streamTextview.setText((userStreamList.get(index)[0].isStream() ? "★" : "☆"));
//                    //DB반영 작업은 아직 안함
//                }
//            });
//
//            if (userStreamList.get(position)[1] != null) {
//                viewHolder.productImageview2.setImageResource(R.drawable.my);
//                //viewHolder.productImageview2.setImageURI();
//                viewHolder.endTimeTextview2.setText(userStreamList.get(position)[1].getTimer() + "분 전");
//                viewHolder.streamTextview2.setText((userStreamList.get(position)[1].isStream() ? "★" : "☆"));
//
//                viewHolder.streamTextview2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        userStreamList.get(index)[1].setStream(!userStreamList.get(index)[1].isStream());
//                        tempViewHolder.streamTextview2.setText((userStreamList.get(index)[1].isStream() ? "★" : "☆"));
//                        //DB반영 작업은 아직 안함
//                    }
//                });
//            }
//
//            convertView.setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                        }
//                    }
//            );
//
//            return convertView;
//        }
//    }
//
//    class ViewHolder {
//        ImageView productImageview, productImageview2;
//        TextView endTimeTextview, streamTextview, endTimeTextview2, streamTextview2;
    }
}
