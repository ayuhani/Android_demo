package com.ayuhani.demo.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.ayuhani.demo.R;

public class MyService extends Service {

    private static final String TAG = "MyService";
    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
    }

    // 在服务创建的时候调用
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: executed");

        Intent it = new Intent(this, ServiceActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, it, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    // 在每次服务启动的时候调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // 在服务销毁的时候调用
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d(TAG, "startDownload: executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress: executed");
            return 0;
        }
    }
}
