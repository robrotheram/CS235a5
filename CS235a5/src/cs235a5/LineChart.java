package cs235a5;

/**
 *
 * \file    LineChart.java
 * \author  Joe Lock, Saeed Mohamed
 * \date    18/02/2013
 *
 * \brief   A Line Chart Class to generate and display
 *          Line Chart visualisation .
 *
 */

// Import JFreeChart
import java.awt.Color;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.*;

// Import Swing Library
import javax.swing.JPanel;

public class LineChart
{
  private double [] m_xValues;
  private double [] m_yValues;
  private String m_chartName;
  private String m_xAxis;
  private String m_yAxis;
  private JFreeChart m_chart;
  private XYSeriesCollection m_collection = new XYSeriesCollection();
  private String m_colourScheme;
  /**
   * Takes user input and puts it into arrays containing the x and y data
   *
   * @param xValues an array containing all the xValues
   * @param yValues an array containing all the y values
   * @return check a boolean flag to ensure data has been set properly
   */
  public void SetData(int segmentOne, int segmentTwo)
  {
    // Get Data
    String[][] dataArray = DataSet.GetData();
    
    // Init Arrays
    m_xValues  = new double[dataArray.length];
    m_yValues = new double[dataArray.length];
    
    // Put Data into Arrays
    for (int i = 0; i < dataArray.length; i++)
    {
      m_xValues[i] = Double.parseDouble(dataArray[i][segmentOne]);
    }
    
    for (int j = 0; j < dataArray.length; j++)
    {
      m_yValues[j] = Double.parseDouble(dataArray[j][segmentTwo]);
    }
  }

  public void SetColourScheme(){
	  
    m_colourScheme = Visualisation.GetColourScheme();
  }
  
  /**
   * Returns the Collection of data on the line chart
   * @return m_collection Returns an XYSeriesCollection of the chart data
   */
  public XYSeriesCollection GetData()
  {
    return m_collection;
  }

  /**
   * Sets the name of the class using the superclases ChartTitle methods
   * @return check boolean flag to ensure name has been set correctly
   */
  public boolean SetName()
  {
    boolean check = false;
    m_chartName = Visualisation.GetChartTitle();

    if (!m_chartName.equals(null))
    {
      check = true;
    }

    return check;
  }

  /**
   * Sets the xaxis title using the GetXLabel method of the super class
   */
  public void SetXAxis()
  {
    m_xAxis = Visualisation.GetXLabel();
  }

  /**
   * Sets the yaxis title using the GetYLabel method of the super class
   */
  public void SetYAxis()
  {
    m_yAxis = Visualisation.GetYLabel();
  }

  /**
   * Creates a dataset of type XYSeries
   */
   public void CreateDataset()
   {
     XYSeries series = new XYSeries("Line Chart");
     
     for (int i =0;i< m_xValues.length;i++)
     {
       series.add(m_xValues[i], m_yValues[i]);
     }

     m_collection.addSeries(series);

   }

   /**
    *
    * Create the line chart using the ChartFactory built into JFreeChart
    * @return m_chart A chart of type JFreeChart
    */
   public JPanel GetChart()
   {
     JFreeChart chart = ChartFactory.createXYLineChart
                                    (m_chartName,
                                     m_xAxis,
                                     m_yAxis,
                                     m_collection,
                                     PlotOrientation.VERTICAL,
                                     true,
                                     true,
                                     false
                                     );
     
     m_chart = chart;
     SetName();
     
     if(m_colourScheme.equals("Greyscale")){
    	  
     	XYPlot plot = (XYPlot)(m_chart.getPlot());
     	XYItemRenderer renderer = (XYItemRenderer) plot.getRenderer();
     	renderer.setSeriesPaint(0, Color.gray);
     	 
      }
      
      else if (m_colourScheme.equals("Light")){
     	XYPlot plot = (XYPlot)(m_chart.getPlot());
      	XYItemRenderer renderer = (XYItemRenderer) plot.getRenderer();
      	renderer.setSeriesPaint(0, Color.green);
     	 
      }
     
     ChartPanel cpanel = new ChartPanel(m_chart);
     JPanel panel = new JPanel();
     panel.add(cpanel);
     return panel;
   }
   
   public JFreeChart GetJChart()
   {
     return m_chart;
   }
}
