
package cs235a5;

import java.util.ArrayList;
import javax.swing.JTabbedPane;

/**
 *
 * @author Robert
 */
public class TabPannel extends JTabbedPane {
    private ArrayList<Chart> m_charts = new ArrayList<Chart>();

    public int GetNumOfCharts(){
        return m_charts.size();
    }
    public void AddTab(String title, Chart chartPannel){
        super.addTab(title, chartPannel);
        m_charts.add(chartPannel);
    }
    
    public Chart GetTab(int i){
        return m_charts.get(i);
    }
    
    
    public TabPannel(){
        super();
    }
    
    
    
}
