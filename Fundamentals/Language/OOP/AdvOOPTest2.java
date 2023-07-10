import edu.met.adsd.banking.*;

class AdvOOPTest2{

	private static void deductTax(Account[] accounts){
		for(Account acc : accounts){
			double e = acc.getBalance() - 20000;
			if(e > 0){
				try{
					acc.withdraw(0.05 * e);
				}catch(InsufficientFundsException ex){}
			}
		}
	}

	private static void payAnnualInterest(Account[] accounts){
		for(Account acc : accounts){
			if(acc instanceof Profitable){
				Profitable p = (Profitable) acc;
				p.addInterest(1);
			}
		}
	}
	
	public static void main(String[] args){
		Account[] bank = new Account[4];
		bank[0] = Banker.openAccount(15000, false);
		bank[1] = Banker.openAccount(20000, true);
		bank[2] = Banker.openAccount(30000, true);
		bank[3] = Banker.openAccount(45000, false);
		//deductTax(bank);
		payAnnualInterest(bank);
		for(Account acc : bank)
			System.out.printf("%s\t%.2f%n", acc.getId(), acc.getBalance());
	}
}



