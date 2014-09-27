package gui;// Imports


/**
 *
 * @Filename JDBCMySQLConnection.java
 *
 * @Version $Id: NewJFrame.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */

import javax.swing.*;
import java.awt.*;


/**
 * <p/>
 * It is the file that renders the table data on UI
 *
 * @author Harsimrat Parmar
 */
class SimpleTable extends JFrame {

    // Instance attributes used in this example
    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;

    // Constructor of main frame
    public SimpleTable(String dataValues[][], String columnNames[]) {

        // Set the frame characteristics
        setTitle("Simple Table Application");
        setSize(300, 200);
        setBackground(Color.gray);

        // Create a panel to hold all other components
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // Create a new table instance
        table = new JTable(dataValues, columnNames);

        // Add the table to a scrolling pane
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        this.setSize(xSize - 100, ySize - 100);
        this.setVisible(true);
    }
}