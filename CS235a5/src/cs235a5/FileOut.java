package cs235a5;

import java.io.File;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
*
* \file    FileOut.java
* \author  Joe Lock, Saeed Mohamed
* \date    03/03/2013
*
* \brief   A File Out class that exports the charts to a .png format
*
*/

public class FileOut {
  ErrorHandling err = new ErrorHandling();
  JFreeChart m_outputChart;
  
  /**
   * A method used to output a given chart as a png
   * @param chart - The specific chart to be outputted
   */
  public void outputChart(JFreeChart chart) 
  {    
	m_outputChart = chart;  
	try {
      ChartUtilities.saveChartAsPNG(new File("C:\\chartOutput\\chart.png"), m_outputChart, 1280, 720);
    } catch (Exception e) {
	  err.ChartError();
	  
    }
  }
}
