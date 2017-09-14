package kr.co.tjeit.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private android.widget.Button sendDownloadCompleteBtn;
    private Button intentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        sendDownloadCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                다운로드 완료 버튼을 누르면
//                왕좌의 게임이 다운로드 완료되었다 라고 "방송"

                final Intent intent = new Intent();
//                어떠한 상황인지 알려주는 내용

//                방송 내용 작성 요령

//                어떤 종류의 상황인지?

//                패키지명.action.실제액션
//                => 패키지명? 혼선을 피하기 위해 앱의 패키지명을 앞단에 추가.
                intent.setAction("kr.co.tjeit.broadcast.action.FILE_DOWNLOADED");

//                실제로 전달할 자료 (첨부자료)
                intent.putExtra("fileName","왕좌의게임시즌7E01.avi");

//                지금 쏘는 이방송은, 정지되어있는 앱들에게도 전파.

//                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);


//                동적 리시버만 방송을 수신할 수 있도록 제한
                intent.addFlags(intent.FLAG_RECEIVER_REGISTERED_ONLY);



//                실제로 방송 진행

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendBroadcast(intent);
                    }
                }, 5000);


            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.intentBtn = (Button) findViewById(R.id.intentBtn);
        this.sendDownloadCompleteBtn = (Button) findViewById(R.id.sendDownloadCompleteBtn);

    }
}
