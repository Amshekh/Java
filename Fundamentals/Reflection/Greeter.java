interface Greeter{

	String meet(String name, int age);

	String leave(String name);
}

class EnglishGreeter implements Greeter{
	
	public String meet(String name, int age){
		if(age < 25)
			return "Hi " + name;
		return "Hello " + name;
	}

	public String leave(String name){
		return "Bye " + name;
	}
}










