package studentmodel;
import java.sql.Connection;
import java.sql.DriverManager;


public class databaseconnection {

	Connection con;
	public Connection databaseconnection() 
	{
try {
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:connect" ,"root","garv@1994");
		} catch (Exception e) {
			System.out.println("constructor : "+e);
		}
	return con;
	}

}
