package com.example.hl.android_practice3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //简单隐式启动
               /* Intent intent = new Intent();
                intent.setAction("startImplicitActivity");
                startActivity(intent);*/
               //拨打电话
               if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                       != PackageManager.PERMISSION_GRANTED){
                   Toast.makeText(MainActivity.this,"缺少电话权限",Toast.LENGTH_LONG).show();
                   return;
               }
                String phonenumber = "18811759290";
                String encodedPhonenumber = null;
                try{
                    encodedPhonenumber = URLEncoder.encode(phonenumber,"UTF-8");
                }catch(UnsupportedEncodingException e){
                    e.printStackTrace();
                }
                startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:" +encodedPhonenumber )));
            }
        });
    }
}
