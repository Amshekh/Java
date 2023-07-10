class GenericMethodTest2{

	private static<T extends Comparable<T>> T maximum(T first, T second){
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		double md = maximum(3.45, 5.43);
		System.out.printf("Max double = %s%n", md);
		String ms = maximum("Monday", "Friday");
		System.out.printf("Max string = %s%n", ms);
		Interval mi = maximum(new Interval(6, 45), new Interval(9, 15));
		System.out.printf("Max interval = %s%n", mi);
	}
}












