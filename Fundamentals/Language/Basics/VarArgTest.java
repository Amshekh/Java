class VarArgTest{

	private static double average(double first, double second){
		return (first + second) / 2;
	}

	private static double average(double first, double second, double third){
		return (first + second + third) / 3;
	}

	private static double average(double first, double second, 
			double... remaining){
		double total = first + second;
		for(double value : remaining)
			total += value;
		return total / (2 + remaining.length);
	}

	public static void main(String[] args){
		System.out.printf("Average of two values = %f%n", 
			average(4.35, 5.49));
		System.out.printf("Average of three values = %f%n", 
			average(4.35, 5.49, 3.84));
		System.out.printf("Average of five values = %f%n", 
			average(4.35, 5.49, 3.84, 7.61, 6.53));
	}
}









