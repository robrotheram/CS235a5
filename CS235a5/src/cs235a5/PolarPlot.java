package cs235a5;

/**
 *
 * \file        PolarPlot.java
 * \author      William & Robert Fletcher
 * 
 * \date        15/04/2013
 *
 * \brief       The Polar Plot Chart Class generates and displays an
 *              scatter plot chart by inheriting from the Chart class.
 *
 */

// Import JFreeChart and libraries 
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;


public class PolarPlot extends Chart{
 
  private JFreeChart m_chart;
  private final int SCATTERPOINTSIZE = 3;
  
  /**
  * Returns the data set  
  * @return true the set data is correct;
  */  
  @Override
  public boolean SetDataSet(DataSet data){
      super.SetData(data);
      return true;
  }
  
  /**
  * returns the x axis values
  * @return xData set values;
  */ 
  @Override
  public boolean SetXData(int xData){
      super.SetXData(xData);
      return true;
  }
  
  /**
  * returns the y axis values
  * @return yData set values;
  */
  @Override
  public boolean SetYData(int yData){
      super.SetYData(yData);
      return true;
  }
  /**
  * returns the title of the Chart
  * @return Chart title of the Chart;
  */
  @Override
  public boolean SetChartTitle(String title){
      super.SetChartTitle(title);
      return true;
  }
  
  /**
  * Returns the colourmap selected 
  * @return colourmap set of the Chart;
  */
  @Override
  public boolean SetColourMap(ColourMap colours){
      super.SetColourMap(colours);
      return true;
  }
  
  /**
  * Returns a author
  * @return author of the Chart;
  */
  @Override
  public boolean SetAuthor(String author){
      super.SetAuthor(author);
      return true;
  }
  
  /**
  * returns the description
  * @return description of the Chart class;
  */
  @Override
  public boolean SetDescription(String description){
      super.SetDescription(description);
      return true;
  }
  
  /**
  * Sets the type of chart to the constant SCATTERPLOT
  * @return true of set correctly;
  */
  public boolean SetChartType(){
      super.SetChartType(ChartType.BARCHART);
      return true;
  }
  
  /**
  * returns the chart type
  * @return the constant AREACHART
  */
  public ChartType getChartType(){
      return ChartType.LINECHART;
  }
  
  /**
  * Returns the X Axis Column Position
  * @return Int X Axis Column Position
  */
  public int GetXData(){
    return super.GetXColumnPosition();
  }

  /**
  * Returns the Y Values for the Column
  * @return m_yValues The Y Axis Data
  */
  public int GetYData(){
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
   *  A method to return the chart created by this class so it can be outputted.
   * @return m_chart the chart created by this class
   */
   public JFreeChart GetJChart(){
     return m_chart;
   }
   
  /**
  * Returns the name of the Chart
  * @return m_chartName the name of the chart
  */
  @Override
  public String GetTitle(){
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
  public PolarPlot (DataSet ds, int xColPosition, int yColPosition, String title, Rectangle rect, ColourMap cm, String author, String description)
  {
     
     super(ds, xColPosition, yColPosition, title, rect, cm, author, description,ChartType.POLARCHART);
      
  }
  
    /**
    * Method that calls the superclass Chart.java to get the charts chartPanel
    * @return 
    */
   public ChartPanel GetPanel(){
       return super.GetChartPannel();
   }
   /**
   * Creates a dataset of type XYSeries
   */
   public XYDataset convertDataSet(){
        int size = 0;                                                //Initialises a value for size
        int sum = 0;                                                 //initialises a value for sum
        int pos = 0;                                                 //initialises a value for position
        int j= 0;                                                    //initialises a increment for the for loop 
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries(super.GetTitle());
        
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
                 series.add(sum,preVal.GetInteger());



                preVal = super.GetDataSet().GetCell(super.GetXColumnPosition(), i++);
                sum=0;//
                pos++;             
                }
            }
        
        for(j = pos; j < super.GetDataSet().GetNumOfRows()-1; j++ ){
            if(super.m_foundElements.get(super.m_foundElements.size()-1).equals(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).toString())){
                if(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).GetDataType()==DataType.INTEGER){
                    sum += super.GetDataSet().GetCell(super.GetYColumnPosition(), j).GetInteger();  
                }else if(super.GetDataSet().GetCell(super.GetXColumnPosition(), j).GetDataType()==DataType.DOUBLE){
                    sum += super.GetDataSet().GetCell(super.GetYColumnPosition(), j).GetDouble(); 
                }
            }
        }
        series.add(sum,preVal.GetInteger());
        dataset.addSeries(series);
        return dataset;
    }
   

   /**
   *
   * Create the scatter chart using the ChartFactory built into JFreeChart
   * @return m_chart A chart of type JFreeChart
   */
   @Override                                                 
    public JFreeChart createChart(){
        JFreeChart CHART = ChartFactory.createPolarChart(
            super.GetTitle(),                                                            // chart title
            convertDataSet(),                                                // orientation
            false, // Legend                                                                        // include legend
            true,                                                                        // tooltips?
            false                                                                        // URLs?
        );
        
            
           Plot p = CHART.getPlot();
           org.jfree.chart.plot.PolarPlot pl = (org.jfree.chart.plot.PolarPlot)p;
           PolarItemRenderer renderer = new PolarPlot.CustomRenderer(); 
           pl.setRenderer(renderer);
        return CHART;
    }

    /**
    * A renderer specific for this type of chart. Sets the colours that will 
    * be used when displaying the chart.
    */
    class CustomRenderer extends DefaultPolarItemRenderer {
        private Paint[] colors;
        private final int SIZE = 5;
        /**
        * The constructor for the custom renderer, which will set the colours
        * of the Area
        */
        public CustomRenderer(){ 
           ColourMap mappedColours = GetColourMap();
           this.setSeriesShape(0,ShapeUtilities.createDiagonalCross(SCATTERPOINTSIZE, 1));
          
          
           this.colors = new Paint[mappedColours.getColourArray().length];
           
           for(int i = 0; i<mappedColours.getColourArray().length;i++){
               this.colors[i] = mappedColours.getColour(i);
           }
        }
       
        @Override
    public void drawSeries(java.awt.Graphics2D g2, java.awt.geom.Rectangle2D dataArea, PlotRenderingInfo info, org.jfree.chart.plot.PolarPlot plot, XYDataset dataset, int seriesIndex) {
         

        int numPoints = dataset.getItemCount(seriesIndex);
        for (int i = 0; i < numPoints; i++) {

            double theta = dataset.getXValue(seriesIndex, i);
            double radius = dataset.getYValue(seriesIndex, i);
            Point p = plot.translateValueThetaRadiusToJava2D(theta, radius, dataArea);
           
            Ellipse2D el = new Ellipse2D.Double(p.x, p.y, SIZE, SIZE);
            g2.setColor(GetColourMap().getColour(i%GetColourMap().getColourArray().length));
            g2.fill(el);
            g2.draw(el);
            
        
    }
        
        
   
    }
    
  
   
   
   

   
   
   
    }
}
