class AutoBoxTest2{

	/*
	private static String select(int sign, String first, 
			String second, String third){
		if(sign < 0)
			return first;
		if(sign == 0)
			return second;
		return third;
	}

	private static Interval select(int sign, Interval first, 
			Interval second, Interval third){
		if(sign < 0)
			return first;
		if(sign == 0)
			return second;
		return third;
	}
	*/

	private static Object select(int sign, Object first, 
			Object second, Object third){
		if(sign < 0)
			return first;
		if(sign == 0)
			return second;
		return third;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		//String ss = select(s, "Monday", "Wednesday", "Friday");
		String ss = (String) select(s, "Monday", "Wednesday", "Friday");
		System.out.printf("Selected string = %s%n", ss);
		//Interval si = select(s, new Interval(5, 45), 
		//	new Interval(4, 35), new Interval(2, 25));
		Interval si = (Interval) select(s, new Interval(5, 45), 
			new Interval(4, 35), new Interval(2, 25));
		System.out.printf("Selected interval = %s%n", si);
		double sd = (Double) select(s, 12.34, 23.45, 34.56);
		System.out.printf("Selected double = %s%n", sd);
		long sl = (Long) select(s, 12345L, 23456L, "ABCDEL");
		System.out.printf("Selected long = %s%n", sl);
	}
}














