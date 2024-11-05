package com.example.acremote;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView fan;
    TextView degree,mode,x,t;
    boolean status=true,fanx=true,tur=true;
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
    }

    public void checkStatus(View view) {
        status= !status;
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
        if(status)
            if(x>16)
                degree.setText(String.valueOf(x-1));
    }
    public void plusDegree(View view) {
        int x=Integer.parseInt(degree.getText().toString());
        if(status)
            if(x<30)
                degree.setText(String.valueOf(x+1));
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
                x.setText("x-fan");
            else
                x.setText("");
            fanx = !fanx;
        }
    }
    public void turbo(View view) {
        if(status) {
            if (tur)
                t.setText("turbo");
            else
                t.setText("");
            tur = !tur;
        }
    }
}