package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_LOGIN = 50;
    boolean logon = false;
    String[] func = {"AAA", "BBB", "CCC", "DDD", "EEE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, func);
        list.setAdapter(adapter);

        if (!logon){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, REQUEST_LOGIN);
//            startActivity(new Intent(this, LoginActivity.class));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LOGIN){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "Success123", Toast.LENGTH_LONG).show();
            }else{
                finish();
            }
        }
    }
}
