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
import java.util.HashMap;
import java.util.List;

/**
 * <p/>
 * The analysis file for determing the results
 *
 * @author Harsimrat Parmar
 */

public class ObesityActivity {

    String query = null;

    public ObesityActivity() {

        query = "SELECT " +
                "  h.county_name ," +
                "  h.state," +
                "  h.year," +
                "  h.obesity_rate," +
                "  h.excercise_rate " +
                "  FROM " +
                "  healthstatistics AS h;";
    }


    /**
     * Result set from query is obtained here
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        HashMap<Integer, HashMap> collection = new HashMap<Integer, HashMap>();

        List<String> countyStateList = new ArrayList<String>();
        HashMap<String, Double> obesityRate11 = new HashMap<String, Double>();
        HashMap<String, Double> exerciseRate11 = new HashMap<String, Double>();
        HashMap<String, Double> obesityRate12 = new HashMap<String, Double>();
        HashMap<String, Double> exerciseRate12 = new HashMap<String, Double>();
        HashMap<String, Double> obesityRate13 = new HashMap<String, Double>();
        HashMap<String, Double> exerciseRate13 = new HashMap<String, Double>();

        try {
            while (resultSet.next()) {

                int year = resultSet.getInt("year");
                String countyState = resultSet.getString("county_name") + " " + resultSet.getString("state");
                double obesity = resultSet.getDouble("obesity_rate");
                double ex_Rate = resultSet.getDouble("excercise_rate");

                if (!countyStateList.contains(countyState)) {
                    countyStateList.add(countyState);
                }
                if (year == 2011) {
                    obesityRate11.put(countyState, obesity);
                    exerciseRate11.put(countyState, ex_Rate);
                } else if (year == 2012) {

                    obesityRate12.put(countyState, obesity);
                    exerciseRate12.put(countyState, ex_Rate);
                } else if (year == 2013) {

                    obesityRate13.put(countyState, obesity);
                    exerciseRate13.put(countyState, ex_Rate);
                }
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        collection.put(20111, obesityRate11);
        collection.put(20112, exerciseRate11);
        collection.put(20121, obesityRate12);
        collection.put(20122, exerciseRate12);
        collection.put(20131, obesityRate13);
        collection.put(20132, exerciseRate13);

        calculate(collection, countyStateList);

    }

    /**
     * Analysis is done here
     *
     * @param collection
     * @param countyStateList
     */
    public void calculate(HashMap<Integer, HashMap> collection, List<String> countyStateList) {


        HashMap<String, Double> obesityRate11 = (HashMap<String, Double>) collection.get(20111);
        HashMap<String, Double> exerciseRate11 = (HashMap<String, Double>) collection.get(20112);
        HashMap<String, Double> obesityRate12 = (HashMap<String, Double>) collection.get(20121);
        HashMap<String, Double> exerciseRate12 = (HashMap<String, Double>) collection.get(20122);
        HashMap<String, Double> obesityRate13 = (HashMap<String, Double>) collection.get(20131);
        HashMap<String, Double> exerciseRate13 = (HashMap<String, Double>) collection.get(20132);

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


            if (obesityRate11.get(countyState) >= obesityRate12.get(countyState)) {
                if (exerciseRate11.get(countyState) <= exerciseRate12.get(countyState)) {


                    increasing1++;
                } else {
                    incorrectCount1++;
                }
            }/* else {
                if (obesityRate11.get(countyState) < obesityRate12.get(countyState)) {

                    decreasing1++;
                } else {
                    incorrectCount1++;
                }
            }*/
        }

        for (String countyState : countyStateList) {
            if (obesityRate12.get(countyState) >= obesityRate13.get(countyState)) {
                if (exerciseRate12.get(countyState) <= exerciseRate13.get(countyState)) {

                    increasing2++;
                } else {
                    incorrectCount2++;
                }
            }/* else {
                if (obesityRate12.get(countyState) < obesityRate13.get(countyState)) {

                    decreasing2++;
                } else {
                    incorrectCount2++;
                }
            }*/
        }


        for (String countyState : countyStateList) {
            if (obesityRate11.get(countyState) > obesityRate13.get(countyState)) {
                if (exerciseRate11.get(countyState) > exerciseRate13.get(countyState)) {

                    increasing1++;
                } else {
                    incorrectCount3++;
                }
            } /*else {
                if (obesityRate11.get(countyState) < obesityRate13.get(countyState)) {

                    decreasing3++;
                } else {
                    incorrectCount3++;
                }
            }*/
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

        new Graph().plot(list, 3, label, symbRep, "Obesity and Physical Activity");
//        new Graph().pie(list,symbRep,this.getClass().getSimpleName());
//          new Graph().USAStates(average13);

    }

    public String getQuery() {
        return query;
    }
}