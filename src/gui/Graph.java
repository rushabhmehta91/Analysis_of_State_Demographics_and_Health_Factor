package gui;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.USAState.Code.*;

import com.googlecode.charts4j.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;

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
 * <p/>FIle to make the graphs on the ui
 *
 *
 * @author Rushabh Mehta
 */
public class Graph {
    static JFrame frame;

    //
    public Graph() {
        frame = new JFrame("Charts");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Plots the graphs
     * @param list
     * @param num
     * @param label
     * @param symbRep
     * @param title
     */
    public void plot(ArrayList<Double> list, int num, ArrayList<String> label, ArrayList<String> symbRep, String title) {
        // EXAMPLE CODE START
        // Defining data plots.
        ArrayList<BarChartPlot> team = new ArrayList<BarChartPlot>();
        ArrayList<com.googlecode.charts4j.Color> color = new ArrayList<com.googlecode.charts4j.Color>();
        color.add(BLUEVIOLET);
        color.add(ORANGERED);
        color.add(LIMEGREEN);
        color.add(AQUA);

        color.add(YELLOW);
        color.add(PLUM);
        color.add(NAVY);

        for (int i = 0; i < symbRep.size(); i++) {
            BarChartPlot team1;
            team1 = Plots.newBarChartPlot(Data.newData(list.subList(num * i, num * (i + 1))), color.get(i), symbRep.get(i));
            team.add(team1);

        }


        // Instantiating chart.
        BarChart chart = GCharts.newBarChart(team);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels count = AxisLabelsFactory.newAxisLabels("Count", 50.0);
        count.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year.setAxisStyle(axisStyle);

        // Adding axis info to chart.
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(label));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 100));
        chart.addYAxisLabels(count);
        chart.addXAxisLabels(year);

        chart.setSize(600, 450);
        chart.setBarWidth(100);
        chart.setSpaceWithinGroupsOfBars(20);
        chart.setDataStacked(true);
        chart.setTitle(title, BLACK, 16);
        chart.setGrid(100, 10, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, LAVENDER, 100);
        fill.addColorAndOffset(WHITE, 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        System.out.println(url);
        try {
            displayUrlString(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Pie charts
     * 
     * @param list
     * @param symbRep
     * @param title
     * @return
     */
    public String pie(ArrayList<Integer> list, ArrayList<String> symbRep, String title) {
        ArrayList<Slice> team = new ArrayList<Slice>();
        ArrayList<com.googlecode.charts4j.Color> color = new ArrayList<com.googlecode.charts4j.Color>();
        color.add(BLUEVIOLET);
        color.add(ORANGERED);
        color.add(AQUA);
        color.add(LIMEGREEN);
        color.add(YELLOW);
        color.add(PLUM);
        color.add(NAVY);

        for (int i = 0; i < symbRep.size(); i++) {
            Slice s1 = Slice.newSlice(list.get(i), color.get(i), symbRep.get(i));
            team.add(s1);
        }
        // EXAMPLE CODE START

        PieChart chart = GCharts.newPieChart(team);
        chart.setTitle(title, BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        String url = chart.toURLString();
//        try {
//            displayUrlString(url);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        while(true){}
        return url;

    }

    /**
     * Graph for states
     * 
     * @param average13
     */
    public void USAStates(List<Integer> average13) {
        // EXAMPLE CODE START
        MapChart chart = GCharts.newMapChart(GeographicalArea.USA);
        String states[] = {"ALABAMA", "ALASKA", "ARIZONA", "ARKANSAS", "CALIFORNIA", "COLORADO", "CONNECTICUT", "DELAWARE", "FLORIDA", "GEORGIA", "HAWAII", "IDAHO", "ILLINOIS", "INDIANA", "IOWA", "KANSAS", "KENTUCKY", "LOUISIANA", "MAINE", "MARYLAND", "MASSACHUSETTS", "MICHIGAN", "MINNESOTA", "MISSISSIPPI", "MISSOURI", "MONTANA", "NEBRASKA", "NEVADA", "NEW_HAMPSHIRE", "NEW_JERSEY", "NEW_MEXICO", "NEW_YORK", "NORTH_CAROLINA", "NORTH_DAKOTA", "OHIO", "OKLAHOMA", "OREGON", "PENNSYLVANIA", "RHODE_ISLAND", "SOUTH_CAROLINA", "SOUTH_DAKOTA", "TENNESSEE", "TEXAS", "UTAH", "VERMONT", "VIRGINIA", "WASHINGTON", "WEST_VIRGINIA", "WISCONSIN", "WYOMING"};
        PoliticalBoundary names_states[] = new PoliticalBoundary[states.length];

        for (int i = 0; i < states.length; i++)
            names_states[i] = new USAState(USAState.Name.valueOf((states[i])), average13.get(i));

        chart.addPoliticalBoundaries(Arrays.<PoliticalBoundary>asList(names_states));
        chart.setColorGradient(WHITE, RED, YELLOW);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        String url = chart.toURLString();
        try {
            displayUrlString(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Displays the genertaed URL on frame
     * @param urlString
     * @throws java.io.IOException
     */
    private void displayUrlString(final String urlString) throws IOException {
        JPanel panel = new JPanel();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new URL(urlString))));
        panel.add(label, BorderLayout.CENTER);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

}


