/*
class PrintItem{
	
	private static String text;
	
	public static void setText(String value){
		text = value;
	}

	public static String getText(){
		return text;
	}
}
*/

class PrintItem{
	
	private static ThreadLocal<String> text = new ThreadLocal<String>();
	
	public static void setText(String value){
		text.set(value);
	}

	public static String getText(){
		return text.get();
	}
}

class Printer{

	public static void print(int copies){
		for(int i = 1; i <= copies; i++){
			System.out.printf("%d:%s for thread<%x>%n", 
				i, PrintItem.getText(), Thread.currentThread().hashCode());
			Worker.doWork(10 * i);
		}
	}
}

class ThreadLocalTest{

	public static void main(String[] args) throws Exception{
		Runnable r = new Runnable(){
			public void run(){
				PrintItem.setText("Today is thursday.");
				Printer.print(10);
			}
		};
		Thread th = new Thread(r);
		th.start();
		PrintItem.setText("Tomorrow is friday.");
		Printer.print(10);
	}
}












