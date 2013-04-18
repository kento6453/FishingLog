package com.fishinglog.app;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLogActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_log);


        Button regBtn = (Button)findViewById(R.id.btn_reg_log);
        regBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				EditText date = (EditText)findViewById(R.id.editText1);
				EditText startTime = (EditText)findViewById(R.id.editText2);
				EditText endTime = (EditText)findViewById(R.id.editText3);
				EditText comment = (EditText)findViewById(R.id.editText4);

				ContentValues values = new ContentValues();
				values.put("date", date.getText().toString());
				values.put("start_time", startTime.getText().toString());
				values.put("end_time", endTime.getText().toString());
				values.put("comment", comment.getText().toString());

		        try {
		        	SQLiteDatabase db;
		        	LogSqlOpenHelper loghelper = new LogSqlOpenHelper(getApplicationContext(), "fishinglog.db", 1);
		        	db=loghelper.getWritableDatabase();
					long id =db.insert("fishing_log", null, values);
					Toast.makeText(getApplicationContext(),  date.getText().toString() + "(" + id + ")を登録しました",Toast.LENGTH_LONG).show();

					db.close();

					finish();

		        } catch (Exception e) {
					// TODO: handle exception
		        	e.printStackTrace();
				}


			}
		});

    }

}
