import java.net.*;

class InetAddrTest{

	public static void main(String[] args){
		try{
			InetAddress addr = args.length > 0
						   ? InetAddress.getByName(args[0])		// check point 1.
						   : InetAddress.getLocalHost();		// check point 2.
			System.out.println(addr);
		}catch(Exception e){
			System.out.println("Cannot resolve host-name!");
		}
	}
}

/* Comments about this programme :-

POINTS :-
	1. This function returns the IP-Address of system by given name.
	2. This function returns the IP-Address of current local system
*/