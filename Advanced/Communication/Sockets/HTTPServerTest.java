import java.io.*;
import java.net.*;
import java.util.*;
import com.sun.net.httpserver.*;

class HTTPServerTest{

	private static String[] symbols = {"DELL", "GOGL", "INTC",
		"MSFT", "ORCL"};
	private static Random rnd = new Random();

	public static void main(String[] args) throws Exception{
		HttpServer server = HttpServer.create(
			new InetSocketAddress(8055), 10);						// check point 1.
		server.createContext("/stock", new StockQuoteHandler());				// check point 2.
		server.start();									// check point 3.
	}

	static class StockQuoteHandler implements HttpHandler{
		
		public void handle(HttpExchange client)
		throws IOException{
			URI uri = client.getRequestURI();						// check point 4.
			String symbol = uri.getQuery();						// Check point 5.
			int i = Arrays.binarySearch(symbols, symbol);
			String response;
			if(i >= 0)
				response = String.format("Price is %.2f%n", 
					(1000 + rnd.nextInt(9000)) / 100.0);
			else
				response = "Price not available!";
			Headers rh = client.getResponseHeaders();					// check point 6.
			rh.set("Content-type", "text/plain");						// check point 7.
			client.sendResponseHeaders(200, 0);						// check point 8.
			OutputStream output = client.getResponseBody();				// check point 9.
			PrintWriter writer = new PrintWriter( 
				new OutputStreamWriter(output));
			writer.println(response);
			writer.close();
		}
	}
}

/* Comments about this programme :-

HttpServer is a Application protocol.

HttpHandler :-
	A handler which is invoked to process HTTP exchanges. Each HTTP exchange is handled by one of these handlers.

createContext :-
	public abstract HttpContext createContext(String path,  HttpHandler handler)
	Creates a HttpContext. A HttpContext represents a mapping from a URI path to a exchange handler on this HttpServer. 
	Once created, all requests received by the server for the path will be handled by calling the given handler object. The context 
	is identified by the path, and can later be removed from the server using this with the removeContext(String) method.

	The path specifies the root URI path for this context. The first character of path must be '/'.

	The class overview describes how incoming request URIs are mapped to HttpContext instances.

	Parameters:
		path - the root URI path to associate the context with
		handler - the handler to invoke for incoming requests.
	
	Throws:
		IllegalArgumentException - if path is invalid, or if a context already exists for this path
		NullPointerException - if either path, or handler are null

HttpExchange :-
	This class encapsulates a HTTP request received and a response to be generated in one exchange.

POINTS :-
	1. Here we are creating the HttpServer and binding on specified port number(8055). and we are passing 10, it means 10 client
	    can wait in the que not more than that.

	2. We are creating the context, we are passing the two parameter.
		 i) First parameter is URI.
		ii) Second parameter is handler.

	3. Starts this server in a new background thread.
	4. Getting the requested URI.
		URI means a part of URL, after partnumber, for example http://localhost:8085/stock/something?MSIL
									             --------------------------
		Here "/stock/something?MSIL" is a URL

	5. Here we are getting the query from URI.
		Query is a part of URI ,after ? mark. in above step MSIL is a query string.

	6. Returns a mutable Map into which the HTTP response headers can be stored and which will be transmitted as part of this 
	     response.
	7. Here we are setting the content-type, (Which type output we are sending.)
	8. Starts sending the response back to the client using the current set of response headers and the numeric response code 
	     as specified in this method.
	9.  returns a stream to which the response body must be written. sendResponseHeaders(int,long)) must be called prior to 
	     calling this method. Multiple calls to this method (for the same exchange) will return the same stream. In order to correctly 
	     terminate each exchange, the output stream must be closed, even if no response body is being sent. 
*/