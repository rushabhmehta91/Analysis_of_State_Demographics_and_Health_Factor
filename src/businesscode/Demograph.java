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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
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
public class Demograph {

    String query = null;

    // Constructor
    public Demograph() {

        query = "SELECT\n" +
                "  d.county_name," +
                "  d.state ," +
                "  d.year," +
                "  d.African_American," +
                "  d.American_Alaskan_Native," +
                "  d.asian, " +
                "  d.hispanic, " +
                "  d.pacific_highlander, " +
                "  p.no_of_death, " +
                "  p.disease_name" +
                "  FROM" +
                "  Demographics as d, " +
                "  Diseases as p" +
                "  where d.state=p.state" +
                "  and d.county_name=p.county_name" +
                "  and d.year=p.year" +
                "  and d.year=2012 ;";

    }

    /**
     * Highest is obtained here
     *
     * @param no1
     * @param no2
     * @param no3
     * @param no4
     * @param no5
     * @return int
     */
    public static int findHighest(double no1, double no2, double no3, double no4, double no5) {
        int[] arr = {1, 2, 3, 4, 5};
        double[] arr2 = {no1, no2, no3, no4, no5};

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (arr2[j] > arr2[i]) {
                    double temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;

                    int temp2 = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp2;
                }
            }
        }
        return arr[0];
    }

    /**
     * Query is executed here
     */
    public void getResults() {


        JDBCMySQLMain connectToDB = new JDBCMySQLMain();
        ResultSet resultSet = connectToDB.executeQuery(query);

        HashMap<Integer, HashMap> collection = new HashMap<Integer, HashMap>();

        List<String> countyStateList = new ArrayList<String>();
        List<String> disease_name = new ArrayList<String>();

        HashMap<String, Double> African_American11 = new HashMap<String, Double>();
        HashMap<String, Double> American_Alaskan_Native11 = new HashMap<String, Double>();
        HashMap<String, Double> asian11 = new HashMap<String, Double>();
        HashMap<String, Double> hispanic11 = new HashMap<String, Double>();
        HashMap<String, Double> pacific_highlander11 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_death11 = new HashMap<String, Integer>();


        HashMap<String, Double> African_American12 = new HashMap<String, Double>();
        HashMap<String, Double> American_Alaskan_Native12 = new HashMap<String, Double>();
        HashMap<String, Double> asian12 = new HashMap<String, Double>();
        HashMap<String, Double> hispanic12 = new HashMap<String, Double>();
        HashMap<String, Double> pacific_highlander12 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_death12 = new HashMap<String, Integer>();


        HashMap<String, Double> African_American13 = new HashMap<String, Double>();
        HashMap<String, Double> American_Alaskan_Native13 = new HashMap<String, Double>();
        HashMap<String, Double> asian13 = new HashMap<String, Double>();
        HashMap<String, Double> hispanic13 = new HashMap<String, Double>();
        HashMap<String, Double> pacific_highlander13 = new HashMap<String, Double>();
        HashMap<String, Integer> no_of_death13 = new HashMap<String, Integer>();


        try {
            while (resultSet.next()) {

                int year = resultSet.getInt("year");
                String countyState = resultSet.getString("county_name") + " " + resultSet.getString("state");
                double African_American = resultSet.getDouble("African_American");
                double American_Alaskan = resultSet.getDouble("American_Alaskan_Native");
                double asian = resultSet.getDouble("asian");
                double hispanic = resultSet.getDouble("hispanic");
                double pacific_highlander = resultSet.getDouble("pacific_highlander");
                int no_of_death = resultSet.getInt("no_of_death");
                String disease_names = resultSet.getString("disease_name");

                String key = countyState + " " + disease_names;
                if (!countyStateList.contains(countyState)) {
                    countyStateList.add(countyState);
                }
                if (!disease_name.contains(disease_name)) {
                    disease_name.add(disease_names);
                }
                if (year == 2011) {

                    African_American11.put(countyState, African_American);
                    American_Alaskan_Native11.put(countyState, American_Alaskan);
                    asian11.put(countyState, asian);
                    hispanic11.put(countyState, hispanic);
                    pacific_highlander11.put(countyState, pacific_highlander);
                    no_of_death11.put(key, no_of_death);

                } else if (year == 2012) {

                    African_American12.put(countyState, African_American);
                    American_Alaskan_Native12.put(countyState, American_Alaskan);
                    asian12.put(countyState, asian);
                    hispanic12.put(countyState, hispanic);
                    pacific_highlander12.put(countyState, pacific_highlander);
                    no_of_death12.put(key, no_of_death);

                } else if (year == 2013) {

                    African_American13.put(countyState, African_American);
                    American_Alaskan_Native13.put(countyState, American_Alaskan);
                    asian13.put(countyState, asian);
                    hispanic13.put(countyState, hispanic);
                    pacific_highlander13.put(countyState, pacific_highlander);
                    no_of_death13.put(key, no_of_death);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        collection.put(20111, African_American11);
        collection.put(20112, American_Alaskan_Native11);
        collection.put(20113, asian11);
        collection.put(20114, hispanic11);
        collection.put(20115, pacific_highlander11);
        collection.put(20116, no_of_death11);

        collection.put(20121, African_American12);
        collection.put(20122, American_Alaskan_Native12);
        collection.put(20123, asian12);
        collection.put(20124, hispanic12);
        collection.put(20125, pacific_highlander12);
        collection.put(20126, no_of_death12);

        collection.put(20131, African_American13);
        collection.put(20132, American_Alaskan_Native13);
        collection.put(20133, asian13);
        collection.put(20134, hispanic13);
        collection.put(20135, pacific_highlander13);
        collection.put(20136, no_of_death13);


        calculate(collection, countyStateList, disease_name);

    }

    /**
     * Analysis is done here
     *
     * @param collection
     * @param countyStateList
     * @param disease_name
     */
    public void calculate(HashMap<Integer, HashMap> collection, List<String> countyStateList, List<String> disease_name) {


        HashMap<String, Double> African_American11 = (HashMap<String, Double>) collection.get(20111);
        HashMap<String, Double> American_Alaskan_Native11 = (HashMap<String, Double>) collection.get(20112);
        HashMap<String, Double> asian11 = (HashMap<String, Double>) collection.get(20113);
        HashMap<String, Double> hispanic11 = (HashMap<String, Double>) collection.get(20114);
        HashMap<String, Double> pacific_highlander11 = (HashMap<String, Double>) collection.get(20115);
        HashMap<String, Integer> no_of_death11 = (HashMap<String, Integer>) collection.get(20116);

        HashMap<String, Double> African_American12 = (HashMap<String, Double>) collection.get(20121);
        HashMap<String, Double> American_Alaskan_Native12 = (HashMap<String, Double>) collection.get(20122);
        HashMap<String, Double> asian12 = (HashMap<String, Double>) collection.get(20123);
        HashMap<String, Double> hispanic12 = (HashMap<String, Double>) collection.get(20124);
        HashMap<String, Double> pacific_highlander12 = (HashMap<String, Double>) collection.get(20125);
        HashMap<String, Integer> no_of_death12 = (HashMap<String, Integer>) collection.get(20126);

        HashMap<String, Double> African_American13 = (HashMap<String, Double>) collection.get(20131);
        HashMap<String, Double> American_Alaskan_Native13 = (HashMap<String, Double>) collection.get(20132);
        HashMap<String, Double> asian13 = (HashMap<String, Double>) collection.get(20133);
        HashMap<String, Double> hispanic13 = (HashMap<String, Double>) collection.get(20134);
        HashMap<String, Double> pacific_highlander13 = (HashMap<String, Double>) collection.get(20135);
        HashMap<String, Integer> no_of_death13 = (HashMap<String, Integer>) collection.get(20136);


        HashMap<String, Integer> resultSet = new HashMap<String, Integer>();

        int increasing1 = 0;
        int decreasing1 = 0;
        int incorrectCount1 = 0;

        int increasing2 = 0;
        int decreasing2 = 0;
        int incorrectCount2 = 0;

        int increasing3 = 0;
        int decreasing3 = 0;
        int incorrectCount3 = 0;

        int[] africanAmData = new int[10];
        int[] americanAlaskanData = new int[10];
        int[] asianData = new int[10];
        int[] hispanicData = new int[10];
        int[] pacifichighlanderData = new int[10];
        String[] diseaseName = new String[]{"Cerebrovascular Disease", "Cholera", "Chronic lower respiratory diseases", "Diabetes mellitus", "Diarrheal Diseases", "HIV/AIDS", "Influenza and pneumonia", "Malaria", "Malignant tumours", "Tuberculosis"};

        for (int i = 0; i < 10; i++) {
            africanAmData[i] = 0;
            americanAlaskanData[i] = 0;
            asianData[i] = 0;
            hispanicData[i] = 0;
            pacifichighlanderData[i] = 0;
        }

        for (String countyState : countyStateList) {

            double African_American = African_American12.get(countyState);
            double American_Alaskan = American_Alaskan_Native12.get(countyState);
            double asian = asian12.get(countyState);
            double hispanic = hispanic12.get(countyState);
            double pacific_highlander = pacific_highlander12.get(countyState);

            String highestDis = null;
            String highestName = null;
            int no_death = 0;
            for (String diseaseName2 : disease_name) {


                String key = countyState + " " + diseaseName2;


                int temp = no_of_death12.get(key);

                if (temp > no_death) {
                    no_death = temp;
                    highestDis = diseaseName2;
                }
            }
            int index = findHighest(African_American, American_Alaskan, asian, hispanic, pacific_highlander);

            if (index == 1) {
                highestName = "African American";
            } else if (index == 2) {
                highestName = "American Alaskan";
            } else if (index == 3) {
                highestName = "Asian";
            } else if (index == 4) {
                highestName = "Hispanic";
            } else if (index == 5) {
                highestName = "Pacific Highlander";
            }

            /*
            System.out.println("COUNTY AND STATE: " + countyState);
            System.out.println("HIGHEST POPULATION OF: "+ highestName);
            System.out.println("HIGHEST DISEASE: "+highestDis);
            System.out.println("********************************");*/
            if (highestDis != null) {

                if (highestName.equals("African American")) {
                    if (highestDis.equals(diseaseName[0])) {
                        africanAmData[0]++;
                    } else if (highestDis.equals(diseaseName[1])) {
                        africanAmData[1]++;
                    } else if (highestDis.equals(diseaseName[2])) {
                        africanAmData[2]++;
                    } else if (highestDis.equals(diseaseName[3])) {
                        africanAmData[3]++;
                    } else if (highestDis.equals(diseaseName[4])) {
                        africanAmData[4]++;
                    } else if (highestDis.equals(diseaseName[5])) {
                        africanAmData[5]++;
                    } else if (highestDis.equals(diseaseName[6])) {
                        africanAmData[6]++;
                    } else if (highestDis.equals(diseaseName[7])) {
                        africanAmData[7]++;
                    } else if (highestDis.equals(diseaseName[8])) {
                        africanAmData[8]++;
                    } else if (highestDis.equals(diseaseName[9])) {
                        africanAmData[9]++;
                    }


                }

                if (highestName.equals("American Alaskan")) {
                    if (highestDis.equals(diseaseName[0])) {
                        americanAlaskanData[0]++;
                    } else if (highestDis.equals(diseaseName[1])) {
                        americanAlaskanData[1]++;
                    } else if (highestDis.equals(diseaseName[2])) {
                        americanAlaskanData[2]++;
                    } else if (highestDis.equals(diseaseName[3])) {
                        americanAlaskanData[3]++;
                    } else if (highestDis.equals(diseaseName[4])) {
                        americanAlaskanData[4]++;
                    } else if (highestDis.equals(diseaseName[5])) {
                        americanAlaskanData[5]++;
                    } else if (highestDis.equals(diseaseName[6])) {
                        americanAlaskanData[6]++;
                    } else if (highestDis.equals(diseaseName[7])) {
                        americanAlaskanData[7]++;
                    } else if (highestDis.equals(diseaseName[8])) {
                        americanAlaskanData[8]++;
                    } else if (highestDis.equals(diseaseName[9])) {
                        americanAlaskanData[9]++;
                    }

                }

                if (highestName.equals("Asian")) {
                    if (highestDis.equals(diseaseName[0])) {
                        asianData[0]++;
                    } else if (highestDis.equals(diseaseName[1])) {
                        asianData[1]++;
                    } else if (highestDis.equals(diseaseName[2])) {
                        asianData[2]++;
                    } else if (highestDis.equals(diseaseName[3])) {
                        asianData[3]++;
                    } else if (highestDis.equals(diseaseName[4])) {
                        asianData[4]++;
                    } else if (highestDis.equals(diseaseName[5])) {
                        asianData[5]++;
                    } else if (highestDis.equals(diseaseName[6])) {
                        asianData[6]++;
                    } else if (highestDis.equals(diseaseName[7])) {
                        asianData[7]++;
                    } else if (highestDis.equals(diseaseName[8])) {
                        asianData[8]++;
                    } else if (highestDis.equals(diseaseName[9])) {
                        asianData[9]++;
                    }

                }

                if (highestName.equals("Hispanic")) {
                    if (highestDis.equals(diseaseName[0])) {
                        hispanicData[0]++;
                    } else if (highestDis.equals(diseaseName[1])) {
                        hispanicData[1]++;
                    } else if (highestDis.equals(diseaseName[2])) {
                        hispanicData[2]++;
                    } else if (highestDis.equals(diseaseName[3])) {
                        hispanicData[3]++;
                    } else if (highestDis.equals(diseaseName[4])) {
                        hispanicData[4]++;
                    } else if (highestDis.equals(diseaseName[5])) {
                        hispanicData[5]++;
                    } else if (highestDis.equals(diseaseName[6])) {
                        hispanicData[6]++;
                    } else if (highestDis.equals(diseaseName[7])) {
                        hispanicData[7]++;
                    } else if (highestDis.equals(diseaseName[8])) {
                        hispanicData[8]++;
                    } else if (highestDis.equals(diseaseName[9])) {
                        hispanicData[9]++;
                    }

                }

                if (highestName.equals("Pacific Highlander")) {
                    if (highestDis.equals(diseaseName[0])) {
                        pacifichighlanderData[0]++;
                    } else if (highestDis.equals(diseaseName[1])) {
                        pacifichighlanderData[1]++;
                    } else if (highestDis.equals(diseaseName[2])) {
                        pacifichighlanderData[2]++;
                    } else if (highestDis.equals(diseaseName[3])) {
                        pacifichighlanderData[3]++;
                    } else if (highestDis.equals(diseaseName[4])) {
                        pacifichighlanderData[4]++;
                    } else if (highestDis.equals(diseaseName[5])) {
                        pacifichighlanderData[5]++;
                    } else if (highestDis.equals(diseaseName[6])) {
                        pacifichighlanderData[6]++;
                    } else if (highestDis.equals(diseaseName[7])) {
                        pacifichighlanderData[7]++;
                    } else if (highestDis.equals(diseaseName[8])) {
                        pacifichighlanderData[8]++;
                    } else if (highestDis.equals(diseaseName[9])) {
                        pacifichighlanderData[9]++;
                    }

                }


                String final_key = highestName + highestDis;

                if (resultSet.get(final_key) == null) {
                    resultSet.put(final_key, 1);
                } else {
                    int count = resultSet.get(final_key);
                    count += 1;
                    resultSet.put(final_key, count);
                }
            }

        }

        // FOR GRAPH

        ArrayList<String> type_of_people = new ArrayList();
        type_of_people.add("African_American");
        type_of_people.add("American_Alaskan_Native");
        type_of_people.add("asian");
        type_of_people.add("hispanic");
        type_of_people.add("pacific_highlander");

        int diseaseCount[] = new int[diseaseName.length];
        for (int i = 0; i < diseaseName.length; i++) {
            diseaseCount[i] = africanAmData[i] + americanAlaskanData[i] + asianData[i] + hispanicData[i] + pacifichighlanderData[i];
        }
        ArrayList<Integer> disease[] = new ArrayList[diseaseName.length];
        for (int i = 0; i < diseaseName.length; i++) {
            disease[i] = new ArrayList<Integer>();
            disease[i].add(africanAmData[i] * 100 / diseaseCount[i]);
            disease[i].add(americanAlaskanData[i] * 100 / diseaseCount[i]);
            disease[i].add(asianData[i] * 100 / diseaseCount[i]);
            disease[i].add(hispanicData[i] * 100 / diseaseCount[i]);
            disease[i].add(pacifichighlanderData[i] * 100 / diseaseCount[i]);
        }
        JFrame frame = new JFrame("CHARTS");
        JPanel panel = new JPanel();

        for (int i = 0; i < diseaseName.length; i++) {
            String url = new Graph().pie(disease[i], type_of_people, this.getClass().getSimpleName() + " " + diseaseName[i]);
            JLabel label = null;
            try {
                label = new JLabel(new ImageIcon(ImageIO.read(new URL(url))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(label, BorderLayout.CENTER);
        }
        JScrollPane scrollBar = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollBar);
        frame.pack();
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().getWidth());
//        int ySize = ((int) tk.getScreenSize().getHeight());
//        frame.setSize(xSize - 100, ySize - 100);
        frame.setVisible(true);


    }

    public String getQuery() {
        return query;
    }
}


