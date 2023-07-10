class ForEachTest{
	
	public static void main(String[] args){
		for(String name : args){
			System.out.printf("Hello %s.%n", name);
		}
		System.out.println("Goodbye!");
	}
}

