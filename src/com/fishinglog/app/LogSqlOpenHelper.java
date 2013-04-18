package com.fishinglog.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LogSqlOpenHelper extends SQLiteOpenHelper {

	public LogSqlOpenHelper(Context context, String name,
			 int version) {
		super(context, name, null, version);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("create table fishing_log (" +
				"id		integer PRIMARY KEY AUTOINCREMENT," +
				"date		integer NOT NULL," +
				"start_time		datetime ," +
				"end_time		datetime ," +
				"comment		varchar(500))"

		);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
