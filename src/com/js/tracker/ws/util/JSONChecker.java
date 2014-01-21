package com.js.tracker.ws.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONChecker {

	private static JSONChecker singleton = null;
	
	private JSONChecker()
	{
		
	}
	
	public static JSONChecker getInstance()
	{
		if(JSONChecker.singleton == null)
		{
			synchronized(JSONChecker.class)
			{
				if(JSONChecker.singleton == null)
				{
					JSONChecker.singleton = new JSONChecker();
				}
			}
		}
		
		return JSONChecker.singleton;
	}
	
	
	
	public JSONObject isValidJSONObject(String input){
		JSONObject ret=null;
		try{			
			ret=new JSONObject(input);			
		}catch(Exception ex){
			
		}
		return ret;
	}
	
	public JSONObject isEmptyJSONObject(String input){
		JSONObject ret=null;		
		JSONObject jSONObject=isValidJSONObject(input);			
		if(jSONObject!=null && (jSONObject instanceof JSONObject)){		
			if(jSONObject.keys().hasNext()){
				ret=jSONObject;
			}				
		}		
		return ret;
	}
		
	public JSONArray isValidJSONArray(String input){
		JSONArray ret=null;
		try{
			ret=new JSONArray(input);			
		}catch(Exception ex){
			
		}
		return ret;
	}
	
	public JSONArray isEmptyJSONArray(String input){
		JSONArray ret=null;
		JSONArray jsonArray=isValidJSONArray(input);
		if(jsonArray!=null && (jsonArray.length()!=0)){				
			ret=jsonArray;			
		}
		return ret;
	}
	
	public boolean isValidJSONString(String input) {
		boolean ret = false;
		if (isValidJSONObject(input) == null) {
			if (isValidJSONArray(input) == null) {

			} else {
				ret = true;
			}
		} else {
			ret = true;
		}
		return ret;
	}
	
}
