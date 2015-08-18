package com.warriortech.cognitionmonitor.util;


import org.json.JSONException;
import org.json.JSONObject;

import com.warriortech.cognitionmonitor.model.GameResult;

public class JSONHandler {
	
    private static final String TAG_RESULT = "result";
    private static final String TAG_ID = "gid";
    private static final String TAG_SCORE = "score";
    private static final String TAG_TIME = "time";	
	
	/* GameResult JSON : {"result":{"id":"111","score":"333","time":"12345"}}*/
	public static GameResult parseGameJSONContent(String jsonStr) {
		// looping through the result
		
		
		GameResult result=null;
		
		try {
			JSONObject jsonObj = new JSONObject(jsonStr);		
			JSONObject content = jsonObj.getJSONObject(TAG_RESULT);
			String gid = content.getString(TAG_ID);
			String score = content.getString(TAG_SCORE);
			String time = content.getString(TAG_TIME);
			result = new GameResult(gid, score, time);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/* GameResult JSON : {"result":{"id":"111","score":"333","time":"12345"}}
	 * order not guaranteed*/
	
	public static String jsonGameResult(GameResult gs)
	{
		JSONObject jsonObj = new JSONObject();
		
		try {
			JSONObject jsonGRObj = new JSONObject();
			jsonGRObj.put(TAG_ID, gs.getGameId());
			jsonGRObj.put(TAG_SCORE, gs.getGameScore());
			jsonGRObj.put(TAG_TIME, gs.getGameTime());
			jsonObj.put(TAG_RESULT, jsonGRObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObj.toString();
	}
	
	// JSON Node names

}
