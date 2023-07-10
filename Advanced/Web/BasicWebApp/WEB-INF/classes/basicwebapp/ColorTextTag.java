package basicwebapp;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ColorTextTag extends SimpleTagSupport{

	private String[] colors = {"violet", "indigo", "blue", 						// Check point 1.
		"green", "yellow", "orange", "red"};

	public void setColors(String value){								// Check point 2.
		colors = value.split(",");
	}

	@Override
	public void doTag() throws JspException, IOException{
		JspContext context = super.getJspContext();
		JspWriter out = context.getOut();
		JspFragment body = super.getJspBody();						// Check point 3.
		StringWriter writer = new StringWriter();						// Check point 4.
		body.invoke(writer);								// Check point 5.
		StringBuffer buffer = writer.getBuffer();						// Check point 6.
		int i = 0;
		for(int j = 0; j < buffer.length(); j++){
			char ch = buffer.charAt(j);
			if(Character.isWhitespace(ch))						// Check point 7.
				out.print(ch);							// Check point 8.
			else{
				String markup = String.format(
					"<font color='%s'>%c</font>",
					colors[(i++) % colors.length], ch);				// Check point 9.
				out.print(markup);						// Check point 10.
			}
		}
	}
}

/* Comments about this programme :-

NOTE :- Please refer the comments of 'PutTimeTag.java'

POINTS :-
	1. This is a String-Array which containing the color's name.
	2. This is a setter method which allowed the set our own color in color array (Which user will pass from JSP file.)
	3. Here we are getting the object of JspFragment via super.getJspBody() method, so with the help of this object we can get
	     the body(text) which passed in our tag.

	4. We are creating the object of stringWriter.
	5. here we are invoking the 'body' object with 'writer' object.
	6. Here we are getting the text(which passed in our tag) in string buffer object.
	7. Here we are checking, Is given character is Whitespace or not so Character.isWhitespace(ch) method will check and it will
	     true or false, If character is whitespace sos it will true, else it will return false.

	8. Here we are print that character on Jsp page (Browser page)
	9. Here we are setting the format in string object so this format we will print on Jsp page(Browser page).
	10. Here we are print that character on Jsp page (Browser page)
*/