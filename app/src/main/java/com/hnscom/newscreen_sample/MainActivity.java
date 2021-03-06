package com.hnscom.newscreen_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.tnplanet.newscreen_sdk.NewscreenAD;

public class MainActivity extends AppCompatActivity {

    private NewscreenAD newscreenAD = new NewscreenAD(MainActivity.this); //현재액티비티
    private String sdk_key = "뉴스크린 담당자에게 발급받은 sdk_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch hnsadSwitch = (Switch) findViewById(R.id.newscreen_switch);

        newscreenAD.setInitCallback(new NewscreenAD.InitCallBack() {
            @Override
            public void initCallBack(boolean valid, String msg) {
                Log.d("MainActivity", "콜백 : "+valid+" /"+msg);
            }
        });

        hnsadSwitch.setChecked(newscreenAD.isRunningNewscreen());
        hnsadSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    newscreenAD.init(sdk_key);
                }else{
                    newscreenAD.stopAd();
                }
            }
        });

    }
}
