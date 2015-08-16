package com.warriortech.cognitionmonitor.service;

import com.warriortech.cognitionmonitor.model.User;

import android.content.Context;

public class WebAppCommunicationImpl implements WebAppCommunication{
	
	Context mContext;
	
	//TODO Task 002 : Use IOC to initial this kind of global variables
	GameStateController gameStateController = new GameStateControllerImpl();

    /** Instantiate the interface and set the context */
	public WebAppCommunicationImpl(Context c) {
        mContext = c;
    }
    
	/* (non-Javadoc)
	 * @see com.warriortech.cognitionmonitor.service.WebAppCommunicationInterface#saveTimeAndScore(float, int)
	 */
	@Override
	public void saveTimeAndScore(float time, int score) {
		// TODO Task 001: Waiting to get the current user information
		User user=new User();
		gameStateController.saveAbilityTestResult(mContext, user, time, score);
		
		//TODO Task 003: Add the javascript interface to the webview
		//webView.addJavascriptInterface(new WebAppInterface(this), "Android");
		//http://developer.android.com/guide/webapps/webview.html
		
		
	}
}
