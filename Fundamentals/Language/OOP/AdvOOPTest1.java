import edu.met.adsd.banking.*;

class AdvOOPTest1{
	
	public static void main(String[] args){
		Account jack = Banker.openAccount(20000, false);
		Account jill = Banker.openAccount(15000, true);
		try{
			double amt = Double.parseDouble(args[0]);
			jill.transfer(amt, jack);
		}catch(InsufficientFundsException e){
			System.out.println("Transfer failed!");
		}catch(Exception e){
			System.out.println("ERROR: " + e);
		}
		System.out.printf("Jack's Account ID is %s and Balance is %.2f%n",
			jack.getId(), jack.getBalance());
		System.out.printf("Jill's Account ID is %s and Balance is %.2f%n",
			jill.getId(), jill.getBalance());
	}
}



