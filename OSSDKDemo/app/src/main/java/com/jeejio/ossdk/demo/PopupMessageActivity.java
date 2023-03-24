package com.jeejio.ossdk.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import jeejio.popup.PopUpMessageProvider;
import jeejio.popup.PopupMessageImp;
import jeejio.popup.PopupMessageManagerImp;

public class PopupMessageActivity extends AppCompatActivity {

    private String TAG = PopupMessageActivity.class.getSimpleName();
    private PopupMessageManagerImp managerImp;
    private Button local_picture, net_picture, local_video, net_video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_message);
        try {
            managerImp = PopupMessageManagerImp.getInstance(getApplicationContext());
        } catch (IllegalAccessException e) {
            Log.e(TAG,"get PopupMessageService failed!");
            e.printStackTrace();
            return;
        }

        local_picture = findViewById(R.id.local_picture);
        local_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMessageImp imp = new PopupMessageImp.Builder(PopupMessageActivity.this)
                        .setContentTitle("本地图片")
                        .setContentPath(PopUpMessageProvider.parse(PopupMessageActivity.this,"test.jpg"))
                        .setContentType(PopupMessageManagerImp.POPUP_MESSAGE_PICTURE).build();
                managerImp.notify(imp);
            }
        });

        net_picture = findViewById(R.id.net_picture);
        net_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMessageImp imp = new PopupMessageImp.Builder(PopupMessageActivity.this)
                        .setContentTitle("山水美景")
                        .setContentPath("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606213359863&di=45e4efd5c301ecd244d6f87a8d6ce9b8&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-12-15%2F5c149eec524ff.jpg")
                        .setContentType(PopupMessageManagerImp.POPUP_MESSAGE_PICTURE).build();
                managerImp.notify(imp);
            }
        });

        local_video = findViewById(R.id.local_video);
        local_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMessageImp imp = new PopupMessageImp.Builder(PopupMessageActivity.this)
                        .setContentTitle("视频")
                        .setContentPath(PopUpMessageProvider.parse(PopupMessageActivity.this,"Wildlife.wmv"))
                        .setContentType(PopupMessageManagerImp.POPUP_MESSAGE_VIDEO).build();
                managerImp.notify(imp);
            }
        });

        net_video = findViewById(R.id.net_video);
        net_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMessageImp imp = new PopupMessageImp.Builder(PopupMessageActivity.this)
                        .setContentTitle("CCTV-1")
                        .setContentPath("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8")
                        .setContentType(PopupMessageManagerImp.POPUP_MESSAGE_VIDEO).build();
                managerImp.notify(imp);
            }
        });
    }

}
