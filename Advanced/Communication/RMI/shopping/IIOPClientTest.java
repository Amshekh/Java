import shopping.*;
import java.util.*;
import javax.rmi.*;
import javax.naming.*;

class IIOPClientTest{
	
	public static void main(String[] args) throws Exception{
		Context naming = new InitialContext();
		Object ref = naming.lookup("cart.rem");						// Check point 1.
		CartFactory factory = (CartFactory) 
			PortableRemoteObject.narrow(ref, CartFactory.class);				// Check point 2.
		Cart mycart = factory.create();
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

Here we are calling PortableRemoteObject.narrow(ref, CartFactory.class) and we are passing-
	 i) reference of romete stub.
	ii) We are passing the Interface (which implemented by that stub) so
	we are saying , I want this type's stub 

POINTS :-
	1. We are looking for the remote stub. we are getting reference of that stub.
	2. Here we are calling the PortableRemoteObject.narrow() so it will return the remort-stub. So here we will get the 
	    CartFactory's stub.
*/