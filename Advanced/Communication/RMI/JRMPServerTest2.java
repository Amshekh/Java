import shopping.*;
import java.rmi.*;

class JRMPServerTest2{
	
	public static void main(String[] args) throws Exception{
		CartFactoryImpl servant = new CartFactoryImpl();
		Naming.rebind("cart.rem", servant);
	}
}

/* 
Here we are creating the object of CartFactoryImpl and we are binding, registering it's stub in RMI-Registry by well-known name
so client will be looking up for this stub by given well-known name.

JRMP create a seperate socket for each client.
*/
