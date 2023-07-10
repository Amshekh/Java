import java.net.*;

class UDPSubTest{

	public static void main(String[] args) throws Exception{
		MulticastSocket subscriber = new MulticastSocket(2056);					// Check point 1.
		InetAddress addr = InetAddress.getByName("230.0.0.1");					// Check point 2.
		subscriber.joinGroup(addr);								// check point 3.
		DatagramPacket packet = new DatagramPacket(						// check point 4.
			new byte[80], 80);
		for(int i = 0; i < 5; i++){
			subscriber.receive(packet);							// check point 5.
			String text = new String(packet.getData(), 
				0, packet.getLength());
			System.out.println(text);
		}
		subscriber.leaveGroup(addr);							// check point 6.
		subscriber.close();					// closing the socket.
	}
}

/* comments about this programme :-

MulticastSocket :-
	The multicast datagram socket class is useful for sending and receiving IP multicast packets. A MulticastSocket is a (UDP) 
	DatagramSocket, with additional capabilities for joining "groups" of other multicast hosts on the internet.

	A multicast group is specified by a class D IP address and by a standard UDP port number. Class D IP addresses are in the 
	range 224.0.0.0 to 239.255.255.255, inclusive. The address 224.0.0.0 is reserved and should not be used. 

POINTS :-
	1. Here we are creating the multicast socket and binding to specified port number.
	2. Getting the IP-Address 
	3. Here we are joining the multicast group, We are saying to router we want that data which came from specified addr.
	4. Here we are creating the packet, so in this packet we will get the data.
	5. Here we are receiving data in packet.
	6. Here we are leaving the multicast group . We are saying to router, we are not interested in data other wise router will 
	    continue send the data.
*/