package com.warriortech.cognitionmonitor.test;

import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsNull;

import com.warriortech.cognitionmonitor.FullscreenActivity;
import com.warriortech.cognitionmonitor.TestDao;
import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisDaoImpl;
import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.model.User;
import com.warriortech.cognitionmonitor.service.Impl.GameStateControllerImpl;
import com.warriortech.cognitionmonitor.service.Interface.GameStateController;

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
	
	public void testSaveGameState() {
		FullscreenActivity activity = getActivity();
		Context context=activity.getApplicationContext();
		PlayScoresHisDaoImpl playScoresHisDaoImpl = new PlayScoresHisDaoImpl( context );
		
		GameStateController gsController=new GameStateControllerImpl();
		GameResult gr=new GameResult("TestGame101", "9999", "100023");
		User user=new User("Test", "User", "11111111", "555");
		
		gsController.saveAbilityTestResult(context, user, gr);
		
		PlayScoresHis playScoresHis = new PlayScoresHis();
		playScoresHis.setPlayGameId("TestGame101");
		Cursor cursor = playScoresHisDaoImpl.GetCursorByGameId(playScoresHis) ;
		if ( cursor.getCount() <1)
		{
			// error 
		}
		assertTrue("Not insert successful", cursor.getCount()>0);
		
		
		
		List<PlayScoresHis> playScoresHisArray =  playScoresHisDaoImpl.ConvertCursorToEntityClass(cursor) ;
		PlayScoresHis playScoreHis2=playScoresHisArray.get(0);
		assertTrue("Can Not get the record out", playScoreHis2!=null);
		assertEquals("Get the incorrect play time", playScoreHis2.getPlayTime(), "100023");
		assertEquals("Get the incorrect game id", playScoreHis2.getPlayGameId(), "TestGame101");
		assertEquals("Get the incorrect gamename", playScoreHis2.getPlayGameName(), "TestGame101");

		assertEquals("Get the incorrect score", playScoreHis2.getScore(), "9999");
		
    }
	
	
	public void testDAO() {
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
		assertTrue("Not insert successful", cursor.getCount()>0);
		
		
		
		List<PlayScoresHis> playScoresHisArray =  playScoresHisDaoImpl.ConvertCursorToEntityClass(cursor) ;
		PlayScoresHis playScoreHis2=playScoresHisArray.get(0);
		assertTrue("Can Not get the record out", playScoreHis2!=null);
		assertEquals("Get the incorrect machine id", playScoreHis2.getMachineId(), "gracyMac");
		assertEquals("Get the incorrect game id", playScoreHis2.getPlayGameId(), "123");
		assertEquals("Get the incorrect gamename", playScoreHis2.getPlayGameName(), "test1");
		
    }
}
