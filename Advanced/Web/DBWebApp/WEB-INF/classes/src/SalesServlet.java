package edu.met.dac.sales;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet({"/home", "/login", "/order", "/logout"})
public class SalesServlet extends HttpServlet{

	private String processGetHome(HttpServletRequest request){				// Check point 1.
		return "/products.jspx";
	}

	private String processGetLogin(HttpServletRequest request){				// Check point 2.
		return "/customer.jspx";
	}
	
	private String processPostLogin(HttpServletRequest request){				// Check point 3.
		HttpSession session = request.getSession(true);					// Check point 4.
		CustomerBean cb = new CustomerBean();					// Check point 5.
		session.setAttribute("login", cb);						// Check point 6.
		String customerId = request.getParameter("customerId");				// Check point 7.
		String password = request.getParameter("password");				// Check point 8.
		if(cb.authorize(customerId, password))					// check point 9.
			return "/order.jspx";
		request.setAttribute("failed", true);						
		return "/customer.jspx";							
	}
	
	private String processPostOrder(HttpServletRequest request){				// Check point 10.
		HttpSession session = request.getSession(true);
		CustomerBean cb = (CustomerBean) session.getAttribute(				// Check point 11.
			"login");
		if(cb == null || cb.isUnauthorized()) 						// Check point 12.
			return "/customer.jspx";
		int productNo = Integer.parseInt(						// Check point 13.
			request.getParameter("productNo"));
		int quantity = Integer.parseInt(
			request.getParameter("quantity"));
		int orderNo = cb.placeOrder(productNo, quantity);				// Check point 14.
		request.setAttribute("orderNo", orderNo);					// Check point 15.
		return "/order.jspx";							// Check point 16.
	}
	
	private String processGetLogout(HttpServletRequest request){				// Check point 17.
		HttpSession session = request.getSession(false);				// Check point 18.
		if(session != null)
			session.invalidate();						// Check point 19.
		return "/products.jspx";							
	}

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
	throws ServletException, IOException{
		String action = request.getServletPath();					// Check point 20.
		String view = null;
		if(action.equals("/home"))							// Check point 21.
			view = processGetHome(request);
		else if(action.equals("/login"))
			view = processGetLogin(request);
		else if(action.equals("/logout"))
			view = processGetLogout(request);
		if(view != null){
			RequestDispatcher rd = request.getRequestDispatcher(			// Check point 22.
				view);
			rd.forward(request, response);					// Check point 23.
		}else{
			response.sendError(405, action);					// Check point 24.
		}
	}

	public void doPost(HttpServletRequest request, 
		HttpServletResponse response)
	throws ServletException, IOException{
		String action = request.getServletPath();
		String view = null;
		if(action.equals("/login"))
			view = processPostLogin(request);
		else if(action.equals("/order"))
			view = processPostOrder(request);
		if(view != null){
			RequestDispatcher rd = request.getRequestDispatcher(
				view);
			rd.forward(request, response);
		}else{
			response.sendError(405, action);
		}
	}
}

//***********************************************************************************************************

/* Comments about this programme :-

*** Something Important ***

POINTS :-
	1. This function is returning the name (path of home page) so home page will be displayed.
	2. This function is returning the name (path of login page) so login page will be displayed if request is submitted by getmethod.
	3. This function is returning the path of nect page which page should be displayed, If customerId and Password is authorized so
	    so display "order" page or if failed so return "Customer page" In this case request is submiting by Post method.
	4. Here we are getting session object, and we are passing true, It means if available so pass that otherwise create a new.
	5. Here we are creating the object of CustomerBean for access the method of that class (Component).
	6. Here we are storing the object of CustomerBean in session as a attribute so we can use in further step.
	7. Here we are getting the customerId from Parameter
	8. Here we are getting the password from Parameter
	9. Here we are calling the authorize method of customerBean for checking, whether login is valid or not.
		If login is valid so we are returning the path of "order.jspx" page.
		other wise we are setting Attribute in request "failed" is true and returning the /customer.jspx
	10. this method for post order get order number and return order.jspx for new order.
	11. Here we are getting the object of CustomerBean from session attribute.
	12. Here we are checking whether is object is null or unauthorized so returning "customer.jspx"
	13. We are getting the value from parameter (productNo and Quantity).
	14. Here we are placing the order by passing (productNo, Quantity) and getting order number.
	15. We are storing orderNo as a attribute in request scope.
	16. returning the  "/order.jspx" for place another order.
	17. This method is using for getLogout.
	18. Here we are getting the session on request object so we are calling request.getSession(false)
		We are passing false it means, if session is existing so give me otherwise return null.
	19. If we are getting the session, It means session is existing so we are calling the function session.invalidate(), this function
	       will help us to invalid the session.
	20. Here we are getting the server path ("/home", "/login", "/order", "/logout") and storing in string variable (action).
	21. Here we are checking string, what path client requested (for which page client made request).
	22. Here we are creating the object of RequestDispatcher and pasing that view
		view is a name of jsp-file, which we are going to display.

	23. Here we are fardwarding the request to that page. and passing the object of 
		HttpServletRequest request, HttpServletResponse response.

	24. Here we are sending the Error page by passing the error number and path name.
		(Error  is "ERROR 405 : Cannot fount action")
*/