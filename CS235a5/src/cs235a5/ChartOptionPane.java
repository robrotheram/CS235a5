/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import TestUI.Test;
import animation.Animation;
import animation.AnimationSpeed;
import animation.AnimationType;
import animation.AnimationWait;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * \file    ChartOptionPane.java
 * \author  Kerry Tolhurst
 * \date    12/04/2013
 *
 * \brief   A UI for the chart options allowing the user input any required
 *          information for creating charts and select between different charts.
 *
 */
public class ChartOptionPane extends JFrame{
    
    private final Dimension COLORDIPLAYSZIE = new Dimension(200,20);
    private final Dimension IHATEBOBCODECONVENSIONS = new Dimension(200,50);
    private final Dimension CHARTLISTSIZE =new Dimension(185, 60);
    private final Dimension CHARTLIST = new Dimension(350, 300);
    private final Dimension BUTTONSIZE = new Dimension(350, 100);
    private final Dimension LABLESIZE = new Dimension(200, 30);
    private final Dimension RIGHPANELSIZE =new Dimension(300, 300);
    private final Dimension PANELSIZE =new Dimension(800, 575);
    private final int ColorPostion1 = 1;
    private final int ColorPostion2 = 2;
    private final int ColorPostion3 = 3;
    private final Border BOARDER =BorderFactory.createEmptyBorder(10,10,10,30);
    /**
     * Constructor that passes all data from the main GUI needed to create charts
     * @param selectedChartIndex  The place in the list of charts
     * @param chartImages Chart Icons
     * @param chartNames Names of charts
     * @param chartDescriptions Descriptions of charts
     * @param intArray Integer array used for creating custom list renderer
     * @param db The data 
     * @param handler The main handler for the GUI
     * @param tabs The tabbed panel for charts
     */
    public ChartOptionPane(int selectedChartIndex, ImageIcon[] chartImages,
             String[] chartNames, String[] chartDescriptions, Integer[] intArray
            , DataSet[] db, VisualiserGUI.GUIHandler handler, TabPanel tabs){
        
        m_cnt = this;
        // Set all data needed to make charts
        m_chartImages = chartImages;
        m_chartStrings = chartNames;
        m_chartImageDescriptions = chartDescriptions;
        m_intArray = intArray;
        listModel = new DefaultListModel();
        SlideShowList = new DefaultListModel();
        for(int i = 0; i <intArray.length;i++){
            listModel.addElement(intArray[i]);
        }
        
        
        
        m_db = db;
        m_tabs = tabs;
        this.handler = handler;
        SlideShow = new Animation();
        
        // Set up and create the chart selection list
        m_chartListPanel = new JPanel(); 
        m_userColourDisplay = new JPanel();
        m_userColourDisplay.setPreferredSize(COLORDIPLAYSZIE);        
        m_chartList = new JList(listModel);
        m_chartListRenderer = new ChartOptionPane.ComboBoxRenderer( m_chartImages, m_chartImageDescriptions);
        m_chartListRenderer.setPreferredSize(CHARTLISTSIZE);
        m_chartList.setCellRenderer(m_chartListRenderer);
        m_chartList.setSelectedIndex(selectedChartIndex);
        Border m_loweredEtched = 
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder m_titledBorder = BorderFactory.createTitledBorder(
                       m_loweredEtched, "Pick a Chart");
        m_chartListPanel.setBorder(m_titledBorder);
        m_chartListPanel.add(m_chartList);
        m_chartListPanel.setSize(CHARTLIST);
        
        // Add animation pannel
        m_AnimationListPanel = new JPanel(); 
        m_AnimationListPanel.setLayout(new BorderLayout());
        m_userColourDisplay = new JPanel();
        m_userColourDisplay.setPreferredSize(COLORDIPLAYSZIE);        
        m_AnimationList = new JList(SlideShowList);
        m_chartListRenderer = new ChartOptionPane.ComboBoxRenderer(
                m_chartImages, m_chartImageDescriptions);
        m_chartListRenderer.setPreferredSize(CHARTLISTSIZE);
        m_AnimationList.setCellRenderer(m_chartListRenderer);
        m_AnimationList.setSelectedIndex(selectedChartIndex);
        Border aniListPanelBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        TitledBorder aniListTileBorder = BorderFactory.createTitledBorder(
                      aniListPanelBorder , "Slide Show List");
        m_AnimationListPanel.setBorder(aniListTileBorder);
        m_AnimationListPanel.add(new JScrollPane(m_AnimationList), BorderLayout.CENTER);
        m_AnimationListPanel.setSize(CHARTLIST);
        
        m_SlideShow = new JButton("Start Slide Show");
        m_deleteSlide = new JButton("Delete Slide");
        AnimationSpeed[] s = new AnimationSpeed[]{AnimationSpeed.VERYFAST,
            AnimationSpeed.FAST,AnimationSpeed.SLOW};
        AnimationWait[] w = new AnimationWait[]{AnimationWait.VERYLONG,
            AnimationWait.LONG,AnimationWait.MEDIUM,AnimationWait.SHORT,AnimationWait.VERYSHORT};
        
        m_speed = new JComboBox(s);
        m_wait = new JComboBox(w);
        JLabel speedL = new JLabel("Animation Speed:");
        JLabel waitL = new JLabel("Animation Wait Time:");
        
        m_buttonPanel = new JPanel();
        m_buttonPanel.setLayout(new FlowLayout());
        m_buttonPanel.add(speedL);
        m_buttonPanel.add(m_speed);
        m_buttonPanel.add(waitL);
        m_buttonPanel.add(m_wait);
        m_buttonPanel.add(m_SlideShow);
        m_buttonPanel.add(m_deleteSlide);
        m_buttonPanel.setPreferredSize(BUTTONSIZE);
        m_AnimationListPanel.add(m_buttonPanel,BorderLayout.SOUTH);
        
        
        
        
        //Set up and create the right option panel
        m_rightPanel = new JPanel(new FlowLayout());
        m_rightPanel.setBorder(BOARDER);
        m_titleLabel = new JLabel("Chart Title");
        m_chartTitle = new JTextField();
        m_chartTitle.setPreferredSize(LABLESIZE);
        
        m_datasetLabel = new JLabel("Choose DataSet");
        m_datasetBox = new JComboBox(db);
        m_datasetBox.setPreferredSize(LABLESIZE);
        m_datasetBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        m_datasetBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int pos =m_datasetBox.getSelectedIndex();
           
                if(pos>-1){
                    m_xAxisData.removeAllItems();
                    m_yAxisData.removeAllItems();
               
                
                m_data = m_db[pos];
                m_colNames = m_db[pos].GetHeader();
                if(!m_db[pos].isEmpty()){
                    for(int i =0; i < m_colNames.length; i++){
                        m_xAxisData.addItem(m_colNames[i]);
                        m_yAxisData.addItem(m_colNames[i]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please create or "
                                + "import some data before making a chart. ", 
                                "Inane Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            }
        });
        
        
        m_xAxisLabel = new JLabel("X Axis Data");
        m_xAxisData = new JComboBox();
        m_xAxisData.setPreferredSize(LABLESIZE);
        m_xAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        m_yAxisLabel = new JLabel("Y Axis Data");
        m_yAxisData = new JComboBox();
        m_yAxisData.setPreferredSize(LABLESIZE);
        m_authorLabel = new JLabel("Chart Author");
        m_chartAuthor = new JTextField();
        m_chartAuthor.setPreferredSize(LABLESIZE);
        m_descriptionLabel = new JLabel("Chart Description");
        m_chartDescription = new JTextField();
        m_chartDescription.setPreferredSize(LABLESIZE);
        m_yAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //populate combo boxes with values from the table data
        
        // Add components to the chart option panel
        m_acceptButton = new JButton("Add Chart");
        m_cancelButton = new JButton("Cancel");
        m_addSlideShow = new JButton("Add to SlideShow");
        m_rightPanel.add(m_datasetLabel);
        m_rightPanel.add(m_datasetBox);
        m_rightPanel.add(m_titleLabel);
        m_rightPanel.add(m_chartTitle);
        m_rightPanel.add(m_xAxisLabel);
        m_rightPanel.add(m_xAxisData);
        m_rightPanel.add(m_yAxisLabel);
        m_rightPanel.add(m_yAxisData);
        m_rightPanel.add(m_authorLabel);
        m_rightPanel.add(m_chartAuthor);
        m_rightPanel.add(m_descriptionLabel);
        m_rightPanel.add(m_chartDescription);
        initColourList();
        m_rightPanel.add(m_colourCheck);
        m_rightPanel.add(m_userColourDisplay);
        m_rightPanel.add(m_acceptButton);
        m_rightPanel.add(m_addSlideShow);
        m_rightPanel.add(m_cancelButton);
        m_rightPanel.setPreferredSize(RIGHPANELSIZE);
        addHandlers();
        this.setLayout(new BorderLayout());
        this.setSize(PANELSIZE);
        this.add(m_chartListPanel, BorderLayout.WEST);
        this.add(m_rightPanel, BorderLayout.CENTER);
        this.add(m_AnimationListPanel,BorderLayout.EAST);
        
        changeLabel();
        this.setVisible(true);
        
    }
    
    /**
     * Returns the index of the selected chart in the list
     * @return int the position of the chart in the list
     */
    public int GetChartType(){
        return m_chartList.getSelectedIndex();
    }
    
    /**
     * Returns the title in the option pane
     * @return String - the title
     */
    public String GetTitle(){
        return m_chartTitle.getText();
        
    }
    
    /**
     * Returns position of the column of data in the array that has been chosen 
     * to be used as the data for the X axis
     * @return int
     */
    public int GetXData(){
        return m_xAxisData.getSelectedIndex();
    }
    
    /**
     * Returns position of the column of data in the array that has been chosen 
     * to be used as the data for the Y axis
     * @return int
     */
    public int GetYData(){
        return m_yAxisData.getSelectedIndex();
    }
    
    /**
     * Gets the author from the option pane
     * @return String
     */
    public String GetAuthor(){
        return m_chartAuthor.getText();
    }
    
    /**
     * Gets the chart description from the option pane
     * @return String
     */
    public String GetDescription(){
        return m_chartDescription.getText();
    }
    
    /**
     * Gets the colours from the chart panel to be displayed
     * @return Colourmap
     */
    public ColourMap GetColours(){
        int colours = m_colourMapList.getSelectedIndex();
        if (m_colourCheck.isSelected()){
           return m_userColours; 
        } else {
            if(colours == 0){
                return m_defaultColour;
            } else if (colours == ColorPostion1){
                return m_coolColour;
            } else if (colours == ColorPostion2){
                return m_warmColour;
            } else if (colours == ColorPostion3){
                return m_colourBlindMap;
            } else {
                return m_purpleMonoColour;
            }
        }
    }
    
    /**
     * Adds handlers to relevant objects
     */
    private void addHandlers(){
        m_colourCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(m_colourCheck.isSelected()){
                   m_userColours = new UserColormap();
                    for (int i = 0; i < m_userColours.getColourArray().length;
                            i++){
                        m_userPanels[i].setBackground(
                                m_userColours.getColour(i));
                        m_userColourDisplay.add(
                                m_userPanels[i]);
                    }
                    m_userColourDisplay.validate();
                    m_userColourDisplay.repaint();
                    
               }
            }
        });
        
       m_addSlideShow.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                SlideShowList.addElement(GetChartType());
                m_data = m_db[0];
                JPanel ch1 = getChart();
                m_data = m_db[1];
                JPanel ch2 = getChart();
                SlideShow.addBiCharts(
                        ch1, 
                        ch2, 
                        AnimationType.LEFT, 
                        (AnimationSpeed) m_speed.getSelectedItem(), 
                        (AnimationWait) m_wait.getSelectedItem());
             
                        
            } 
       });
       m_SlideShow.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                SlideShow.setSpeed((AnimationSpeed) m_speed.getSelectedItem());
                SlideShow.setWait((AnimationWait) m_wait.getSelectedItem());
                
                SlideShow.setVisible(true);
                        
            } 
       });
     m_deleteSlide.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                SlideShowList.removeElementAt(m_AnimationList.getSelectedIndex());
                SlideShow.removeSlide(m_AnimationList.getSelectedIndex() );
            } 
       });
       
       
       
        
        m_acceptButton.addActionListener(new ActionListener(){
            //private final int AREACHART = 0, POLARCHART = 1, BARCHART = 2, LINECHART = 3
            //, PIECHART = 4, SCATTERPLOT = 5;
            @Override
            public void actionPerformed(ActionEvent event) {
                
                m_tabs.AddTab(GetTitle(),getChart());
            }
        });
        m_cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                m_cnt.dispose();
            }
        });
        
        m_chartList.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                
                
            
            }
        });
 
        
    }
    /**
     * Method to get the chard depending what the user clicked in the List Box
     * @return Chart the Bar,PieScatter etc chart with all the data the user inputted
     */
    
    private Chart getChart(){
        if(GetChartType() == AREACHART){
                    AreaChart areaChart = new AreaChart(m_data, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(areaChart);
                    
                } else if (GetChartType() == POLARCHART){
                    PolarPlot polarChart = new PolarPlot(m_data, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(polarChart);
                    
                } else if (GetChartType() == BARCHART){
                    ColumnChart barChart = new ColumnChart(m_data, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(barChart);
                    
                } else if (GetChartType() == LINECHART){
                    LineChart lineChart = new LineChart(m_data, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(lineChart);
                    
                } else if (GetChartType() == PIECHART){
                    PieChart pieChart = new PieChart(m_data, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(pieChart);
                    
                } else if (GetChartType() == BUBBLECHART){
                    BubbleChart bubbleChart = new BubbleChart(m_data, 
                            GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return(bubbleChart);
                    
                } else if (GetChartType() == SCATTERPLOT){
                    ScatterPlotChart scatterChart = new ScatterPlotChart(m_data, 
                            GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    return scatterChart;
                }else{
                    return null;
                }
                
    }
    /**
     * Method for changing the Axis labels depending what chart is used
     */
    private void changeLabel(){
        if(GetChartType() == AREACHART){
                     m_xAxisLabel.setText("X Axis Data");
                     m_yAxisLabel.setText("Y Axis Data");
                } else if (GetChartType() == POLARCHART){
                    m_xAxisLabel.setText("Radius Data:");
                    m_yAxisLabel.setText("Theata Data:");
                    
                } else if (GetChartType() == BARCHART){
                    m_xAxisLabel.setText("X Axis Data");
                    m_yAxisLabel.setText("Y Axis Data");
                    
                } else if (GetChartType() == LINECHART){
                    m_xAxisLabel.setText("X Axis Data");
                    m_yAxisLabel.setText("Y Axis Data");
                } else if (GetChartType() == PIECHART){
                    m_xAxisLabel.setText("Catagory :");
                    m_yAxisLabel.setText("Data Value for Catagory :");
                    
                } else if (GetChartType() == BUBBLECHART){
                    m_xAxisLabel.setText("X Axis Data");
                    m_yAxisLabel.setText("Y Axis Data");
                    
                } 
    }
    
    /**
     * Creates the custom list for choosing colour schemes
     */
    private void initColourList()
    {
        m_colourListPanel = new JPanel();
        // Loads the chart images and creates an index
        m_colourListPanel.setLayout(new BorderLayout());
        m_colourKeys = new ImageIcon[m_colourMapNames.length];
        m_intArray2 = new Integer[m_colourMapNames.length];
        for (int i = 0; i < m_colourMapNames.length; i++){
            m_intArray2[i] = i;
            m_colourKeys[i] = m_colourMaps[i].getPanels();
            m_chartImages[i].setDescription(m_colourMapNames[i]); 
            
        }
        
        // Creates the combo box
        m_colourMapList = new JComboBox(m_intArray2);
        m_colourMapListRenderer = new ChartOptionPane.ComboBoxRenderer(
                m_colourKeys, m_colourMapNames);
        m_colourMapListRenderer.setPreferredSize(IHATEBOBCODECONVENSIONS);
        m_colourMapList.setRenderer(m_colourMapListRenderer);
        m_colourMapList.setMaximumRowCount(ColorPostion3);
        
        //m_colourMapList.addActionListener(handler);
        m_colourListPanel.add(m_colourMapList, BorderLayout.PAGE_START);

        m_rightPanel.add(m_colourListPanel);
    }
    
    /**
     * Custom renderer class for both the Chart list and the Colours list
     */
    class ComboBoxRenderer extends JLabel implements ListCellRenderer 
    {
        private Font uhOhFont;
        private Object[] m_images;
        private String[] m_descriptions;

        /**
         * Constructor passing all the information needed to initialise the 
         * renderer
         * @param images the icons for the list items
         * @param descriptions the descriptions for the icons
         */
        public ComboBoxRenderer(Object[] images, String[] descriptions) {
            setOpaque(true);
            setHorizontalAlignment(LEFT);
            setVerticalAlignment(CENTER);
            m_images = images;
            m_descriptions = descriptions;
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
                setBackground(m_cnt.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = (ImageIcon)m_images[selectedIndex];
            String chart = m_descriptions[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(chart);
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
    private Animation SlideShow;
    private ChartOptionPane m_cnt;
    private DefaultListModel listModel,SlideShowList;
    private DataSet m_data;
    private final int AREACHART = 0, POLARCHART = 1, BARCHART = 2, LINECHART = 3
            , PIECHART = 4, BUBBLECHART = 5, SCATTERPLOT = 6;
    private JPanel m_chartListPanel;
    private JPanel m_rightPanel,m_AnimationListPanel,m_buttonPanel;
    private JLabel m_titleLabel, m_authorLabel, m_descriptionLabel,
            m_xAxisLabel, m_yAxisLabel,m_datasetLabel;
    private DataSet[] m_db;
    private JTextField m_chartTitle, m_chartAuthor, m_chartDescription;
    private JComboBox m_xAxisData, m_yAxisData, m_colourMapList,m_datasetBox,m_speed,m_wait;
    public static JButton m_acceptButton, m_cancelButton,m_addSlideShow, m_SlideShow, m_deleteSlide;
    private JList m_chartList, m_AnimationList;
    private ImageIcon[] m_chartImages, m_colourKeys;
    private String[] m_chartStrings, m_chartImageDescriptions, m_colNames;
    private Integer[] m_intArray, m_intArray2;
    // Set up the colourmaps
    private ColourMap m_defaultColour = new ColourMap(new Color[] {
        new Color(2,89,89), new Color(0,175,181), new Color(189,51,103), 
        new Color(242,206,22), new Color(204,135,4)});
    private ColourMap m_coolColour = new ColourMap(new Color[] {
        new Color(104,186,45), new Color(0,145,63), new Color(0,147,142), 
        new Color(0,147,221),  new Color(0,68,142)});
    private ColourMap m_warmColour = new ColourMap(new Color[] {
        new Color(225,244,0), new Color(242,173,25), new Color(232,119,25), 
        new Color(224,86,22), new Color(216,38,28)});
    private ColourMap m_colourBlindMap = new ColourMap(new Color[] {
        new Color(252,162,0), new Color(53,181,230), new Color(41,141,114), 
        new Color(240,107,19), new Color(247,236,40)});
    private ColourMap m_purpleMonoColour = new ColourMap(new Color[] {
        new Color(105,152,245), new Color(208,136,208), new Color(169,117,204), 
        new Color(126,87,162), new Color(92,67,139)});
    private ColourMap[] m_colourMaps = new ColourMap[] {m_defaultColour, 
        m_coolColour, m_warmColour, m_colourBlindMap, m_purpleMonoColour};
    private String[] m_colourMapNames ={"Default", "Cool Colours", 
        "Warm Colours", "ColourBlind Friendly", "Purple Monochrome"};
    private ChartOptionPane.ComboBoxRenderer m_chartListRenderer, 
            m_colourMapListRenderer;
    private JPanel m_colourListPanel;
    private JPanel m_userColourDisplay;
    private JCheckBox m_colourCheck = new JCheckBox("Want to use custom colours?");
    private VisualiserGUI.GUIHandler handler;
    private TabPanel m_tabs;
    private JPanel m_colour1 = new JPanel(), m_colour2 = new JPanel(), 
            m_colour3 = new JPanel(), m_colour4 = new JPanel(), 
            m_colour5 = new JPanel();
    private JPanel[] m_userPanels = new JPanel[] {m_colour1, m_colour2, m_colour3,
        m_colour4, m_colour5};
    private ColourMap m_userColours;
  
}



