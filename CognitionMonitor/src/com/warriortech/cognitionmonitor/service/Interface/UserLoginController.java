/**
 * 
 */
package com.warriortech.cognitionmonitor.service.Interface;

import android.content.Context;

/**
 * @author ximinyan
 *
 */
public interface UserLoginController {
	public boolean checkUserLoginInformation(Context context, String accountName, String password);
}
