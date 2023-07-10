class DoWhileTest{
	
	public static void main(String[] args){
		int i = 0;
		do{
			System.out.printf("Hello %s.%n", args[i++]);
		}while(i < args.length);
		System.out.println("Goodbye!");
	}
}




