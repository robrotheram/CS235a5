package cs235a5;

/**
 * \file        PieChart.java
 * \author      Mike Smith
 * \date        17/02/2013
 *
 * \brief A class to create a Pie Chart
 *
 */

// Import File I/O
import java.awt.Color;
import java.io.File;

// Import JFreeChart
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot;

// Import Swing Library
import javax.swing.JPanel;

public class PieChart
{
  private DefaultPieDataset m_pieDataSet;
  private String[] m_chartSegmentNames;
  private double[] m_chartSegmentValues;
  private String m_Description;
  private String m_chartName;
  private String m_colourScheme;
  private JFreeChart m_chart;

  /**
   * Puts inputted data into arrays that can be used to create the pie chart
   * @param segmentNames  Array containing pie chart segment names
   * @param segmentValues  Array containing pie chart segment values
   */
  public void SetData(int segmentOne, int segmentTwo)
  {
    // Get Data
    String[][] dataArray = DataSet.GetData();

    // Init Arrays
    m_chartSegmentNames  = new String[dataArray.length];
    m_chartSegmentValues = new double[dataArray.length];

    // Add Data to Arrays
    for (int i = 0; i < dataArray.length; i++)
    {
      m_chartSegmentNames[i] = dataArray[i][segmentOne];
    }

    for (int j = 0; j < dataArray.length; j++)
    {
      m_chartSegmentValues[j] = Double.parseDouble(dataArray[j][segmentTwo]);
    }
  }

  /**
   * Returns a  pie dataset through a get method
   * @return m_pieDataSet The pie charts dataset.
   */
  public DefaultPieDataset GetData()
  {
    return m_pieDataSet;
  }

  /**
   * Takes a string as input and sets the name of the chart
   *
   * @param name The chart's name
   * @return check  A boolean flag to ensure the data is set correctly
   */
  public boolean SetName()
  {
    boolean check = false;

    m_chartName = Visualiser.GetChartTitle(); // set chart name
    if (!m_chartName.equals(""))
    {
      check = true;
    }

    return check;
  }

  /**
   * Sets the description of the chart
   */
  public void SetDescription()
  {
    m_Description = Visualiser.GetDescription();
  }

  /**
  *
  * @return m_Description the charts description
  */
  public String GetDescription()
  {
    return m_Description;
  }

  /**
   * Get the Chart Name
   * @return m_chartName the charts title
   */
  public String GetName()
  {
    return m_chartName;
  }

  public void SetColourScheme(){

    m_colourScheme = Visualiser.GetColourScheme();
  }

  /**
   * Creates a piechart dataset
   */
   public void CreateDataset()
   {
     DefaultPieDataset dataset = new DefaultPieDataset();

     for(int i =0; i< m_chartSegmentNames.length;i++)
     {
       //Fill the dataset with segment names and values
       dataset.setValue(m_chartSegmentNames[i], m_chartSegmentValues[i]);
     }

     m_pieDataSet = dataset;
   }

   /**
    * Creates a pie chart using the ChartFactory with JFreeChart
    * @param PieDataset A dataset in the form or a pie chart
    * @return chart An object of type JFreeChart
    */
   public JPanel GetChart()
   {
     JFreeChart chart = ChartFactory.createPieChart(
                        m_chartName, //Chart Name
                        m_pieDataSet,//Pie Chart Dataset
                        true,//show legend
                        true,// ToolTipes
                        false //Configure chart to show URL's
                        );

     m_chart = chart;
     SetName();
     m_chart.setTitle(m_chartName);

     if(m_colourScheme.equals("Greyscale"))
     {
       PiePlot plot = (PiePlot) m_chart.getPlot();
       int m_ColourNumber = 0;

       for(int i=0 ; i < m_pieDataSet.getItemCount(); i++)
       {
         if(m_ColourNumber < 255)
         {
           m_ColourNumber +=3;
         }

         plot.setSectionPaint(i,
              new Color(m_ColourNumber,m_ColourNumber,m_ColourNumber));
       }

       m_chart.setBorderVisible(true);
     } else if (m_colourScheme.equals("Light")){
       PiePlot plot = (PiePlot) m_chart.getPlot();
       for(int i = 0; i < m_pieDataSet.getItemCount(); i++)
       {
         if(i % 5 == 0)
         {
           plot.setSectionPaint(i, Color.red);
         }
         else if (i % 4 == 0)
         {
           plot.setSectionPaint(i, Color.blue);
         }
         else if (i % 3 == 0)
         {
           plot.setSectionPaint(i, Color.green);
         }
         else if (i % 2 == 0)
         {
           plot.setSectionPaint(i, Color.pink);
         }
         else
         {
           plot.setSectionPaint(i, Color.yellow);
         }
       }
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
