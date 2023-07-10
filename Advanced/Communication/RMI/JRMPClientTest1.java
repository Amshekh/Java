import shopping.*;
import java.rmi.*;
import java.util.*;

class JRMPClientTest1{
	
	public static void main(String[] args) throws Exception{
		PriceManager pm = (PriceManager) Naming.lookup(
			"rmi://fedguest/price.rem");						// Check point 1.
		Scanner input = new Scanner(System.in);						// Check point 2.
		try{
			System.out.print("Item: ");
			String i = input.next();				// Reading the String.
			double p = pm.getUnitPrice(i);			// Calling the method of Remote object.
			System.out.print("Quantity: ");
			int q = input.nextInt();				// Reading the Integer so no need to cast.
			float d = pm.getBulkDiscount(q);			// Calling the method of Remote object.
			System.out.printf("Total payment: %.2f%n",
				p * q * (1 - d / 100));
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e.getMessage());
		}
	}
}

/* Comments about this programme :-

*** Something Important ***
	Initial Boot Strapping is a machanism that allows  Client application to obtain the copy of remote object stub.
	Location Transparency is machanism that allows client application to access a remote object in same manner as it accesses
	the local object(using dot[.] operator), the client access a remote object by invoking a method on it's stub.

	Object Marshalling :-
		It is a machanism that allows object to be passed/returned to/from a method . JRMP supports marshalling for
		following two kinds of object.
		 i) Serializable Object :-
			JRMP will check what type this object is, if it will get this is a serializable type so it will execute on the
			copy (Marshal-By-Value).

		 i) Exported Remote Object :-
			JRMP will check what type this object is, if it will get this is a  Exported Remote object so it will be dispatch
			to the original object (Marshal-By-Reference).

POINTS :-
	1. Here we are getting the reference of the remote object' stub. We are casting here because this method returns the Remote.
		here "pm" is a Remote-stub, Remote object is stateless.

	2. Here we are creating the scanner because we want to read input from Console.
*/