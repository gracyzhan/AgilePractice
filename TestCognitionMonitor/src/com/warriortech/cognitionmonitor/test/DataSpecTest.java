package com.warriortech.cognitionmonitor.test;

import java.util.Date;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;

import com.warriortech.cognitionmonitor.FullscreenActivity;
import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisDaoImpl;

public class DataSpecTest extends ActivityInstrumentationTestCase2<FullscreenActivity> {
	
	public DataSpecTest(){
		super(FullscreenActivity.class);
	} 

	public void NullDataHisTest(){
		FullscreenActivity activity = getActivity();
		Context context = activity.getApplicationContext();
		PlayScoresHisDaoImpl playScoresHisDaoImpl = new PlayScoresHisDaoImpl( context );
		
		PlayScoresHis playScoresHis = new PlayScoresHis();
		playScoresHis.setID(null);
		playScoresHis.setMachineId(null);
		playScoresHis.setPlayGameId(null);
		playScoresHis.setPlayGameName(null);
		playScoresHis.setScore(null);
		Date date = new Date();
		playScoresHis.setPlayTime(date.toString());
		long tid = playScoresHisDaoImpl.insert(playScoresHis);
		
		playScoresHis = new PlayScoresHis();
	}
	
}
