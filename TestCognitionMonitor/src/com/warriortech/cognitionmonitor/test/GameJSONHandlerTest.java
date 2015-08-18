package com.warriortech.cognitionmonitor.test;

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;

import android.content.Context;
import com.warriortech.cognitionmonitor.model.GameResult;
import com.warriortech.cognitionmonitor.service.Impl.GameJSONHandlerImpl;
import com.warriortech.cognitionmonitor.service.Impl.GameStateControllerImpl;
import com.warriortech.cognitionmonitor.service.Interface.GameStateController;
import com.warriortech.cognitionmonitor.util.JSONHandler;

import junit.framework.TestCase;

public class GameJSONHandlerTest extends TestCase {
	
	@Test
	public void testGameJSONHandlerImpl() {
		GameJSONHandlerImpl gameJC=null;
		try {
			gameJC=
					new GameJSONHandlerImpl("{\"result\": [{\"gid\":\"1455\",\"score\":\"0\",\"time\":\"145\"}]}");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GameResult result = new GameResult("1455", "0", "145");		
		GameResult result2 = gameJC.parseGameJSONContent();
		
		assertTrue(result.getGameId().equals(result2.getGameId())) ;
		assertTrue(result.getGameTime().equals(result2.getGameTime())) ;
		assertTrue(result.getGameScore().equals(result2.getGameScore())) ;
		
		
	}
	
	@Test
	public void testJSONHandlerImpl() {
		
		
		GameResult result = new GameResult("1455", "0", "145");		
		GameResult result2 = JSONHandler.parseGameJSONContent("{\"result\": {\"gid\":\"1455\",\"score\":\"0\",\"time\":\"145\"}}");
		
		assertTrue(result.getGameId().equals(result2.getGameId())) ;
		assertTrue(result.getGameTime().equals(result2.getGameTime())) ;
		assertTrue(result.getGameScore().equals(result2.getGameScore())) ;
		
		
	}
	
	@Test
	public void testJSONHandlerImpl2() {
		
		
		GameResult result = new GameResult("1455", "0", "145");	
		String json1=JSONHandler.jsonGameResult(result);
		String json2 = "{\"result\": {\"gid\":\"1455\",\"score\":\"0\",\"time\":\"145\"}}";
		result=JSONHandler.parseGameJSONContent(json1);
		GameResult result2=JSONHandler.parseGameJSONContent(json2);
		assertTrue(result.getGameId().equals(result2.getGameId())) ;
		assertTrue(result.getGameTime().equals(result2.getGameTime())) ;
		assertTrue(result.getGameScore().equals(result2.getGameScore())) ;
		
		
	}
	
}
