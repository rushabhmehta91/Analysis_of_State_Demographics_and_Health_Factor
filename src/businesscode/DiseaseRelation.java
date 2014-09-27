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
 * @author Omkar Hegde
 */
public class DiseaseRelation {

    String query = null;

    // Constructor
    public DiseaseRelation() {

        query = "SELECT\n" +
                "   c.county_name as cn," +
                "  c.state ," +
                "  c.year," +
                "  c.poverty," +
                "  c.num_of_death as total_number_of_death," +
                "  h.no_of_hospitals" +
                //"  d.disease_name,"+
                //"  d.no_of_death"+
                "  FROM" +
                "  county as c, " +
                //"  diseases as d,"+
                "  healthstatistics as h" +
                //"  where c.county_name=d.county_name"+
                //"  and c.state=d.state"+
                //  "  and c.year = d.year"+
                "  where c.county_name=h.county_name" +
                "  and c.state=h.state" +
                "  and c.year = h.year" +
                "  group by cn, c.state, c.year;";

    }

    /**
     * Query is executed here
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        HashMap<Integer, HashMap> collection = new HashMap<Integer, HashMap>();
        List<String> countyStateList = new ArrayList<String>();

        HashMap<String, Double> pvertyRate11 = new HashMap<String, Double>();
        HashMap<String, Double> no_of_death11 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_hospital11 = new HashMap<String, Integer>();


        HashMap<String, Double> pvertyRate12 = new HashMap<String, Double>();
        HashMap<String, Double> no_of_death12 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_hospital12 = new HashMap<String, Integer>();

        HashMap<String, Double> pvertyRate13 = new HashMap<String, Double>();
        HashMap<String, Double> no_of_death13 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_hospital13 = new HashMap<String, Integer>();

        try {
            while (resultSet.next()) {

                int year = resultSet.getInt("year");
                String countyState = resultSet.getString("cn") + " " + resultSet.getString("state");
                double poverty = resultSet.getDouble("poverty");
                double total_number_of_death = resultSet.getDouble("total_number_of_death");
                int no_of_hospital = resultSet.getInt("no_of_hospitals");


                if (!countyStateList.contains(countyState)) {
                    countyStateList.add(countyState);
                }

                if (year == 2011) {

                    pvertyRate11.put(countyState, poverty);
                    no_of_death11.put(countyState, total_number_of_death);
                    no_of_hospital11.put(countyState, no_of_hospital);
                } else if (year == 2012) {

                    pvertyRate12.put(countyState, poverty);
                    no_of_death12.put(countyState, total_number_of_death);
                    no_of_hospital12.put(countyState, no_of_hospital);
                } else if (year == 2013) {

                    pvertyRate13.put(countyState, poverty);
                    no_of_death13.put(countyState, total_number_of_death);
                    no_of_hospital13.put(countyState, no_of_hospital);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        collection.put(20111, pvertyRate11);
        collection.put(20112, no_of_death11);
        collection.put(20113, no_of_hospital11);

        collection.put(20121, pvertyRate12);
        collection.put(20122, no_of_death12);
        collection.put(20123, no_of_hospital12);

        collection.put(20131, pvertyRate13);
        collection.put(20132, no_of_death13);
        collection.put(20133, no_of_hospital13);

        calculate(collection, countyStateList);

    }

    /**
     * Analysis is done here
     *
     * @param collection
     * @param countyStateList
     */
    public void calculate(HashMap<Integer, HashMap> collection, List<String> countyStateList) {


        HashMap<String, Double> pvertyRate11 = (HashMap<String, Double>) collection.get(20111);
        HashMap<String, Double> no_of_death11 = (HashMap<String, Double>) collection.get(20112);
        HashMap<String, Integer> no_of_hospital11 = (HashMap<String, Integer>) collection.get(20113);

        HashMap<String, Double> pvertyRate12 = (HashMap<String, Double>) collection.get(20121);
        HashMap<String, Double> no_of_death12 = (HashMap<String, Double>) collection.get(20122);
        HashMap<String, Integer> no_of_hospital12 = (HashMap<String, Integer>) collection.get(20123);

        HashMap<String, Double> pvertyRate13 = (HashMap<String, Double>) collection.get(20131);
        HashMap<String, Double> no_of_death13 = (HashMap<String, Double>) collection.get(20132);
        HashMap<String, Integer> no_of_hospital13 = (HashMap<String, Integer>) collection.get(20133);

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

            if ((pvertyRate11.get(countyState) > pvertyRate12.get(countyState)) || (no_of_hospital11.get(countyState) < no_of_hospital12.get(countyState))) {

                if (no_of_death11.get(countyState) > no_of_death12.get(countyState)) {

                    decreasing1++;
                } else {
                    if ((no_of_hospital11.get(countyState) <= no_of_hospital12.get(countyState))) {
                        increasing1++;
                    } else {
                        incorrectCount1++;
                    }
                }
            }
        }

        for (String countyState : countyStateList) {

            if ((pvertyRate12.get(countyState) > pvertyRate13.get(countyState)) || (no_of_hospital12.get(countyState) < no_of_hospital13.get(countyState))) {

                if (no_of_death12.get(countyState) > no_of_death13.get(countyState)) {

                    decreasing2++;
                } else {
                    if ((no_of_hospital12.get(countyState) <= no_of_hospital13.get(countyState))) {
                        increasing2++;
                    } else {
                        incorrectCount2++;
                    }
                }
            }
        }


        for (String countyState : countyStateList) {

            if ((pvertyRate11.get(countyState) > pvertyRate13.get(countyState)) || (no_of_hospital11.get(countyState) < no_of_hospital13.get(countyState))) {

                if (no_of_death11.get(countyState) > no_of_death13.get(countyState)) {

                    decreasing3++;
                } else {
                    if ((no_of_hospital11.get(countyState) <= no_of_hospital13.get(countyState))) {
                        increasing3++;
                    } else {
                        incorrectCount3++;
                    }

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

        new Graph().plot(list, 3, label, symbRep, "Disease along with Number of Hospitals, Poverty and Death Rate");
//        new Graph().pie(list,symbRep,this.getClass().getSimpleName());
//          new Graph().USAStates(average13);


    }

    public String getQuery() {
        return query;
    }
}
