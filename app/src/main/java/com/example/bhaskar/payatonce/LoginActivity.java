package com.example.bhaskar.payatonce;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

class Data {
    public String p,b,e,w,m,t,g;
    Data(String p1,String b1,String e1,String w1,String m1,String t1,String g1) {
        p = p1;
        b = b1;
        e = e1;
        w = w1;
        m= m1;
        t=t1;
        g=g1;
    }
}
public class LoginActivity extends AppCompatActivity  {
    String url = "http://200899a0.ngrok.io/WebApplication1/api/Products/";
    EditText pass;
    AutoCompleteTextView ph;
    String passwd,bal,el,w,m,tv,ga;
    JSONObject root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass = (EditText)findViewById(R.id.password);
        ph = (AutoCompleteTextView)findViewById(R.id.phno);
        }

    public void signin(View view ) throws IOException {
        String phonno = ph.getText().toString();
        url = url + phonno;
        fetchData();
        if(pass.getText().toString() == passwd) {
            Intent intent = new Intent(this, MainActivity.class);
            Data d =new Data(passwd,bal,el,w,m,tv,ga);
            intent.putExtra("dataa",d);
            startActivity(intent);
        }
        else {
            //Show wrong passwd
        }
    }
    public void fetchData() throws IOException {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        root= new JSONObject(response);
                        try {
                            passwd = root.getString("password");
                            bal =root.getString("BankBal");
                            el=root.getString("Electricity");
                            w=root.getString("Water");
                            m=root.getString("Mobile");
                            tv=root.getString("Tv");
                            ga=root.getString("Gas");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }
}

