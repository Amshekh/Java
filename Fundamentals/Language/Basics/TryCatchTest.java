class TryCatchTest{

	public static void main(String[] args){
		try{
			run(args[0]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("USAGE: java TryCatchTest value-to-square");
		}catch(NumberFormatException e){
			System.out.println("ERROR: Bad input value");
		}
		System.out.println("Goodbye!");
	}

	private static void run(String text){
		double value = Double.parseDouble(text);
		System.out.printf("Square of %s is %f%n", text, value * value);
	}
}













