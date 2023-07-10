package edu.met.adsd.banking;

public abstract class Account{
	
	String id;
	protected double balance;
	
	public final String getId(){
		return id;
	}

	public final double getBalance(){
		return balance;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount)
	throws InsufficientFundsException;

	public final void transfer(double amount, Account other)
	throws InsufficientFundsException{
		if(this == other)
			throw new IllegalTransferException();
		this.withdraw(amount);
		other.deposit(amount);
	}
}















