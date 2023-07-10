import java.io.*;
import java.net.*;
import java.util.*;

class TCPServerTest2{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rnd = new Random();

	public static void main(String[] args) throws Exception{
		final ServerSocket server = new ServerSocket(2055);
		Runnable r = new Runnable(){
			public void run(){
				try{
					service(server);
				}catch(IOException e){}
			}
		};
		for(int i = 0; i < 3; i++){
			Thread th = new Thread(r);
			th.start();
		}
	}

	private static void service(ServerSocket server)
	throws IOException{
		for(;;){
			Socket client = server.accept();
			client.setSoTimeout(45000);
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(output), true);
			try{
				writer.println("Welcome to stock-server.");
				String symbol = reader.readLine();
				int i = Arrays.binarySearch(symbols, symbol);
				if(i >= 0)
					writer.printf("Price is %.2f%n", 
						(1000 + rnd.nextInt(9000)) / 100.0);
				else
					writer.println("Price not available!");
			}catch(Exception e){}
			writer.close();
			reader.close();
			client.close();
		}
	}
}

/* 
In this programme we are using thread so we can access multiple client at a time (concurrently).
*/