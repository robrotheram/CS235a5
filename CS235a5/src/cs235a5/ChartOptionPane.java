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
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Kerry Tolhurst
 */
public class ChartOptionPane extends JFrame{
    
    public ChartOptionPane(int selectedChartIndex, ImageIcon[] chartImages,
             String[] chartNames, String[] chartDescriptions, Integer[] intArray){
        
        m_chartImages = chartImages;
        m_chartStrings = chartNames;
        m_chartImageDescriptions = chartDescriptions;
        m_intArray = intArray;
        
        m_chartListPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 350));
        
        m_chartList = new JList(m_intArray);
        m_chartListRenderer = new ChartOptionPane.ComboBoxRenderer();
        m_chartListRenderer.setPreferredSize(new Dimension(175, 50));
        m_chartList.setCellRenderer(m_chartListRenderer);
        //m_chartList.setMaximumRowCount(3);
        
        m_chartListPanel.add(new JScrollPane(m_chartList));
        m_rightPanel = new JPanel(new BorderLayout());
        
        m_chartListPanel.setPreferredSize(new Dimension(325, 350));
        this.add(m_chartListPanel, BorderLayout.LINE_START);
        this.add(m_rightPanel, BorderLayout.LINE_END);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    private JLabel m_titleLabel, m_authorLabel, m_descriptionLabe,
            m_xAxisLabel, m_yAxisLabel;
    private JTextField m_chartTitle, m_chartAuthor, m_chartDescription;
    private JComboBox m_xAxisData, m_yAxisData;
    private JButton m_optionsAcceptButton, m_optionsCancelButton;
    private JList m_chartList;
    private ImageIcon[] m_chartImages;
    private String[] m_chartStrings;
    private String[] m_chartImageDescriptions;
    private Integer[] m_intArray;
    private ChartOptionPane.ComboBoxRenderer m_chartListRenderer;
}
