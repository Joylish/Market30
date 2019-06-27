package com.openhack.market30;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.openhack.market30.adapter.ItemInCardAdapter;
        import com.openhack.market30.model.ItemInCard;

        import java.util.ArrayList;
        import com.google.zxing.integration.android.IntentIntegrator;
        import com.google.zxing.integration.android.IntentResult;

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
        setContentView(R.layout.activity_main);
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
            Toast.makeText(this, re, Toast.LENGTH_LONG).show();
        }
    }
}
