package com.warriortech.cognitionmonitor.service;

import android.webkit.JavascriptInterface;

public interface WebAppCommunication {

	/**Provide the method which javascript of webview can invoke
     * for saving the result of the cognition ability test to the database
     * @param time
     * @param score
     */
    @JavascriptInterface
    public void saveTimeAndScore(float time, int score);
}
