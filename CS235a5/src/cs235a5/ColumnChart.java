package cs235a5;

/**
 *
 * \file        ColumnChart.java
 * \author      Mike Smith
 * \date        18/02/2013
 *
 * \brief       A Line Chart Class to generate and display
 *              Line Chart visualisation .
 *
 */

// Import JFreeChart
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;

import java.awt.Color;
import java.io.File;

// Import Swing Library
import javax.swing.JPanel;

public class ColumnChart
{
  private String[][] input_data;
  private String m_Description;
  private double [] m_xValues;
  private double [] m_yValues;
  private String m_chartName;
  private String m_xAxis;
  private String m_yAxis;
  private String m_colourScheme;
  private JFreeChart m_chart;
  
  private XYSeriesCollection m_collection = new XYSeriesCollection();

  /**
   * Takes user input and puts it into arrays containing the x and y data
   *
   * @param xValues an array containing all the xValues
   * @param yValues an array containing all the y values
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
   * Returns the X Values for the Column
   * @return m_xValues The X Axis Data
   */
  public double[] GetXData()
  {
    return m_xValues;
  }

  /**
   * Returns the Y Values for the Column
   * @return m_yValues The Y Axis Data
   */
  public double[] GetYData()
  {
    return m_yValues;
  }


  /**
   * Sets the name of the class using the superclases ChartTitle methods
   * @return check boolean flag to ensure name has been set correctly
   */
  public boolean SetName()
  {
    boolean check = false;
    
    m_chartName = Visualisation.GetChartTitle(); // set chart name
    if (!m_chartName.equals(""))
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
   * Sets the yaxis title using the GetYLabel method of the Visualiser class
   */
  public void SetYAxis()
  {
    m_yAxis = Visualisation.GetYLabel();
  }

  /**
   * Sets the description of the chart.
   */
  public void SetDescription()
  {
    m_Description = Visualisation.GetDescription();
  }

  /**
   * Returns the Description for the Chart
   * @return m_Description a description of the char thats been genarated
   */
  public String GetDescription(){

    return m_Description;
  }

  /**
   * Returns the label for the X Axis
   * @return m_xAxis the label of the xAxis
   */
  public String GetXLabel()
  {
    return m_xAxis;
  }

  /**
   * Returns the label for the Y Axis
   * @return the label of the yAxis
   */
  public String GetYLabel()
  {
    return m_yAxis;
  }

  /**
   * Returns the name of the Chart
   * @return m_chartName the name of the chart
   */
  public String GetName()
  {
    return m_chartName;
  }

  /**
   * Creates a dataset of type XYSeries
   */
   public void CreateDataset()
   {
     
	   XYSeries series = new XYSeries("Column Chart");
     for (int i =0;i< m_xValues.length;i++)
     {
       series.add(m_xValues[i], m_yValues[i]);
     }
     
     m_collection.addSeries(series);
   }

   /**
    *
    * Create the column chart using the ChartFactory built into JFreeChart
    * @return m_chart A chart of type JFreeChart
    */
   public JPanel GetChart()
   {
     JFreeChart chart = ChartFactory.createXYBarChart
                                    (m_chartName,
                                     m_xAxis,
                                     false,
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
   
   /**
    *  A method to return the chart created by this class so it can be outputted.
    * @return m_chart the chart created by this class
    */
   public JFreeChart GetJChart()
   {
     return m_chart;
   }
}
