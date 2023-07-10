class GenericMethodTest1{

	private static<T> T select(int sign, T first, 
			T second, T third){
		if(sign < 0)
			return first;
		if(sign == 0)
			return second;
		return third;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = select(s, "Monday", "Wednesday", "Friday");
		System.out.printf("Selected string = %s%n", ss);
		Interval si = select(s, new Interval(5, 45), 
			new Interval(4, 35), new Interval(2, 25));
		System.out.printf("Selected interval = %s%n", si);
		double sd = select(s, 12.34, 23.45, 34.56);
		System.out.printf("Selected double = %s%n", sd);
		long sl = select(s, 12345L, 23456L, 0xABCDEL);
		System.out.printf("Selected long = %s%n", sl);
	}
}














