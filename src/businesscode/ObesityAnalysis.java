package businesscode;


/**
 *
 * @Filename Demograph.java
 *
 * @Version $Id: Demograph.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */

import connect.JDBCMySQLMain;
import gui.Graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p/>
 * The analysis file for determing the results
 *
 * @author Omkar Hegde
 */

public class ObesityAnalysis {

    String query = null;

    /**
     * Constructor
     */
    public ObesityAnalysis() {

        query = "SELECT\n" +
                " state,year,  sum(obesity_rate)/count(county_name) as average" +
                "  FROM" +
                "  big_data.healthstatistics " +
                "  group by state " +
                "  order by state asc;";
    }

    /**
     * getQuery()
     *
     * @return
     */
    public String getQuery() {
        return query;
    }

    /**
     * 
     * getResults runr the query and analyses the data
     * 
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        List<Integer> average11 = new ArrayList<Integer>();
        int avg1 = 0;
        try {
            while (resultSet.next()) {

                double avg = resultSet.getDouble("average");

                if ((20 <= avg) && (avg < 25)) {
                    avg1 = 10;
                }
                if ((25 <= avg) && (avg < 30)) {
                    avg1 = 30;
                }
                if ((30 <= avg) && (avg < 35)) {
                    avg1 = 50;
                }
                if ((35 <= avg) && (avg < 45)) {
                    avg1 = 70;
                }
                average11.add(avg1);
            }


            Iterator<Integer> it = average11.iterator();
            
            while (it.hasNext()) {

                System.out.print(it.next() + " ");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        new Graph().USAStates(average11);
    }
}