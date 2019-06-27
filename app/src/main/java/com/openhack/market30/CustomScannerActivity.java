package com.openhack.market30;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CustomScannerActivity extends Activity implements DecoratedBarcodeView.TorchListener{
    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private BackPressCloseHandler backPressCloseHandler;
    private Boolean switchFlashlightButtonCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_scanner);
        switchFlashlightButtonCheck =true;
        backPressCloseHandler = new BackPressCloseHandler(this);

        barcodeScannerView =(DecoratedBarcodeView)findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);
        capture = new CaptureManager(this, barcodeScannerView);
        capture.decode();
        capture.initializeFromIntent(getIntent(), savedInstanceState);

    }

    protected void onResume(){
        super.onResume();
        capture.onResume();
    }

    protected void onPause(){
        super.onPause();
        capture.onPause();
    }

    protected  void onDestroy(){
        super.onDestroy();
        capture.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }

    @Override
    public void onTorchOff() {
    }

    @Override
    public void onTorchOn() {
    }

}
