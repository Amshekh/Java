import java.io.*;
import java.net.*;
import java.util.*;

class TCPServerTest1{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rnd = new Random();

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(2055);						// Check point 1.
		service(server);
	}

	private static void service(ServerSocket server)
	throws IOException{
		for(;;){
			Socket client = server.accept();						// Check point 2.
			client.setSoTimeout(15000);							// check point 3.
			InputStream input = client.getInputStream();					// check point 4.
			OutputStream output = client.getOutputStream();				// check point 5.
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(output), true);
			try{
				writer.println("Welcome to stock-server.");
				String symbol = reader.readLine();					// check point 6.
				int i = Arrays.binarySearch(symbols, symbol);
				if(i >= 0)
					writer.printf("Price is %.2f%n", 
						(1000 + rnd.nextInt(9000)) / 100.0);			// check point 7.
				else
					writer.println("Price not available!");
			}catch(Exception e){}
			writer.close();	// closing the all thing.
			reader.close();
			client.close();
		}
	}
}

/* Comments about this programme :-

BufferedReader :- It is used for read the byte.
PrintWriter :- It is used to write the byte on port.

POINTS :-
	1. Here we are creating the server socket, we are doing three step here -
		  i) Creating the socket, ii) Binding the socket, iii) putting in listen mode
	2. Here we are accepting the request and giving it to particular socket for handle this client.
	3. Maximum time limitation
	4. Getting output stream of client, it is used for write the text or byte on client side.
	5. Getting reader of client, it is used for read the text or byte from client side.
	6. Here we are finding the item inside array so we are array's object and item which we want to find
		If item is available so it will return the index of that item else it will rturn negative value.
	7. This function will return the number (rendomly generated) between 0 and 8999.
*/