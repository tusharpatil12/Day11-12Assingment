package com.bridgeLabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
interface IStockAccount{
	public  void addDetails(String stockName, int numberOfShare, int sharePrice);
	public  void calculateValue();
	public int getTotalValue(String stockName);
}
class StockAccount {
	String stockName;
	int numberOfShare;
	int sharePrice;
	int totalValue;
	public StockAccount(String stockName, int numberOfShare, int sharePrice) {
		this.stockName = stockName;
		this.numberOfShare = numberOfShare;
		this.sharePrice = sharePrice;
		totalValue = 0;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}
	@Override
	public String toString() {
		String stock = "the value of each stock for company " + stockName + "total value" + totalValue;
		return stock;
	}
}
class NewStock implements IStockAccount{
	private int numOfCompany=0;
	private ArrayList<StockAccount> stockAccounts;
	private HashMap<String, Integer> totalValue;
	NewStock(){
		stockAccounts = new ArrayList<>();
		totalValue  = new HashMap<>();
	}
	public  void addDetails(String stockName, int numberOfShare, int sharePrice){
		StockAccount stockAccount = new StockAccount(stockName, numberOfShare,sharePrice);
		stockAccounts.add(stockAccount);
		totalValue.put(stockName,0);
	}
	public  void calculateValue(){
		for(int index = 0; index<stockAccounts.size(); index++){
			StockAccount stockAccount  =stockAccounts.get(index);
			stockAccount.setTotalValue(this.calculateValue(stockAccount));
		}
	}
	public int calculateValue(StockAccount stockAccount){
		int totalvalue = 0;
		totalvalue =totalvalue+stockAccount.sharePrice*stockAccount.numberOfShare;
		System.out.println("...................................");
		System.out.println("The "+ stockAccount.stockName + " company each Stock price is : " +stockAccount.sharePrice);
		totalValue.put(stockAccount.stockName,totalvalue);
		return totalvalue;
	}
	public int getTotalValue(String stockName){
		return totalValue.get(stockName);
	}
	public static void main(String[] args) {
		IStockAccount stock  = new NewStock();
		stock.addDetails("tcs",500,1020);
		stock.addDetails("Mahendra",500,150);
		stock.addDetails("Hindustan petroleum",500,1030);
		stock.calculateValue();
		Scanner sc = new Scanner(System.in);
		System.out.println("....................................");
		System.out.println();
		System.out.println("Enter Company name  for Track total Value of Stock");
		String stockName = sc.nextLine();
		int totalValue = stock.getTotalValue(stockName);
		System.out.println("The tatal value stock for company"+totalValue);
	}
}
