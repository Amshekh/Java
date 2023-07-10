import java.sql.*;

class ParamSQLTest{
	
	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@//localhost/xe", 
			"scott", "tiger");
		con.setAutoCommit(false);								// Check point 1.
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
			PreparedStatement pstmt = con.prepareStatement(			// Check point 2.
				"insert into orders values (?,?,?,?,?)");
			pstmt.setInt(1, orderNo);						// Check point 2(i)
			pstmt.setDate(2, today);						// Check point 2(ii)
			pstmt.setString(3, customerId);					// Check point 2(iii)
			pstmt.setInt(4, productNo);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();							// Check point 3.
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			con.rollback();							// Check point 4.
			System.out.printf("Order Failed: %s%n", 
				e.getMessage());
		}
		con.close();
	}
}

/* Comments about this programme :-

We have a parameterised query so we can sefely execute  our programme, we dont have to bother about SQL Injection.
bydefault connection object is in auto-commit mode
When any single update happens so connnection's object automatically fire COMMIT command.
but it can create a big problem
suppose we are updating the data of multiple table in one single transcation and all updation related to each-other
and after one updation connection's object will fire commit command and it may happen second updation may fail so we will get 
trouble here because after commit we can not do rollback so 
we are doing Auto-Commit false here so we will only fire  COMMIT and ROLLBACK command after complete our whole transcation.

POINTS :-
	1. Here we are doing Auto-Commit false, We are saying to connectios's object, please you dont fire commit command I will
	     fire COMMIT or ROLLBACK command explicitly.

	2. This is a parameterised query. so for parameter we pass '?; in the query.
		  i) We are passing integer value for first parameter (means first '?')
		 ii) We are passing Date value for second parameter (means second '?')
		iii) We are passing string value for third parameter (means third '?')

	3. Here we are firing Commit command explicitly.	 All transaction completed successfully so we are firing COMMIT command.
	4. Here we are passing Rollback command explicitly because of some error execution came here. so all transaction will be
	     ROLLBACK.
*/