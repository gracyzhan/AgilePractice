package com.warriortech.cognitionmonitor.service;

import android.content.Context;

/**
 * 
 * @author ximinyan
 *
 */
public interface UserRegisterController {
	
	public void saveUserInfoToDB(Context context, String accountName, String password, String email);

}
