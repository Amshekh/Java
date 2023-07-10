package basicwebapp;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class PutTimeTag extends SimpleTagSupport{
	
	private SimpleDateFormat formatter = 
		new SimpleDateFormat("HH:mm:ss");							// Check point 1.

	public void setFormat(String pattern){				// Check point 8.
		formatter.applyPattern(pattern);
	}

	@Override
	public void doTag() throws JspException, IOException{						// Check point 2.
		JspContext context = super.getJspContext();						// Check point 3.
		JspWriter out = context.getOut();							// Check point 4.
		Date now = new Date();								// Check point 5.
		out.print(formatter.format(now));							// Check point 6.
		context.setAttribute("ticks", System.currentTimeMillis());					// Check poiny 7.
	}
}

/* Comments about this programme :-

NOTE :-	This programme is for Custome Tag, This will used with '.tld' file
	Here '.tld' file is 'basic.tld'

For make the custome tag so that TagClass must be extend javax.servlet.jsp.tagext.TagSupport class.

SimpleTagSupport :-
	The SimpleTagSupport class is a utility class intended to be used as the base class for new simple tag handlers. 
	The SimpleTagSupport class implements the SimpleTag interface and adds additional convenience methods including getter 
	methods for the properties in SimpleTag.

JspContext :-
	JspContext serves as the base class for the PageContext class and abstracts all information that is not specific to servlets. 
	This allows for Simple Tag Extensions to be used outside of the context of a request/response Servlet.

JspWriter :-
	JspWriter is for response the output to JSP Page.
	It means, it allows us to write something on jsp page

POINTS :-
	1. SimpleDateFormat allows you to start by choosing any user-defined patterns for date-time formatting. 
	2. Default Processing method for tag. When tag will be defined so this method will be get called.
	3. Here we are getting the object of JspContext (means  JspPage)
	4. Here we are getting the object of JspWriter which will allowed us to write on Jsp Page.
	5. Here we are getting  the current time of this system.
	6. We are printing this time (in given format) on jsp page.
	7. Register the name and value specified with page scope semantics.
		We will set the value in 'ticks' so we can get in jsp page.

	8. We are writing the setFormat() method, because we have a format attribute in tag so when we are set the value of format
	    so this method setFormat() will get called.
*/