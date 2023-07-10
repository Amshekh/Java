package edu.met.adsd.banking;

public class Banker{
	
	private static long nextId;

	private Banker(){}

	static{
		long t = System.currentTimeMillis();
		nextId = t % 1000000;
	}

	public static Account openAccount(double amount, boolean savings){
		Account acc;
		if(savings)
			acc = new SavingsAccount();
		else
			acc = new CurrentAccount();
		acc.id += nextId++;
		acc.deposit(amount);
		return acc;
	}
}
















