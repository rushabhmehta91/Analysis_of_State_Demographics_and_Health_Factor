/**
 *
 */
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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * <p/>
 * It is the file that holds the JDBC Connection
 *
 * @author Harsimrat Parmar
 */
public class JDBCMySQLMain {

    // Constructor
    public JDBCMySQLMain() {
    }


    /**
     * @param string
     * @return
     */
    public ResultSet getData(String string) {


        Connection connection = (Connection) JDBCMySQLConnection.getConnection();

        Statement st = null;

        try {
            st = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet resultSet = null;
        try {
            resultSet = st.executeQuery(string);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    /**
     * Execue query
     * 
     * @param string
     * @return
     */
    public ResultSet executeQuery(String string) {

        Connection connection = (Connection) JDBCMySQLConnection.getConnection();
        Statement st = null;

        try {
            st = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;
        try {
            resultSet = st.executeQuery(string);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;

    }

    /**
     * Update query
     * 
     * @param query
     */
    public void updateQuery(String query) {

        Connection connection = (Connection) JDBCMySQLConnection.getConnection();
        Statement st = null;

        try {
            st = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
