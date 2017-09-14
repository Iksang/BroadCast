package kr.co.tjeit.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

//                리시버는 10초이내에 동작을 마무리해야함. Timeout
//                젤리빈 버젼 이후로는 60초로 제한이 늘어남
//                for문 잘못쓰면 안됨

                Toast.makeText(context, "리시버의 시작", Toast.LENGTH_SHORT).show();


                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
