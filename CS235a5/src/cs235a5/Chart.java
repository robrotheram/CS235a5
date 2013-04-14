/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    protected ArrayList<String>m_foundElements;
    private final int OFFSET = 30;
    
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
        
       super(title, db, cm, author, description);
       
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
       
       this.setBounds(r.x,r.y,r.width,(r.height-OFFSET));
       this.setLayout(new java.awt.BorderLayout());
       this.add(createPanel(),BorderLayout.CENTER);
       this.add(addChartInfo(r,author,description),BorderLayout.SOUTH);
       this.setVisible(true);
       this.validate();
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
    
    
    /**
     * Private method to add the charts info ie the Author Description and time to the chart
     * @param Rectangle the size of the panel
     * @param String author of the chart
     * @param String Description, The charts Description
     * @return JPanel A panel with a 3 labels containing the author, description, time
     */
    private JPanel addChartInfo(Rectangle r,String author, String Desc ){
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(r.width,OFFSET));
        p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        p.setLayout(new FlowLayout());
        
        JLabel auth = new JLabel("Author: "+author+" | ");
        p.add(auth);
        JLabel des = new JLabel("Description: "+Desc+" | ");
        p.add(des);
        JLabel date = new JLabel("Date: "+getDate("dd/MM/yyyy")+" Time: "+getDate("HH:mm:ss"));
        p.add(date);
        
        
        p.validate(); 
       
        
        
        
        return p;
    } 
     /**
     * Method to get the current time and date and return it as a string
     * @return String  - the current time and Data
     */
     private String getDate(String format){
               DateFormat dateFormat = new SimpleDateFormat(format);
               //get current date time with Date()
               Date date = new Date();
               System.out.println(dateFormat.format(date));
         
               //get current date time with Calendar()
               Calendar cal = Calendar.getInstance();
               return(dateFormat.format(cal.getTime()));
               
           
           
     }  
    
    
    /**
     * Method for checking array list if the element has already be found. 
     * It so that when making the chart dataset there will be no duplicates.
     * @param String Value to be checked
     * @return boolean true if found
     */
    protected boolean isUnique(String val){
		 boolean found = false;
		 for (int i = 0; i< m_foundElements.size(); i++){
			 
			 if(val.equals( m_foundElements.get(i))){
				 found = true;
                                 
				 break;
			 }
			 
		 }
                  System.out.println();
		 return found;
	 }
    
    
}
