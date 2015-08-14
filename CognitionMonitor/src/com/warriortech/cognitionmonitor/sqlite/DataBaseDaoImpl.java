package com.warriortech.cognitionmonitor.sqlite;

import com.warriortech.cognitionmonitor.dao.PlayScoresHisTable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseDaoImpl extends SQLiteOpenHelper{

	private final static int DATABASE_VERSION = 1; 
	private final static String DATABASE_NAME = "/sdcard/CognitionMonitorDb.db";   
	public String getDatabaseName() {
		return DATABASE_NAME;
	}
	
	public DataBaseDaoImpl(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String sql = "CREATE TABLE " + PlayScoresHisTable.TABLE_NAME + " (" + PlayScoresHisTable.ID   
				 + " INTEGER primary key autoincrement, " 
				+ PlayScoresHisTable.MachineId + " TEXT, " 
				+ PlayScoresHisTable.PlayGameId + " TEXT, " 
				+ PlayScoresHisTable.PlayGameName + " TEXT, " 
				+ PlayScoresHisTable.Score + " FLOAT, " + 
				PlayScoresHisTable.PlayTime+" timestamp );";   

				 db.execSQL(sql);   
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		/*
		String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;   
		db.execSQL(sql);   
		onCreate(db); */
		
		// Here, if there are some more tables should be added in the future, add codes here, using alter !
	}
	
	

}
