package com.dharam.rockalltest.domain;

public class MarketData {

	private String ticker;
	private String price;
	private String ISIN;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getISIN() {
		return ISIN;
	}
	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MarketData [ticker=");
		builder.append(ticker);
		builder.append(", price=");
		builder.append(price);
		builder.append(", ISIN=");
		builder.append(ISIN);
		builder.append("]");
		return builder.toString();
	}
	
	
}
