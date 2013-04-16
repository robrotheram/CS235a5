
package cs235a5;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/** @brief This class is a extention to the jTabbedPane.

    This Class contains a ArrayList so that the charts can be accessed by other
    * classes
    @author Robert Fletcher
    @file TabPannel.java
    @date April 2013
    */

public class TabPannel extends JTabbedPane {
    private final TabPannel CON = this;
    private ArrayList<Chart> m_charts = new ArrayList<Chart>();
    private int tabCounter;
    private final int SIZE = 10;
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
        
        
        
        
        
   
    JEditorPane ep = new JEditorPane();
    ep.setEditable(false);
    
    

        try {
                BufferedImage im = ImageIO.read(this.getClass().getResource("/assets/images/no.png"));
                ImageIcon i = new ImageIcon(im.getScaledInstance(10,10, Image.SCALE_SMOOTH));
             JButton tabCloseButton = new JButton("");

             tabCloseButton.setIcon(i);
             tabCloseButton.setBorder(BorderFactory.createEmptyBorder());
        //removes content area
        tabCloseButton.setContentAreaFilled(false);
        tabCloseButton.setActionCommand("" + tabCounter);

        ActionListener al;
        al = new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();
            String s1 = btn.getActionCommand();
            for (int i = 0; i < CON.getTabCount(); i++) {
              JPanel pnl = (JPanel) CON.getTabComponentAt(i);
              btn = (JButton) pnl.getComponent(1);
              String s2 = btn.getActionCommand();
              if (s1.equals(s2)) {
                CON.removeTabAt(i);
                break;
              }
            }
          }
        };
        tabCloseButton.addActionListener(al);


          JPanel pnl = new JPanel();
          JLabel l  = new JLabel(title);
          pnl.add(l);
          pnl.setOpaque(false);

            pnl.add(tabCloseButton);

          super.setTabComponentAt(super.getTabCount() - 1, pnl);
          super.setSelectedIndex(super.getTabCount() - 1);


        tabCounter++;

        } catch (IOException ex) {}
   
  
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
        
}
