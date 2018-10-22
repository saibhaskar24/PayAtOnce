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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tot = (TextView)findViewById(R.id.tot);
        Intent i = getIntent();
        JSONObject jo = i.getStringExtra("JSNOData");
        bal =  jo.getInt("BankBal");
        total += jo.getInt("");
        total += jo.getInt("");
        total += jo.getInt("");
        total += jo.getInt("");
    }

    public void pay(View view) {
        if(total > tot) {
            Intent intent = new Intent(this, FinalResult.class);
            startActivity(intent);
        }
        else {

        }
  }

}
