package com.galasys.payment.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FunCtionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onMovie(View view){
        startActivity(new Intent(FunCtionActivity.this,MainActivity.class));
    }
    public void onknowledge(View view){
        startActivity(new Intent(FunCtionActivity.this,Android_DataActivity.class));
    }
    public void onWelfare(View view){
        //吐司
       startActivity(new Intent(FunCtionActivity.this,FuLiActivity.class));
    }
}
