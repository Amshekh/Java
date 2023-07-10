class WhileTest{
	
	public static void main(String[] args){
		int i = 0;
		while(i < args.length){
			System.out.printf("Hello %s.%n", args[i++]);
		}
		System.out.println("Goodbye!");
	}
}



