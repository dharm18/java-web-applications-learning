package com.dharam.rockalltest;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.dharam.rockalltest.domain.LoanAccount;
import com.dharam.rockalltest.domain.MarketData;
import com.dharam.rockalltest.domain.Position;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * This class does the second part the assignment which is generating file with outstanding loan amounts.
 * 
 * @author Dharmendra Vishwakarma <vdharam18@gmail.com>
 * @since 30-09-2019 12.30 AM
 */
public class LoanAlerts {

	Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Main class with arguments - marketdata.json loandata.json
	 * Command : com.dharam.rockalltest.LoanAlerts marketdata.json loandata.json
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			if(args.length!=2) {
				System.err.println("Two arguments are expected. Following structure of command is allowed.");
				System.out.println("com.dharam.rockalltest.LoanAlerts marketdata.json loandata.json");
				System.exit(-1);
			}
			
			String marketDataFileName = args[0];
			String loanDataFileName = args[1];
			
			//json string conversion from file
			String loanDataJsonString = new String(Files.readAllBytes(Paths.get(loanDataFileName)), StandardCharsets.UTF_8);
			String marketDataJsonString = new String(Files.readAllBytes(Paths.get(marketDataFileName)), StandardCharsets.UTF_8);
			
			//logic to generate outstanding loans
			LoanAlerts alerts = new LoanAlerts();
			alerts.generateAlerts(loanDataJsonString, marketDataJsonString);
			
		} catch (FileNotFoundException e) {
			System.err.println("Files are not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method taks json strings and convert them into java POJO objects. These pojos are iterated and totalPortfolio is generated from MAP implementation of market data for faster retrieval.
	 * @param loanDataJsonString
	 * @param marketDataJsonString
	 */
	private void generateAlerts(String loanDataJsonString, String marketDataJsonString) {
		
		try {
			final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        
			//convert from json to Pojo
	        List<LoanAccount> loans = gson.fromJson(loanDataJsonString, new TypeToken<List<LoanAccount>>() {}.getType());
	        
	        List<MarketData> marketData = gson.fromJson(marketDataJsonString, new TypeToken<List<MarketData>>() {}.getType());
	        log.info("marketData : " + marketData.size());
	        
			//log.info(loans.toString());
	        log.info("loans : " + loans.size());
			
	        //market data map conversion based on id/ISIN
			Map<String,MarketData> marketDataMap = new HashMap<>();
			for (MarketData i: marketData) marketDataMap.put(i.getISIN(),i);
			
			// to hold outstanding values
			List<LoanAccount> outstandingLoans = new ArrayList<>();
			
			for(LoanAccount loan : loans) {
				double totalPortfolioValue = 0, outstandingAmount=0;
				outstandingAmount = loan.getAmount();
				
				List<Position> positions = loan.getPositions();
				
				for(Position position: positions){
					totalPortfolioValue += Double.parseDouble(marketDataMap.get(position.getId()).getPrice()) * position.getQuantity();
				};
				
				//System.out.println(outstandingAmount + " == " + totalPortfolioValue);
				
				//condition - outstanding loans
				if(totalPortfolioValue < outstandingAmount) {
					LoanAccount outstandingLoan = new LoanAccount();
					outstandingLoan.setId(loan.getId());
					outstandingLoan.setCreditPolicy(loan.getCreditPolicy());
					outstandingLoan.setAmount(outstandingAmount);
					outstandingLoan.setEligibleCollateral(totalPortfolioValue);
					
					outstandingLoans.add(outstandingLoan);
				}
			}
			
			String outstandingLoansJson = gson.toJson(outstandingLoans);
			System.out.println(outstandingLoansJson);
			
			//json file writing logic
			try (FileWriter outputFile = new FileWriter("loanalerts.json", false)){
				outputFile.write(outstandingLoansJson);
				outputFile.close();
				log.info("Successfully written final output file in json format.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
