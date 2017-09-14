package kr.co.tjeit.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BroadcastActivity extends BaseActivity {

    BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String fileName = intent.getStringExtra("fileName");

                Toast.makeText(context, fileName+"이(가) 다운로드 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        };


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("kr.co.tjeit.broadcast.action.FILE_DOWNLOADED");

        registerReceiver(mBroadcastReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    public void bindViews() {

    }
}
