/**
 * author: Jerry Lee @ 11:57:36 am 
 */
package com.warriortech.cognitionmonitor.service.Interface;

import java.util.Date;
import java.util.List;

import com.warriortech.cognitionmonitor.model.*;
/**
 * @author jerry
 *
 */
public interface ResultController {
	
	public GameResultHistory getGameResultList(User user, Date dtStart, Date dtEnd);
	
	public GameResultHistory getGameResultList(User user, String dtStart, String dtEnd);
	
	public String getGameResultJSON(User user, Date dtStart, Date dtEnd);
	
	public String getGameResultJSON(User user,  String dtStart, String dtEnd);
	
	
}
