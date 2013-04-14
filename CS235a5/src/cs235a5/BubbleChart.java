/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.Paint;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.data.xy.MatrixSeriesCollection;
import org.jfree.data.xy.NormalizedMatrixSeries;

/**
 *\file     BubbleChart.java
 *\author   Robert Fletcher & Zhenjie Mu
 *\date     April 2013
 * 
 * \brief   A Bubble Chart class to generate and display Bubble Chart visualisation
 */


public class BubbleChart extends Chart{
   
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
   * Sets the type of chart to the constant AreaChart
   * @return true of set correctly;
   */
  public boolean SetChartType(){
      return super.SetChartType(ChartType.BUBBLECHART);
  }
  
  /**
   * returns the chart type
   * @return the constant BUBBLECHART
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
   * @return m_Description a description of the char thats been genarated
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
  public BubbleChart (DataSet ds, int xColPosition, int yColPosition, String title, Rectangle rect, ColourMap cm, String author, String description)
  {
     super(ds, xColPosition, yColPosition, title, rect, cm, author, description);
  }
    
  /**
   * Creates a dataset of type XYSeries
   */
     public MatrixSeriesCollection convertDataSet()
             
  {
        ArrayList<Integer>xVal = new ArrayList<Integer>();
        ArrayList<Integer>yVal = new ArrayList<Integer>();
        ArrayList<Double>sumVal = new ArrayList<Double>();
        
        int size = 0;
        int sum = 0;
        int pos = 0;
        int j= 0;                                                    //.........needs to be changed!?!?........
        


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

                
                
                 int x= super.GetDataSet().GetCell(super.GetXColumnPosition(),(i)).GetInteger();
                 int y = super.GetDataSet().GetCell(super.GetYColumnPosition(),(i)).GetInteger();
                 xVal.add(x);
                 yVal.add(y);
                 double d = (y+0.0)/sum;
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
            series.update(yVal.get(i),xVal.get(i),sumVal.get(i));
        }
        
        
       series.setScaleFactor(series.getRowCount());
       MatrixSeriesCollection dataset = new MatrixSeriesCollection(series);
        return dataset;
    }

     
     
     
    
        /**
    *
    * Create the column chart using the ChartFactory built into JFreeChart
    * @return m_chart A chart of type JFreeChart
    */
   @Override                                                 //.....needs to be changed?!?!................
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
        
        /*
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);  

        // increase the margins to account for the fact that the auto-range
        // doesn't take into account the bubble size
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setLowerMargin(1);
        domainAxis.setUpperMargin(1);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLowerMargin(1);
        rangeAxis.setUpperMargin(1);
        return CHART;
         */
        
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
        
        /**
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
        
        /**
         * Accessory method for getting the colours of the area
         * @param row - the identifier of the row it is returning
         * @param column - the identifier of the area it is returning
         * @return the colour of each area 
         */
        
        public Paint getItemPaint(final int row, final int column) {     //............needs to be changed?!.........
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
}
