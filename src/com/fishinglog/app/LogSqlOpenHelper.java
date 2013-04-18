package com.fishinglog.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LogSqlOpenHelper extends SQLiteOpenHelper {

	public LogSqlOpenHelper(Context context, String name,
			 int version) {
		super(context, name, null, version);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
