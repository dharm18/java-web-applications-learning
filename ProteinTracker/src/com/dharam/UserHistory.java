package com.dharam;

import java.util.Date;

/**
 * @author hp
 *
 */
public class UserHistory {

	private Date entryTime;
	private String entry;
	
	public UserHistory() {
		
	}
	
	
	public UserHistory(Date entryTime, String entry) {
		super();
		this.entryTime = entryTime;
		this.entry = entry;
	}


	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserHistory [entryTime=");
		builder.append(entryTime);
		builder.append(", entry=");
		builder.append(entry);
		builder.append("]");
		return builder.toString();
	}
	
	
}
