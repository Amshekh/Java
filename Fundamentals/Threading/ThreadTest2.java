class ThreadTest2{

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

	static class HelloThread extends Thread{
		
		@Override
		public void run(){
			sayHello();
		}
	}

	public static void main(String[] args){
		HelloThread th = new HelloThread();
		th.setDaemon(true);
		th.start();
		sayWelcome();		
	}
}















