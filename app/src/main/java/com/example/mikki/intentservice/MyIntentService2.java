package com.example.mikki.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService2 extends IntentService {

    int timeOne = 0;
    int timeTwo = 0;
    public MyIntentService2() {
        super("MyIntentService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        timeOne = intent.getExtras().getInt("key");
        timeTwo= intent.getExtras().getInt("two");
        try {
            Thread.sleep(this.timeOne*1000);
            Thread.sleep(this.timeTwo*1000);
            Log.d("test1", ""+ timeOne + "  " + timeTwo + "finished execution");
            Intent intent1 = new Intent(MyIntentService2.this, MyReceiver.class);
            intent1.putExtra("data", timeOne);
            intent1.putExtra("two", timeTwo);
            intent1.setAction("myreceiver");
            intent1.addCategory(Intent.CATEGORY_DEFAULT);
            sendBroadcast(intent1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
