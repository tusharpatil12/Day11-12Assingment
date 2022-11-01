package com.bridgeLabz;

import java.util.Scanner;

public class Account {

	String name;
	long accountNumber;
	double Balance;
	double amount;
	Account(String name, long accountNumber, double Balance){
		this.name = name;
		this.accountNumber = accountNumber;
		this.Balance = Balance;
	}
	public void deposit(double amount){
		Balance =Balance+amount;
		System.out.println("your amount debit Successfully");
		System.out.println();
		System.out.println("your current Available Balance is  :"+Balance);
	}
	public  void withdrawal(double amount){
		if(amount<=Balance){
			Balance = Balance-amount;
			System.out.println("your "+ amount+" amount withdrawal successfully ! ");
			System.out.println();
			System.out.println("your current Available Balance is "+Balance);
		}
		else {
			System.out.println("sorry you can not Withdrawal because Inefficient Balance");
		}
	}
	public void printDetails(){
		System.out.println("Your Name  : "+name);
		System.out.println("Your Account Number  : "+accountNumber);
		System.out.println("Your Available Balance  :" +Balance);
	}
	public  static int account(){
		String id="";
		int auto_id=0;
		String alphabet = "123456789";
		java.util.Random r = new java.util.Random();
		for(int i=1; i<=7; i++){
			char c = alphabet.charAt((r.nextInt(alphabet.length())));
			id = String.valueOf(c)+id;
			auto_id = auto_id+Integer.parseInt(id);
		}
		return auto_id;
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println(".....WELCOME TO BANK APPLICATION........");
		System.out.println("create account here");
		Scanner sc = new Scanner(System.in);
		String fullNam;
		int account = Account.account();
		System.out.println("Enter first name :");
		String firstName = sc.nextLine();
		System.out.println("Enter last name :");
		String lastname = sc.nextLine();
		System.out.println("Enter amount minimum 10000 :");
		double amount = sc.nextInt();
		fullNam = firstName+" "+lastname;
		Account bank = new Account(fullNam,account,amount);
		System.out.println("your create account successfully");
		int choice;
		do {
			System.out.println("1. deposit amount");
			System.out.println("2. Withdrawal amount ");
			System.out.println("3. printDetails");
			System.out.println("0.Exit");
			System.out.println("your choice option here enter number");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println(".......................");
				System.out.println("enter amount :");
				double amoun = sc.nextDouble();
				bank.deposit(amoun);
				System.out.println("deposit successfully ");
				System.out.println(".......................");
				break;
			case 2:
				System.out.println(".......................");
				System.out.println("enter amount :");
				double amoun_1 = sc.nextDouble();
				bank.withdrawal(amoun_1);
				System.out.println("Withdrawal successfully ");
				System.out.println(".......................");
				break;
			case 3:
				System.out.println(".......................");
				bank.printDetails();
				System.out.println(".......................");
				break;
			}
		}while (choice!=0);


	}

}
