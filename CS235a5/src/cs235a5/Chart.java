package cs235a5;


/**
 * \file Chart.java
 * 
 * \author Kerryanne Tolhurst
 * 
 * \date 15/04/2013
 * 
 * \brief The chart class is the abstract super class for all charts.
 * 	  It sets the constructor for all classes and sets all methods needed to be
 *  	  implemented by all subclasses.
 * 
 */

//Import JFreeChart and other libraries 
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

public abstract class Chart extends Visualisation {
    
   
    /** Allows access for setting the dataset
     * returns true if the dataset is correct
     * 
     * @param db dataset to be set
     * @return returns true is set if successful
     */
    boolean SetDataSet(DataSet db){
        super.SetData(db);
        return true;
    }
    
    /** Allows access for setting the x axis data to be used for making charts
     * returns true if the x axis data is correct
     * 
     * @param xData
     * @return 
     */
    boolean SetXData(int xData){
        m_xAxisDataPosition = xData;
        return true;
    }
    
    /** Set type the chart from the enum ChartChart class
     * returns true if the chartType takes in data correctly
     * 
     * @param ChartType chartType 
     * @return True if set correctly
     */
      public boolean SetChartType(ChartType chartType){
          m_chartType  = chartType;
          System.out.println("ChartType on create at Chart.java = "+m_chartType);
          return true;
      }
    
    /** Allows access for setting the y axis data to be used for making charts
     * returns true if the y axis takes in the data correctly
     * 
     * @param yData
     * @return 
     */
    boolean SetYData(int yData){
        m_yAxisDataPosition = yData;
        return true;
    }
    
    /** Allows setting the chart title. 
     * returns true if the title is set correctly
     */
    boolean SetChartTitle(String newTitle){
        super.SetTitle(newTitle);
        return true;
    };
    
    /** Sets the colour map and can change it
     * Abstract class that sets the current colour map and carries out any 
     * processing to change the colour of the chart elements
     */
    boolean SetColourMap(ColourMap colourMap){
        m_colourScheme = colourMap;
        return true;
    };
    
    /**
     *Gets the type of the sub classed chart from the enumeration class ChartType;
     * @return ChartType
     */
    public ChartType GetChartType(){
        System.out.println("ChartType at Chart.java = "+m_chartType);
        return m_chartType;
    }
    
    /** Allows access to the dataset if needed
     * returns the DataSet if called
     * @return M_DB
     */
    DataSet GetData(){
        return super.GetDataSet();
    }
    
    /** Allows access to the data for x axis if needed
     * returns the xAxisPosition for the Chart
     * @return X_AXISDATAPOSITION
     */
    int GetXColumnPosition(){
        return m_xAxisDataPosition;
    }
    
    /** Allows access to the data for y axis if needed
     * returns the yAxisPosition for the Chart
     * @return Y_AXISDATAPOSITION
     */
    int GetYColumnPosition(){
        return m_yAxisDataPosition;
    }
    
    /** Allows access to the chart title if needed
     * returns the chart title for the Chart
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
    
    /** Method to get the current time and date and return it as a string
     * returns the date from the computer which is currently running the program 
     * 
     * @param format
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
    
    /** Constructor setting all class variables needed to create a chart
     * The constructor will create all class variables to be called by the subclasses
     * of the chart class.
     * @param db - the data for the chart
     * @param xColumnPos - the column data for the x axis from the dataset
     * @param yColPos - the column data for the y axis from the dataset
     * @param title - chart title
     * @param r - to display the chart in the windows native size
     */
    public Chart(DataSet db,int xColumnPos, int yColumnPos, String title, 
            Rectangle r, ColourMap cm, String author, String description,ChartType ct){
        
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
       if(!SetChartType(ct)){
          System.err.println("Chart().setChartType(): Failed"); 
       }
       
       this.setBounds(r.x,r.y,r.width,(r.height-OFFSET));
       this.setLayout(new java.awt.BorderLayout());
       this.add(createPanel(),BorderLayout.CENTER);
       this.add(addChartInfo(r,author,description),BorderLayout.SOUTH);
       this.setVisible(true);
       this.validate();
    };
    
    /** Creates the Chart class
     * Abstract class that creates the actual chart 
     */
    abstract public JFreeChart createChart();
    
    /**	Creates the chart panel
     * Returns a chart panel from the chart to be used by the chart class
     * @return myChart 
     */
    private ChartPanel createPanel(){
        ChartPanel myChart = new ChartPanel(createChart());
           myChart.setMouseWheelEnabled(true);
        return myChart;
    } 
    
    
    /** Adds charts information 
     * Private method to add the charts information for example "The Author Description and time to the chart"
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
    
    /** Method that tests array lists and finding elements
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
    
    private DataSet m_db;			//Initalises the DataSet variable valled m_db
    private int m_xAxisDataPosition;		//Initalises x Axis position
    private int m_yAxisDataPosition;		//Initalises y Axis position
    private String m_chartAuthor; 		// Allows the user to add an author
    private String m_chartDescription; 		// Allows the user to add a description
    private ColourMap m_colourScheme; 		// Sets the colour of the charts
    private String m_title;			//Initalises the chart title
    private ChartType m_chartType;		//Initalises the chart type
    protected ArrayList<String>m_foundElements;		//Initalises the array list to find elements
    private final int OFFSET = 30;		//Initalises the variable offset and sets it to "30"
    
}
