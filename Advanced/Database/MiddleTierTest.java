import sales.*;
import javax.xml.ws.*;

class MiddleTierTest{
	
	public static void main(String[] args) throws Exception{
		OrderManager service = new OrderManager();			// Check point 1.
		Endpoint.publish("http://0.0.0.0:8056/orderManager",
			service);						// Check point 2.
	}
}

/* Comments about this programme :-

What is JAX-WS ?
	Java API for XML Web Services (JAX-WS) is one of a set of Java technologies used to develop Web services. 
	JAX-WS belongs to what Sun Microsystems calls the "core Web services" group. 

What is the use of  wsimport :-
	The wsimport command-line tool supports the top-down approach to developing JAX-WS Web services. When you start with 
	an existing WSDL file, use the wsimport command-line tool to generate the required JAX-WS portable artifacts.

POINTS :-
	1. Creating the object of Service.
	2. Here we are publishing the service on particular Ip-Address.
		The necessary server infrastructure will be created and configured by the JAX-WS implementation using some 
		default configuration.
*/