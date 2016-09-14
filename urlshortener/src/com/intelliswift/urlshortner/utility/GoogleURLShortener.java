package com.intelliswift.urlshortner.utility;

import java.io.BufferedReader;  
import java.io.InputStreamReader;  

import org.apache.http.HttpResponse;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.StringEntity;  
import org.apache.http.impl.client.DefaultHttpClient;  

public class GoogleURLShortener {  
   
 public static String getShortUrl(String longUrl) {  
    
	 try {
		  String url = "https://www.googleapis.com/urlshortener/v1/url?key=AIzaSyC8_Mc9QjFjtS8e33JMMn22OiW819JABuk";
		  System.out.println("about to call");
		  HttpClient client = new DefaultHttpClient();  
		  HttpPost post = new HttpPost(url);  
		  
		  // add header  
		  post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");  
		  post.setHeader("Content-Type", "application/json");  
		  
		  StringEntity params = new StringEntity("{\"longUrl\": \""+longUrl+"\"}");  
		  post.setEntity(params);
		  
		  HttpResponse response = client.execute(post);  
		  
		  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
		  StringBuffer result = new StringBuffer();  
		  String line = "";  
		  while ((line = rd.readLine()) != null) {  
			  result.append(line);  
		  }
		  System.out.println(result);
		  //JsonObjectParser jsonObj = new (result.toString());  
		  //Object object = jsonObj.get("id");  
		  return result.toString();  
	 } catch (Exception e) {  
	  return "";  
	 }  
 }  
}  