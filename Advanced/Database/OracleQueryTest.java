import java.sql.*;
import java.util.*;

class OracleQueryTest{

	public static void main(String[] args) throws Exception{
		Properties login = new Properties();
		login.put("user", "scott");				// username
		login.put("password", "tiger");			// Password
		Driver d = new oracle.jdbc.OracleDriver();		// Orcle driver.
		Connection con = d.connect(
			"jdbc:oracle:thin:@//localhost/xe", login);	// path of database.
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
			"select pno, price, stock from products");
		while(rs.next())
			System.out.printf("%d\t%.2f\t%d%n",
				rs.getInt(1), rs.getDouble(2),
				rs.getInt("stock"));
		rs.close();
		stmt.close();
		con.close();
	}
}

// Refer the comment of 'MySQLQueryTest.java'