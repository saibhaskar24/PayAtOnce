package com.example.bhaskar.payatonce;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;



public class LoginActivity extends AppCompatActivity  {
    String url = "http://cefec761.ngrok.io/WebApplication1/api/Products/";
    EditText pass;
    AutoCompleteTextView ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass = (EditText)findViewById(R.id.password);
        ph = (AutoCompleteTextView)findViewById(R.id.phno);
        }

    public void signin(View view ) {
        String phonno = ph.getText().toString();
        url = url + phonno;
        JSONObject jo ;
        String passwd = (String) jo.get("passwd");
        if(pass.getText().toString() == passwd) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("JSNOData", jo);
            startActivity(intent);
        }
        else {
            //Show wrong passwd
        }
    }
}

