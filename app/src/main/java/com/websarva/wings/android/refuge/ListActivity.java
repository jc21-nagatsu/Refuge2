package com.websarva.wings.android.refuge;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    int i = 0;
    private static final String[] scenes = {
            "東六番丁小学校"
            ,"東二番丁小学校"
            ,"上杉山通小学校"
            ,"北六番丁小学校"
            ,"五橋中学校"
            ,"五城中学校"
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.list_view);

        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, scenes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedText = scenes[position];
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setClassName("com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity");

        String str = String.format(Locale.US,
                "http://maps.google.com/maps?daddr=%s",
                selectedText);
        intent.setData(Uri.parse(str));
        startActivity(intent);

    }

    /*public void UPDATE(View view) {
        //ListViewのインスタンスを生成


        TestOpenHelper helper = new TestOpenHelper(ListActivity.this);
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            String sql = "select shel_name from shelter";
            Cursor cursor = db.rawQuery(sql,null);

            while (cursor.moveToNext()){
                int idx = cursor.getColumnIndex("shel_name");
                scenes[i] = cursor.getString(idx);
                i++;
            }
        }
        finally {
            db.close();
        }



    }*/
}
