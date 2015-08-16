package com.warriortech.cognitionmonitor.service;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.warriortech.cognitionmonitor.model.GameResult;

public class ParseGameJSONHandlerImpl implements ParseGameJSONController{
	
	public ParseGameJSONHandlerImpl(){
		
	}
	
	public ParseGameJSONHandlerImpl(String jsonStr) throws JSONException{
		JSONObject jsonObj = new JSONObject(jsonStr);
		this.rootNode = jsonObj.getJSONArray(TAG_RESULT);
	}
	
	@Override
	public GameResult parseGameJSONContent() {
		// looping through the result
		JSONObject content = null;
		String gid = null;
		String score = null;
		String time = null;;
		
		try {
			content = this.rootNode.getJSONObject(0);
			gid = content.getString(TAG_ID);
			score = content.getString(TAG_SCORE);
			time = content.getString(TAG_TIME);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
