import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

class ThreadPoolTest{

	static class PrintJob implements Runnable{
		
		private String text;
		private static AtomicInteger count = new AtomicInteger();
		
		public PrintJob(String value){
			text = value;
		}
	
		public void run(){
			for(int i = 1; i <= 10; i++){
				System.out.printf("%d:%s for thread<%x>%n", 
					count.incrementAndGet(), text, 
					Thread.currentThread().hashCode());
				Worker.doWork(10 * i);
			}
		}
	}	

	public static void main(String[] args) throws Exception{
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.submit(new PrintJob("Monday"));
		pool.submit(new PrintJob("Tuesday"));
		pool.shutdown();
	}
}











