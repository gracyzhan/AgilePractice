package com.warriortech.cognitionmonitor.service;

import android.content.Context;

import com.warriortech.cognitionmonitor.model.User;

public interface GameStateController {
	
	public boolean saveAbilityTestResult(Context context, User user, float time, int score);

}
