class StringUtilities{
	
	public native static int getHashOf(String text);

	public native static String getReverseOf(String text);

	static{
		System.loadLibrary("strutil");
	}
}

class StringAccessTest{

	public static void main(String[] args) throws Exception{
		System.out.printf("Original string: %s%n", args[0]);
		System.out.printf("Hash of string : %x%n", 
			StringUtilities.getHashOf(args[0]));
		System.out.printf("Reversed string: %s%n", 
			StringUtilities.getReverseOf(args[0]));
	}
}












