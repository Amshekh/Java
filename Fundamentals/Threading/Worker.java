class Worker{

	public static void doWork(int count){
		long t = System.currentTimeMillis() + count;
		while(System.currentTimeMillis() < t);
	}
}


