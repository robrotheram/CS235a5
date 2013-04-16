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
 * @author Kerry Tolhurst
 */
public class ChartOptionPane extends JFrame{
    
    public ChartOptionPane(int selectedChartIndex, ImageIcon[] chartImages,
             String[] chartNames, String[] chartDescriptions, Integer[] intArray
            , DataSet db, VisualiserGUI.GUIHandler handler){
        // Set all data needed to make charts
        m_chartImages = chartImages;
        m_chartStrings = chartNames;
        m_chartImageDescriptions = chartDescriptions;
        m_intArray = intArray;
        this.handler = handler;
        
        // Set up and create the chart selection list
        m_chartListPanel = new JPanel(); 
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
        m_xAxisData.setMaximumSize(new Dimension(110,30));
        m_xAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        m_yAxisLabel = new JLabel("Y Axis Data");
        m_yAxisData = new JComboBox();
        m_yAxisData.setMaximumSize(new Dimension(110,30));
        m_authorLabel = new JLabel("Chart Author");
        m_chartAuthor = new JTextField();
        m_chartAuthor.setPreferredSize(new Dimension(200, 30));
        m_descriptionLabel = new JLabel("Chart Description");
        m_chartDescription = new JTextField();
        m_chartDescription.setPreferredSize(new Dimension(200, 30));
        m_yAxisData.setAlignmentX(Component.CENTER_ALIGNMENT);
        //populate combo boxes with values from the table data
        m_colNames = db.GetHeader();
        for(int i =0; i < m_colNames.length; i++){
            m_xAxisData.addItem(m_colNames[i]);
            m_yAxisData.addItem(m_colNames[i]);
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
        m_rightPanel.add(m_acceptButton);
        m_rightPanel.add(m_cancelButton);
        m_rightPanel.setPreferredSize(new Dimension(300, 300));
        
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 370));
        this.add(m_chartListPanel, BorderLayout.LINE_START);
        this.add(m_rightPanel, BorderLayout.LINE_END);
        this.setVisible(true);
        
    }
    
    private void addHandlers(){
        m_colourCheck.addChangeListener(handler);
    }
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
        //m_colourListPanel.setBorder(BorderFactory.createEmptyBorder(10,10,
                //10,10));
        
        m_rightPanel.add(m_colourListPanel);
    }
    
    class ComboBoxRenderer extends JLabel implements ListCellRenderer 
    {
        private Font uhOhFont;
        private Object[] m_images;
        private String[] m_descriptions;

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
    
    private JPanel m_chartListPanel;
    private JPanel m_rightPanel;
    private JLabel m_titleLabel, m_authorLabel, m_descriptionLabel,
            m_xAxisLabel, m_yAxisLabel;
    private JTextField m_chartTitle, m_chartAuthor, m_chartDescription;
    private JComboBox m_xAxisData, m_yAxisData, m_colourMapList;
    private JButton m_acceptButton, m_cancelButton;
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
    private JCheckBox m_colourCheck = new JCheckBox("Custom Colours?");
    private VisualiserGUI.GUIHandler handler;
}
