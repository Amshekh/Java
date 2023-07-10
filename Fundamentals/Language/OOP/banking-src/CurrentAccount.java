package edu.met.adsd.banking;

final class CurrentAccount extends Account{
	
	public CurrentAccount(){
		id = "C/A";
		balance = 0;
	}

	public void deposit(double amount){
		balance += amount;
	}

	public void withdraw(double amount){
		balance -= amount;
	}
}












