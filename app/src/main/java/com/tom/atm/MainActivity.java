package com.tom.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int REQUEST_LOGIN = 50;
    private static final String TAG = "MainActivity";
    boolean logon = false;
//    String[] func = {"AAA", "BBB", "CCC", "DDD", "EEE"};
    String[] func;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        func = getResources().getStringArray(R.array.functions);
//        forListView();
//        forSpinner();
        GridView grid = (GridView) findViewById(R.id.grid);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.functions, android.R.layout.simple_list_item_1);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);

        if (!logon){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, REQUEST_LOGIN);
//            startActivity(new Intent(this, LoginActivity.class));
        }

    }

    private void forSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.notify));
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.notify, android.R.layout.simple_list_item_1);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //被選擇的當下
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, position+"");
                Log.d(TAG, (String) adapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void forListView() {
        ListView list = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, func);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d(TAG, position+"/"+id);
                switch ((int)id){
                    case 4:
                        finish();
                        break;
                }
            }
        });
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

    public void getData(View v){
        String data = spinner.getSelectedItem().toString();
        TextView tv = (TextView) findViewById(R.id.dataText);
        tv.setText(data);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                finish();
                break;
        }
    }

}
