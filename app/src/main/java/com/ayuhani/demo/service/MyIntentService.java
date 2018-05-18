package com.ayuhani.demo.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    private static final String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService"); // 调用父类的有参构造方法
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        // 打印当前线程的id
        Log.d(TAG, "Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }
}
