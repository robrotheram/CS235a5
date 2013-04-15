package cs235a5;

/**
 *
 * \file        ColumnChart.java
 * \author      Robert Fletcher
 * \date        13/04/2013
 *
 * \brief       The Pie Chart Class generates and displays
 *              column chart by inheriting from the Chart class.
 *
 */

// Import JFreeChart
import org.jfree.chart.*;
import java.awt.Rectangle;

import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart extends Chart {
 
  private JFreeChart m_chart;
  
  
    
  @Override
  public boolean SetDataSet(DataSet data){
      super.SetData(data);
      return true;
  }
  
  @Override
  public boolean SetXData(int xData){
      super.SetXData(xData);
      return true;
  }
  
  @Override
  public boolean SetYData(int yData){
      super.SetYData(yData);
      return true;
  }
  
  @Override
  public boolean SetChartTitle(String title){
      super.SetChartTitle(title);
      return true;
  }
  
  @Override
  public boolean SetColourMap(ColourMap colours){
      super.SetColourMap(colours);
      return true;
  }
  
  @Override
  public boolean SetAuthor(String author){
      super.SetAuthor(author);
      return true;
  }
  
  @Override
  public boolean SetDescription(String description){
      super.SetDescription(description);
      return true;
  }
  
  /**
   * Sets the type of chart to the constant BarChart
   * @return true of set correctly;
   */
  public boolean SetChartType(){
      return super.SetChartType(ChartType.PIECHART);
  }
  
  /**
   * returns the chart type PIECHART
   * @return the constant 
   */
  public ChartType getChartType(){
      return super.GetChartType();
  }
  
  /**
   * Returns the X Axis Column Position
   * @return Int X Axis Column Position
   */
  public int GetXData()
  {
    return super.GetXColumnPosition();
  }

  /**
   * Returns the Y Values for the Column
   * @return m_yValues The Y Axis Data
   */
  public int GetYData()
  {
    return super.GetYColumnPosition();
  }

  /**
   * Returns the Description for the Chart
   * @return m_Description a description of the char thats been generated
   */
  @Override
  public String GetDescription(){

    return super.GetDescription();
  }

  /**
   * Returns the name of the Chart
   * @return m_chartName the name of the chart
   */
  @Override
  public String GetTitle()
  {
    return super.GetChartTitle();
  }

     /**
     * constructor setting all class variables needed to create a column chart
     * @param ds - the data for the chart
     * @param xColPosition - the column data for the x axis from the dataset
     * @param yColPosition - the column data for the y axis from the dataset
     * @param title - chart title
     * @param rect - to display the chart in the windows native size
     * @param cm - the colour scheme for the chart
     * @param author - sets the author of the chart
     * @param description - gives the chart a description
     */
  public PieChart (DataSet ds, int xColPosition, int yColPosition, String title, Rectangle rect, ColourMap cm, String author, String description)
  {
     super(ds, xColPosition, yColPosition, title, rect, cm, author, description);
      
  }
  
  /**
   * Creates a dataset of type XYSeries
   */
   private DefaultPieDataset convertDataSet()
  {
        int size = 0;
        int sum = 0;
        int pos = 0;
        int j= 0;
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        DataCell preVal = super.GetDataSet().GetCell(0, 0);
        // Creates a new list for the found elements 
        super.m_foundElements = new ArrayList<String>();

        for(int i= 0; i < super.GetDataSet().GetNumOfRows()-1; i++ ){

            if(!super.isUnique(super.GetDataSet().GetCell(super.GetXColumnPosition(), i).toString())){
                for(j = pos; j < super.GetDataSet().GetNumOfRows()-1; j++ ){
                    if(preVal.toString().equals(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).toString())){


                        //Check if datatype is a number
                        if(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).GetDataType()==DataType.INTEGER){
                            sum += super.GetDataSet().GetCell(super.GetYColumnPosition(), j).GetInteger();  
                        }else if(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).GetDataType()==DataType.DOUBLE){
                            sum += super.GetDataSet().GetCell(super.GetYColumnPosition(), j).GetDouble(); 
                        }
                    }
                }
                super.m_foundElements.add(super.GetDataSet().GetCell(super.GetXColumnPosition(), i).toString());

                //Add to chart dataSet

                dataset.setValue(Integer.toString(super.GetDataSet().GetCell(
                        super.GetXColumnPosition(), (i)).GetInteger()),sum);



                preVal = super.GetDataSet().GetCell(super.GetXColumnPosition(), i++);
                sum=0;//
                pos++;	            
                }
            }
        
        return dataset;
    }
   

   /**
    *
    * Create the pie chart using the ChartFactory built into JFreeChart
    * @return m_chart A chart of type JFreeChart
    */
   @Override
    public JFreeChart createChart(){
        System.out.println("x="+super.GetDataSet().GetHeader());
        
        DefaultPieDataset ds = convertDataSet();
        
        final JFreeChart CHART = ChartFactory.createPieChart(
            super.GetTitle(),         // chart title
            ds,            
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
       
        final PiePlot plot = (PiePlot) CHART.getPlot(); 
         CustomRenderer renderer = new CustomRenderer(); 
        renderer.setColor(plot, ds);
        return CHART;
    }
   
   
   
   /**
     * A renderer specific for this type of chart. Sets the colours that will 
     * be used when displaying the chart.
     */
    class CustomRenderer { 
        private Paint[] colors;
        
        /**
         * The constructor for the custom renderer, which will set the colours
         * of the bars
         */
        public CustomRenderer(){ 
           ColourMap mappedColours = GetColourMap();
           this.colors = new Paint[mappedColours.getColourArray().length];
           for(int i = 0; i<mappedColours.getColourArray().length;i++){
               this.colors[i] = mappedColours.getColour(i);
           }
        }
            
       
        
        /**
         * Accessor method for getting the colours of each column
         * @param row - the identifier of the row it is returning
         * @param column - the identifier of the column it is returning
         * @return the colour of each column 
         */
        public void setColor(PiePlot plot, DefaultPieDataset dataset) 
        { 
            List <Comparable> keys = dataset.getKeys(); 
            int aInt; 
            
            for (int i = 0; i < keys.size(); i++) 
            { 
                aInt = i % this.colors.length; 
                plot.setSectionPaint(keys.get(i), this.colors[aInt]); 
            } 
        } 
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
