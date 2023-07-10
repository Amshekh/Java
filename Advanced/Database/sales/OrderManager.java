package sales;

import java.sql.*;
import javax.jws.*;

@WebService(targetNamespace="http://dac.met.edu/sales")						// Check point 1.
public class OrderManager{
	
	@WebMethod										// Check point 2.
	public int placeOrder(OrderInfo info){								// Check point 3.
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost/xe", 
				"scott", "tiger");
			con.setAutoCommit(false);
			try{
				Statement stmt = con.createStatement();
				stmt.executeUpdate(
					"update ord_ctl set ord_no=ord_no+1");
				ResultSet rs = stmt.executeQuery(
					"select ord_no from ord_ctl");
				rs.next();
				int orderNo = rs.getInt(1);
				rs.close();
				stmt.close();
				Date today = new Date(System.currentTimeMillis());
				PreparedStatement pstmt = con.prepareStatement(
					"insert into orders values (?,?,?,?,?)");
				pstmt.setInt(1, orderNo);
				pstmt.setDate(2, today);
				pstmt.setString(3, info.customerId);
				pstmt.setInt(4, info.productNo);
				pstmt.setInt(5, info.quantity);
				pstmt.executeUpdate();
				pstmt.close();
				con.commit();
				return orderNo;
			}catch(SQLException e){
				con.rollback();
				throw e;
			}finally{
				con.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}

/* Comments about this programme :-

please refer the comments of 'ParamSQLTest.java'

wsgen -cp . sales.OrderManager :-
	This command will create a folder 'jaxws' and inside this folder it will create  PlaceOrder.class and PlaceOrderResponse.class
	because we have declared PlaceOrder as a WebService method inside OrderManager.java

POINTS :-
	1. Here we are using the @WebService annotation means, this class will be known as web-service.
	    We are using namespace attribute which will used in XML file.

	2. Here we are using the @WebMethod annotation means, this is a method of Web-Service which we can call.
	3. This is a place order which is used for place the order. We are taking the object of Order info.
	     That object containing the all information for place order (customerId, productNo, quantity).
*/