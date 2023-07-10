import java.io.*;
import java.net.*;

class HTTPClientTest{

	public static void main(String[] args) throws Exception{
		String ref = String.format("http://%s:8055/stock?%s",
			args[0], args[1]);
		URL url = new URL(ref);						// check point 1.
		InputStream input = url.openStream();					// check point 2.
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(input));
		System.out.println(reader.readLine());
		reader.close();
	}
}

/* Comments about this programme :-

POINTS :-
	1. Here we are creating the object of URL by and passing the url so that url will be containing by this object.
	2. Opens a connection to this URL and returns an InputStream for reading from that connection.
*/