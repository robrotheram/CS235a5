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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
            , DataSet db){
        
        m_chartImages = chartImages;
        m_chartStrings = chartNames;
        m_chartImageDescriptions = chartDescriptions;
        m_intArray = intArray;
        
        m_chartListPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 360));
        
        m_chartList = new JList(m_intArray);
        m_chartListRenderer = new ChartOptionPane.ComboBoxRenderer();
        m_chartListRenderer.setPreferredSize(new Dimension(175, 50));
        m_chartList.setCellRenderer(m_chartListRenderer);
        m_chartList.setSelectedIndex(selectedChartIndex);
        
        Border m_loweredEtched = 
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        TitledBorder m_titledBorder = BorderFactory.createTitledBorder(
                       m_loweredEtched, "Pick a Chart");
        
        m_chartListPanel.setBorder(m_titledBorder);
        m_chartListPanel.add(m_chartList);
        m_chartListPanel.setSize(new Dimension(350, 300));
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
        m_rightPanel.add(m_acceptButton);
        m_rightPanel.add(m_cancelButton);
        m_rightPanel.setPreferredSize(new Dimension(300, 300));
        
        this.add(m_chartListPanel, BorderLayout.LINE_START);
        this.add(m_rightPanel, BorderLayout.LINE_END);
        this.setVisible(true);
        
    }
  
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
    private JComboBox m_xAxisData, m_yAxisData;
    private JButton m_acceptButton, m_cancelButton;
    private JList m_chartList;
    private ImageIcon[] m_chartImages;
    private String[] m_chartStrings, m_chartImageDescriptions, m_colNames;
    private Integer[] m_intArray;
    private ChartOptionPane.ComboBoxRenderer m_chartListRenderer;
}
