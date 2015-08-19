package com.warriortech.cognitionmonitor.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.SystemClock;

/**
 * @author zqzhan
 *
 */
public class PlayScoresHisDaoImpl extends DataBaseDaoImpl {

	private final static String DATABASE_NAME = "CognitionMonitorDb.db";
	private final static Integer VERSION = 1;

	public PlayScoresHisDaoImpl(Context context, String name,
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, null, VERSION); 
		// TODO Auto-generated constructor stub
	}

	public PlayScoresHisDaoImpl(Context context) {
		this(context, DATABASE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return
	 */
	public Cursor select() {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db

		.query(PlayScoresHisTable.TABLE_NAME, null, null, null, null,
				null, null);

		return cursor;

	}

	/**
	 * @param playScoresHis
	 *            - getMachineId
	 * @return
	 */
	public Cursor GetCursorByMachineId(PlayScoresHis playScoresHis) {

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM " + PlayScoresHisTable.TABLE_NAME
				+ " WHERE " + playScoresHis.getMachineId()

				+ "='" + playScoresHis.getMachineId() + "'";

		Cursor cursor = db.rawQuery(sql, null);
		return cursor;
	}

	/**
	 * @param playScoresHis
	 *            -getPlayGameId
	 * @return
	 */
	public Cursor GetCursorByGameId(PlayScoresHis playScoresHis) {

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM " + PlayScoresHisTable.TABLE_NAME
				+ " WHERE " + PlayScoresHisTable.PlayGameId

				+ "='" + playScoresHis.getPlayGameId() + "'";

		Cursor cursor = db.rawQuery(sql, null);
		return cursor;
	}

	/**
	 * @param playScoresHis
	 *            -getPlayGameId
	 * @return
	 */
	public Cursor GetCursorByRowId(PlayScoresHis playScoresHis) {

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM " + PlayScoresHisTable.TABLE_NAME

		+ " WHERE rowid = '" + playScoresHis.getID() + "'";

		Cursor cursor = db.rawQuery(sql, null);
		return cursor;
	}
	
	
	/**
	 * @param playScoresHis
	 * please use playScoresHis.getPlayTimeStart and playScoresHis.getPlayTimeEnd to transfer the conditions
	 * please use playScoresHis.getPlayGameId() 
	 * @return
	 */
	public Cursor GetCursorByDateAndGameId(PlayScoresHis playScoresHis) {

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM " + PlayScoresHisTable.TABLE_NAME
				+ " WHERE " + PlayScoresHisTable.PlayGameId
				+ "='" + playScoresHis.getPlayGameId() + "'"
				+ " and " + PlayScoresHisTable.PlayTime + " between '" +
				playScoresHis.getPlayTimeStart() +"' and '"+ playScoresHis.getPlayTimeEnd() +"'";
		 
		Cursor cursor = db.rawQuery(sql, null);
		return cursor;
	}

	/**
	 * @param playScoresHis
	 *            - getPlayGameName
	 * @return
	 */
	public Cursor GetCursorByGrameName(PlayScoresHis playScoresHis) {

		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT * FROM " + PlayScoresHisTable.TABLE_NAME
				+ " WHERE " + PlayScoresHisTable. PlayGameName 

				+ " like '%" + playScoresHis.getPlayGameName() + "%'";

		Cursor cursor = db.rawQuery(sql, null);
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
		cv.put(PlayScoresHisTable. MachineId , playScoresHis.getMachineId());
		cv.put(PlayScoresHisTable. PlayGameId , playScoresHis.getPlayGameId());
		cv.put(PlayScoresHisTable. PlayGameName ,
				playScoresHis.getPlayGameName());
		cv.put(PlayScoresHisTable. Score , playScoresHis.getScore());
		//Date dt = new Date();
		cv.put(PlayScoresHisTable. PlayTime , playScoresHis.getPlayTime());

		long row = db.insert(PlayScoresHisTable.TABLE_NAME, null, cv);
		return row;

	}

	/**
	 * @param id
	 *            delete..
	 */
	public void delete(int id)

	{

		SQLiteDatabase db = this.getWritableDatabase();

		String where = PlayScoresHisTable. ID  + " = ?";

		String[] whereValue = { Integer.toString(id) };

		db.delete(PlayScoresHisTable.TABLE_NAME, where, whereValue);

	}

	/**
	 * @param id
	 * @param cardList
	 *            update ...
	 */
	public void update(int id, PlayScoresHis playScoresHis)

	{

		SQLiteDatabase db = this.getWritableDatabase();

		String where = PlayScoresHisTable.ID  + " = ?";

		String[] whereValue = { Integer.toString(id) };

		/* ContentValues */
		ContentValues cv = new ContentValues();
		cv.put(PlayScoresHisTable.MachineId, playScoresHis.getMachineId());
		cv.put(PlayScoresHisTable.PlayGameId, playScoresHis.getMachineId());
		cv.put(PlayScoresHisTable.PlayGameName,
				playScoresHis.getMachineId());
		cv.put(PlayScoresHisTable.Score , playScoresHis.getMachineId());
		Date dt = new Date(SystemClock.elapsedRealtime());
		cv.put(PlayScoresHisTable.PlayTime , dt.toString());

		db.update(PlayScoresHisTable.TABLE_NAME, cv, where, whereValue);

	}
	
	public List<PlayScoresHis> ConvertCursorToEntityClass(Cursor cursor)
	{
		List<PlayScoresHis> playScoresHiss= new ArrayList<PlayScoresHis>();
		while ( cursor.moveToNext() )
		{
			//getID  
			PlayScoresHis playScoresHis= new PlayScoresHis();
			playScoresHis.setID( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.ID ) )) ;
			playScoresHis.setMachineId ( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.MachineId ) )) ;
			playScoresHis.setPlayGameId  ( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.PlayGameId ) )) ;
			playScoresHis.setPlayGameName   ( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.PlayGameName ) )) ;
			playScoresHis.setPlayTime    ( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.PlayTime ) )) ;
			playScoresHis.setScore     ( cursor.getString( cursor.getColumnIndex( PlayScoresHisTable.Score  ) )) ;
			playScoresHiss.add(playScoresHis);
		} 
        
        return playScoresHiss;

	}

}
