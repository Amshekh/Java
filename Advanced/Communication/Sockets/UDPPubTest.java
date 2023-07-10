import java.net.*;
import java.util.*;

class UDPPubTest{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rnd = new Random();

	public static void main(String[] args) throws Exception{
		DatagramSocket publisher = new DatagramSocket();					// check point 1.
		InetAddress addr = InetAddress.getByName("230.0.0.1");					// check point 2.
		for(;;){
			int i = rnd.nextInt(symbols.length);
			String text = String.format("%s : %.2f", 
				symbols[i], (1000 + rnd.nextInt(9000)) / 100.0);
			DatagramPacket packet = new DatagramPacket(					// check point 3.
				text.getBytes(), text.length(), addr, 2056);
			publisher.send(packet);							// check point 4.
			Thread.sleep(10000);
		}
	}
}

/* comments about this programme :-

DatagramSocket :-
	A datagram socket is the sending or receiving point for a packet delivery service. Each packet sent or received on a datagram 
	socket is individually addressed and routed. Multiple packets sent from one machine to another may be routed differently, and 
	may arrive in any order. 

DatagramPacket :-
	Datagram packets are used to implement a connectionless packet delivery service. Each message is routed from one machine 
	to another based solely on information contained within that packet. Multiple packets sent from one machine to another might 
	be routed differently, and might arrive in any order. Packet delivery is not guaranteed. 


POINTS :-
	1. Here we are creating the datagram socket which is connection-less.
	2. Here we are getting the IP-Address by given name "230.0.0.1" (It is a D class's Ip-Address) no other computer will have this
	    Ip-Address,  This type IP-Address is used for multicasting.

	3. Here we are creating the data gram packet which containing the data(in byte), size of data, addr, IP-Address (on this addr
	     we are sending the packet), port number of that address.
	4. Sending the packet.
*/