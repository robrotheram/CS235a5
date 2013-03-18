package cs235a5;

/**
 *
 * \file    visualiserGUI.java
 * \author  John Rowley
 * \date    16/02/2013
 *
 * \brief   A Grahical User Interface to read and
 *          display data from a .csv file, and trasform
 *          that data into visualisations.
 *
 */

// Import File I/O
import java.io.File;

// Import AWT Library
import java.awt.*;
import java.awt.event.*;

// Import Swing Library
import javax.swing.*;
import javax.swing.event.*;

// Import Exceptions
import java.io.IOException;

public class VisualiserGUI extends JFrame
{
  private final Dimension MIN_SIZE = new Dimension(800, 500);

  private JFrame m_frame;
  private Container m_container;
  private JPanel m_drawPanel;
  private JFileChooser m_fc;

  private JMenuBar m_menuBar;
  private JMenu m_fileMenu, m_drawMenu;
  private JMenuItem m_openMenuItem, m_exitMenuItem;
  private JMenuItem m_drawPieChartMenuItem, m_drawLineChartMenuItem;
  private JMenuItem m_drawColumnChartMenuItem;

  private JLabel m_descriptionText,m_authorText;
  private JLabel m_titleLabel, m_xAxisLabel, m_yAxisLabel, m_scaleLabel;
  private JLabel m_authorLabel, m_descriptionLabel, m_dataLabel, m_colourLabel;

  private JTextField m_title, m_xAxisTitle, m_yAxisTitle;
  private JTextField m_author, m_description;

  private JComboBox m_scale, m_dataList, m_dataListTwo, m_chartColour;

  private GUIEventHandler m_handler;
  private String m_filename;
  private File m_file;

  public Boolean VisualiserGUI()
  {
    // Init JFileChooser
    m_fc = new JFileChooser();

    // Init Main Window
    m_container = getContentPane();
    m_container.setLayout(new BorderLayout());

    // Init MenuBar
    initMenuBar();
    
    // Add MenuBor to Main Window
    m_container.add(m_menuBar);

    // Init a new GUIEventHandler
    m_handler = new GUIEventHandler();

    // Set Listeners for Interface Elements
    m_openMenuItem.addActionListener(m_handler);
    m_exitMenuItem.addActionListener(m_handler);
    m_drawPieChartMenuItem.addActionListener(m_handler);
    m_drawLineChartMenuItem.addActionListener(m_handler);
    m_drawColumnChartMenuItem.addActionListener(m_handler);

    // Set Size
    setPreferredSize(MIN_SIZE);
    pack();

    // Display
    setLocationRelativeTo(null);
    setJMenuBar(m_menuBar);
    setVisible(true);

    return true;
  }

  private class GUIEventHandler implements ActionListener, KeyListener
  {
    public void keyTyped(KeyEvent ke){}
    public void keyPressed(KeyEvent ke){}
    public void keyReleased(KeyEvent ke){}

    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == m_openMenuItem) {
        if (m_fc.showOpenDialog(m_container) == JFileChooser.APPROVE_OPTION) {
          m_file = m_fc.getSelectedFile();
          m_filename = m_file.getAbsolutePath();
        }

        int i = m_filename.length() - 3;
        int j = m_filename.length();
        if (m_filename.substring(i, j).equals("csv"))
        {
          DataSet.AddData(m_filename);
          displayTableView();
        }
        else
        {
          ErrorHandling err = new ErrorHandling();
          err.WrongType();
        }
      } else if (e.getSource() == m_exitMenuItem) {
        System.exit(0);
      } else if (e.getSource() == m_drawPieChartMenuItem) {
        if (createOptionWindow() == 0) {
          Visualisation.SetTitle(m_title.getText());
          Visualisation.SetDescription(m_description.getText());
          Visualisation.SetAuthor(m_author.getText());
          Object colour = m_chartColour.getSelectedItem();
          Visualisation.SetColour(colour.toString().toLowerCase());
          int i = m_dataList.getSelectedIndex();
          int j = m_dataListTwo.getSelectedIndex();
          PieChart p = new PieChart();
          p.SetData(i, j);
          p.CreateDataset();
          p.SetColourScheme();
          JPanel panel = p.GetChart();
          createWindow("Pie Chart", panel);
        }
      } else if (e.getSource() == m_drawLineChartMenuItem) {
        if (createOptionWindow() == 0) {
          Visualisation.SetTitle(m_title.getText());
          Visualisation.SetDescription(m_description.getText());
          Visualisation.SetAuthor(m_author.getText());
          Object colour = m_chartColour.getSelectedItem();
          Visualisation.SetColour(colour.toString().toLowerCase());
          int i = m_dataList.getSelectedIndex();
          int j = m_dataListTwo.getSelectedIndex();
          LineChart l = new LineChart();
          l.SetData(i, j);
          l.CreateDataset();
          l.SetColourScheme();
          JPanel panel = l.GetChart();
          createWindow("Line Chart", panel);
        }
      } else if (e.getSource() == m_drawColumnChartMenuItem) {
        if (createOptionWindow() == 0) {
          Visualisation.SetTitle(m_title.getText());
          Visualisation.SetDescription(m_description.getText());
          Visualisation.SetAuthor(m_author.getText());
          Object colour = m_chartColour.getSelectedItem();
          Visualisation.SetColour(colour.toString().toLowerCase());
          int i = m_dataList.getSelectedIndex();
          int j = m_dataListTwo.getSelectedIndex();
          ColumnChart c = new ColumnChart();
          c.SetData(i, j);
          c.CreateDataset();
          c.SetColourScheme();
          JPanel panel = c.GetChart();
          createWindow("Column Chart", panel);
        }
      }
    }
  }

  /**
   * Initialises the MenuBar
   * Adds the various elements.
   */
  public void initMenuBar()
  {
    // Initialise MenuBar
    m_menuBar = new JMenuBar();

    // Add Menu Elements
    m_fileMenu = new JMenu("File");
    m_drawMenu = new JMenu("Draw");

    // Add Menu Items to Menu Elements
    m_openMenuItem            = new JMenuItem("Open");
    m_exitMenuItem            = new JMenuItem("Exit");
    m_drawPieChartMenuItem    = new JMenuItem("Pie Chart");
    m_drawLineChartMenuItem   = new JMenuItem("Line Chart");
    m_drawColumnChartMenuItem = new JMenuItem("Column Chart");

    m_fileMenu.add(m_openMenuItem);
    m_fileMenu.add(m_exitMenuItem);

    m_drawMenu.add(m_drawPieChartMenuItem);
    m_drawMenu.add(m_drawLineChartMenuItem);
    m_drawMenu.add(m_drawColumnChartMenuItem);

    // Add Menu Elements to MenuBar
    m_menuBar.add(m_fileMenu);
    m_menuBar.add(m_drawMenu);
  }

  /**
   * Creates a JTable to be displayed in the main container.
   * @param m_filename The full path to the input file.
   */
  public Boolean displayTableView()
  {
    TableView tv = new TableView();

    m_container.removeAll();
    m_container.add(tv.GetTableView(), BorderLayout.CENTER);
    pack();

    return true;
  }

  /**
   * Creates a plain window to be populated with various visualisations.
   * @param windowTitle A string to be used as the JFrame window title.
   * @param panel A JPanel to be added to the JFrame for displaying.
   */
  public void createWindow(String windowTitle, JPanel panel)
  {
    m_frame           = new JFrame(windowTitle);
    m_authorText      = new JLabel();
    m_descriptionText = new JLabel();

    m_authorText.setText("Author: " + Visualisation.GetAuthor());
    m_descriptionText.setText("Description: " + Visualisation.GetDescription());

    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
   
    panel.add(m_authorText);
    panel.add(m_descriptionText);
    m_frame.add(panel);

    m_frame.pack();
    m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    m_frame.setVisible(true);
  }

  /**
   * Creates an option window prior to drawing a visualiton,
   * allowing the user to set titles and axis labels.
   * @param windowTitle A string to be used as the JFrame window title.
   * @return int 0 for OK Button, 2 for Cancel Button.
   */
  public int createOptionWindow()
  {
    // Init a new SpringLayout for aligning interface elements
    SpringLayout layout = new SpringLayout();

    String[] colours = {"Light", "Greyscale", "Default"};

    // Init m_drawPanel
    m_drawPanel = new JPanel();
    m_drawPanel.setLayout(layout);
    m_drawPanel.setPreferredSize(new Dimension(455, 200));

    // Init and set the m_drawPanel elements
    m_titleLabel       = new JLabel("Title: ");
    m_title            = new JTextField(10);
    m_scaleLabel       = new JLabel("Scale: ");
    m_scale            = new JComboBox();
    m_xAxisLabel       = new JLabel("X Axis Label: ");
    m_xAxisTitle       = new JTextField(10);
    m_authorLabel      = new JLabel("Author: ");
    m_author           = new JTextField(10);
    m_yAxisLabel       = new JLabel("Y Axis Label: ");
    m_yAxisTitle       = new JTextField(10);
    m_descriptionLabel = new JLabel("Description: ");
    m_description      = new JTextField(10);
    m_dataLabel        = new JLabel("Data Range: ");
    m_dataList         = new JComboBox(DataSet.GetHeaders());
    m_dataListTwo      = new JComboBox(DataSet.GetHeaders());
    m_colourLabel      = new JLabel("Colour: ");
    m_chartColour      = new JComboBox(colours);

    // Add Elements to m_drawPanel
    m_drawPanel.add(m_titleLabel);
    m_drawPanel.add(m_title);
    m_drawPanel.add(m_scaleLabel);
    m_drawPanel.add(m_scale);
    m_drawPanel.add(m_xAxisLabel);
    m_drawPanel.add(m_xAxisTitle);
    m_drawPanel.add(m_authorLabel);
    m_drawPanel.add(m_author);
    m_drawPanel.add(m_yAxisLabel);
    m_drawPanel.add(m_yAxisTitle);
    m_drawPanel.add(m_descriptionLabel);
    m_drawPanel.add(m_description);
    m_drawPanel.add(m_dataLabel);
    m_drawPanel.add(m_dataList);
    m_drawPanel.add(m_dataListTwo);
    m_drawPanel.add(m_colourLabel);
    m_drawPanel.add(m_chartColour);


    /*
     * Below are a set of constraints that precisely align the
     * elements for an option panel. Changing these may cause
     * elements to overlap, becoming unusable.
     */

    // m_titleLabel
    layout.putConstraint(SpringLayout.WEST, m_titleLabel,
                         5,
                         SpringLayout.WEST, m_drawPanel);
    layout.putConstraint(SpringLayout.NORTH, m_titleLabel,
                         15,
                         SpringLayout.NORTH, m_drawPanel);

    // m_title
    layout.putConstraint(SpringLayout.WEST, m_title,
                         54,
                         SpringLayout.EAST, m_titleLabel);
    layout.putConstraint(SpringLayout.NORTH, m_title,
                         5,
                         SpringLayout.NORTH, m_drawPanel);

    // m_scaleLabel
    layout.putConstraint(SpringLayout.WEST, m_scaleLabel,
                         5,
                         SpringLayout.EAST, m_title);
    layout.putConstraint(SpringLayout.NORTH, m_scaleLabel,
                         15,
                         SpringLayout.NORTH, m_drawPanel);

    // m_scale
    layout.putConstraint(SpringLayout.WEST, m_scale,
                         45,
                         SpringLayout.EAST, m_scaleLabel);
    layout.putConstraint(SpringLayout.NORTH, m_scale,
                         5,
                         SpringLayout.NORTH, m_drawPanel);

    // m_xAxisLabel
    layout.putConstraint(SpringLayout.WEST, m_xAxisLabel,
                         5,
                         SpringLayout.WEST, m_drawPanel);
    layout.putConstraint(SpringLayout.NORTH, m_xAxisLabel,
                         15,
                         SpringLayout.SOUTH, m_titleLabel);

    // m_xAxisTitle
    layout.putConstraint(SpringLayout.WEST, m_xAxisTitle,
                         5,
                         SpringLayout.EAST, m_xAxisLabel);
    layout.putConstraint(SpringLayout.NORTH, m_xAxisTitle,
                         5,
                         SpringLayout.SOUTH, m_title);

    // m_authorLabel
    layout.putConstraint(SpringLayout.WEST, m_authorLabel,
                         5,
                         SpringLayout.EAST, m_xAxisTitle);
    layout.putConstraint(SpringLayout.NORTH, m_authorLabel,
                         15,
                         SpringLayout.SOUTH, m_scaleLabel);

    // m_author
    layout.putConstraint(SpringLayout.WEST, m_author,
                         35,
                         SpringLayout.EAST, m_authorLabel);
    layout.putConstraint(SpringLayout.NORTH, m_author,
                         5,
                         SpringLayout.SOUTH, m_scale);

    // m_yAxisLabel
    layout.putConstraint(SpringLayout.WEST, m_yAxisLabel,
                         5,
                         SpringLayout.WEST, m_drawPanel);
    layout.putConstraint(SpringLayout.NORTH, m_yAxisLabel,
                         15,
                         SpringLayout.SOUTH, m_xAxisLabel);

    // m_yAxisTitle
    layout.putConstraint(SpringLayout.WEST, m_yAxisTitle,
                         5,
                         SpringLayout.EAST, m_yAxisLabel);
    layout.putConstraint(SpringLayout.NORTH, m_yAxisTitle,
                         5,
                         SpringLayout.SOUTH, m_xAxisTitle);

    // m_descriptionLabel
    layout.putConstraint(SpringLayout.WEST, m_descriptionLabel,
                         5,
                         SpringLayout.EAST, m_yAxisTitle);
    layout.putConstraint(SpringLayout.NORTH, m_descriptionLabel,
                         15,
                         SpringLayout.SOUTH, m_authorLabel);

    // m_description
    layout.putConstraint(SpringLayout.WEST, m_description,
                         5,
                         SpringLayout.EAST, m_descriptionLabel);
    layout.putConstraint(SpringLayout.NORTH, m_description,
                         5,
                         SpringLayout.SOUTH, m_author);

    // m_dataLabel
    layout.putConstraint(SpringLayout.WEST, m_dataLabel,
                         5,
                         SpringLayout.WEST, m_drawPanel);
    layout.putConstraint(SpringLayout.NORTH, m_dataLabel,
                         15,
                         SpringLayout.SOUTH, m_yAxisLabel);

    // m_dataList
    layout.putConstraint(SpringLayout.WEST, m_dataList,
                         10,
                         SpringLayout.EAST, m_dataLabel);
    layout.putConstraint(SpringLayout.NORTH, m_dataList,
                         5,
                         SpringLayout.SOUTH, m_yAxisTitle);

    // m_dataListTwo
    layout.putConstraint(SpringLayout.WEST, m_dataListTwo,
                         94,
                         SpringLayout.WEST, m_drawPanel);
    layout.putConstraint(SpringLayout.NORTH, m_dataListTwo,
                         2,
                         SpringLayout.SOUTH, m_dataList);

    // m_colourLabel
    layout.putConstraint(SpringLayout.WEST, m_colourLabel,
                         5,
                         SpringLayout.EAST, m_dataList);
    layout.putConstraint(SpringLayout.NORTH, m_colourLabel,
                         15,
                         SpringLayout.SOUTH, m_descriptionLabel);

    // m_chartColour
    layout.putConstraint(SpringLayout.WEST, m_chartColour,
                         5,
                         SpringLayout.EAST, m_colourLabel);
    layout.putConstraint(SpringLayout.NORTH, m_chartColour,
                         15,
                         SpringLayout.SOUTH, m_description);
    /*
     * End Constraints
     */


    return JOptionPane.showConfirmDialog(null,
                                         m_drawPanel,
                                         "Visualation Options",
                                         JOptionPane.OK_CANCEL_OPTION,
                                         JOptionPane.PLAIN_MESSAGE);
  }
}
