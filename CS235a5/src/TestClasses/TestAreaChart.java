/** @brief This class is will Test all the methods in the Area chart class
 
  The Class contains a number of methods to text all the methods in the C
  * column chart class
    @author Alex McDonough & Robert Fletcher
    @file TestAreaChart.java
    @see AreaChart.java
    @date April 2013
    */

package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.AreaChart;
import cs235a5.DataSet;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestAreaChart {
    private final String CLASSNAME ="AreaChart";
    private final int SIZE = 500;
    private AreaChart m_CC;
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
    public TestAreaChart(){
        
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
     * Method to test the AreaChart and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestAreaChartDiplay(boolean run){
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
            
            m_CC = new ColumnChart(m_db,
                                    0,
                                    4,
                                    "title",
                                    new Rectangle(0,0,30,30),
                                    new ColourMap(CLRS),
                                    "Author",
                                    "Decription"
                                    );
            m_pnl.add(m_CC);
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
     * Method to test the AreaChart GetDataSet() method  and returns a Test object containing the 
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
            m_CC.SetDataSet(new DataSet());
            if(m_CC.GetDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
       /**
     * Method to test the AreaChart SetDataSet() method  and returns a Test object containing the 
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
            
            if(m_CC.SetDataSet(m_db)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    /**
     * Method to test the AreaChart SetXAreaData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
      
    public Test TestSetXAreaData(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the X Area",//Test Title
                 CLASSNAME,//Class Name
                 "SetXData",//Method Being Tested
                 "A test to see if the you can set the X Area in the class", //Description
                 "0", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CC.SetXData(0)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      /**
     * Method to test the AreaChart SetYAreaData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetYAreaData(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Y Area",//Test Title
                 CLASSNAME,//Class Name
                 "SetYData",//Method Being Tested
                 "A test to see if the you can set the Y Area in the class", //Description
                 "4", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CC.SetYData(4)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
   /**
     * Method to test the AreaChart SetTitle() method  and returns a Test object containing the 
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
            
            if(m_CC.SetChartTitle("A wonderful title")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     
      /**
     * Method to test the AreaChart SetSetColourMap method  and returns a Test object containing the 
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
            
            if(m_CC.SetColourMap(new ColourMap(CLRS))){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
     /**
     * Method to test the areaChart SetAuthor() method  and returns a Test object containing the 
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
            
            if(m_CC.SetAuthor("Robert")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
     /**
     * Method to test the AreaChart SetDescription() method  and returns a Test object containing the 
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
            
            if(m_CC.SetAuthor("A Description")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     /**
     * Method to test the AreaChart SetXChartType() method  and returns a Test object containing the 
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
            
            if(m_CC.SetChartType()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
    /**
     * Method to test the AreaChart GetXAreaData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
    public Test TestGetXAreaData(boolean run){
            Test theTest = new Test(
                 "Testing if you can Get the X Area",//Test Title
                 CLASSNAME,//Class Name
                 "GetXData",//Method Being Tested
                 "A test to see if the you can get the X column from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CC.GetXData()>=0){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       /**
     * Method to test the AreaChart GetYAreaData() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestGetYAreaData(boolean run){
            Test theTest = new Test(
                 "Testing if you can Get the Y area",//Test Title
                 CLASSNAME,//Class Name
                 "GetYData",//Method Being Tested
                 "A test to see if the you can get the Y area from the class", //Description
                 "na", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CC.GetXData()>=0){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      /**
     * Method to test the AreaChart GetTitle() method  and returns a Test object containing the 
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
            
            if(m_CC.GetTitle()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      /**
     * Method to test the AreaChart GetColourMap() method  and returns a Test object containing the 
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
            
            if(m_CC.GetColourMap()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
      /**
     * Method to test the AreaChart GetAuthor() method  and returns a Test object containing the 
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
            
            if(m_CC.GetAuthor()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
      /**
     * Method to test the AreaChart GetDescritpion() method  and returns a Test object containing the 
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
            
            if(m_CC.GetDescription()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
      /**
     * Method to test the AreaChart GetChartType() method  and returns a Test object containing the 
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
            
            if(m_CC.SetChartType()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
     
      /**
     * Method to test the AreaChart createChart() method  and returns a Test object containing the 
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
            
            if(m_CC.createChart()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
        } 
        
        return theTest;
    }
    
     /**
     * Method to test the AreaChart GetGetJChart() method  and returns a Test object containing the 
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
            
            if(m_CC.GetJChart()!=null){
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
        TestAreaChart TCC = new TestAreaChart();
        boolean run = true;
        System.out.println("Test Chart can be displayed: "+
              TCC.TestAreaChartDiplay(run).getResult());
        
        System.out.println("Test createchart: "+
              TCC.TestcreateChart(run).getResult());
        System.out.println("Test getJChart "+
              TCC.TestGetJChart(run).getResult());
        
        System.out.println("Test Set Title: "+
              TCC.TestSetTitle(run).getResult());
        System.out.println("Test Get Title: "+
              TCC.TestGetTitle(run).getResult());
        
        System.out.println("Test Set DataSet: "+
              TCC.TestsetDataSet(run).getResult());
        System.out.println("Test Get dataSet: "+
              TCC.TestGetDataSet(run).getResult());
        
        System.out.println("Test Set XData: "+
              TCC.TestSetXAreaData(run).getResult());
        System.out.println("Test Get XData: "+
              TCC.TestGetXAreaData(run).getResult());
        
        System.out.println("Test Set YData: "+
              TCC.TestSetYAreaData(run).getResult());
        System.out.println("Test Get YData: "+
              TCC.TestGetYAreaData(run).getResult());
        
        System.out.println("Test Set Color Map: "+
              TCC.TestSetColourMap(run).getResult());
        System.out.println("Test Get Color Map: "+
              TCC.TestGetColourMap(run).getResult());
        
         System.out.println("Test Set Author: "+
              TCC.TestSetAuthor(run).getResult());
        System.out.println("Test Get Author: "+
              TCC.TestGetAuthor(run).getResult());
        
         System.out.println("Test Set Desciption: "+
              TCC.TestSetYAreaData(run).getResult());
        System.out.println("Test Get Desciption: "+
              TCC.TestGetYAreaData(run).getResult());
        
        
        
        
    }
      
      
      
      
    
  
        
    
    
    
    
    
    
    
    
}
