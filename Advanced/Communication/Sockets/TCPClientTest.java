import java.io.*;
import java.net.*;

class TCPClientTest{

	public static void main(String[] args) throws Exception{
		Socket client = new Socket(args[0], 2055);					// check point 1.
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(client.getInputStream()));
		PrintWriter writer = new PrintWriter(
			new OutputStreamWriter(client.getOutputStream()));
		System.out.println(reader.readLine());						// check point 2.
		writer.println(args[1]);							// check point 3.
		writer.flush();								// check point 4.
		System.out.println(reader.readLine());
		writer.close();
		reader.close();
		client.close();
	}
}

/* Comments about this programme :-

POINTS :-
	1. Here we are creating the socket and connecting to given IP-Address(args[0]) on given port number.
	2. Here we are reading text/byte from server's port.
	3. Here we are writing something on server's port.
	4. Here we are calling flush() method , It means dont wait for buffer to get full , When you get data so forward.
*/