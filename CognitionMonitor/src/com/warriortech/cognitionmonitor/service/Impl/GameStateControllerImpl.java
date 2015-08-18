package com.warriortech.cognitionmonitor.service.Impl;

import java.util.Date;

import android.content.Context;

import com.warriortech.cognitionmonitor.TestDao;
import com.warriortech.cognitionmonitor.dao.DataBaseDaoImpl;
import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisDaoImpl;
import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.model.User;
import com.warriortech.cognitionmonitor.service.Interface.GameStateController;

public class GameStateControllerImpl implements GameStateController {

	DataBaseDaoImpl databaseDao=new PlayScoresHisDaoImpl(null);
	@Override
	public boolean saveAbilityTestResult(Context context, User user, GameResult gs) {
		
				
		PlayScoresHisDaoImpl playScoresHisDaoImpl = new PlayScoresHisDaoImpl( context );
		PlayScoresHis playScoresHis = new PlayScoresHis();
		playScoresHis.setMachineId("gracyMac");
		//TODO : I need to store the user information as well
		playScoresHis.setPlayGameId(gs.getGameId());
		playScoresHis.setPlayGameName(gs.getGameId());
		playScoresHis.setScore(gs.getGameScore());
		playScoresHis.setPlayTime(gs.getGameTime());
		Date date = new Date();
		playScoresHis.setPlayTime(date.toString());
		long tid = playScoresHisDaoImpl.insert(playScoresHis);
		
		
		return true;
	}

}
