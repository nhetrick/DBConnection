import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;


public class OracleConnection {
	static Connection connection;
	static String url;
	static String username;
	static String password;
	String driver = "ojdbc5";
	
	
	OracleConnection(String url, String username, String password) throws SQLException {
		this.url = url;
		this.username = username;
		this.password = password;
		connection = null;
	}
	
	public void getDBConnection() throws SQLException{
        OracleDataSource ds;
        ds = new OracleDataSource();
        ds.setURL(url);
        connection = ds.getConnection(username, password);
    }
	
	public static void main(String[] args) throws SQLException {
	//	OracleConnection oracleConnection = new OracleConnection("jdbc:oracle:thin:@machineshop.cfps2jr8efah.us-west-2.rds.amazonaws.com:1521", "MachineShop", "MachineShop");
	//	oracleConnection.getDBConnection();
	       Connection connection = null;
	        try {
	            // Load the JDBC driver
	            String driverName = "oracle.jdbc.driver.OracleDriver";
	            Class.forName(driverName);

	            // Create a connection to the database
	            String serverName = "machineshop.cfps2jr8efah.us-west-2.rds.amazonaws.com";
	            String portNumber = "1521";
	            String sid = "xe";
	            String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	            String username = "MachineShop";
	            String password = "MachineShop";
	         //   connection = DriverManager.getConnection(url, username, password); 
	            connection = java.sql.DriverManager.getConnection(
	            		"jdbc:oracle:thin:MachineShop/MachineShop@"+serverName+":"+portNumber+":dbSID");
	            System.out.println("Success");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class Not Found Error");
	        } 
	    
		
	}

}
