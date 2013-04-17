/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import TestUI.Test;
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
            , DataSet db, VisualiserGUI.GUIHandler handler, TabPannel tabs){
        // Set all data needed to make charts
        m_chartImages = chartImages;
        m_chartStrings = chartNames;
        m_chartImageDescriptions = chartDescriptions;
        m_intArray = intArray;
        m_db = db;
        m_tabs = tabs;
        this.handler = handler;
        
        // Set up and create the chart selection list
        m_chartListPanel = new JPanel(); 
        m_userColourDisplay = new JPanel();
        m_userColourDisplay.setPreferredSize(new Dimension(200,20));        
        m_chartList = new JList(m_intArray);
        m_chartListRenderer = new ChartOptionPane.ComboBoxRenderer(
                m_chartImages, m_chartImageDescriptions);
        m_chartListRenderer.setPreferredSize(new Dimension(185, 50));
        m_chartList.setCellRenderer(m_chartListRenderer);
        m_chartList.setSelectedIndex(selectedChartIndex);
        Border m_loweredEtched = 
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder m_titledBorder = BorderFactory.createTitledBorder(
                       m_loweredEtched, "Pick a Chart");
        m_chartListPanel.setBorder(m_titledBorder);
        m_chartListPanel.add(m_chartList);
        m_chartListPanel.setSize(new Dimension(350, 300));
        
        //Set up and create the right option panel
        m_rightPanel = new JPanel(new FlowLayout());
        m_rightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,
                10,30));
        m_titleLabel = new JLabel("Chart Title");
        m_chartTitle = new JTextField();
        m_chartTitle.setPreferredSize(new Dimension(200, 30));
        m_xAxisLabel = new JLabel("X Axis Data");
        m_xAxisData = new JComboBox();
        m_xAxisData.setPreferredSize(new Dimension(200,30));
        m_xAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        m_yAxisLabel = new JLabel("Y Axis Data");
        m_yAxisData = new JComboBox();
        m_yAxisData.setPreferredSize(new Dimension(200,30));
        m_authorLabel = new JLabel("Chart Author");
        m_chartAuthor = new JTextField();
        m_chartAuthor.setPreferredSize(new Dimension(200, 30));
        m_descriptionLabel = new JLabel("Chart Description");
        m_chartDescription = new JTextField();
        m_chartDescription.setPreferredSize(new Dimension(200, 30));
        m_yAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //populate combo boxes with values from the table data
            m_colNames = db.GetHeader();
        if(!m_db.isEmpty()){
            for(int i =0; i < m_colNames.length; i++){
                m_xAxisData.addItem(m_colNames[i]);
                m_yAxisData.addItem(m_colNames[i]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please create or "
                        + "add some data before meking a chart. ", 
                        "Inane Error", JOptionPane.ERROR_MESSAGE);
        }
        // Add components to the chart option panel
        m_acceptButton = new JButton("OK");
        m_cancelButton = new JButton("Cancel");
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
        m_rightPanel.add(m_cancelButton);
        m_rightPanel.setPreferredSize(new Dimension(300, 300));
        addHandlers();
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 420));
        this.add(m_chartListPanel, BorderLayout.LINE_START);
        this.add(m_rightPanel, BorderLayout.LINE_END);
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
            } else if (colours == 1){
                return m_coolColour;
            } else if (colours == 2){
                return m_warmColour;
            } else if (colours == 3){
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
        m_acceptButton.addActionListener(new ActionListener(){
            //private final int AREACHART = 0, POLARCHART = 1, BARCHART = 2, LINECHART = 3
            //, PIECHART = 4, SCATTERPLOT = 5;
            @Override
            public void actionPerformed(ActionEvent event) {
                if(GetChartType() == AREACHART){
                    AreaChart areaChart = new AreaChart(m_db, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), areaChart);
                    setVisible(false);
                } else if (GetChartType() == POLARCHART){
                    PolarPlot polarChart = new PolarPlot(m_db, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), polarChart);
                    setVisible(false);
                } else if (GetChartType() == BARCHART){
                    ColumnChart barChart = new ColumnChart(m_db, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), barChart);
                    setVisible(false);
                } else if (GetChartType() == LINECHART){
                    LineChart lineChart = new LineChart(m_db, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), lineChart);
                    setVisible(false);
                } else if (GetChartType() == PIECHART){
                    PieChart pieChart = new PieChart(m_db, GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), pieChart);
                    setVisible(false);
                } else if (GetChartType() == BUBBLECHART){
                    BubbleChart bubbleChart = new BubbleChart(m_db, 
                            GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), bubbleChart);
                    setVisible(false);
                } else if (GetChartType() == SCATTERPLOT){
                    ScatterPlotChart scatterChart = new ScatterPlotChart(m_db, 
                            GetXData(), 
                            GetYData(), GetTitle(),new Rectangle(0,0,
                            m_tabs.getWidth(),m_tabs.getWidth()),
                            GetColours(), GetAuthor(), GetDescription());
                    m_tabs.AddTab(GetTitle(), scatterChart);
                    setVisible(false);
                }
            }
        });
        m_cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
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
        m_colourMapListRenderer.setPreferredSize(new Dimension(200, 50));
        m_colourMapList.setRenderer(m_colourMapListRenderer);
        m_colourMapList.setMaximumRowCount(3);
        
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
                setBackground(list.getBackground());
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
    private final int AREACHART = 0, POLARCHART = 1, BARCHART = 2, LINECHART = 3
            , PIECHART = 4, BUBBLECHART = 5, SCATTERPLOT = 6;
    private JPanel m_chartListPanel;
    private JPanel m_rightPanel;
    private JLabel m_titleLabel, m_authorLabel, m_descriptionLabel,
            m_xAxisLabel, m_yAxisLabel;
    private DataSet m_db;
    private JTextField m_chartTitle, m_chartAuthor, m_chartDescription;
    private JComboBox m_xAxisData, m_yAxisData, m_colourMapList;
    public static JButton m_acceptButton, m_cancelButton;
    private JList m_chartList;
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
    private TabPannel m_tabs;
    private JPanel m_colour1 = new JPanel(), m_colour2 = new JPanel(), 
            m_colour3 = new JPanel(), m_colour4 = new JPanel(), 
            m_colour5 = new JPanel();
    private JPanel[] m_userPanels = new JPanel[] {m_colour1, m_colour2, m_colour3,
        m_colour4, m_colour5};
    private ColourMap m_userColours;
}
