package com.warriortech.cognitionmonitor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameResultHistory {
	private final User user;
	private List<GameResult> results=new ArrayList<GameResult>();
	private Date timeFrom;
	private Date timeTo;
	
	public GameResultHistory(User user)
	{
		this.user=user;
	}

	public List<GameResult> getResults() {
		return results;
	}

	public void setResults(List<GameResult> results) {
		this.results = results;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}

	public User getUser() {
		return user;
	}
	
}
