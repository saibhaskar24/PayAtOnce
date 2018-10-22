package com.example.bhaskar.payatonce;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    double total =0;
    TextView tot ;
    int bal;
    public  class data {
        public String p,b,e,w,m,t,g;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tot = (TextView)findViewById(R.id.tot);
        Intent i = getIntent();
        data d = new data();
        d = i.getStringExtra("dataa");
        bal =  Integer.parseInt(d.b);
        total += Integer.parseInt(d.e);
        total += Integer.parseInt(d.w);
        total += Integer.parseInt(d.m);
        total += Integer.parseInt(d.t);
        total += Integer.parseInt(d.g);
    }

    public void pay(View view) {
        tot.setText(total+"");
        if(total > bal) {
            Intent intent = new Intent(this, FinalResult.class);
            startActivity(intent);
        }
        else {

        }
  }

}
