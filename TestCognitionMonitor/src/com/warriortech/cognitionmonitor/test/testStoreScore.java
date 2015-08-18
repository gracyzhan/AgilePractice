package com.warriortech.cognitionmonitor.test;

import java.util.Date;
import java.util.List;

import com.warriortech.cognitionmonitor.FullscreenActivity;
import com.warriortech.cognitionmonitor.TestDao;
import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisDaoImpl;

import android.content.Context;
import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;

public class testStoreScore extends ActivityInstrumentationTestCase2<FullscreenActivity> {

	public testStoreScore() {
		super(FullscreenActivity.class);
		// TODO Auto-generated constructor stub

	
	}
	
	public void testActivityExists() {
		FullscreenActivity activity = getActivity();
	    assertNotNull(activity);
	}
	
	public void testGreet() {
		FullscreenActivity activity = getActivity();
		Context context=activity.getApplicationContext();
		PlayScoresHisDaoImpl playScoresHisDaoImpl = new PlayScoresHisDaoImpl( context );
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
