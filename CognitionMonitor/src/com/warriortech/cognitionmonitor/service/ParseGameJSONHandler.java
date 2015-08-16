package com.warriortech.cognitionmonitor.service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.warriortech.cognitionmonitor.model.GameResult;

public class ParseGameJSONHandler {
	
	public ParseGameJSONHandler(){
		
	}
	
	public ParseGameJSONHandler(String jsonStr) throws JSONException{
		JSONObject jsonObj = new JSONObject(jsonStr);
		this.rootNode = jsonObj.getJSONArray(TAG_RESULT);
	}
	
	public GameResult parseJSONContent() throws JSONException{
		// looping through the result
		JSONObject content = this.rootNode.getJSONObject(0);
		String gid = content.getString(TAG_ID);
		String score = content.getString(TAG_SCORE);
		String time = content.getString(TAG_TIME);
		
		GameResult result = new GameResult(gid, score, time);
		
		
		return result;
		
	}
	
	// JSON Node names
    private static final String TAG_RESULT = "result";
    private static final String TAG_ID = "gid";
    private static final String TAG_SCORE = "score";
    private static final String TAG_TIME = "time";
    
    // contacts JSONArray
    JSONArray result = null;
    JSONArray rootNode;

}
