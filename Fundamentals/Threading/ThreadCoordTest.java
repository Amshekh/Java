class ThreadCoordTest{

	private static volatile int value = -1;
	private static Object cond = new Object();
	
	private static void produce(){
		for(int i = 10; i >= 0; i--){
			Worker.doWork(100 * i + 10);
			synchronized(cond){
				value = i;
				cond.notify();
			}
		}
	}

	private static void consume() throws InterruptedException{
		do{
			synchronized(cond){
				cond.wait();
			}
			System.out.printf("Processed value = %d%n", value * value);
		}while(value != 0);
	}

	public static void main(String[] args) throws Exception{
		Runnable r = new Runnable(){
			public void run(){
				produce();
			}
		};
		Thread th = new Thread(r);
		th.start();
		consume();
	}
}













