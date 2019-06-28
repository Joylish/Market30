package com.openhack.market30;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    RecyclerView superView;
    RecyclerAdapter superAdapter;
    List<ProductInfomation> superItemList;

    RecyclerView convineView;
    RecyclerAdapter convineAdapter;
    List<ProductInfomation> convineItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_main);
        TextView map_txt = (TextView) findViewById(R.id.textView17);
        map_txt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
//        Button my_btn = (Button) findViewById(R.id.calendar_btn);
//        my_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
//                View drawerView = (View) findViewById(R.id.slide_menu);
//                drawerLayout.openDrawer(drawerView);
//            }
//        });

        superView = (RecyclerView) findViewById(R.id.market_type_item_recyclerview);
        convineView = (RecyclerView) findViewById(R.id.market_type_item_recyclerview2);

        //슈퍼마켓에 대한 데이터 추가
        ProductInfomation ary = new ProductInfomation();
        ary.setTimer(30);
        ary.setDeadTime(2019, 6, 28, 10, 30);
        ary.setProductName("사과");
        ary.setPrice(300);
        ary.setMarketName("슈퍼1");
        ary.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.strawberry2));
        ary.setDistance(320);


        ProductInfomation ary2 = new ProductInfomation();
        ary2.setTimer(40);
        ary2.setDeadTime(2019, 6, 28, 10, 30);
        ary2.setProductName("배");
        ary2.setPrice(1000);
        ary2.setMarketName("슈퍼2");
        ary2.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.eggs));
        ary2.setDistance(41);


        ProductInfomation ary3 = new ProductInfomation();
        ary3.setTimer(60);
        ary3.setDeadTime(2019, 6, 28, 10, 30);
        ary3.setProductName("파인애플");
        ary3.setPrice(2000);
        ary3.setMarketName("슈퍼1");
        ary3.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.carrot));
        ary3.setDistance(100);

        superItemList = new ArrayList<>();
        superItemList.add(ary);
        superItemList.add(ary2);
        superItemList.add(ary3);

        //편의점에 대한 데이터 추가
        ProductInfomation ary4 = new ProductInfomation();
        ary4.setTimer(30);
        ary4.setDeadTime(2019, 6, 28, 10, 30);
        ary4.setProductName("도시락");
        ary4.setPrice(300);
        ary4.setMarketName("편의점1");
        ary4.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.gamdongran));
        ary4.setDistance(10);

        ProductInfomation ary5 = new ProductInfomation();
        ary5.setTimer(40);
        ary5.setDeadTime(2019, 6, 28, 10, 30);
        ary5.setProductName("빵");
        ary5.setPrice(300);
        ary5.setMarketName("편의점3");
        ary5.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.eggs));
        ary5.setDistance(109);

        ProductInfomation ary6 = new ProductInfomation();
        ary6.setTimer(60);
        ary6.setDeadTime(2019, 6, 28, 10, 30);
        ary6.setProductName("과자");
        ary6.setPrice(2000);
        ary6.setMarketName("편의점2");
        ary6.setImageURI(Uri.parse("android.resource://com.openhack.market30/" + R.drawable.eggs));
        ary6.setDistance(32);

        convineItemList = new ArrayList<>();
        convineItemList.add(ary4);
        convineItemList.add(ary5);
        convineItemList.add(ary6);


//        TextView superMarketBtn = (TextView)findViewById(R.id.supermarket_whole_view_txt);
//        superMarketBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
//
//                intent.putExtra("MarketType", "슈퍼마켓");
//
//                MainActivity.this.startActivity(intent);
//            }
//        });

//        TextView convineBtn = (TextView) findViewById(R.id.convine_whole_view_txt);
//        convineBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MarketActivity.class);
//
//                intent.putExtra("MarketType", "편의점");
//
//                MainActivity.this.startActivity(intent);
//            }
//        });

        setMarketTypeItemList();
    }

    private void setMarketTypeItemList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        superView.setLayoutManager(layoutManager);
        superAdapter = new RecyclerAdapter(this, superItemList);
        superView.setAdapter(superAdapter);

        ListDecoration decoration = new ListDecoration();
        superView.addItemDecoration(decoration);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        convineView.setLayoutManager(layoutManager2);
        convineAdapter = new RecyclerAdapter(this, convineItemList);
        convineView.setAdapter(convineAdapter);

        ListDecoration decoration2 = new ListDecoration();
        convineView.addItemDecoration(decoration2);
    }

    class ListDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
                outRect.right = 10;
            }
        }
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private List<ProductInfomation> itemList;
        private Context context;

        public RecyclerAdapter(Context context, List<ProductInfomation> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // context 와 parent.getContext() 는 같다.
            View view = LayoutInflater.from(context).inflate(R.layout.product_listview, parent, false);

            return new RecyclerAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
            final ProductInfomation item = itemList.get(position);

            holder.timerTextview.setText("마감 " + item.getTimer() + "분 전");
            holder.productImage.setImageURI(item.getPictureURI());
            holder.productNameTextview.setText("상품명 : " + item.getProductName());
            holder.productPriceTextview.setText("가격 : " + item.getPrice() + "원");
            holder.marketDistanceTextview.setText(item.getDistance() + "m");
//            Log.d("ASDF", item.getUri());

            holder.productImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MarketActivity.class);

                    intent.putExtra("uri", item.getUri());

                    MainActivity.this.startActivity(intent);
                }
            });

//            holder.productImage.setOnClickListener(new Button.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    // TODO : click event
//                }
//            });

            //

//            holder.productImage.setOnClickListener(onClickItem);
        }


        @Override
        public int getItemCount() {
            return itemList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView productImageView, timerTextview, productNameTextview, productPriceTextview, marketDistanceTextview;
            public ImageView productImage;

            public ViewHolder(View itemView) {
                super(itemView);

                timerTextview = (TextView) itemView.findViewById(R.id.timer);
                productImage = (ImageView) itemView.findViewById(R.id.product_image);
                productNameTextview = (TextView) itemView.findViewById(R.id.product_name);
                productPriceTextview = (TextView) itemView.findViewById(R.id.product_price);
                marketDistanceTextview = (TextView) itemView.findViewById(R.id.market_distance);
            }
        }
    }
}