class AutoBoxTest1{
	
	public static void main(String[] args){
		double a = 12.5;
		Object b = a; //Double.valueOf(a)
		double c = (Double) b; //((Double) b).doubleValue()
		System.out.printf("a = %s, b = %s, c = %s%n", a, b, c);
	}
}




