package com.warriortech.cognitionmonitor.service;

import com.warriortech.cognitionmonitor.model.GameResult;

import android.webkit.JavascriptInterface;

public interface WebAppCommunication {

	/**Provide the method which javascript of webview can invoke
     * for saving the result of the cognition ability test to the database
     * @param time
     * @param score
     */
    @JavascriptInterface
    public void saveTimeAndScore(float time, int score);
    
    
    /**
     * Provide the method to read data from DB, and
     * pass it to js file
     * 
     * @return GameResult
     */
    @JavascriptInterface
    public GameResult readGameInfoFromDB();
}
