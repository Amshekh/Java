import java.io.*;
import java.sql.*;
import java.util.*;

class QueryTest{

	public static void main(String[] args) throws Exception{
		Properties config = new Properties();							// Check point 1.
		FileInputStream input =
			new FileInputStream("jdbc.properties");					// Check point 2.
		config.load(input);									// Check point 3.
		input.close();					// Closing the object of file.
		Class.forName(config.getProperty("driver.class"));					// Check point 4.
		Connection con = DriverManager.getConnection(
			config.getProperty("driver.url"),
			config.getProperty("user.name"),
			config.getProperty("user.password"));						// Check point 5.
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

/* Comments about this programme :-

plaese refer the comments of 'MySQLQueryTest.java'

We wrote a properties file, that file containing the Driver.class, Driver.url, username, password,
so we can change after word, no need to recompile programme. This programme will be working with many type of Database.
(MySQL, Oracle, etc...)

DriverManager :-
	If we load any Driver class by Class.forName so DriverManager register that class with itself by itself.
	so we can create connection by DriverManager
	Simply we can say that Driver class is attached with DriverManager.

POINTS :-
	1. Creating the object of Properties file.
	2. we are getting the object of that file (jdbc.properties).
	3. Here we are loading the filr with our properties extension.
	4. we are creating the object  of Driver class (it is Oracle or MySQL). We are loading the class
	5. Here we are creating the connection. We are getting the username, password, diver-url etc.. from properties file.
*/