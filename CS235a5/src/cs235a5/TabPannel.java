
package cs235a5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

/** @brief This class is a extention to the jTabbedPane.

    This Class contains a ArrayList so that the charts can be accessed by other
    * classes
    @author Robert Fletcher
    @file TabPannel.java
    @date April 2013
    */

public class TabPannel extends JTabbedPane {
    
    private ArrayList<Chart> m_charts = new ArrayList<Chart>();

    /**
    * This method returns the number of charts in the list.
    * @return Integer The numbers of charts in the ArrayList.
    **/

    public int GetNumOfCharts(){
        return m_charts.size();
    }
    /**
    * This method adds a chart to the list.
    * @param  String title the title of the chart and the header of the 
    * JTabbedPane
    * @param Chart the chart to be added to the JTabbedPane
    * @return boolean true if added to the list with no errors
    **/
    public boolean AddTab(String title, Chart chartPannel){
        super.addTab(title, chartPannel);
        m_charts.add(chartPannel);
        return true;
    }
    
    /**
     * This Method gets the chart from the array list
     * @param int i the position in the ArrayList
     * @return Chart the chart in the position i in the Array List
     */
    public Chart GetTab(int i){
        return m_charts.get(i);
    }
    
    private class TabButton extends JButton implements ActionListener {
        public TabButton() {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("close this tab");
            //Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = indexOfTabComponent(TabPannel.this);
            if (i != -1) {
                remove(i);
            }
        }
 
        //we don't want to update UI for this button
        public void updateUI() {
        }
 
        //paint the cross
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.MAGENTA);
            }
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }

        private final MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }
 
        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
    }
 
   
    
    
    
}
