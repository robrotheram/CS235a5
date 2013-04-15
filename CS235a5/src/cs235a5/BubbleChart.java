package cs235a5;

/**
 *\file     BubbleChart.java
 *\author   Robert Fletcher & Zhenjie Mu
 *\date     April 2013
 * 
 * \brief   A Bubble Chart class to generate and display Bubble Chart visualisation
 */

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

public class BubbleChart extends Chart{
   
  private JFreeChart m_chart;
  
  /**Allows access for setting the dataset
   * returns true if the dataset is correct
   *
   * @param data dataset to be set
   * @return returns true is set if successful
   */ 
  @Override
  public boolean SetDataSet(DataSet data){
      super.SetData(data);
      return true;
  }
  
  /**Allows access for setting the x axis data to be used for making charts
   * returns true if the x axis data is correct
   *
   * @param xData
   * @return
   */
  @Override
  public boolean SetXData(int xData){
      super.SetXData(xData);
      return true;
  }
  
  /** Allows access for setting the y axis data to be used for making charts
   * returns true if the y axis data is correct
   *
   * @param yData
   * @return
   */
  @Override
  public boolean SetYData(int yData){
      super.SetYData(yData);
      return true;
  }
  
  /** Sets the title of the Chart
   * returns true if the title is set correctly
   *
   * @param title
   * @return Chart title of the Chart;
   */
  @Override
  public boolean SetChartTitle(String title){
      super.SetChartTitle(title);
      return true;
  }
  
  /** Returns the colourmap selected
   * returns true if the colour is configured correctly
   *
   * @param colours
   * @return colourmap set of the Chart;
   */
  @Override
  public boolean SetColourMap(ColourMap colours){
      super.SetColourMap(colours);
      return true;
  }
  
  /** Returns a aurthor
   * returns the method as true if a author is set for the chart
   *
   * @param author
   * @return author of the Chart;
   */
  @Override
  public boolean SetAuthor(String author){
      super.SetAuthor(author);
      return true;
  }
  
  /** Sets the description
   * returns the description as true if the method takes in the description
   *
   * @param description
   * @return description of the Chart class;
   */
  @Override
  public boolean SetDescription(String description){
      super.SetDescription(description);
      return true;
  }
  
  /** Sets the type of chart to the constant LineChart
   * returns the chart type (Line) if called
   *
   * @return true of set correctly;
   */
  public boolean SetChartType(){
      return super.SetChartType(ChartType.BUBBLECHART);
  }
  
  /** Returns the chart type
   * returns chart type (Line) if the method is called
   *
   * @return the constant BUBBLECHART
   */
  public ChartType getChartType(){
      return super.GetChartType();
  }
  
  /** Returns the X Axis Column Position
   * returns the XData position based on the XColumnPosition
   *
   * @return Int XColumnPosition The X Axis Data
   */
  public int GetXData()
  {
    return super.GetXColumnPosition();
  }

  /** Returns the Y Values for the Column
   * returns the YData position based on the YColumnPosition
   *
   * @return Int YColumnPosition The Y Axis Data
   */
  public int GetYData()
  {
    return super.GetYColumnPosition();
  }

  /** Returns the Description
   * returns the Description of the chart if called
   *
   * @return m_Description a description of the char thats been genarated
   */
  @Override
  public String GetDescription(){

    return super.GetDescription();
  }

  /** Returns the Title
   * returns the name or title of the Chart if the method is called
   * @return m_chartName the name of the chart
   */
  @Override
  public String GetTitle()
  {
    return super.GetChartTitle();
  }
    /** constructor setting all class variables needed to create a Bubble chart
     * The constructor will create all class variables to be called by the subclasses
     * of the chart class.
     * 
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
    
     /** Creates a dataset of type XYSeries
      * Creates a dataset based on the data from the Chart class of which the graph
      * will be based on.
      */
     public MatrixSeriesCollection convertDataSet()
             
  {
        ArrayList<Integer>xVal = new ArrayList<Integer>();
        ArrayList<Integer>yVal = new ArrayList<Integer>();
        ArrayList<Double>sumVal = new ArrayList<Double>();
        
        int size = 0;                                                //Initialises a value for size
        int sum = 0;                                                 //Initialises a value for sum
        int pos = 0;                                                 //Initialises a value for position
        int j= 0;                                                    //Initialises a increment for the for loop
        


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

     
     
     
    
     /** Creates a Line Chart
      * Creates the Line Chart using the ChartFactory built into JFreeChart
      * of which can then be used by the visualiser to be displayed.
      *
      * @return m_chart A chart of type JFreeChart
      */
   @Override                                               
    public JFreeChart createChart(){
        final JFreeChart CHART = ChartFactory.createBubbleChart(
            super.GetTitle(),                                                               // chart title
            super.GetDataSet().GetAColumnName(super.GetXColumnPosition()),                  // domain axis label
            super.GetDataSet().GetAColumnName(super.GetYColumnPosition()),                  // range axis label
            convertDataSet(),            
            PlotOrientation.HORIZONTAL,                                                     // orientation 
            true,                                                                           // include legend
            true,                                                                           // tooltips?
            false                                                                           // URLs?
        );
        
        final XYPlot plot = (XYPlot) CHART.getPlot();
        plot.setForegroundAlpha(0.65f); // Set the transparency of the bubble
  
        XYBubbleRenderer renderer = new BubbleChart.CustomRenderer(); 
        plot.setRenderer(renderer);
        return CHART;
    }
     
     /** A renderer for the Line Chart class
      * A renderer specific for this type of chart. Sets the colours that will
      * be used when displaying the chart.
      */
    class CustomRenderer extends XYBubbleRenderer{
        private Paint[] colors;
        
        /** Consrtuctor for a custom rendrer
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
        
        public Paint getItemPaint(final int row, final int column) {
           return (this.colors[column % this.colors.length]); 
        } 
    }
    
     /** A method that returns the chart created from the data
      * A method to return the chart created from the data by this class so it can be outputted.
      *
      * @return m_chart the chart created by this class
      */
   public JFreeChart GetJChart()
   {
     return m_chart;
   }
}
