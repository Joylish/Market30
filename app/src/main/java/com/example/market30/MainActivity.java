package com.example.market30;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView superView;
    RecyclerAdapter superAdapter;
    List<ProductInfomation> superItemList;

    RecyclerView convineView;
    RecyclerAdapter convineAdapter;
    List<ProductInfomation> convineItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        superView = (RecyclerView)findViewById(R.id.market_type_item_recyclerview);
        convineView = (RecyclerView)findViewById(R.id.market_type_item_recyclerview2);

        //슈퍼마켓에 대한 데이터 추가
        ProductInfomation ary = new ProductInfomation();
        ary.setTimer(30);
        ary.setProductName("사과");
        ary.setPrice(300);
        ary.setMarketName("슈퍼1");
        ProductInfomation ary2 = new ProductInfomation();
        ary2.setTimer(40);
        ary2.setProductName("배");
        ary2.setPrice(1000);
        ary2.setMarketName("슈퍼2");
        ProductInfomation ary3 = new ProductInfomation();
        ary3.setTimer(60);
        ary3.setProductName("파인애플");
        ary3.setPrice(2000);
        ary3.setMarketName("슈퍼1");
        superItemList = new ArrayList<>();
        superItemList.add(ary);
        superItemList.add(ary2);
        superItemList.add(ary3);

        //편의점에 대한 데이터 추가
        ProductInfomation ary4 = new ProductInfomation();
        ary4.setTimer(30);
        ary4.setProductName("도시락");
        ary4.setPrice(300);
        ary4.setMarketName("편의점1");
        ProductInfomation ary5 = new ProductInfomation();
        ary5.setTimer(40);
        ary5.setProductName("빵");
        ary5.setPrice(00);
        ary5.setMarketName("편의점3");
        ProductInfomation ary6 = new ProductInfomation();
        ary6.setTimer(60);
        ary6.setProductName("과자");
        ary6.setPrice(2000);
        ary6.setMarketName("편의점2");
        convineItemList = new ArrayList<>();
        convineItemList.add(ary4);
        convineItemList.add(ary5);
        convineItemList.add(ary6);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
            ProductInfomation item = itemList.get(position);

            holder.timerTextview.setText("마감 " + item.getTimer() + "분 전");
            //holder.productImage.setImageURI(uri);
            holder.productNameTextview.setText("상품명 : " + item.getProductName());
            holder.productPriceTextview.setText("가격 : " + item.getPrice() + "원");
            //holder.marketDistanceTextview.setText(item.getMarketName());

//            holder.productImage.setOnClickListener(onClickItem);
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView timerTextview, productNameTextview, productPriceTextview, marketDistanceTextview;
            public ImageView productImage;

            public ViewHolder(View itemView) {
                super(itemView);

                timerTextview = (TextView)itemView.findViewById(R.id.timer);
                productImage = (ImageView)itemView.findViewById(R.id.product_image);
                productNameTextview = (TextView)itemView.findViewById(R.id.product_name);
                productPriceTextview = (TextView)itemView.findViewById(R.id.product_price);
                marketDistanceTextview = (TextView)itemView.findViewById(R.id.market_distance);
            }
        }
    }
}
