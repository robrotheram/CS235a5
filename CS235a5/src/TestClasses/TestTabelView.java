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
import cs235a5.TabPannel;
import cs235a5.TableView;
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

/** @brief This class is will Test all the methods in the TabPannel class
 
  The Class contains a number of methods to text all the methods in the 
  * TabPannel class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see TabPannel.java
    @date April 2013
    */

public class TestTabelView {
    private final String CLASSNAME = "TableView";
    private TableView TV; 
    private final Color[] c = {Color.RED,Color.RED,Color.RED,Color.RED,Color.RED};
    private final DataSet m_db;
    private JFrame m_frame;
    private JPanel m_pnl;
    private final int SIZE = 500;
    /**
     * Constructor that fill the Dataset
     */
    public TestTabelView(){
        m_db = new DataSet();
        CSVReader csvr = new CSVReader(m_db,getFile(),",");
        csvr.ParseFile();
        
        
        m_frame = new JFrame("Testing"+CLASSNAME);
        m_frame.setSize(SIZE,SIZE);
        m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        m_pnl = new JPanel();
        m_pnl.setBackground(Color.yellow);
        m_pnl.setBounds(0,0,SIZE, SIZE);
        m_frame.add(m_pnl);
  
           
          
    
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
     * Method to test the TableView SetDataSet() method  and returns a Test object containing the 
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
            
            if(TV.setDataSet(m_db)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
     /**
     * Method to check that the table can be filled by the dataset
     * @param boolean if the method is being run
     * @return Test 
     */
      public Test TestDisplay(boolean run){
            Test theTest = new Test(
                 "Testing if you can fill the table from the Dataset",//Test Title
                 CLASSNAME,//Class Name
                 "setDataSet",//Method Being Tested
                 "A test to see if the you can fill the table form the class in the class", //Description
                 "DataSet rectangle", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            TV = new TableView(m_db,m_pnl.getBounds());
            m_pnl.add(TV);
            m_pnl.validate();
            if(TV!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
    
    
     /**
     * Method to test the TableView getDataSet() method  and returns a Test object containing the 
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
                 "setDataSet",//Method Being Tested
                 "A test to see if the you can get the DataSet in the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(TV.getDataSet()!=null){
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
        TestTabelView TTV = new TestTabelView();
        System.out.println("Test Fill the table "+
              TTV.TestDisplay(run).getResult());
        
         System.out.println("Test Set DataSet: "+
              TTV.TestsetDataSet(run).getResult());
        System.out.println("Test Get dataSet: "+
              TTV.TestGetDataSet(run).getResult());
        
        
    }
       
    
}



