import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBInteraction
{
	public DBInteraction(String dbName)
	{
		try 
		{
			Connection connector = DriverManager.getConnection("jbdc:mysql://localhost:"/*TODO setup/find correct path to db*/, "root", "");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
	}
}
