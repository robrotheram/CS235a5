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

// Import AWT Library
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
// Import Swing Library
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartPanel;

public class VisualiserGUI extends JFrame
{
    

    public final void setContext(){
        m_Context = this;
    }
    
  public VisualiserGUI() 
  {
    
      
    // Init Main Window
    m_numOfDS = 0;
    m_container = getContentPane();
    m_container.setLayout(new BorderLayout());
    setContext();
    m_db = new DataSet[]{new DataSet(),new DataSet()};
    handler = new VisualiserGUI.GUIHandler();
    
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
    m_chartTabPanel = new TabPanel();
    
    m_pTop = new JPanel();
    m_pTop.setLayout(new BorderLayout());
    m_pTop.setBackground(Color.DARK_GRAY);
    m_pTop.add(new TableView(m_db[0],true),BorderLayout.CENTER);
    m_pTop.validate();
    
    m_pBottom = new JPanel();
    m_pBottom.setLayout(new BorderLayout());
    m_pBottom.setBackground(Color.BLACK);
    m_pBottom.add(new TableView(m_db[1],true),BorderLayout.CENTER);
    m_pBottom.validate();
    
    mTableSpitPane =  new JSplitPane(JSplitPane.VERTICAL_SPLIT,m_pTop,m_pBottom);
    mTableSpitPane.setOneTouchExpandable(true);
    mTableSpitPane.setResizeWeight(WEIGHT);
    
            
    
    m_SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,mTableSpitPane, m_chartTabPanel);
    m_SplitPane.setOneTouchExpandable(false);
    m_SplitPane.setResizeWeight(WEIGHT);
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
        m_aboutMenu = new JMenu("About");

        // Create file menu items
        m_newMenuItem = new JMenuItem("New...");
        m_openMenuItem = new JMenuItem("Open");
        m_saveMenuItem = new JMenuItem("Save");
        m_saveAsMenuItem = new JMenuItem("Save As...");
        m_exitMenuItem = new JMenuItem("Exit");
        m_newMenuImport = new JMenuItem("Import");
        CloudOption = new JMenuItem("The Cloud");
        // Add items to file menu
        m_fileMenu.add(m_newMenuItem);
        m_fileMenu.add(m_openMenuItem);
        m_fileMenu.add(CloudOption);
        m_fileMenu.add(m_saveMenuItem);
        m_fileMenu.add(m_newMenuImport);
        m_fileMenu.add(m_exitMenuItem);
        
        // Create about menu items
        m_versionMenuItem = new JMenuItem("Version");
        
        //Add menu items to about menu
        m_aboutMenu.add(m_versionMenuItem);

        // Add handlers
        m_newMenuItem.addActionListener(handler);
        m_openMenuItem.addActionListener(handler);
        m_saveMenuItem.addActionListener(handler);
        m_newMenuImport.addActionListener(handler);
        m_exitMenuItem.addActionListener(handler);
        CloudOption.addActionListener(handler);
        
        m_versionMenuItem.addActionListener(handler);
        // Add Menu Elements to MenuBar
        m_menuBar.add(m_fileMenu);
        
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
        m_toolbar.setPreferredSize(BOBTHISWILLCONFUSEYOUIFYOUREADITJUSTGOAWAY);
       
        m_newFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/newDocument.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_newFileButton.setPreferredSize(BUTTONSIZE);
        m_newFileButton.setToolTipText("New File");
        
        m_openFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/openFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_openFileButton.setPreferredSize(BUTTONSIZE);
        m_openFileButton.setToolTipText("Open File");
        m_saveFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/saveFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_saveFileButton.setPreferredSize(BUTTONSIZE);
        m_saveFileButton.setToolTipText("Save File");

        m_printFileButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/printFile.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_printFileButton.setPreferredSize(BUTTONSIZE);
        m_printFileButton.setToolTipText("Print File");
         
        m_importButton = new JButton(
                new ImageIcon(ImageIO.read(this.getClass().getResource(
                "/assets/images/importIcon.png")).getScaledInstance(
                40, 40, Image.SCALE_SMOOTH)));
        m_importButton.setPreferredSize(BUTTONSIZE);
        m_importButton.setToolTipText("Import CSV File");
        
        //add components
        m_toolbar.add(m_newFileButton);
        m_toolbar.add(m_openFileButton);
        m_toolbar.add(m_saveFileButton);
        m_toolbar.add( m_importButton);
        m_toolbar.add(m_printFileButton);
        m_toolbar.add(m_chartListPanel);
        
        // Add handlers
        m_newFileButton.addActionListener(handler);
        m_importButton.addActionListener(handler);
        m_openFileButton.addActionListener(handler);
        m_saveFileButton.addActionListener(handler);
        
        m_toolbar.setVisible(true);
        m_container.add(m_toolbar, BorderLayout.PAGE_START);
        
        // ------ code to remove the chart the tabpanel is displaying ----///
         m_openFileButton.addActionListener(new ActionListener(){
            @Override
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
        m_chartListRenderer.setPreferredSize(SIZE);
        m_chartList.setRenderer(m_chartListRenderer);
        m_chartList.setMaximumRowCount(THREE);
        
        m_chartList.addActionListener(handler);
        m_chartListPanel.add(m_chartList, BorderLayout.PAGE_START);
        m_chartListPanel.setBorder(BOARDER);
        
    }
    
  
    /**
     * Creates an image icon from the image parsed from the path
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
       if(m_numOfDS==0){
            Rectangle r =  new Rectangle(0,0,m_pTop.getWidth(),m_pTop.getWidth());
           //System.out.println(m_displayArea.getWidth() + " " +m_displayArea.getWidth());
           m_pTop.removeAll();
           m_pTop.add(new TableView(m_db[m_numOfDS], r),BorderLayout.CENTER);
           m_numOfDS++;
           m_pTop.validate();
           
       }else if(m_numOfDS==1){
           Rectangle r =  new Rectangle(0,0,m_pBottom.getWidth(),m_pBottom.getWidth());
           //System.out.println(m_displayArea.getWidth() + " " +m_displayArea.getWidth());
           m_pBottom.removeAll();
           m_pBottom.add(new TableView(m_db[m_numOfDS], r),BorderLayout.CENTER);
           m_numOfDS++;
           m_pBottom.validate();
           
       }
       
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
        
        /**
         * Set the styling for the error text when creating image icons for the 
         * chart list
         * @param uhOhText
         * @param normalFont 
         */
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }

    public class GUIHandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event) {
            
            
            
            
            if((event.getSource() == m_importButton)||(event.getSource() == m_newMenuImport)){
                //creates a new CSVFileDialog for opening CSV files
                if((m_numOfDS == 0)||(m_numOfDS > 1)){
                 m_numOfDS = 0;
                 JFrame getFile = new CSVReaderDialog(m_db[0], m_Context);
                 getFile.setVisible(true);  
                }else if(m_numOfDS == 1){
                    int i = JOptionPane.showConfirmDialog (null, "Would You Like to inport a second dataset","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
                    if(i == JOptionPane.YES_OPTION){
                        JFrame getFile = new CSVReaderDialog(m_db[1], m_Context);
                        getFile.setVisible(true); 
                    }else if(i== JOptionPane.CANCEL_OPTION){
                        
                    }else if(i == JOptionPane.NO_OPTION){
                        JFrame getFile = new CSVReaderDialog(m_db[0], m_Context);
                        getFile.setVisible(true); 
                    }
                  
                }else{
                }
                
                
            } else if ((event.getSource() == m_newFileButton)||(event.getSource() == m_newMenuItem)){
                
                int i = JOptionPane.showConfirmDialog (null, "Would You Like to Over Overwrite the data","Warning",JOptionPane.YES_NO_OPTION);
                if(i == JOptionPane.YES_OPTION){
                    m_numOfDS = 0;
                    m_db[0] = new DataSet();
                    m_pTop.removeAll();
                    m_pTop.add(new TableView(m_db[0],true),BorderLayout.CENTER);
                    m_pTop.validate();
                    m_db[1] = new DataSet();
                    m_pBottom.removeAll();
                    m_pBottom.add(new TableView(m_db[1],true),BorderLayout.CENTER);
                    m_pBottom.validate();

                    mTableSpitPane.setTopComponent(m_pTop);
                    mTableSpitPane.setTopComponent(m_pBottom);
                    
                    m_chartTabPanel = new TabPanel();
                    m_SplitPane.setLeftComponent(mTableSpitPane);
                    m_SplitPane.setRightComponent(m_chartTabPanel);
                    m_SplitPane.validate();
                }

                
            }else if(event.getSource() == CloudOption){
                CloudDialog cd = new CloudDialog(m_db[0],m_Context);
            } else if ((event.getSource() == m_openFileButton)||(event.getSource() == m_openMenuItem)){
                
                OpenDialog o = new OpenDialog(m_db[0],m_chartTabPanel,m_Context);
                o.ReadFile();

            } else if ((event.getSource() == m_saveFileButton)||(event.getSource() == m_saveMenuItem)){
                
                if(m_chartTabPanel.GetNumOfCharts()<1){
                    JOptionPane.showMessageDialog(m_container, "You can not save that you have not made ", 
                        "Insane Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    SaveDialog s = new SaveDialog(m_db[0],m_chartTabPanel);
                    s.SaveFile();
                }   
            } else if(event.getSource() ==m_exitMenuItem )
            {
                 if(m_chartTabPanel.GetNumOfCharts()>0){
                    
                    SaveDialog s = new SaveDialog(m_db[0],m_chartTabPanel);
                    s.SaveFile();
                 } 
                 System.exit(0);
                
            } else if(event.getSource() == m_printFileButton){
                 int i = m_chartTabPanel.getSelectedIndex();
                 if(i >-1){
                    Chart c =  m_chartTabPanel.GetTab(i);
                    if(c!=null){
                        ChartPanel cp = c.GetChartPannel();
                        cp.createChartPrintJob();
                    }
                 }
            } else if ((event.getSource() == m_chartList)||(event.getSource() ==  m_chartsMenu)){
                if (m_db[0].isEmpty()){
                    JOptionPane.showMessageDialog(m_container, "Please create or "
                        + "add some data before meking a chart. ", 
                        "Inane Error", JOptionPane.ERROR_MESSAGE);
                } else  {
                    ChartOptionPane m_chartOptions = new ChartOptionPane(
                        m_chartList.getSelectedIndex(), m_chartImages,
                        m_chartImageStrings, m_chartImageDescriptions, 
                        m_intArray, m_db, handler, m_chartTabPanel);
                }
            }else if(event.getSource() ==  m_versionMenuItem){
                JOptionPane.showMessageDialog(m_container, "Data Visuliser 2.1\n"+
                                    "Robert Fletcher\n" +
                                    "Kerry Tolhurst\n" +
                                    "William Bray\n" +
                                    "William Jones\n" +
                                    "Alex McDonough\n" +
                                    "Wyler Gu\n" +
                                    "Zhenjie Mu", 
                                    "About",JOptionPane.INFORMATION_MESSAGE);
                
            } 
    

        
    }
}
    /** Main container objects */
    private int m_numOfDS;
    private Container m_container;
    private final Toolkit KIT;
    private final Dimension SCREENSIZE;
    private final int AREACHART = 0, POLARCHART = 1, BARCHART = 2, LINECHART = 3
            , PIECHART = 4, SCATTERPLOT = 5;
    private DataSet[] m_db;
    private VisualiserGUI m_Context;
    private VisualiserGUI.GUIHandler handler;
    
    /** Menu bar objects */
    private JMenuBar m_menuBar;
    // Menu bar items
    private JMenu m_fileMenu, m_chartsMenu, m_viewMenu, m_aboutMenu; 
    // File menu items
    private JMenuItem m_newMenuItem, m_openMenuItem, m_saveMenuItem, 
            m_saveAsMenuItem,m_newMenuImport, m_exitMenuItem, CloudOption;
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
    private JButton m_importButton;
    
    // Custom combo box items
    private ImageIcon[] m_chartImages;
    private String[] m_chartImageDescriptions =new String[] {"Area chart", "Polar chart","Bar chart", "Line chart", "Pie chart", "Bubble Chart","Scatter-plot chart"};
    private String[] m_chartImageStrings = new String[] {"areaChart",
     "polarChart",
     "barChart", 
     "lineChart", 
     "pieChart",
     "bubblesChart",
     "scatterPlotChart"};
    
    private Integer[] m_intArray;
    private JComboBox m_chartList;
    private VisualiserGUI.ComboBoxRenderer m_chartListRenderer;
    private JPanel m_chartListPanel;
    
    /** Data and Chart components */
    private JPanel m_tableAndCharts; 
    private TabPanel m_chartTabPanel;
    private TableView m_tablePane;
    
    private JSplitPane m_SplitPane, mTableSpitPane;
    private VisualiserGUI m_cnt;
    private JPanel m_pTop, m_pBottom;
 
    public static JPanel m_colour1, m_colour2, m_colour3, m_colour4, m_colour5;

    public  JPanel[] m_userPanels = new JPanel[] {m_colour1, m_colour2, m_colour3,
        m_colour4, m_colour5};
    
    
    private final double WEIGHT = 0.5;
    private final Dimension BUTTONSIZE = new Dimension(50,50);
    private final Dimension BOBTHISWILLCONFUSEYOUIFYOUREADITJUSTGOAWAY = new Dimension(500, 120);
    private final Border BOARDER  = BorderFactory.createEmptyBorder(10,10,10,10); 
    private final int THREE = 3;
    private final Dimension SIZE = new Dimension(175, 50);


}
