import shopping.*;
import java.rmi.*;

class JRMPServerTest1{
	
	public static void main(String[] args) throws Exception{
		PriceManagerImpl servant = new PriceManagerImpl();				// check point 1.
		Naming.rebind("price.rem", servant);						// check point 2.
	}
}

/* Comments about this programme :-
from java5.1  it dynamically support  for stub.
JRMP create a seperate socket for each client.

POINTS :-
	1. Here we are creating the remote object.
	2. here we are binding the remote object.  
		Here we are registers remote object's stub by this name (price.rem) in RMI-Registry.
*/