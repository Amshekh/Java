import shopping.*;
import javax.naming.*;

class IIOPServerTest{
	
	public static void main(String[] args) throws Exception{
		Context naming = new InitialContext();					// Check point 1.
		CartFactoryPortableImpl servant =
			new CartFactoryPortableImpl();
		naming.rebind("cart.rem", servant);						// Check point 2.
	}
}

/* comments about this programme :-

InitialContext :-
	This class is the starting context for performing naming operations. 
	All naming operations are relative to a context. The initial context implements the Context interface and provides the starting 
	point for resolution of names. 

Common Object Services :-
	The Common Object Services (COS) Name Server is the name server for storing Common Object Request Broker Architecture 
	(CORBA) object references. It can be accessed from CORBA applications by using the COS Naming package 
	(org.omg.CORBA.CosNaming).
	
POINTS :-
	1. We are creating the object of InitialContext because we have to register our stub in COS naming service.
	2. Bind the object by well-known name.
*/