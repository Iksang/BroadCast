package kr.co.tjeit.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by tjoeun on 2017-09-14.
 */

public class BroadcastReceiverSide extends BroadcastReceiver {


//    원하는 방송이 들어왔을 때 실행되는 메쏘드
    @Override
    public void onReceive(Context context, Intent intent) {
//        방송이 수신되면 할일

//        어떤 파일이 다운로드 되었는지 Toast로 출력

        String fileName = intent.getStringExtra("fileName");

        Toast.makeText(context, fileName+"이(가) 다운로드 되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
