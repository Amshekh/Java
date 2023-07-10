package edu.met.dac.sales;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.annotation.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ProductTag extends SimpleTagSupport{
	
	//Context Dependency Injection
	@Resource(name="jdbc/SalesDB")								// Check point 1.
	private DataSource ds;

	private String var;

	public void setVar(String name){								// Check point 2.
		var = name;
	}

	@Override
	public void doTag() throws IOException, JspException{
		JspContext context = super.getJspContext();						// check point 3.
		JspFragment body = super.getJspBody();						// Check point 4.
		try{
			Connection con = ds.getConnection();						// check point 5.
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
					"select pno, price, stock from products");			// Check point 6.
				while(rs.next()){							// Check point 7.
					ProductInfo product = new ProductInfo(rs);			// Check point 8.
					context.setAttribute(var, product);				// Check point 9.
					body.invoke(null);					// Check point 10.
				}
				rs.close();
				stmt.close();
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new JspTagException(e);					// Check point 11.
		}
	}

	public static class ProductInfo{							// Check point 12.
		
		private ResultSet rs;

		public ProductInfo(ResultSet rs){						// Check point 13.
			this.rs = rs;
		}

		public int getProductNo() throws SQLException{					// Check point 14.
			return rs.getInt("pno");
		}

		public double getPrice() throws SQLException{
			return rs.getDouble("price");
		}

		public int getStock() throws SQLException{
			return rs.getInt("stock");
		}
	}
}

/* comments about this programme :-

*** something important ***
	The javax.annotation.Resource annotation is used to declare a reference to a resource.
	
	The name element is the JNDI name of the resource, and is optional for field- and method-based injection. For field-based 
	injection, the default name is the field name qualified by the class name. For method-based injection, the default name is the 
	JavaBeans property name based on the method qualified by the class name. The name element must be specified for 
	class-based injection.

*** How this programme is working ***
	In side doTag we are retriving all(pno, price, stock )from products table, this all data handling by ResultSet's object so we are 
	fetching data one-by-one with rs.next() method, We are fetching the data of particular row so ResultSet's object will handle
	only that row's data and we are crreating the object of ProductInfo(Nested class) and passing that ResultSet's object (this
	object is handling only that particular row's data), and we are storing that object with particular name so we can access
	this object by that name in jspx file. (name var's value) and same work for all rows,

	in ProductInfo we are assigning the this resultSet' object to That class's (ProductInfo) ResultSet object.
	and we are defining getter method of that all colum(which we included in select query) and we are getting value.

POINTS :-
	1. Here we are decalring the reference to resource. It is same as ds = (DataSource) naming.lookup("jdbc/SalesDB");
	    It is called as Field-Based Injection
		To use field-based resource injection, declare a field and decorate it with the @Resource annotation.

	2. We are defining setter method so user can set the value for 'var' is jspx page in this particular tag.
	3. Here we are getting the object of Jsp context.
	4. Here we are getting the object of Jsp Body.
	5. Here we are getting the connection on DataSource object.
	6. Here we are retriving the value from database so we are getting the object of ResultSet.
	7. We are calling the rs.next() method for retriving the data of row one-by-one.
	8. We are creating the object of ProductInfo and we are passing the object of Resultset, this ResultSet's object is handling 
	     particular'row data. (for each row we are creating the seperate object of ProductInfo and passing the object of ReultSet)

	9. We are storing the ProductInfo's object with the name of var(which passed from jspx by client.)
	     so we can access this object in jspx file by that name (var's value) and we can access ProjectInfo object's methods.

	10. We are invoking the body object.
	11. Here we are throwing JspTagException(e);
	12. We are creating the Nested class ProductInfo.
	13. This is a constructor of ProductInfo which taking the object of ResultSet as it's argument and we are assigning  passed
	       ResultSet object to Current(this) ResultSet object. so we can access the method.

	14. We are defining the getter method so we can get the value of particular column
*/