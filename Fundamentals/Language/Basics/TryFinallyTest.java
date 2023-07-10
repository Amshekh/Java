class TryFinallyTest{

	public static void main(String[] args){
		try{
			run(args[0]);
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e);
		}
		System.out.println("Goodbye!");
	}

	private static void run(String text){
		System.out.println("Opening files.");
		try{
			double value = Double.parseDouble(text);
			System.out.printf("Square of %s is %f%n", text, value * value);
		}finally{
			System.out.println("Closing files.");
		}
	}
}













