/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import cs235a5.TabPanel;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/** @brief This class is will Test all the methods in the TabPannel class
 
  The Class contains a number of methods to text all the methods in the 
  * TabPannel class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see TabPannel.java
    @date April 2013
    */

public class TestTabPannel {
    private final String CLASSNAME = "TabPannel";
    private TabPanel m_TP = new TabPanel();
    private final Color[] c = {Color.RED,Color.RED,Color.RED,Color.RED,Color.RED};
    private final DataSet m_db;
    
    /**
     * Constructor that fill the Dataset
     */
    public TestTabPannel(){
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
     * Method to test the TabPannel AddTab() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    
    
       public Test TestAddTab(boolean run){
        Test theTest = new Test(
                 "Testing if you can Add a chart to the TabbedPane",//Test Title
                 CLASSNAME,//Class Name
                 "AddTab",//Method Being Tested
                 "A test to see if the You can add a tab to the tabbedPane and store in the arrayList", //Description
                 "Test Panel, BarChart", //Input Data
                 "True" //Expected output
                 );   
        
       
        if(run){
            theTest.hasRun();
            try{ 
                if(m_TP.AddTab("Test Panel", 
                        new ColumnChart(m_db,
                        0,
                        4,
                        "title",
                        new Rectangle(0,0,30,30),
                        new ColourMap(c),
                        "Author",
                        "Decription"))){
                               
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }catch(Exception e){
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
        /**
     * Method to test the TabPannel GetTab() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
       
       public Test TestGetTab(boolean run){
        Test theTest = new Test(
                 "Testing if you can Get a chart from the TabbedPane",//Test Title
                 CLASSNAME,//Class Name
                 "AddTab",//Method Being Tested
                 "A test to see if the You can get a tab to the tabbedPane and retreive it from the arrayList", //Description
                 "0", //Input Data
                 "chart != null" //Expected output
                 );   
        
       
        if(run){
            theTest.hasRun();
            try{
                m_TP.AddTab("Test Panel", 
                                new ColumnChart(m_db,
                                                0,
                                                4,
                                                "title",
                                                new Rectangle(0,0,30,30),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));

                        if(m_TP.GetTab(0)!=null){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }catch(Exception e){
                System.err.println(e);
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       
      /**
     * Method to test the TabPannel NumOfCharts() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */  
    public Test TestNumOfCharts(boolean run){
    Test theTest = new Test(
             "Testing if you can Get a number of chart from the TabbedPane",//Test Title
             CLASSNAME,//Class Name
             "AddTab",//Method Being Tested
             "A test to see if the You can get the number of charts", //Description
             "N/A", //Input Data
             "0>1" //Expected output
             );   


    if(run){
        theTest.hasRun();
                if(m_TP.GetNumOfCharts()>=0){
            theTest.setPassed(true);
        }else{
            theTest.setPassed(false);
        }

    }
    return theTest;
    }
    /**
     * Main method to run all the tests in this class 
     * 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        boolean run = true;
        TestTabPannel TTP = new TestTabPannel();
        
        System.out.println("Test Add Tab"+
                TTP.TestAddTab(run).getResult());
        System.out.println("Test Get Tab"+
                TTP.TestGetTab(run).getResult());
        System.out.println("Test Number of Tab"+
                TTP.TestNumOfCharts(run).getResult());
        
        
    }
       
    
}



