package com.websarva.wings.android.refuge;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //ボタンが押された時の処理
    public void onClick(View view){

        //ここに遷移するための処理
        //インテントの作成
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);//画面遷移
    }
}
