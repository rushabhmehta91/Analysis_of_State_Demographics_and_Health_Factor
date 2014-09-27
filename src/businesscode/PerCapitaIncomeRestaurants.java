package businesscode;


/**
 *
 * @Filename PerCapitaIncomeRestaurants.java
 *
 * @Version $Id: PerCapitaIncomeRestaurants.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */

import connect.JDBCMySQLMain;
import gui.Graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * <p/>
 * The analysis file for determing the results
 *
 * @author Omkar Hegde
 */

public class PerCapitaIncomeRestaurants {


    String query = null;

    // consructor
    public PerCapitaIncomeRestaurants() {

        query = "SELECT c.county_name AS countyName," +
                "  c.state AS state ," +
                "  c.year AS year," +
                "  c.per_capita_income AS perCapitaIncome," +
                "  SUM(r.count) AS restaurantCount " +
                "FROM county    AS c," +
                "  restaurant   AS r " +
                "WHERE c.county_name = r.county_name " +
                "AND c.state        = r.state " +
                "AND c.year         = r.year " +
                "GROUP BY c.county_name, " +
                "  c.state, " +
                "  c.year;";
    }


    /**
     * getResults()
     * Runs query and gets results
     *
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        HashMap<Integer, HashMap> collection = new HashMap<Integer, HashMap>();

        List<String> countyStateList = new ArrayList<String>();

        HashMap<String, Double> perCapitaIncome11 = new HashMap<String, Double>();
        HashMap<String, Integer> numRestaurants11 = new HashMap<String, Integer>();

        HashMap<String, Double> perCapitaIncome12 = new HashMap<String, Double>();
        HashMap<String, Integer> numRestaurants12 = new HashMap<String, Integer>();

        HashMap<String, Double> perCapitaIncome13 = new HashMap<String, Double>();
        HashMap<String, Integer> numRestaurants13 = new HashMap<String, Integer>();

        try {

            // result is iterated
            while (resultSet.next()) {


                int year = resultSet.getInt("year");
                String countyState = resultSet.getString("countyName") + " " + resultSet.getString("state");
                double perCapitaIncome = resultSet.getDouble("perCapitaIncome");
                int restaurants = resultSet.getInt("restaurantCount");

                if (!countyStateList.contains(countyState))
                    countyStateList.add(countyState);
                if (year == 2011) {

                    perCapitaIncome11.put(countyState, perCapitaIncome);
                    numRestaurants11.put(countyState, restaurants);
                } else if (year == 2012) {

                    perCapitaIncome12.put(countyState, perCapitaIncome);
                    numRestaurants12.put(countyState, restaurants);
                } else if (year == 2013) {

                    perCapitaIncome13.put(countyState, perCapitaIncome);
                    numRestaurants13.put(countyState, restaurants);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        collection.put(20111, perCapitaIncome11);
        collection.put(20112, numRestaurants11);
        collection.put(20121, perCapitaIncome12);
        collection.put(20122, numRestaurants12);
        collection.put(20131, perCapitaIncome13);
        collection.put(20132, numRestaurants13);


        calculate(collection, countyStateList);
    }


    /**
     * Analysis of the resuslts
     * 
     * @param collection
     * @param countyStateList
     */
    public void calculate(HashMap<Integer, HashMap> collection, List<String> countyStateList) {

        double totalObesityPercent = 0;
        int totalRestaurants = 0;


        HashMap<String, Double> perCapita11 = (HashMap<String, Double>) collection.get(20111);
        HashMap<String, Integer> numRestaurants11 = (HashMap<String, Integer>) collection.get(20112);
        HashMap<String, Double> perCapita12 = (HashMap<String, Double>) collection.get(20121);
        HashMap<String, Integer> numRestaurants12 = (HashMap<String, Integer>) collection.get(20122);
        HashMap<String, Double> perCapita13 = (HashMap<String, Double>) collection.get(20131);
        HashMap<String, Integer> numRestaurants13 = (HashMap<String, Integer>) collection.get(20132);

        int increasing1 = 0;
        int decreasing1 = 0;
        int incorrectCount1 = 0;

        int increasing2 = 0;
        int decreasing2 = 0;
        int incorrectCount2 = 0;

        int increasing3 = 0;
        int decreasing3 = 0;
        int incorrectCount3 = 0;

        for (String countyState : countyStateList) {

            if (numRestaurants11.get(countyState) > numRestaurants12.get(countyState)) {

                if (perCapita11.get(countyState) < perCapita12.get(countyState)) {

                    increasing1++;
                } else {
                    incorrectCount1++;
                }
            } else {
                if (perCapita11.get(countyState) > perCapita12.get(countyState)) {

                    decreasing1++;
                } else {
                    incorrectCount1++;
                }
            }
        }

        for (String countyState : countyStateList) {

            if (numRestaurants12.get(countyState) > numRestaurants13.get(countyState)) {
                if (perCapita12.get(countyState) > perCapita13.get(countyState)) {
                    increasing2++;
                } else {
                    incorrectCount2++;
                }
            } else {
                if (perCapita12.get(countyState) < perCapita13.get(countyState)) {

                    decreasing2++;
                } else {
                    incorrectCount2++;
                }
            }
        }


        for (String countyState : countyStateList) {

            if (numRestaurants11.get(countyState) > numRestaurants13.get(countyState)) {
                if (perCapita11.get(countyState) > perCapita13.get(countyState)) {
                    increasing1++;
                } else {
                    incorrectCount3++;
                }
            } else {
                if (perCapita11.get(countyState) < perCapita13.get(countyState)) {

                    decreasing3++;
                } else {
                    incorrectCount3++;
                }
            }
        }


        System.out.println("Increasing 11-12: " + increasing1);
        System.out.println("Decreasing 11-12: " + decreasing1);
        System.out.println("Incorrect 11-12: " + incorrectCount1);

        System.out.println("");
        System.out.println("");

        System.out.println("Increasing 12-13: " + increasing2);
        System.out.println("Decreasing 12-13: " + decreasing2);
        System.out.println("Incorrect 12-13: " + incorrectCount2);

        System.out.println("");
        System.out.println("");

        System.out.println("Increasing 11-13: " + increasing3);
        System.out.println("Decreasing 11-13: " + decreasing3);
        System.out.println("Incorrect 11-13: " + incorrectCount3);

        //FOR GRAPH
        ArrayList<Double> list;
        list = new ArrayList();

        double total1 = increasing1 + decreasing1 + incorrectCount1;
        double total2 = increasing2 + decreasing2 + incorrectCount2;

        double total3 = increasing3 + decreasing3 + incorrectCount3;

        list.add((increasing1 / total1) * 100);
        list.add((increasing2 / total2) * 100);
        list.add((double) ((increasing3 / total3) * 100));

        list.add((decreasing1 / total1) * 100);
        list.add((decreasing2 / total2) * 100);
        list.add((decreasing3 / total3) * 100);

        list.add((incorrectCount1 / total1) * 100);
        list.add((incorrectCount2 / total2) * 100);
        list.add((incorrectCount3 / total3) * 100);

        ArrayList<String> label;
        label = new ArrayList();
        label.add("2011-2012");
        label.add("2012-2013");
        label.add("2011-2013");

        ArrayList<String> symbRep;
        symbRep = new ArrayList();
        symbRep.add("Increasing");
        symbRep.add("Decreasing");
        symbRep.add("Incorrect");

        new Graph().plot(list, 3, label, symbRep, "Per Capita Income and Number of Restaurants");

    }

    public String getQuery() {
        return query;
    }
}
