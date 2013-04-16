/** @brief This class is will Test all the methods in the Column chart class
 
  The Class contains a number of methods to text all the methods in the C
  * column chart class
    @author Robert Fletcher
    @file TestColumnChart.java
    @see ColumnChart.java
    @date April 2013
    */

package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import cs235a5.Visualisation;
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

public class TestVisulisation {
    private final String CLASSNAME ="ColumnChart";
    private final int SIZE = 500;
    private Visualisation m_CC;
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
    public TestVisulisation() {
        
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
     * Method to test the ColumnChart and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestColumnChartDiplay(boolean run){
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
     * Method to test the ColumnChart GetDataSet() method  and returns a Test object containing the 
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
            m_CC.SetData(new DataSet());
            if(m_CC.GetDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
       /**
     * Method to test the ColumnChart SetDataSet() method  and returns a Test object containing the 
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
            
            if(m_CC.SetData(m_db)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    
     
   /**
     * Method to test the Class SetTitle() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */  
      public Test TestSetTitle(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the Title",//Test Title
                 CLASSNAME,//Class Name
                 "SetTitle",//Method Being Tested
                 "A test to see if the you can set the Chart's Title in the class", //Description
                 "A wonderful title", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CC.SetTitle("A wonderful title")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     
      /**
     * Method to test the ColumnChart SetSetColourMap method  and returns a Test object containing the 
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
            
            if(m_CC.SetColour(new ColourMap(CLRS))){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
     /**
     * Method to test the ColumnChart SetAuthor() method  and returns a Test object containing the 
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
     * Method to test the ColumnChart SetDescription() method  and returns a Test object containing the 
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
     * Method to test the ColumnChart GetTitle() method  and returns a Test object containing the 
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
            
            if(m_CC.GetChartTitle()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      /**
     * Method to test the ColumnChart GetColourMap() method  and returns a Test object containing the 
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
     * Method to test the ColumnChart GetAuthor() method  and returns a Test object containing the 
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
     * Method to test the ColumnChart GetDescritpion() method  and returns a Test object containing the 
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
     * Main method to run all the tests in this class 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        TestVisulisation TCC = new TestVisulisation();
        boolean run = true;
        System.out.println("Test Chart can be displayed: "+
              TCC.TestColumnChartDiplay(run).getResult());
 
        System.out.println("Test Set Title: "+
              TCC.TestSetTitle(run).getResult());
        System.out.println("Test Get Title: "+
              TCC.TestGetTitle(run).getResult());
        
        System.out.println("Test Set DataSet: "+
              TCC.TestsetDataSet(run).getResult());
        System.out.println("Test Get dataSet: "+
              TCC.TestGetDataSet(run).getResult());
        System.out.println("Test Set Color Map: "+
              TCC.TestSetColourMap(run).getResult());
        System.out.println("Test Get Color Map: "+
              TCC.TestGetColourMap(run).getResult());
        
         System.out.println("Test Set Author: "+
              TCC.TestSetAuthor(run).getResult());
        System.out.println("Test Get Author: "+
              TCC.TestGetAuthor(run).getResult());
        
         
        
        
        
        
    }
      
      
      
      
    
  
        
    
    
    
    
    
    
    
    
}
