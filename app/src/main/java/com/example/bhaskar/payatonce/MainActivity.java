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
    int bal,el,w,m,tv,ga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tot = (TextView)findViewById(R.id.tot);
        Intent i = getIntent();
        bal = Integer.parseInt(i.getStringExtra("bal"));
        el = Integer.parseInt(i.getStringExtra("el"));
        w = Integer.parseInt(i.getStringExtra("w"));
        m = Integer.parseInt(i.getStringExtra("m"));
        tv = Integer.parseInt(i.getStringExtra("tv"));
        ga = Integer.parseInt(i.getStringExtra("ga"));
        total = bal+el+m+tv+ga;
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
