package com.example.mikki.intentservice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver implements IView {

    @Override
    public void onReceive(Context context, Intent intent) {

       int one = intent.getIntExtra("data", 0);
       int two = intent.getIntExtra("two", 3);
       Log.d("test1", ""+ one + "  " + two);

       Intent intent1 = new Intent(context, MainActivity.class);
       intent1.putExtra("one", one);
       intent1.putExtra("two", two);
       context.startActivity(intent1);


       /*Toast.makeText(context, "dddddddd", Toast.LENGTH_LONG).show();

       TextView result = MainActivity.getMainActivity().findViewById(R.id.tv_result);

       result.setText("first: " + one + "\nsecond: " + two);*/


    }
}
