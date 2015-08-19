package com.warriortech.cognitionmonitor.dao;

/**
 * @author zqzhan
 * This class is used to transport data from the layers upper dao
 * like service, control and etc. 
 */
public class PlayScoresHis {

	private String ID = "ID";

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMachineId() {
		return MachineId;
	}

	public void setMachineId(String machineId) {
		MachineId = machineId;
	}

	public String getPlayTime() {
		return PlayTime;
	}

	public void setPlayTime(String playTime) {
		PlayTime = playTime;
	}

	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}


	public String getPlayGameId() {
		return PlayGameId;
	}

	public void setPlayGameId(String playGameId) {
		PlayGameId = playGameId;
	}

	public String getPlayGameName() {
		return PlayGameName;
	}

	public void setPlayGameName(String playGameName) {
		PlayGameName = playGameName;
	}

	public String getPlayTimeStart() {
		return PlayTimeStart;
	}

	public void setPlayTimeStart(String playTimeStart) {
		PlayTimeStart = playTimeStart;
	}

	public String getPlayTimeEnd() {
		return PlayTimeEnd;
	}

	public void setPlayTimeEnd(String playTimeEnd) {
		PlayTimeEnd = playTimeEnd;
	}
	
	private String MachineId = "MachineId";
	private String PlayTime = "PlayTime";
	private String Score = "Score";
	private String PlayGameId = "PlayGameId";
	private String PlayGameName = "PlayGameName";
	private String PlayTimeStart = "";
	private String PlayTimeEnd = "";

}
