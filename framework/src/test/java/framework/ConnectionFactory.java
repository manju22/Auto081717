package framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    public static String Environment = FrameworkLibrary.config.getString("env");
    private static ConnectionFactory instance = new ConnectionFactory();
    private static ConnectionFactory stockInstance = new ConnectionFactory();
    private static ConnectionFactory icPlusInstance = new ConnectionFactory();


    private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

    public static Connection getConnectionICplus() {
        return icPlusInstance.createConnectionICplus();
    }

    public static Connection getConnectionStock() {
        return stockInstance.createConnectionStock();
    }

    public Connection createConnection() {

        Connection connection = null;
        try {

            System.out.println("connecting to" + Environment + "database");
            String url = FrameworkLibrary.config.getString(Environment + "_URL");
            System.out.println("url is" + url);
            String user = FrameworkLibrary.config.getString(Environment + "_USER");
            System.out.println("user is" + user);
            String password = FrameworkLibrary.config.getString(Environment + "_PASSWORD");
            System.out.println("password is" + password);

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public Connection createConnectionStock() {

        Connection connection = null;
        try {

            System.out.println("connecting to" + Environment + "STOCK database");
            String url = FrameworkLibrary.config.getString(Environment + "_STOCK_URL");
            System.out.println("url is " + url);
            String user = FrameworkLibrary.config.getString(Environment + "_STOCK_USER");
            System.out.println("user is " + user);
            String password = FrameworkLibrary.config.getString(Environment + "_STOCK_PASSWORD");
            System.out.println("password is " + password);

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public Connection createConnectionICplus() {

        Connection connection = null;
        try {

            System.out.println("connecting to IC+ database");
            String url = FrameworkLibrary.config.getString("ICPLUS_URL");
            System.out.println("url is " + url);
            String user = FrameworkLibrary.config.getString("ICPLUS_USER");
            System.out.println("user is " + user);
            String password = FrameworkLibrary.config.getString("ICPLUS_PASSWORD");
            System.out.println("password is " + password);

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;

    }
    
public Connection createConnectionBugfix(){
		
		Connection connection = null;
		try {
			
			System.out.println("connecting to  Bugfix database");
			String url = FrameworkLibrary.config.getString("BUGFIX_URL");
			System.out.println("url is "+url);
			String user = FrameworkLibrary.config.getString("BUGFIX_USER");
			System.out.println("user is "+user);
			String password=FrameworkLibrary.config.getString("BUGFIX_PASSWORD");
			System.out.println("password is "+password);
			
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
		
	}
}