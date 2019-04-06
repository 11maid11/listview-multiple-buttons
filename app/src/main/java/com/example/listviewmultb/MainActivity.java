package com.example.listviewmultb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listView);
        data.add("Max");
        data.add("Ana");
        data.add("Joe");
        data.add("Jack");
        data.add("Jerry");
        data.add("XF");
        data.add("Stephan");

        final ListViewAdapter lvAdapter = new ListViewAdapter(this,R.layout.list_view_items,data);
        lv.setAdapter(lvAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                parent.removeView(view);
                data.remove(position);
                lvAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Clicked " + data.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
