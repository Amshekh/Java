package edu.met.dac.sales;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class CustomerBean implements java.io.Serializable{
	
	private DataSource ds;
	private String customerId;

	public CustomerBean(){
		try{
			Context naming = new InitialContext();					// Check point 1.
			ds = (DataSource) naming.lookup("jdbc/SalesDB");				// Check point 2.
		}catch(NamingException e){	
			throw new RuntimeException(e);						// check point 3.
		}
	}

	public String getCustomerId(){								// Check point 4.
		return customerId;
	}

	public boolean isUnauthorized(){								// Check point 5.
		return customerId == null;
	}

	public boolean authorize(String customerId, String password){					// Check point 6.
		try{
			Connection con = ds.getConnection();						// Check point 7.
			try{
				PreparedStatement pstmt = con.prepareStatement(			// Check point 8.
					"select count(cust_id) from customers "
					+ "where cust_id=? and pwd=?");
				pstmt.setString(1, customerId);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				int count = rs.getInt(1);
				rs.close();
				pstmt.close();
				this.customerId = count == 1 ? customerId : null;				// Check point 9.
				return count == 1;						// Check point 10.
			}finally{
				con.close();						// Check point 11.
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public int placeOrder(int productNo, int quantity){					// Check point 12.
		try{
			Connection con = ds.getConnection();
			con.setAutoCommit(false);						// Check point 13.
			try{
				Statement stmt = con.createStatement();			// Check point 14.
				stmt.executeUpdate(
					"update ord_ctl set ord_no=ord_no+1");		// Check point 15.
				ResultSet rs = stmt.executeQuery(
					"select ord_no from ord_ctl");			// Check point 16.
				rs.next();							// Check point 17.
				int orderNo = rs.getInt(1);
				rs.close();
				stmt.close();
				Date today = new Date(System.currentTimeMillis());
				PreparedStatement pstmt = con.prepareStatement(
					"insert into orders values (?,?,?,?,?)");
				pstmt.setInt(1, orderNo);
				pstmt.setDate(2, today);
				pstmt.setString(3, customerId);
				pstmt.setInt(4, productNo);
				pstmt.setInt(5, quantity);
				pstmt.executeUpdate();
				pstmt.close();
				con.commit();						// Check point 18.
				return orderNo;
			}catch(SQLException e){
				con.rollback();						// Check point 19.
				throw e;
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);					// Check point 20.
		}
	}
}


/* Comments about this programme :-

This is a Java-Bean component.

Requirnments for Bean :-
	that class (Bean class) should be serialized.
	Class must support zero-parameter constructor.
	It must expose properties using method which follow standard get/set naming convention.

InitialContext :-
	This class is the starting context for performing naming operations.
	All naming operations are relative to a context. The initial context implements the Context interface and provides the starting 
	point for resolution of names.

POINTS :-
	1. Here we are getting the object for performing naming operations.
	2. Here we are looking for DataSource, which is binded or created in connectionPool.
	3. This can throw error, so we are handling the exception and throwing the RuntimeException.
	4. Here we are defining the method for get customer Id.
	5. Here we are checking 'Is given customer Id is Unauthorised', It will return true or false.
	6. Here we are defining the method for authorize 'Is customerId and Password valid or not'.
	7. Here we are getting the connection on DataSource (Which we got from naming.lookup(jdbc/SalesDB))
	8. We are firing query, which will check 'CustomerId and password is valid or not.'
	9. Here we are assigning the customerId. (If count is 1 so User is valid user so customer id is valid otherwise assigning null)
	10. Here we are returning 'true or false' if customerId and Password is valid so returnning true otherwise returning false.
	11. We are closing the connection  in finally block, because in try block error may happen so finally block always execute.
	12. Here we are defining the function for placeOrder.
	13. We are doing automatic commit false, means compiler will not fire the commit query, we will fire commit or rollback query.
	14. We are creating the statement object for play with Data of Database.
	15. Here we are updating the value of particular colum in table
		NOTE :-	"ord_ctl"  is a table which has a "ord_no" colum, this colum has stored last orderNumber as it's value so 
			we can increment our orderNumber easily.
		
			"Here we are not firing Commit command and compiler also will not fire commit command because we said
			  con.setAutoCommit(false);"

			Why are we not firing commit command because our Order may get failed so value of the "ord_no" must
			not be increment, that's why  in catch block we are firing "ROLLBACK" command. 

			executeUpdate() :- Its for insert, updtae, delete

	16. We are retriving the value from database. executeQuery() for select.
	17. rs.next(); If we are retriving the data from database so executeQuery() an dthis method always return ResultSet so
	      retrive the data via ResultSet object so for every row we have to call rs.next() method.

	18. After done everything we are firing commit command.
	19. If any error happens so compilation will come is catch block so we are firing "Rollback" command.
	20. We are throwing RuntimeException.
*/