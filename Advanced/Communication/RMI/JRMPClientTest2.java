import shopping.*;
import java.rmi.*;
import java.util.*;

class JRMPClientTest2{
	
	public static void main(String[] args) throws Exception{
		CartFactory factory = (CartFactory) Naming.lookup(
			"rmi://fedguest/cart.rem");							//Check point 1.
		Cart mycart = factory.create();							//Check point 2.
		Scanner input = new Scanner(System.in);
		for(int j = 1; ; j++){
			System.out.printf("Item %d: ", j);
			String i = input.next();
			if(i.equals("end")) break;
			System.out.printf("Adding %s to cart...", i);
			if(mycart.addItem(i))
				System.out.println("Done.");
			else
				System.out.println("Failed!");
		}
		System.out.printf("Total payment: %.2f%n", 
			mycart.getPayment());
	}
}

/* Comments about this programme :-

POINTS :-
	1. Here we are getting the stub of Remote object (CartFactory). We are looking up with well-known with pass.
	2. Here we are getting the stub of Remote object (Cart).
*/