package com.http.get;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.json.*;

public class HttpGet {
	
	public static String sendGet(String url,String param){
		String result = "";
		BufferedReader in = null;
		try{
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.connect();
//			Map<String,List<String>> Map = connection.getHeaderFields();
//			for(String key : Map.keySet()){
//				System.out.println(key + "---->" + Map.get(key));
//			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result += line;
			}
		}catch(Exception e){
			System.out.println("∑¢ÀÕGET«Î«Û“Ï≥£" + e);
			e.printStackTrace();
		}
		finally{
			try{
				if(in != null){
					in.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static String jsonOb(String jsonString,String key) throws JSONException{
		JSONObject jsonObj = new JSONObject(jsonString);
		String defaultS = jsonObj.getString(key);
//		System.out.println(defaultS);
		return defaultS;
	}
	public static String jsonArr(String jsonStr,String key) throws JSONException{
		JSONObject obj = new JSONObject(jsonStr);
		String valueArray = obj.getJSONArray(key).getString(0);
		System.out.println(valueArray);
		return valueArray;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
	String s = HttpGet.sendGet("http://192.168.90.43/search_keyword.php", "platf=android&limit=30");
//	System.out.println(s);
	try {
		HttpGet.jsonArr(HttpGet.jsonOb(s, "result"), "default");
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
