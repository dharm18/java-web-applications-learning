package com.dharam.rockalltest;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dharam.rockalltest.domain.MarketData;
import com.dharam.rockalltest.utility.MakeHttpCall;

/**
 * Market Data processor - Reads http url with json content and parses it to another json file with custom price formatter.
 * @author Dharam
 *
 */
public class MarketDataProcessor {
	
	Logger log = Logger.getLogger(this.getClass().getName());
	DecimalFormat priceFormatter = new DecimalFormat("0.####");
	
	public static void main(String[] args) {
		
		try {
			if(args.length==1) {
				String urlPath = args[0];
				MarketDataProcessor marketDataProcessor = new MarketDataProcessor();
				marketDataProcessor.processURL(urlPath);
			}
			else {
				System.out.println("URL argument should be passed for this program. \nFor example, java com.dharam.rockalltest.MarketDataProcessor http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/marketdata.json");
				System.exit(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void processURL(String urlPath) throws Exception {
		try {
			MakeHttpCall makeHttpCall = new MakeHttpCall();
			String respJson = makeHttpCall.makeHttpGetCall(urlPath);
			List<MarketData> marketDataList = new ArrayList<MarketData>(); 
			
			JSONArray jsonArr = new JSONArray(respJson);
			
			for(int i = 0; i < jsonArr.length(); i++){
				JSONObject obj = jsonArr.getJSONObject(i);
				
				MarketData marketData = new MarketData();
				marketData.setTicker(obj.has("ticker") ? obj.getString("ticker") : null);
				marketData.setPrice(priceFormatter.format(obj.getDouble("price")));
				marketData.setISIN(obj.getString("id"));
				
				log.info("market Data " + marketData);
				
				marketDataList.add(marketData);
			}
			
			log.info(marketDataList.size()+"");
			
			//file writing logic
			JSONArray outputJson = new JSONArray(marketDataList);
			try (FileWriter outputFile = new FileWriter("marketdata.json", false)){
				outputJson.write(outputFile);
				outputFile.close();
				log.info("Successfully written json file for part-1");
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
