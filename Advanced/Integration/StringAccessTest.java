class StringUtilities{
	
	public native static int hashOf(String text);

	public native static String reverseOf(String text);

	static{
		System.loadLibrary("strutil");
	}
}

class StringAccessTest{

	public static void main(String[] args) throws Exception{
		System.out.printf("Original string: %s%n", args[0]);
		System.out.printf("Hash of string: %X%n", 
			StringUtilities.hashOf(args[0]));
		System.out.printf("Reversed string: %s%n", 
			StringUtilities.reverseOf(args[0]));
	}
}















