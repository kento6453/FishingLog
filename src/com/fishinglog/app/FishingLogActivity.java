package com.fishinglog.app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FishingLogActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    	SQLiteDatabase db;
    	LogSqlOpenHelper loghelper = new LogSqlOpenHelper(getApplicationContext(), "fishinglog.db", 1);
    	db=loghelper.getReadableDatabase();
        Cursor c = db.rawQuery("select id, date, start_time, end_time, comment from fishing_log", null);
        c.moveToFirst();
        int count=c.getCount();

//        ArrayList<FishingLogModel> list = new ArrayList<FishingLogModel>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for (int i = 0; i < count; i++) {
            FishingLogModel logModel = new FishingLogModel();
            logModel.setDate(c.getString(1));
//            list.add(logModel);
            adapter.add(logModel.getDate());
            c.moveToNext();
        }
        db.close();

//        FishingLogAdapter adapter = new FishingLogAdapter(this, R.layout.fishinglog_row, list);

        ListView listview = (ListView)findViewById(R.id.listView1);
        listview.setAdapter(adapter);

        Button btnAddLog = (Button)findViewById(R.id.bnt_add_log);
        btnAddLog.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent = new Intent();
				intent.setClassName("com.fishinglog.app", "com.fishinglog.app.AddLogActivity");
				startActivity(intent);
			}
		});

    }

    public void onResume(){

    	super.onResume();
    	SQLiteDatabase db;
    	LogSqlOpenHelper loghelper = new LogSqlOpenHelper(getApplicationContext(), "fishinglog.db", 1);
    	db=loghelper.getReadableDatabase();
        Cursor c = db.rawQuery("select id, date, start_time, end_time, comment from fishing_log", null);
        c.moveToFirst();
        int count=c.getCount();

//        ArrayList<FishingLogModel> list = new ArrayList<FishingLogModel>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        for (int i = 0; i < count; i++) {
            FishingLogModel logModel = new FishingLogModel();
            logModel.setDate(c.getString(1));
//            list.add(logModel);
            adapter.add(logModel.getDate());
            c.moveToNext();
        }
        db.close();

//        FishingLogAdapter adapter = new FishingLogAdapter(this, R.layout.fishinglog_row, list);

        ListView listview = (ListView)findViewById(R.id.listView1);
        listview.setAdapter(adapter);

    }


}