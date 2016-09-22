package com.tom.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v){
        EditText edUserid = (EditText) findViewById(R.id.userid);
        String userid = edUserid.getText().toString();
        EditText edPasswd = (EditText) findViewById(R.id.passwd);
        String passwd = edPasswd.getText().toString();
        if (userid.equals("jack") && passwd.equals("1234")){

            setResult(RESULT_OK);
            finish();
        }else{
        }
    }
    public void cancel(View v){

    }
}
