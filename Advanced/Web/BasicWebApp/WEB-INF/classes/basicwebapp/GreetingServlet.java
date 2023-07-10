package basicwebapp;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GreetingServlet extends HttpServlet{
	
	private String greet;
	
	@Override
	public void init(ServletConfig cfg)							// Check point 1.
	throws ServletException{
		super.init(cfg);
		greet = cfg.getInitParameter("greet");						// Check point 2.
		if(greet == null)
			greet = "Greetings";
	}

	@Override
	public void doGet(HttpServletRequest request, 						// Check point 3.
			HttpServletResponse response)
	throws IOException, ServletException{
		String name = request.getParameter("name");					// Check point 4.
		if(name == null) name = "";
		response.setContentType("text/html");					// Check point 5.
		PrintWriter writer = response.getWriter();					// Check point 6.
		writer.println("<html>");							// Check point 7.
		writer.println("<head><title>Greetings</title></head>");
		writer.println("<body>");
		writer.printf("<h1>%s Visitor %s</h1>%n", greet, name);
		writer.printf("<b>Time on server: </b>%s%n", new Date());
		writer.println("</body>");
		writer.println("</html>");
		writer.close();							// Closing the writer object
	}

}

/* Comments about this programme :-

public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	Once the servlet starts getting the requests, the service() method is called by the servlet container to respond.
	so it will call doGet() or doPost method implicitly, by checking howz request has submitted.

POINTS :-
	1. This method is called implicitly only once, whenever servlet is loaded in memory.  
	     By this init() method the servlet get to know that it has been placed into service.

	2.  When page will load so this servlet will be execute so it will get the value of InitParameter("greet").
		We will put in URL  e.g.        *******?greet=Hello

	3. Request will be submitting by Get method so doGet() method will be called by service() method by wservlet container for
	     giving the response.

	4. Here we are getting the value of parameter of URL (name=Abhay).
	5. Here we are setting the Content type, which type output we are responding.
	6. Here we are getting the writter object for give response.
	7. Here we are sending dynamic HTML page to client-browser.
*/