/** @brief This class is will Test all the methods in the Column chart class
 
  The Class contains a number of methods to text all the methods in the C
  * column chart class
    @author Robert Fletcher
    @file TestPIeChart.java
    @see PIeChart.java
    @date April 2013
    */

package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.DataSet;
import cs235a5.LineChart;
import cs235a5.PieChart;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPieChart {
    private final String CLASSNAME ="PieChart";
    private final int SIZE = 500;
    private PieChart m_PC;
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
     * Constructor that sets up the dataset and the frame to shoe to chart
     */
    public TestPieChart(){
        
            m_frame = new JFrame("Testing"+CLASSNAME);
            m_frame.setSize(SIZE,SIZE);
            m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            m_pnl = new JPanel();
            m_pnl.setBackground(Color.yellow);
            m_pnl.setBounds(0,0,SIZE, SIZE);
            m_frame.add(m_pnl);
  
            m_db = new DataSet();
            URL fileURL = this.getClass().getResource("/assets/files/csv.csv"); 
            File f = new File(fileURL.getPath());
            CSVReader csvr = new CSVReader(m_db,f,",");
            csvr.ParseFile();
          
    }
    /**
     * Method to test the PIeChart and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestPieChartDiplay(boolean run){
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
            
            m_PC = new PieChart(m_db,
                                    0,
                                    4,
                                    "title",
                                    new Rectangle(0,0,30,30),
                                    new ColourMap(CLRS),
                                    "Author",
                                    "Decription"
                                    );
            m_pnl.add(m_PC);
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
     * Method to test the PIeChart GetDataSet() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestGetDataSet(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "getDataSet",//Method Being Tested
                 "A test to see if the you can get the DataSet from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            m_PC.SetDataSet(new DataSet());
            if(m_PC.GetDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
       /**
     * Method to test the PIeChart SetDataSet() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
      public Test TestsetDataSet(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "setDataSet",//Method Being Tested
                 "A test to see if the you can set the DataSet in the class", //Description
                 "DataSet", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetDataSet(m_db)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    /**
     * Method to test the PIeChart SetXColumnData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
      
    public Test TestSetXColumnData(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the X column",//Test Title
                 CLASSNAME,//Class Name
                 "SetXData",//Method Being Tested
                 "A test to see if the you can set the X column in the class", //Description
                 "0", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetXData(0)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      /**
     * Method to test the PIeChart SetYColumnData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetYColumnData(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Y column",//Test Title
                 CLASSNAME,//Class Name
                 "SetYData",//Method Being Tested
                 "A test to see if the you can set the Y column in the class", //Description
                 "4", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetYData(4)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
   /**
     * Method to test the PIeChart SetTitle() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */  
      public Test TestSetTitle(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Chart's Title",//Test Title
                 CLASSNAME,//Class Name
                 "SetTitle",//Method Being Tested
                 "A test to see if the you can set the Chart's Title in the class", //Description
                 "A wonderful title", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetChartTitle("A wonderful title")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     
      /**
     * Method to test the PIeChart SetSetColourMap method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetColourMap(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Chart's Colour Map",//Test Title
                 CLASSNAME,//Class Name
                 "SetColourMap",//Method Being Tested
                 "A test to see if the you can set the Chart's Colour Map in the class", //Description
                 "A wonderful title", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetColourMap(new ColourMap(CLRS))){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
     /**
     * Method to test the PIeChart SetAuthor() method  and returns a Test object containing the 
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
            
            if(m_PC.SetAuthor("Robert")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
     /**
     * Method to test the PIeChart SetDescription() method  and returns a Test object containing the 
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
            
            if(m_PC.SetAuthor("A Description")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     /**
     * Method to test the PIeChart SetXChartType() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetChartType(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Chart's Type",//Test Title
                 CLASSNAME,//Class Name
                 "SetChartType",//Method Being Tested
                 "A test to see if the you can set the Chart's type in the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetChartType()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
    /**
     * Method to test the PIeChart GetXColumnData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
    public Test TestGetXColumnData(boolean run){
            Test theTest = new Test(
                 "Testing if you can Get the X column",//Test Title
                 CLASSNAME,//Class Name
                 "GetXData",//Method Being Tested
                 "A test to see if the you can get the X column from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.GetXData()>=0){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       /**
     * Method to test the PIeChart GetYColumnData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetYColumnData(boolean run){
            Test theTest = new Test(
                 "Testing if you can Get the Y column",//Test Title
                 CLASSNAME,//Class Name
                 "GetYData",//Method Being Tested
                 "A test to see if the you can get the Y column from the class", //Description
                 "na", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.GetXData()>=0){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      /**
     * Method to test the PIeChart GetTitle() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
      public Test TestGetTitle(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Chart's Title",//Test Title
                 CLASSNAME,//Class Name
                 "getTitle",//Method Being Tested
                 "A test to see if the you can get the Chart's Title in the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.GetTitle()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      /**
     * Method to test the PIeChart GetColourMap() method  and returns a Test object containing the 
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
            
            if(m_PC.GetColourMap()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
      /**
     * Method to test the PIeChart GetAuthor() method  and returns a Test object containing the 
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
            
            if(m_PC.GetAuthor()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
      /**
     * Method to test the PIeChart GetDescritpion() method  and returns a Test object containing the 
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
            
            if(m_PC.GetDescription()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
      /**
     * Method to test the PIeChart GetChartType() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetChartType(boolean run){
            Test theTest = new Test(
                 "Testing if you can Get the Chart's Type",//Test Title
                 CLASSNAME,//Class Name
                 "GetChartType",//Method Being Tested
                 "A test to see if the you can Get the Chart's type from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.SetChartType()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
      /**
     * Method to test the PIeChart createChart() method  and returns a Test object containing the 
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
            
            if(m_PC.createChart()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
    
     /**
     * Method to test the PIeChart GetGetJChart() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetJChart(boolean run){
            Test theTest = new Test(
                 "Testing if you can create the JFreeChart",//Test Title
                 CLASSNAME,//Class Name
                 "GetJChart",//Method Being Tested
                 "A test to see if the you can Get the create the chart", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_PC.GetJChart()!=null){
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
        TestPieChart TPC = new TestPieChart();
        boolean run = true;
        System.out.println("Test Chart can be displayed: "+
              TPC.TestPieChartDiplay(run).getResult());
        
        System.out.println("Test createchart: "+
              TPC.TestcreateChart(run).getResult());
        System.out.println("Test getJChart "+
              TPC.TestGetJChart(run).getResult());
        
        System.out.println("Test Set Title: "+
              TPC.TestSetTitle(run).getResult());
        System.out.println("Test Get Title: "+
              TPC.TestGetTitle(run).getResult());
        
        System.out.println("Test Set DataSet: "+
              TPC.TestsetDataSet(run).getResult());
        System.out.println("Test Get dataSet: "+
              TPC.TestGetDataSet(run).getResult());
        
        System.out.println("Test Set XData: "+
              TPC.TestSetXColumnData(run).getResult());
        System.out.println("Test Get XData: "+
              TPC.TestGetXColumnData(run).getResult());
        
        System.out.println("Test Set YData: "+
              TPC.TestSetYColumnData(run).getResult());
        System.out.println("Test Get YData: "+
              TPC.TestGetYColumnData(run).getResult());
        
        System.out.println("Test Set Color Map: "+
              TPC.TestSetColourMap(run).getResult());
        System.out.println("Test Get Color Map: "+
              TPC.TestGetColourMap(run).getResult());
        
         System.out.println("Test Set Author: "+
              TPC.TestSetAuthor(run).getResult());
        System.out.println("Test Get Author: "+
              TPC.TestGetAuthor(run).getResult());
        
         System.out.println("Test Set Desciption: "+
              TPC.TestSetYColumnData(run).getResult());
        System.out.println("Test Get Desciption: "+
              TPC.TestGetYColumnData(run).getResult());
        
        
        
        
    }
      
      
      
      
    
  
        
    
    
    
    
    
    
    
    
}
