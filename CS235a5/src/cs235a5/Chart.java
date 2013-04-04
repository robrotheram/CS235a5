/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Kerryanne Tolhurst
 * The chart class is the abstract super class for all charts.
 * It sets the constructor for all classes and sets all methods needed to be
 * implemented by all subclasses.
 * 
 */
public abstract class Chart extends Visualisation {
    
    private DataSet m_db;
    private int m_xAxisDataPosition;
    private int m_yAxisDataPosition;
    private String m_chartAuthor; // Allows the user to add an author
    private String m_chartDescription; // Allows the user to add a description
    private ColourMap m_colourScheme; // Sets the colour of the charts
    private String m_title;
    private ChartType m_chartType;
    

    
    
   
    
    /**
     * Allows access for setting the dataset
     * 
     * @param db dataset to be set
     * @return returns true is set is successful
     */
    boolean SetDataSet(DataSet db){
        super.SetData(db);
        return true;
    }
    
    /**
     * Allows access for setting the x axis data to be used for making charts
     * 
     * @param xData
     * @return 
     */
    boolean SetXData(int xData){
        m_xAxisDataPosition = xData;
        return true;
    }
    /**
     * Set type the chart from the enum ChartChart class
     * @param ChartType chartType 
     * @return True if set correctly
     */
      boolean SetChartType(ChartType chartType){
          m_chartType  = chartType;
          return true;
      }
    
    /**
     * Allows access for setting the y axis data to be used for making charts
     * 
     * @param yData
     * @return 
     */
    boolean SetYData(int yData){
        m_yAxisDataPosition = yData;
        return true;
    }
    
    /**
     * Allows setting the chart title. 
     */
    boolean SetChartTitle(String newTitle){
        super.SetTitle(newTitle);
        return true;
    };
    
    /**
     * Abstract class that sets the current colour map and carries out any 
     * processing to change the colour of the chart elements
     */
    boolean SetColourMap(ColourMap colourMap){
        m_colourScheme = colourMap;
        return true;
    };
    
    ChartType GetChartType(){
        return m_chartType;
    }
    
    /**
     * allows access to the dataset if needed
     * @return M_DB
     */
    DataSet GetData(){
        return super.GetDataSet();
    }
    
    /**
     * allows access to the data for x axis if needed
     * @return X_AXISDATAPOSITION
     */
    int GetXColumnPosition(){
        return m_xAxisDataPosition;
    }
    
    /**
     * allows access to the data for y axis if needed
     * @return Y_AXISDATAPOSITION
     */
    int GetYColumnPosition(){
        return m_yAxisDataPosition;
    }
    
    /**
     * allows access to the chart title if needed
     * @return m_title
     */
    String GetTitle(){
        return super.GetChartTitle();
    }
    
    /**
     * Abstract class theat returns the array of the current colour map 
     */
    ColourMap GetColours(){
        return super.GetColourMap();
    };
    
    /**
     * constructor setting all class variables needed to create a chart
     * @param db - the data for the chart
     * @param xColumnPos - the column data for the x axis from the dataset
     * @param yColPos - the column data for the y axis from the dataset
     * @param title - chart title
     * @param r - to display the chart in the windows native size
     */
    public Chart(DataSet db,int xColumnPos, int yColumnPos, String title, 
            Rectangle r, ColourMap cm, String author, String description){
       if(SetData(db)){
           System.out.println("MS_Chart().setData(): Successful");
       } else {
           System.err.println("MS_Chart().setData(): Failed");
       }
       
       if(SetXData(xColumnPos)){
           System.out.println("MS_Chart().setXData(): Successful");
       } else {
           System.err.println("MS_Chart().setXData(): Failed");
       }
       
       if(SetYData(yColumnPos)){
           System.out.println("MS_Chart().setYData(): Successful");
       } else {
           System.err.println("MS_Chart().setYData(): Failed");
       }
       
       if(SetChartTitle(title)){
           System.out.println("MS_Chart().setChartTitle(): Successful");
       } else {
           System.err.println("MS_Chart().setChartTitle(): Failed");
       }
       
       if(SetColourMap(cm)){
           System.out.println("MS_Chart().setColourMap(): Successful");
       } else {
           System.err.println("MS_Chart().setColourMap(): Failed");
       }
       if(SetAuthor(author)){
           System.out.println("MS_Chart().SetAuthor(): Successful");
       } else {
           System.err.println("MS_Chart().SetAuthor(): Failed");
       }
       if(SetDescription(description)){
           System.out.println("MS_Chart().SetDescription(): Successful");
       } else {
           System.err.println("MS_Chart().SetDescription(): Failed");
       }
       this.setBounds(r);
       this.setLayout(new java.awt.BorderLayout());
       this.add(createPanel(),BorderLayout.CENTER);
       this.setVisible(true);
    };
    
    /**
     * Abstract class that creates the actual chart 
     */
    abstract public JFreeChart createChart();
    
    /**
     * Creates a chart panel from the chart
     * @return myChart 
     */
    private ChartPanel createPanel(){
        ChartPanel myChart = new ChartPanel(createChart());
           myChart.setMouseWheelEnabled(true);
        return myChart;
    } 
}
