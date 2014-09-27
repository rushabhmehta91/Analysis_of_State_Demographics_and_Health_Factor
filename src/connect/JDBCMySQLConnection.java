package connect;


/**
 *
 * @Filename JDBCMySQLConnection.java
 *
 * @Version $Id: NewJFrame.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p/>
 * It is the file that holds the JDBC Connection
 *
 * @author Harsimrat Parmar
 */

public class JDBCMySQLConnection {

    // static reference to itself
    private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
    public static final String URL = "jdbc:mysql://localhost:3306/big_data";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    // private constructor
    private JDBCMySQLConnection() {
        try {
            // Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connection is created
     *
     * @return
     */
    private Connection createConnection() {

        Connection connection = null;
        try {
            // Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    /**
     * Connection is made
     *
     * @return
     */
    public static Connection getConnection() {
        return instance.createConnection();
    }
}