class ThreadTest1{

	private static int count = 20;

	private static void sayHello(){
		for(int i = 1; i <= count; i++){
			System.out.printf("Hello:%d from thread<%x>%n", 
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}
	}

	private static void sayWelcome(){
		for(int i = count / 2; i > 0; i--){
			System.out.printf("Welcome:%d from thread<%x>%n", 
				i, Thread.currentThread().hashCode());
			Worker.doWork(i);
		}
	}

	public static void main(String[] args){
		Runnable r = new Runnable(){
			public void run(){
				sayHello();
			}
		};
		Thread th = new Thread(r);
		th.start();
		sayWelcome();		
	}
}















