import java.sql.*;

class StoredProcTest{
	
	public static void main(String[] args) throws Exception{
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@//localhost/xe", 
			"scott", "tiger");
		try{
			CallableStatement cstmt = con.prepareCall(				// Check point 1.
				"{call PLACE_ORDER(?, ?, ?, ?)}");
			cstmt.setString(1, customerId);					// Check point 1(i).
			cstmt.setInt(2, productNo);
			cstmt.setInt(3, quantity);
			cstmt.registerOutParameter(4, Types.INTEGER);				// Check point 1(ii).
			cstmt.execute();							// Check point 2.
			int orderNo = cstmt.getInt(4);					// Check point 3.
			cstmt.close();
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			System.out.printf("Order Failed: %s%n", 
				e.getMessage());
		}
		con.close();
	}
}

/* 
Please refers the comments of 'QueryTest.java'

CallableStatement :-
	The interface used to execute SQL stored procedures. The JDBC API provides a stored procedure SQL escape syntax that 
	allows stored procedures to be called in a standard way for all RDBMSs. This escape syntax has one form that includes a result 
	parameter and one that does not. If used, the result parameter must be registered as an OUT parameter. The other parameters
	can be used for input, output or both. Parameters are referred to sequentially, by number, with the first parameter being 1.

	super interface of this interface are PreparedStatement, Statement, Wrapper 

POINTS :-
	1. Creates a CallableStatement object for calling database stored procedures.
		 i) We are passing the value for first parameter of StoredProcedure (PLACE_ORDER).
		ii) Registers the OUT parameter in ordinal position parameterIndex to the JDBC type sqlType.
		     We are registering the parameter which will give the output so we are passing two thing
			First is parameter index (4). and
			Second is Which type it will return.

	2. Here we are executing SQL Statement. This is method of PreparedStatement.
	3. Here we are getting the value from output parameter after executed that stored procedure.
*/