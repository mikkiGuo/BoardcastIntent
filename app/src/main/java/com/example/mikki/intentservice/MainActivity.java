package com.example.mikki.intentservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static MainActivity mainActivity;
    private MyReceiver receiver;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;
        btn = findViewById(R.id.button);
        TextView result = findViewById(R.id.tv_result);

        IntentFilter filter = new IntentFilter();
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new MyReceiver();
        registerReceiver(receiver, filter);

        /*int one = getIntent().getIntExtra("one", 0);
        int two = getIntent().getIntExtra("two", 0);

        result.setText("first: " + one + "\nsecond: " + two);*/


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MyIntentService2.class);
                i.putExtra("key",1);
                i.putExtra("two", 2);
                startService(i);
            }
        });


    }

    public static Activity getMainActivity(){
       return mainActivity;
    }
}
