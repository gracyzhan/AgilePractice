package com.warriortech.cognitionmonitor.service.Interface;

import android.content.Context;

import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.model.User;

public interface GameStateController {
	
	public boolean saveAbilityTestResult(Context context, User user, GameResult gs);

}
