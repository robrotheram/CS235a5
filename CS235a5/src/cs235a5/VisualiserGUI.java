package cs235a5;

/**
 *
 * \file    visualiserGUI.java
 * \author  John Rowley(Original), Kerry Tolhurst(Built upon for A5)
 * \date    16/02/2013
 *
 * \brief   A Graphical User Interface to read and
 *          display data from a .csv file, and transform
 *          that data into visualisations.
 *
 */

// Import File I/O
import java.io.File;

// Import AWT Library
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
// Import Swing Library
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VisualiserGUI extends JFrame
{
 
    public void setContext(VisualiserGUI con){
        m_Context = con;
    }
    
  public VisualiserGUI() 
  {
    
      
    // Init Main Window
    m_container = getContentPane();
    m_container.setLayout(new BorderLayout());
    m_Context = this;
    m_db = new DataSet();
    handler = new GUIHandler();
    
    // Gets users current resolution
    KIT = m_container.getToolkit();
    SCREENSIZE = KIT.getScreenSize();
    
    // Add MenuBar to Main Window
    initMenuBar();
    
    // Initialise the custom chart combo box
    initChartComboBox();
        try {
            // Add toolbar to main window
            initToolBar();
        } catch (IOException ex) {
            JOptionPane error = new JOptionPane();
        }
   
    // Creates the table and chart display areas of the GUI
    m_chartTabPanel = new TabPannel();
    
    m_pLeft = new JPanel();
    m_pLeft.setLayout(new BorderLayout());
    m_pLeft.setBackground(Color.DARK_GRAY);
    m_pLeft.add(new TableView(m_db,true),BorderLayout.CENTER);
    m_pLeft.validate();
    
    m_SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,m_pLeft, m_chartTabPanel);
    m_SplitPane.setDividerSize(8);
    m_SplitPane.setOneTouchExpandable(false);
    m_SplitPane.setResizeWeight(0.25);
    m_container.add(m_SplitPane, BorderLayout.CENTER);
    
    setPreferredSize(SCREENSIZE);
    pack();

    // Display
    setLocationRelativeTo(null);
    setJMenuBar(m_menuBar);
    setVisible(true);

  }
  
  
    /**
    * Initialises the MenuBar
    * Creates and adds the various elements.
    */
    private void initMenuBar()
    {
        // Create menu bar
        m_menuBar = new JMenuBar();
        
        // Create menus
        m_fileMenu = new JMenu("File");
        m_chartsMenu = new JMenu("Charts");
        m_viewMenu = new JMenu("View");
        m_aboutMenu = new JMenu("About");

        // Create file menu items
        m_newMenuItem = new JMenuItem("New...");
        m_openMenuItem = new JMenuItem("Open");
        m_saveMenuItem = new JMenuItem("Save");
        m_saveAsMenuItem = new JMenuItem("Save As...");
        m_exitMenuItem = new JMenuItem("Exit");
        
        // Add items to file menu
        m_fileMenu.add(m_newMenuItem);
        m_fileMenu.add(m_openMenuItem);
        m_fileMenu.add(m_saveMenuItem);
        m_fileMenu.add(m_saveAsMenuItem);
        m_fileMenu.add(m_exitMenuItem);
        
        // Create charts menu items
        m_newChartMenuItem = new JMenuItem("New Chart...");  
        m_editChartMenuItem = new JMenuItem("Edit Chart");

        // Add items to charts menu
        m_chartsMenu.add(m_newChartMenuItem);
        m_chartsMenu.add(m_editChartMenuItem);
        
        // Create view menu items
        m_colourMapMenuItem = new JMenuItem("Chart colours...");

        // Add items to view menu
        m_viewMenu.add(m_colourMapMenuItem);
        
        // Create about menu items
        m_versionMenuItem = new JMenuItem("Version");
        m_helpDocumentationMenuItem = new JMenuItem("Help...");
        
        //Add menu items to about menu
        m_aboutMenu.add(m_versionMenuItem);
        m_aboutMenu.add(m_helpDocumentationMenuItem);
        
        // Add handlers
        m_openMenuItem.addActionListener(handler);
        
        // Add Menu Elements to MenuBar
        m_menuBar.add(m_fileMenu);
        m_menuBar.add(m_chartsMenu);
        m_menuBar.add(m_viewMenu);
        m_menuBar.add(m_aboutMenu);
        
        m_menuBar.setVisible(true);
    }
    
    /**
     * Initialises the toolbar
     * Creates and adds the components
     * @throws IOException 
     */
    
    private void initToolBar() throws IOException 
    {
        Border m_loweredEtched = 
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        TitledBorder m_titledBorder = BorderFactory.createTitledBorder(
                       m_loweredEtched, "Tools");
       
        m_toolbar = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        m_toolbar.setBorder(m_titledBorder);
        m_toolbar.setPreferredSize(new Dimension(500, 120));
       
        m_newFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/newDocument.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_newFileButton.setPreferredSize(new Dimension(50, 50));
        m_newFileButton.setToolTipText("New File");
        
        m_openFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/openFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_openFileButton.setPreferredSize(new Dimension(50, 50));
        m_openFileButton.setToolTipText("Open File");
        m_saveFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/saveFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_saveFileButton.setPreferredSize(new Dimension(50, 50));
        m_saveFileButton.setToolTipText("Save File");
        m_printFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/printFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_printFileButton.setPreferredSize(new Dimension(50, 50));
        m_printFileButton.setToolTipText("Print File");
            
        m_toolbar.add(m_newFileButton);
        m_toolbar.add(m_openFileButton);
        m_toolbar.add(m_saveFileButton);
        m_toolbar.add(m_printFileButton);
        m_toolbar.add(m_chartListPanel);
        // Add handlers
        
        
        m_openFileButton.addActionListener(handler);
        
        m_toolbar.setVisible(true);
        m_container.add(m_toolbar, BorderLayout.PAGE_START);
        
        // ------ code to remove the chart the tabpanel is displaying ----///
         m_openFileButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                int i = m_chartTabPanel.getSelectedIndex();
                if(i>-1){
                    m_chartTabPanel.remove(m_chartTabPanel.GetTab(i));
                    m_chartTabPanel.validate();

                }
            }});   
    }
    
    /*
     * Creates the custom combo box for chart selection.
     * Creates and adds all needed elements.
     */
    private void initChartComboBox()
    {
        
        m_chartListPanel = new JPanel();
        // Loads the chart images and creates an index
        m_chartListPanel.setLayout(new BorderLayout());
        m_chartImages = new ImageIcon[m_chartImageStrings.length];
        m_intArray = new Integer[m_chartImageStrings.length];
        for (int i = 0; i < m_chartImageStrings.length; i++){
            m_intArray[i] = i;
            try {
               m_chartImages[i] = 
                        new ImageIcon(ImageIO.read(this.getClass().getResource(
                        "/assets/images/" + m_chartImageStrings[i] + ".png"
                        )).getScaledInstance(40, 40, Image.SCALE_SMOOTH));
                m_chartImages[i].setDescription(m_chartImageDescriptions[i]); 
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "There was an error "
                        + "loading the chart icons. Please report this fault"
                        + "to the developers at: \n GroupMS@gmail.com", 
                        "Inane Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
        
        // Creates the combo box
        m_chartList = new JComboBox(m_intArray);
        m_chartListRenderer = new VisualiserGUI.ComboBoxRenderer();
        m_chartListRenderer.setPreferredSize(new Dimension(175, 50));
        m_chartList.setRenderer(m_chartListRenderer);
        m_chartList.setMaximumRowCount(3);
        
        m_chartList.addActionListener(handler);
        m_chartListPanel.add(m_chartList, BorderLayout.PAGE_START);
        m_chartListPanel.setBorder(BorderFactory.createEmptyBorder(10,10,
                10,10));
        
    }
    
    /**
     * Creates and image icon from the image parsed from the path
     * @param path - the image path
     * @return the new image icon
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = VisualiserGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
                return null;
        }
    }
    
    /**
     * Displays the tables from the CSVReaderDialog
     * 
     * @return true if successful, false if not
     */
    public boolean displayTable(){
       Rectangle r =  new Rectangle(0,0,m_pLeft.getWidth(),m_pLeft.getWidth());
       //System.out.println(m_displayArea.getWidth() + " " +m_displayArea.getWidth());
       m_pLeft.removeAll();
       m_pLeft.add(new TableView(m_db, r),BorderLayout.CENTER);
       m_pLeft.validate();
       return true;
    }
    /**
     * Internal custom combo box renderer class
     * Handles how the chart selection combobox will look and feel 
     * and will allow icons in the list for extra visual aid
     */
    class ComboBoxRenderer extends JLabel implements ListCellRenderer 
    {
        private Font uhOhFont;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
        }

        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */
        @Override
        public Component getListCellRendererComponent(
                                           JList list,
                                           Object value,
                                           int index,
                                           boolean isSelected,
                                           boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = ((Integer)value).intValue();

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = m_chartImages[selectedIndex];
            String chart = m_chartImageDescriptions[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText("\r\n" + chart);
                setFont(list.getFont());
            } else {
                setUhOhText(chart + " (no image available)",
                            list.getFont());
            }

            return this;
        }
        
        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }

    public class GUIHandler implements ActionListener, ChangeListener {
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == m_openFileButton){
                //creates a new CSVFileDialog for opening CSV files
                JFrame getFile = new CSVReaderDialog(m_db , m_Context);
                getFile.setVisible(true);
                
            } else if (event.getSource() == m_openMenuItem){
                //creates a new CSVFileDialog for opening CSV files
                JFrame getFile = new CSVReaderDialog(m_db , m_Context);
                getFile.setVisible(true);
            } else if (event.getSource() == m_chartList){
                if (m_db.GetHeader() == null){
                    JOptionPane.showMessageDialog(m_container, "Please create or "
                        + "add some data before meking a chart. ", 
                        "Inane Error", JOptionPane.ERROR_MESSAGE);
                } else  {
                    ChartOptionPane m_chartOptions = new ChartOptionPane(
                        m_chartList.getSelectedIndex(), m_chartImages,
                        m_chartImageStrings, m_chartImageDescriptions, 
                        m_intArray, m_db, handler);
                }
            }
            
        }

        @Override
        public void stateChanged(ChangeEvent change) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    /** Main container objects */
    private Container m_container;
    private final Toolkit KIT;
    private final Dimension SCREENSIZE;
    private DataSet m_db;
    private VisualiserGUI m_Context;
    private GUIHandler handler;
    
    /** Menu bar objects */
    private JMenuBar m_menuBar;
    // Menu bar items
    private JMenu m_fileMenu, m_chartsMenu, m_viewMenu, m_aboutMenu; 
    // File menu items
    private JMenuItem m_newMenuItem, m_openMenuItem, m_saveMenuItem, 
            m_saveAsMenuItem, m_exitMenuItem;
    // Chart menu items
      private JMenuItem m_newChartMenuItem, m_editChartMenuItem;
    // View menu items
    private JMenuItem m_colourMapMenuItem;
    // About menu items
    private JMenuItem m_versionMenuItem, m_helpDocumentationMenuItem;
    
    /** Toolbar objects */
    private JPanel m_toolbar;
    private JButton m_newFileButton;
    private JButton m_openFileButton;
    private JButton m_saveFileButton;
    private JButton m_printFileButton;
    // Custom combo box items
    private ImageIcon[] m_chartImages;
    private String[] m_chartImageDescriptions = {"Area chart", "Polar chart", 
        "Compound bar chart", "Line chart", "Pie chart", 
        "Scatter-plot chart"};;
    private String[] m_chartImageStrings = {"areaChart", "polarChart",
        "compoundBarChart", "lineChart", "pieChart",
        "scatterPlotChart"};
    private Integer[] m_intArray;
    private JComboBox m_chartList;
    private VisualiserGUI.ComboBoxRenderer m_chartListRenderer;
    private JPanel m_chartListPanel;
    
    /** Data and Chart components */
    private JPanel m_tableAndCharts; 
    private TabPannel m_chartTabPanel;
    private TableView m_tablePane;
    
    private JSplitPane m_SplitPane;
    
    private JPanel m_pLeft;
    private JPanel m_pRight;
    
    
   
    
    private JPanel m_drawPanel;
    private JFileChooser m_fc;

    private JLabel m_descriptionText,m_authorText;
    private JLabel m_titleLabel, m_xAxisLabel, m_yAxisLabel, m_scaleLabel;
    private JLabel m_authorLabel, m_descriptionLabel, m_dataLabel, m_colourLabel;

    private JTextField m_title, m_xAxisTitle, m_yAxisTitle;
    private JTextField m_author, m_description;

    private JComboBox m_scale, m_dataList, m_dataListTwo, m_chartColour;

    //private GUIEventHandler m_handler;
    private String m_filename;
    private File m_file;  
}
