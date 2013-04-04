
package cs235a5;

import java.util.ArrayList;
import javax.swing.JTabbedPane;

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
    
   
    
    
    
}
