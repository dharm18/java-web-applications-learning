package com.dharam.rockalltest.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class MakeHttpCall {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	public String makeHttpGetCall(String url) throws Exception {
		
		StringBuilder response = null;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			con.setReadTimeout(1000000);
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			log.info("Sending 'GET' request to URL : " + url);
			log.info("Response Code : " + responseCode);
			log.info("Content type : " + con.getContentType());
			
			if(!con.getContentType().equalsIgnoreCase("application/json"))
				throw new Exception("Invalid content type. application/json is accepted");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			log.info(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Invalid URL is supplied.");
		}
		
		return response.toString();
	}
}
