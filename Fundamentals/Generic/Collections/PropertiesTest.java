import java.util.*;

class PropertiesTest{
	
	public static void main(String[] args){
		Properties config = System.getProperties();
		if(args.length > 0)
			System.out.printf("Value = %s%n", config.getProperty(args[0]));
		else
			config.list(System.out);
	}
}



