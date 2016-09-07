package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;


public class MakeAPICall {
	
	Logger log = Logger.getLogger(MakeAPICall.class.getName());
	private static final String USER_AGENT = "Mozilla/5.0";
	
	public String makeHttpGetCall(String url, String parameters) throws IOException {

		URL obj = new URL(url + parameters);
		
		HttpURLConnection con;
			con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setReadTimeout(1000000);
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		/*log.info("Sending 'GET' request to URL : " + url+parameters);
		log.info("Response Code : " + responseCode);
*/
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		/*log.info(response.toString());*/
		return response.toString();
	}
	
}
