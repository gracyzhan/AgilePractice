package com.warriortech.cognitionmonitor.sqlite;

 import java.sql.Date;

import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.* ;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.SystemClock;

 /**
 * @author zqzhan
 *
 */
public class PlayScoresHisDaoImpl extends DataBaseDaoImpl {   

 //private final static String DATABASE_NAME = "CognitionMonitorDb.db";   

public PlayScoresHisDaoImpl(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

private PlayScoresHisTable playScoresHisTable = new PlayScoresHisTable();
 /**
 * @return
 */
public Cursor select() {   

 SQLiteDatabase db = this.getReadableDatabase();   

 Cursor cursor = db   

 .query(playScoresHisTable.getTABLE_NAME(), null, null, null, null, null, null);   

 return cursor;   

 }   
 
 /**
 * @param playScoresHis - getMachineId
 * @return
 */
public Cursor GetCursorByMachineId(PlayScoresHis playScoresHis)
 {

	 SQLiteDatabase db = this.getReadableDatabase();   
	 String sql = "SELECT * FROM " + playScoresHisTable.getTABLE_NAME() + " WHERE " + 
	 playScoresHis.getMachineId()   

	 + "='" +playScoresHis.getMachineId()+"'";   

	 Cursor cursor=db.rawQuery(sql, null);
	 return cursor;
 }
 
/**
 * @param playScoresHis -getPlayGameId
 * @return
 */
public Cursor GetCursorByGameId(PlayScoresHis playScoresHis)
 {

	 SQLiteDatabase db = this.getReadableDatabase();   
	 String sql = "SELECT * FROM " + playScoresHisTable.getTABLE_NAME() + " WHERE " + 
			 playScoresHisTable.getPlayGameId() 

	 + "='" +playScoresHis.getPlayGameId()+"'";   

	 Cursor cursor=db.rawQuery(sql, null);
	 return cursor;
 }

/**
 * @param playScoresHis - getPlayGameName
 * @return
 */
public Cursor GetCursorByGrameName(PlayScoresHis playScoresHis)
 {

	 SQLiteDatabase db = this.getReadableDatabase();   
	 String sql = "SELECT * FROM " + playScoresHisTable.getTABLE_NAME() + " WHERE " + 
			 playScoresHisTable.getPlayGameName()

	 + " like '%" +playScoresHis.getPlayGameName() +"%'";   

	 Cursor cursor=db.rawQuery(sql, null);
	 return cursor;
 }


 /**
 * @param playScoresHis
 * @return
 */
public long insert(PlayScoresHis playScoresHis)   

 {   

 SQLiteDatabase db = this.getWritableDatabase();   
 /* ContentValues */  
 ContentValues cv = new ContentValues();   
 cv.put(playScoresHisTable.getMachineId(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getPlayGameId(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getPlayGameName(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getScore(), playScoresHis.getMachineId());   
 Date dt=new Date(SystemClock.elapsedRealtime());
 cv.put(playScoresHisTable.getPlayTime(), dt.toString());   
  

 long row = db.insert(playScoresHisTable.getTABLE_NAME(), null, cv);   

 return row;   

 }   

 
 /**
 * @param id
 * delete..
 */
public void delete(int id)   

 {   

 SQLiteDatabase db = this.getWritableDatabase();   

 String where = playScoresHisTable.getID() + " = ?";   

 String[] whereValue ={ Integer.toString(id) };   

 db.delete(playScoresHisTable.getTABLE_NAME(), where, whereValue);   

 }   

 

 /**
 * @param id
 * @param cardList
 * update ...
 */
public void update(int id, PlayScoresHis playScoresHis)   

 {   

 SQLiteDatabase db = this.getWritableDatabase();   

 String where = playScoresHisTable.getID() + " = ?";   

 String[] whereValue = { Integer.toString(id) };   

 /* ContentValues */  
 ContentValues cv = new ContentValues();   
 cv.put(playScoresHisTable.getMachineId(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getPlayGameId(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getPlayGameName(), playScoresHis.getMachineId());   
 cv.put(playScoresHisTable.getScore(), playScoresHis.getMachineId());   
 Date dt=new Date(SystemClock.elapsedRealtime());
 cv.put(playScoresHisTable.getPlayTime(), dt.toString());   

 db.update(playScoresHisTable.getTABLE_NAME(), cv, where, whereValue);   

 }   

 } 

