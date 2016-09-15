package ar.com.model.domain;

import java.io.Serializable;

public class TransactionReport implements Serializable{
	private double volume;
	private String from;
	private String to;
	private String date;
	
	public TransactionReport(){}
	public TransactionReport(double volume,String from,String to,String date)
	{
		this.volume=volume;
		this.from=from;
		this.date=date;
		this.to=to;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
 
}
