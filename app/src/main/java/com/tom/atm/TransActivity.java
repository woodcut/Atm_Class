package com.tom.atm;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.data;

public class TransActivity extends AppCompatActivity {

    private static final String TAG = "TransActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        //http://atm201605.appspot.com/h
        new TransTask().execute("http://atm201605.appspot.com/h");
    }

    class TransTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(params[0]);
                InputStream is = url.openStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader in = new BufferedReader(isr);
                String line = in.readLine();
                while (line!=null){
                    Log.d(TAG, "line:"+line);
                    sb.append(line);
                    line = in.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
    }
}
