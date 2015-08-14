package com.warriortech.cognitionmonitor;

import java.util.Date;
import java.util.List;

import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.sqlite.PlayScoresHisDaoImpl;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

public class TestDao extends Activity{
	
	public void onCreate(Bundle savedInstanceState)
	{
		PlayScoresHisDaoImpl playScoresHisDaoImpl = new PlayScoresHisDaoImpl( TestDao.this );
		PlayScoresHis playScoresHis = new PlayScoresHis();
		playScoresHis.setMachineId("gracyMac");
		playScoresHis.setPlayGameId("123");
		playScoresHis.setPlayGameName("test1");
		Date date = new Date();
		playScoresHis.setPlayTime(date.toString());
		long tid = playScoresHisDaoImpl.insert(playScoresHis);
		
		playScoresHis = new PlayScoresHis();
		playScoresHis.setID(String.valueOf(tid));
		Cursor cursor = playScoresHisDaoImpl.GetCursorByRowId(playScoresHis) ;
		if ( cursor.getCount() <1)
		{
			// error 
		}
		List<PlayScoresHis> playScoresHisArray =  playScoresHisDaoImpl.ConvertCursorToEntityClass(cursor) ;
		if ( playScoresHisArray != null && playScoresHisArray.size() >0)
		{
			 for ( int i =0 ; i<playScoresHisArray.size() ;i++)
			 {
				 System.out.println( playScoresHisArray.get(i).getID() );  
				 System.out.println( playScoresHisArray.get(i).getMachineId() );  
				 System.out.println( playScoresHisArray.get(i).getPlayGameId());  
				 System.out.println( playScoresHisArray.get(i).getPlayGameName() );  
				 System.out.println( playScoresHisArray.get(i).getPlayTime() );  
				 System.out.println( playScoresHisArray.get(i).getScore() ); 
				 
			 }
		}
		 
		
	}

}
