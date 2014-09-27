package businesscode;


/**
 *
 * @Filename PerCapComp.java
 *
 * @Version $Id: PerCapComp.java,v 1.0 2014/02/25 09:23:00 $
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
public class PerCapComp {

    String query = null;

    // constructor
    public PerCapComp() {

        query = "SELECT\n" +
                "  c.county_name as cn," +
                "  c.state ," +
                "  c.year," +
                "  c.per_capita_income," +
                "  h.obesity_rate," +
                "  Sum(r.count) as Restaurant_count " +
                "  FROM" +
                "  county as c, " +
                "  restaurant as r, " +
                "  healthstatistics as h" +
                "  where c.county_name=r.county_name" +
                "  and c.state=r.state " +
                "  and c.year = r.year" +
                "  and c.county_name=h.county_name " +
                "  and c.state=h.state" +
                "  and c.year = h.year" +
                "  and h.obesity_rate is not null " +
                "  and c.per_capita_income is not null " +
                " group by cn, c.state, c.year;";

    }

    /**
     * Result set for the query is extracted and iterated
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        HashMap<Integer, HashMap> collection = new HashMap<Integer, HashMap>();

        List<String> countyStateList = new ArrayList<String>();

        HashMap<String, Double> obesityRate11 = new HashMap<String, Double>();
        HashMap<String, Double> per_capita_income11 = new HashMap<String, Double>();
        HashMap<String, Integer> restaurant_count11 = new HashMap<String, Integer>();

        HashMap<String, Double> obesityRate12 = new HashMap<String, Double>();
        HashMap<String, Double> per_capita_income12 = new HashMap<String, Double>();
        HashMap<String, Integer> restaurant_count12 = new HashMap<String, Integer>();

        HashMap<String, Double> obesityRate13 = new HashMap<String, Double>();
        HashMap<String, Double> per_capita_income13 = new HashMap<String, Double>();
        HashMap<String, Integer> restaurant_count13 = new HashMap<String, Integer>();

        try {
            while (resultSet.next()) {

                int year = resultSet.getInt("year");
                String countyState = resultSet.getString("cn") + " " + resultSet.getString("state");
                double per_capita_income = resultSet.getDouble("per_capita_income");
                double obesity_rate = resultSet.getDouble("obesity_rate");
                int rest_count = resultSet.getInt("Restaurant_count");

                if (!countyStateList.contains(countyState)) {
                    countyStateList.add(countyState);
                }
                if (year == 2011) {

                    obesityRate11.put(countyState, obesity_rate);
                    per_capita_income11.put(countyState, per_capita_income);
                    restaurant_count11.put(countyState, rest_count);
                } else if (year == 2012) {

                    obesityRate12.put(countyState, obesity_rate);
                    per_capita_income12.put(countyState, per_capita_income);
                    restaurant_count12.put(countyState, rest_count);
                } else if (year == 2013) {

                    obesityRate13.put(countyState, obesity_rate);
                    per_capita_income13.put(countyState, per_capita_income);
                    restaurant_count13.put(countyState, rest_count);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        collection.put(20111, obesityRate11);
        collection.put(20112, per_capita_income11);
        collection.put(20113, restaurant_count11);

        collection.put(20121, obesityRate12);
        collection.put(20122, per_capita_income12);
        collection.put(20123, restaurant_count12);

        collection.put(20131, obesityRate13);
        collection.put(20132, per_capita_income13);
        collection.put(20133, restaurant_count13);


        calculate(collection, countyStateList);

    }

    /**
     * Analysis of the data is done here
     * 
     * @param collection
     * @param countyStateList
     */
    public void calculate(HashMap<Integer, HashMap> collection, List<String> countyStateList) {


        HashMap<String, Double> obesityRate11 = (HashMap<String, Double>) collection.get(20111);
        HashMap<String, Double> per_capita_income11 = (HashMap<String, Double>) collection.get(20112);
        HashMap<String, Integer> restaurant_count11 = (HashMap<String, Integer>) collection.get(20113);

        HashMap<String, Double> obesityRate12 = (HashMap<String, Double>) collection.get(20121);
        HashMap<String, Double> per_capita_income12 = (HashMap<String, Double>) collection.get(20122);
        HashMap<String, Integer> restaurant_count12 = (HashMap<String, Integer>) collection.get(20123);

        HashMap<String, Double> obesityRate13 = (HashMap<String, Double>) collection.get(20131);
        HashMap<String, Double> per_capita_income13 = (HashMap<String, Double>) collection.get(20132);
        HashMap<String, Integer> restaurant_count13 = (HashMap<String, Integer>) collection.get(20133);


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

            if ((per_capita_income11.get(countyState) <= per_capita_income12.get(countyState)) || (restaurant_count11.get(countyState) <= restaurant_count12.get(countyState))) {

                if (obesityRate11.get(countyState) <= obesityRate12.get(countyState)) {

                    increasing1++;
                } else {
                    incorrectCount1++;
                }
            }
        }

        for (String countyState : countyStateList) {

            if ((per_capita_income12.get(countyState) <= per_capita_income13.get(countyState)) || (restaurant_count12.get(countyState) <= restaurant_count13.get(countyState))) {

                if (obesityRate12.get(countyState) <= obesityRate13.get(countyState)) {

                    increasing2++;
                } else {
                    incorrectCount2++;
                }
            }
        }


        for (String countyState : countyStateList) {

            if ((per_capita_income11.get(countyState) <= per_capita_income13.get(countyState)) || (restaurant_count11.get(countyState) <= restaurant_count13.get(countyState))) {

                if (obesityRate11.get(countyState) <= obesityRate13.get(countyState)) {

                    increasing3++;
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

        //        double increase=increasing1+increasing2+increasing3;
//        double decrease=decreasing1+decreasing2+decreasing3;
//        double incorrect=incorrectCount1+incorrectCount2+incorrectCount3;
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
//        System.out.println(list);

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

        new Graph().plot(list, 3, label, symbRep, "Number of Restaurants, Per Capita Income and Obesity Rate");
//        new Graph().pie(list,symbRep,this.getClass().getSimpleName());
//          new Graph().USAStates(average13);


    }

    public String getQuery() {
        return query;
    }
}