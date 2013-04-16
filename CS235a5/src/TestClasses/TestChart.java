/** @brief This class is will Test all the methods in the Scatter Plot chart class
 
  The Class contains a number of methods to text all the methods in the 
  * Scatter Plot chart class
    @author Robert Flecher
    @file TestChart.java
    @see Chart.java
    @date April 2013
    */

package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.Chart;
import cs235a5.ColourMap;
import cs235a5.Chart;
import cs235a5.ChartType;
import cs235a5.DataSet;
import cs235a5.LineChart;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;

public class TestChart {
    private final String CLASSNAME ="ScatterPlot";
    private final int SIZE = 500;
    private Chart m_LC;
    private JFrame m_frame;
    private JPanel m_pnl;
    private DataSet m_db;
    private final Color[] CLRS = {
                                Color.RED,
                                Color.GREEN,
                                Color.BLUE,
                                Color.WHITE,
                                Color.BLACK
                            };
    
    
    /**
     * Constructor that sets up the dataset and the frame to show the chart
     */
    public TestChart(){
         
            m_frame = new JFrame("Testing"+CLASSNAME);
            m_frame.setSize(SIZE,SIZE);
            m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            m_pnl = new JPanel();
            m_pnl.setBackground(Color.yellow);
            m_pnl.setBounds(0,0,SIZE, SIZE);
            m_frame.add(m_pnl);
  
            m_db = new DataSet();
            CSVReader csvr = new CSVReader(m_db,getFile(),",");
            csvr.ParseFile();
          
    }
        /**
     * Private method to get the file inside of the jar file
     * @return File
     */ 
    private File getFile(){
        String  p = System.getProperty("user.dir")+"/rrf.csv";
        try{
            InputStream is = is = this.getClass().getResourceAsStream("/assets/files/csv.csv");
            OutputStream stream = new BufferedOutputStream(new FileOutputStream(p));
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                stream.write(buffer, 0, len);
            }
            if(stream!=null){
                stream.close();
            }
        }catch(IOException e){}
        return new File(p);
    }
    
    /**
     * 
     * Method to test the Chart and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestChartDiplay(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Chart Constructor",//Test Title
                 CLASSNAME,//Class Name
                 "N/A",//Method Being Tested
                 "A test to see if the you can get Chart can be made", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
       
        
        if(run){
            theTest.hasRun();
            try{
            
            m_LC = new ChartImpl(m_db,
                                    0,
                                    4,
                                    "title",
                                    new Rectangle(0,0,30,30),
                                    new ColourMap(CLRS),
                                    "Author",
                                    "Decription");
            m_pnl.add(m_LC);
            m_pnl.validate();
            m_frame.setVisible(true);    
            theTest.setPassed(true);
            
            }catch(Exception e){
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    
    
  



     
      
     /**
     * Method to test the Chart SetAuthor() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestSetAuthor(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Chart's Author",//Test Title
                 CLASSNAME,//Class Name
                 "SetAuthor",//Method Being Tested
                 "A test to see if the you can set the Chart's Author in the class", //Description
                 "Robert", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.SetAuthor("Robert")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
     /**
     * Method to test the Chart SetDescription() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetDesciption(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Chart's Description",//Test Title
                 CLASSNAME,//Class Name
                 "SetDescription",//Method Being Tested
                 "A test to see if the you can set the Chart's Description in the class", //Description
                 "A description", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.SetAuthor("A Description")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }

     
      /**
     * Method to test the Chart GetColourMap() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetColourMap(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Chart's Colour Map",//Test Title
                 CLASSNAME,//Class Name
                 "GetColourMap",//Method Being Tested
                 "A test to see if the you can get the Chart's Colour Map from the class", //Description
                 "A wonderful title", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.GetColourMap()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
      /**
     * Method to test the Chart GetAuthor() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
    public Test TestGetAuthor(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Chart's Author",//Test Title
                 CLASSNAME,//Class Name
                 "GetAuthor",//Method Being Tested
                 "A test to see if the you can get the Chart's Author from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.GetAuthor()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
      /**
     * Method to test the Chart GetDescritpion() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetDesciption(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Chart's Description",//Test Title
                 CLASSNAME,//Class Name
                 "GetDescription",//Method Being Tested
                 "A test to see if the you can get the Chart's Description from the class", //Description
                 "A description", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.GetDescription()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }

     
      /**
     * Method to test the Chart createChart() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
    public Test TestcreateChart(boolean run){
            Test theTest = new Test(
                 "Testing if you can create the JFreeChart",//Test Title
                 CLASSNAME,//Class Name
                 "createChart",//Method Being Tested
                 "A test to see if the you can Get the create the chart", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_LC.createChart()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
    

    
    /**
     * Main method to run all the tests in this class 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        TestChart TLC = new TestChart();
        boolean run = true;
        System.out.println("Test Chart can be displayed: "+
              TLC.TestChartDiplay(run).getResult());
        
        System.out.println("Test createchart: "+
              TLC.TestcreateChart(run).getResult());
        

        System.out.println("Test Get Color Map: "+
              TLC.TestGetColourMap(run).getResult());
        
         System.out.println("Test Set Author: "+
              TLC.TestSetAuthor(run).getResult());
        System.out.println("Test Get Author: "+
              TLC.TestGetAuthor(run).getResult());
        


    }

    private class ChartImpl extends Chart {

        public ChartImpl(DataSet m_db, int i, int i0, String title, Rectangle rectangle, ColourMap colourMap, String author, String decription) {
            super(m_db, i, i0, title, rectangle, colourMap, author, decription,ChartType.AREACHART);
        }

        @Override
        public JFreeChart createChart() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
