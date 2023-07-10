class ThreadRaceTest{

	static class JointAccount{
		
		private int id;
		private int balance;
		private static int nid = 1000;
	
		public JointAccount(int amount){
			id = ++nid;
			balance = amount;
		}

		public int getId(){
			return id;
		}

		public int getBalance(){
			return balance;
		}
		
		public void deposit(int amount){
			Worker.doWork(amount / 100);
			balance += amount;
		}

		public boolean withdraw(int amount){
			boolean result = false;
			if(balance >= amount){
				Worker.doWork(amount / 100);
				balance -= amount;
				result = true;
			}
			return result;
		}
	}

	public static void main(String[] args) throws Exception{
		final JointAccount acc = new JointAccount(10000);
		System.out.printf("Joint-Account with ID %d opened for "
			+ "Jack and Jill.%n", acc.getId());
		System.out.printf("Initial balance: %d%n", acc.getBalance());
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("Jack withdraws 7000...");
				if(acc.withdraw(7000) == false)
					System.out.println("Jack's withdraw operation failed!");
			}
		};
		Thread th = new Thread(r);
		th.start();
		System.out.println("Jill withdraws 8000...");
		if(acc.withdraw(8000) == false)
			System.out.println("Jill's withdraw operation failed!");
		th.join();
		System.out.printf("Final balance: %d%n", acc.getBalance());
	}
}















