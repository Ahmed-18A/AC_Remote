package com.example.acremote;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView fan,x,t;
    TextView degree,mode,stat;
    boolean status=false,fanx=true,tur=true;
    int mode2 =2,fanD=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        degree=findViewById(R.id.degree);
        fan=findViewById(R.id.fan);
        mode=findViewById(R.id.mode);
        x=findViewById(R.id.x);
        t=findViewById(R.id.t);
        stat=findViewById(R.id.stat);
    }

    public void checkStatus(View view) {
        if(status){
            status=false;
            stat.setTextColor(Color.RED);
            stat.setText("Off");
        }
        else {
            status=true;
            stat.setTextColor(Color.GREEN);
            stat.setText("On");
        }
    }
    public void checkMode(View view) {
        if(status) {
            if (mode2 == 1) {
                mode2 = 2;
                mode.setText("HEAT");
            } else {
                mode2 = 1;
                mode.setText("COLD");
            }
        }
    }
    public void minDegree(View view) {
        int x=Integer.parseInt(degree.getText().toString());
        if(status){
            if(x>16)
                degree.setText(String.valueOf(x-1));
            else
                Toast.makeText(this, "The lowest temperature is 16", Toast.LENGTH_SHORT).show();
        }
    }
    public void plusDegree(View view) {
        int x=Integer.parseInt(degree.getText().toString());
        if(status) {
            if (x < 30)
                degree.setText(String.valueOf(x + 1));
            else
                Toast.makeText(this, "The highest temperature is 30", Toast.LENGTH_SHORT).show();
        }
    }
    public void air(View view) {
        if(status) {
            if (fanD==1){
                fanD++;
                fan.setImageResource(R.drawable.i2);
            }
            else {
                if (fanD == 2) {
                    fanD++;
                    fan.setImageResource(R.drawable.i3);
                }
                else {
                    if (fanD == 3) {
                        fanD = 1;
                        fan.setImageResource(R.drawable.i1);
                    }
                }
            }
        }
    }
    public void xfan(View view) {
        if(status) {
            if (fanx)
                x.setImageResource(R.drawable.fan);
            else
                x.setImageDrawable(null);
            fanx = !fanx;
        }
    }
    public void turbo(View view) {
        if(status) {
            if (tur)
                t.setImageResource(R.drawable.turbo);
            else
                t.setImageDrawable(null);
            tur = !tur;
        }
    }
}