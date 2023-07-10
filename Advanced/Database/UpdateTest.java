import java.sql.*;

class UpdateTest{
	
	public static void main(String[] args) throws Exception{
		String sql = "update products set stock=stock+5";
		if(args.length > 0)
			sql += " where pno=" + Integer.parseInt(args[0]);				// Check point 1.
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@//localhost/xe", 
			"scott", "tiger");
		Statement stmt = con.createStatement();
		int n = stmt.executeUpdate(sql);							// Check point 2.
		System.out.printf("Number of updated products: %d%n", n);
		stmt.close();
		con.close();
	}
}

/* Comments about this programme :-
	In this programme we are updating the record of table.

POINTS :-
	1. Here we are converting in Interger, because user can pass the other untrusted query also so it can create a big problem
	     It calls SQL Enjection.

	2. Here we are calling the executeStatement() because we are  updating the record of table.
	    NOTE :- This method is only used when  query is for insert, update or delete.
*/