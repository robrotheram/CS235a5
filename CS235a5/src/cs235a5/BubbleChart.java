/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.data.xy.MatrixSeriesCollection;
import org.jfree.data.xy.NormalizedMatrixSeries;
import org.jfree.data.xy.XYDataset;

/**
 *\file     BubbleChart.java
 *\author   Robert Fletcher & Zhenjie Mu
 *\date     April 2013
 * 
 * \brief   A Bubble Chart class to generate and display Bubble Chart visualisation
 */


public class BubbleChart extends Chart{
   
  private JFreeChart m_chart;

   /**Allows access for setting the dataset
  * Sets the data set to be used to produce a graph
  *
  * @param data dataset to be set
  * @return returns true is set if successful
  */
  @Override
  public boolean SetDataSet(DataSet data){
      super.SetData(data);
      return true;
  }
  
  /**Sets access for the x axis data 
   * Allows access for setting the x axis data to be used for making charts
   *
   * @param xData
   * @return
   */
  @Override
  public boolean SetXData(int xData){
      super.SetXData(xData);
      return true;
  }
  
  /**Sets access for the y axis data
   * Allows access for setting the y axis data to be used for making charts
   *
   * @param xData
   * @return
   */
  @Override
  public boolean SetYData(int yData){
      super.SetYData(yData);
      return true;
  }
  
  /** Sets the title of the Chart
   * Alllows access for setting a title to be used with the chart
   *
   * @param title
   * @return Chart title of the Chart;
   */
  @Override
  public boolean SetChartTitle(String title){
      super.SetChartTitle(title);
      return true;
  }
  
  /**Returns the colourmap selected
   * Sets the colour to be applied to the chart
   *
   * @param colours
   * @return colourmap set of the Chart;
   */
  @Override
  public boolean SetColourMap(ColourMap colours){
      super.SetColourMap(colours);
      return true;
  }
  
  /**Returns an author
   * sets the author's name to be used on the chart
   *
   * @param author
   * @return author of the Chart;
   */
  @Override
  public boolean SetAuthor(String author){
      super.SetAuthor(author);
      return true;
  }
  
  /**sets the description
   * sets a description to inform the user what the chart represents
   *
   * @param description
   * @return description of the Chart class;
   */
  @Override
  public boolean SetDescription(String description){
      super.SetDescription(description);
      return true;
  }
  
  /**Sets the Chart type
   * Sets the type of chart to the constant BubbleChart
   * 
   * @return true of set correctly;
   */
  public boolean SetChartType(){
      return super.SetChartType(ChartType.BUBBLECHART);
  }
  
  /** Returns the chert type
   * returns what kind of chart is being created
   * 
   * @return the constant LINECHART
   */
  public ChartType getChartType(){
      return super.GetChartType();
  }
  
  /**Returns the X Axis Column Position
   * Returns the X axis column position of data to be 
   * used on the graph
   * 
   * @return Int X Axis Column Position
   */
  public int GetXData(){
    return super.GetXColumnPosition();
  }

  /**Returns the Y Values for the Column
   * Returns the Y axis column position of data to be 
   * used on the graph
   * 
   * @return m_yValues The Y Axis Data
   */
  public int GetYData(){
    return super.GetYColumnPosition();
  }

  /**Returns the Description for the Chart
   * Returns the description of the what the chart represents
   * 
   * @return m_Description a description of the char thats been generated
   */
  @Override
  public String GetDescription(){
    return super.GetDescription();
  }

  /**Returns the name of the Chart
   * returns the chart title to identify what the chart is called
   * @return m_chartName the name of the chart
   */
  @Override
  public String GetTitle(){
    return super.GetChartTitle();
  }
  
  
    /**Creates class variables for a bubble chart
     * constructor setting all class variables needed to create a bubble chart
     * @param ds - the data for the chart
     * @param xColPosition - the column data for the x axis from the dataset
     * @param yColPosition - the column data for the y axis from the dataset
     * @param title - chart title
     * @param rect - to display the chart in the windows native size
     * @param cm - the colour scheme for the chart
     * @param author - sets the author of the chart
     * @param description - gives the chart a description
     */
  public BubbleChart (DataSet ds, int xColPosition, int yColPosition, String title, Rectangle rect, ColourMap cm, String author, String description)
  {
     super(ds, xColPosition, yColPosition, title, rect, cm, author, description,ChartType.BUBBLECHART);
  }
    
  /**
   * Creates a dataset of type XYSeries
   */
     public MatrixSeriesCollection convertDataSet()
             
  {
        ArrayList<Integer>xVal = new ArrayList<Integer>();
        ArrayList<Integer>yVal = new ArrayList<Integer>();
        ArrayList<Double>sumVal = new ArrayList<Double>();
        
        int size = 0;                            //Initalises the size variable
        int sum = 0;                             //Initalises the total number variable
        int pos = 0;                             //Initalises the position variable
        int j= 0;                                //Initalises the increment value for the for loop                   
        


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

                
                
                 int x=  preVal.GetInteger();
                 int y = super.GetDataSet().GetCell(super.GetYColumnPosition(),(i)).GetInteger();
                 xVal.add(x);
                 yVal.add(y);
                 double d = /*(y+0.0)/ */ sum;
                 sumVal.add((d));



                preVal = super.GetDataSet().GetCell(super.GetXColumnPosition(), i++);
                sum=0;//
                pos++;             
                }
            }
        
        
        double maxSum = Collections.max(sumVal);
        int maxY = Collections.max(yVal);
        int maxX = Collections.max(xVal);
        
        NormalizedMatrixSeries series = new NormalizedMatrixSeries(super.GetTitle(),(maxY+1),(maxX+1));
        for(int i = 0; i<sumVal.size();i++){
            System.out.println("X: "+xVal.get(i)+"  Y: "+yVal.get(i)+"  Sum: "+sumVal.get(i));
            series.update(yVal.get(i),xVal.get(i),sumVal.get(i));
        }
        
        
       series.setScaleFactor(series.getRowCount());
       MatrixSeriesCollection dataset = new MatrixSeriesCollection(series);
        return dataset;
    }

     
     
     
    
   /**Creates a Bubble Chart
    * Create the bubble chart using the ChartFactory built into JFreeChart
    * 
    * @return m_chart A chart of type JFreeChart
    */
   @Override                                               
    public JFreeChart createChart(){
        final JFreeChart CHART = ChartFactory.createBubbleChart(
            super.GetTitle(),         // chart title
            super.GetDataSet().GetAColumnName(super.GetXColumnPosition()),               // domain axis label
            super.GetDataSet().GetAColumnName(super.GetYColumnPosition()),                  // range axis label
            convertDataSet(),            
            PlotOrientation.HORIZONTAL, // orientation 
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        
        final XYPlot plot = (XYPlot) CHART.getPlot();
        plot.setForegroundAlpha(0.65f); // Set the transparency of the bubble
     
        
       XYBubbleRenderer renderer = new BubbleChart.CustomRenderer(); 
       plot.setRenderer(renderer);
        return CHART;
    }
      /**
     * A renderer specific for this type of chart. Sets the colours that will 
     * be used when displaying the chart.
     */
    class CustomRenderer extends XYBubbleRenderer{
        private Paint[] colors;
        
        /** Custome renderer
         * The constructor for the custom renderer, which will set the colours
         * of the Area
         */
        public CustomRenderer(){ 
        
          ColourMap mappedColours = GetColourMap();
          this.colors = new Paint[mappedColours.getColourArray().length];
          
           for(int i = 0; i<mappedColours.getColourArray().length;i++){
               this.colors[i] = mappedColours.getColour(i);
           }
        }

        /** Gets the colours of an area
         * Accessory method for getting the colours of the area
         * @param row - the identifier of the row it is returning
         * @param column - the identifier of the area it is returning
         * @return the colour of each area 
         */
        
        public Paint getItemPaint(final int row, final int column) {     
           return (this.colors[column % this.colors.length]); 
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
   /**
    * Method that calls the superclass Chart.java to get the charts chartPanel
    * @return 
    */
   public ChartPanel GetPanel(){
       return super.GetChartPannel();
   }
}
