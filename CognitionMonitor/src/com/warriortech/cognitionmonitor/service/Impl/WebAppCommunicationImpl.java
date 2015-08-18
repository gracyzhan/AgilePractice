package com.warriortech.cognitionmonitor.service.Impl;

import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.model.User;
import com.warriortech.cognitionmonitor.service.Interface.GameStateController;
import com.warriortech.cognitionmonitor.util.JSONHandler;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppCommunicationImpl{
	
	Context mContext;
	
	//TODO Task 002 : Use IOC to initial this kind of global variables
	GameStateController gameStateController = new GameStateControllerImpl();

    /** Instantiate the interface and set the context */
	public WebAppCommunicationImpl(Context c) {
        mContext = c;
    }
    
	/**save the game id, time and score to local database  */
	@JavascriptInterface
	public void saveTimeAndScore(float time, int score) {
		// TODO Task 001: Waiting to get the current user information
		User user=new User("firstName", "lastName", "password", "001");
		gameStateController.saveAbilityTestResult(mContext, user, time, score);
		
		//TODO Task 003: Add the javascript interface to the webview
		//webView.addJavascriptInterface(new WebAppInterface(this), "Android");
		//http://developer.android.com/guide/webapps/webview.html
		
		
	}

	@JavascriptInterface
	public String readGameInfoFromDB() {
		// TODO Task 004 read data from DB and pass it to js
		// may need JSONObject, need to modify
		GameResult gr=new GameResult("123", "4444", "333");
		
		return JSONHandler.jsonGameResult(gr);
	}
}
