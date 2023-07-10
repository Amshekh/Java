class ArrayUtilities{

	public native static double sumOf(double[] values);
	
	public native static void squareAll(double[] values);

	static{
		System.loadLibrary("arrutil");
	}
}

class ArrayAccessTest{

	public static void main(String[] args) throws Exception{
		double[] values = new double[args.length];
		for(int i = 0; i < args.length; i++)
			values[i] = Double.parseDouble(args[i]);
		System.out.printf("Sum of values: %s%n", 
			ArrayUtilities.sumOf(values));
		ArrayUtilities.squareAll(values);
		System.out.printf("Sum of squares: %s%n", 
			ArrayUtilities.sumOf(values));
	}
}









