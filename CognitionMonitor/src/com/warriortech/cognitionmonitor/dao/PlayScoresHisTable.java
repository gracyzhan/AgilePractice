package com.warriortech.cognitionmonitor.dao;

/**
 * @author zqzhan
 * This class is used to describe the physical table in the database
 * do not use this class to transport data 
 * use PlayScoresHis to transport data
 */
public class PlayScoresHisTable {

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	 
	public String getID() {
		return ID;
	}

	 
	public String getMachineId() {
		return MachineId;
	}

	 

	public String getPlayTime() {
		return PlayTime;
	}

	 

	public String getScore() {
		return Score;
	}

	
	public String getPlayGameId() {
		return PlayGameId;
	}

	public String getPlayGameName() {
		return PlayGameName;
	}

	private String PlayGameId = "PlayGameId";
	private String PlayGameName = "PlayGameName";
	private String PlayTime = "PlayTime";
	private String Score = "Score";
	private String TABLE_NAME = "PlayScoresHis";
	private String ID = "ID";
	private String MachineId = "MachineId";
	

}
