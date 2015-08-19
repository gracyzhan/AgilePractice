package com.warriortech.cognitionmonitor.service.Impl;

import java.util.Date;
import java.util.List;

import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.model.GameResultHistory;
import com.warriortech.cognitionmonitor.model.User;
import com.warriortech.cognitionmonitor.service.Interface.ResultController;

public class ResultControllerImpl implements ResultController {

	@Override
	public GameResultHistory getGameResultList(User user, Date dtStart,
			Date dtEnd) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public GameResultHistory getGameResultList(User user, String dtStart,
			String dtEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGameResultJSON(User user, Date dtStart, Date dtEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGameResultJSON(User user, String dtStart, String dtEnd) {
		// TODO Auto-generated method stub
		return null;
	}

}
