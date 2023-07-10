import java.sql.*;
import java.util.*;

class MySQLQueryTest{

	public static void main(String[] args) throws Exception{
		Properties login = new Properties();							// Check point 1.
		login.put("user", "root");								// Check point 2.
		Driver d = new com.mysql.jdbc.Driver();						// Check point 3.
		Connection con = d.connect(
			"jdbc:mysql://localhost/sales", login);						// Check point 4.
		Statement stmt = con.createStatement();						// Check point 5.
		ResultSet rs = stmt.executeQuery(
			"select pno, price, stock from products");					// Check point 6.
		while(rs.next())									// Check point 7.
			System.out.printf("%d\t%.2f\t%d%n",
				rs.getInt(1), rs.getDouble(2),
				rs.getInt("stock"));
		rs.close();
		stmt.close();
		con.close();
	}
}

/* Commenta about this programme :-

executeQuery() :-
	It is used, when our query is for selecting the data (select).

executeUpdate() :-
	It is used, when our query is updating the data (insert, update, delete).

POINTS :-
	1. Here we are creating the object of properties for passing the username of password.
	2. Here we are passing the user name. ("root is a username").
		NOTE :- MySQL do not want password.
	3. Here we are creating the object of mysql driver.
	4. Here we are connecting to database (by passing path of database and properties object)
	5. Creates a Statement object for sending SQL statements to the database. 
	6. We are executing query (we are passing the Query)
	7. Here we are fatching the data one-by-one
*/