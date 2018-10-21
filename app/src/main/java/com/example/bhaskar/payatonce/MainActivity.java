package com.example.bhaskar.payatonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double total = 0;
    TextView tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tot = (TextView)findViewById(R.id.tot);
    }

    public void pay(View view) {
        Intent intent = new Intent(this,FinalResult.class);
        startActivity(intent);
    }
}
