package com.warriortech.cognitionmonitor.service.Impl;

import android.content.Context;

import com.warriortech.cognitionmonitor.dao.DataBaseDaoImpl;
import com.warriortech.cognitionmonitor.dao.PlayScoresHis;
import com.warriortech.cognitionmonitor.dao.PlayScoresHisDaoImpl;
import com.warriortech.cognitionmonitor.model.User;
import com.warriortech.cognitionmonitor.service.Interface.GameStateController;

public class GameStateControllerImpl implements GameStateController {

	DataBaseDaoImpl databaseDao=new PlayScoresHisDaoImpl(null);
	@Override
	public boolean saveAbilityTestResult(Context context, User user, float time, int score) {
		// TODO #004 Convert the user, time, score to the PlayScoresHis
		// impletation
		PlayScoresHis playScoreObject=new PlayScoresHis();
		
		
		return false;
	}

}
