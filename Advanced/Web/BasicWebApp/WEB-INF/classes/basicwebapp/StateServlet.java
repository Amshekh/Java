package basicwebapp;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet({"/state"})										// Check point 1.
public class StateServlet extends HttpServlet{	

	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)
	throws IOException, ServletException{
		String name = request.getParameter("name");
		if(name == null) name = "";
		HttpSession session = request.getSession(true);						// Check point 2.
		Integer m = (Integer) session.getAttribute("count");					// Check point 3
		m = (m == null) ? 1 : m + 1;
		session.setAttribute("count", m);							// Check point 4.
		ServletContext app = super.getServletContext();						// Check point 5.
		Integer n;
		synchronized(app){								// check point 6.
			n = (Integer) app.getAttribute("count");					// Check point 7.
			n = (n == null) ? 1 : n + 1;
			app.setAttribute("count", n);							// Check point 8.
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>Greetings</title></head>");
		writer.println("<body>");
		writer.printf("<h1>Welcome Visitor %s</h1>%n", name);
		writer.printf("<b>Number of request: </b>%d / %d%n",
			m, n);
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}

}

/* Comments about this programme :-

NOTE :- please refer the comments of 'GreetServlet.java'

"This programme is using with welcome.jsp"

@WebServlet :-
	Annotation used to declare a servlet.
	This annotation is processed by the container at deployment time, and the corresponding servlet made available at the 
	specified URL patterns.

POINTS :-
	1. Here we are declaring the servlet and "/state" is nothing but url-pattern
		same as in web.xml <url-pattern>/state</url-pattern>

	2. Here we are getting the session scope. We are passing boolean type parameter that is for -
	    	true :- 	to create a new session for this request if necessary; 
		false :-	 to return null if there's no current session

	3.  Returns the object bound with the specified name in this session, or null if no object is bound under the name.
		It returns the object so we are casting in Interger because we are getting count from session scope.

	4. Binds an object to this session, using the name specified.
	5. Here we are getting the Application scope.
	6. Here we are using synchronized because this is a application scope, that is using by multiple client.
	7. Returns the servlet container attribute with the given name, or null if there is no attribute by that name.
	8. Binds an object to a given attribute name in this servlet context.
*/