package com.warriortech.cognitionmonitor.model;

/**
 * Data model for game
 * 
 * @author ximinyan
 *
 */
public class GameResult {
	
	public GameResult(){
		
	}
	
	public GameResult(String gid, String score, String time){
		this.gameId = gid;
		this.gameScore = score;
		this.gameTime = time;
	}
	
	public String getGameId(){
		return this.gameId;
	}
	
	public String getGameScore(){
		return this.gameScore;
	}

	public String getGameTime(){
		return this.gameTime;
	}
	
	private String gameId;
	private String gameScore;
	private String gameTime;
}
