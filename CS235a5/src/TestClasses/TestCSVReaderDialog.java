/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CSVReaderDialog;
import cs235a5.DataSet;
import cs235a5.VisualiserGUI;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;




/** @brief This class is will Test all the methods in the CSVReaderDialog class
 
  The Class contains a number of methods to text all the methods in the 
  * CSVReaderDialog class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see CSVReaderDialog.java
    @date April 2013
    */

public class TestCSVReaderDialog {
    private final String CLASSNAME = "CSVReaderDialog";
    private CSVReaderDialog m_CD = new CSVReaderDialog();
    private VisualiserGUI VGUI = new VisualiserGUI();
    private File f = getFile();
    
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
     * Hides the VisualiserGUI GUI since it is not needed
     */
    public  TestCSVReaderDialog(){
        VGUI.setVisible(false);
    }
    
    
      /**
     * Method to test the CSVReaderDialog CSVReadserDialog method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestCSVReaderDialogDisplay(boolean run){
        Test theTest = new Test(
                 "Testing if you can display the UI",//Test Title
                 CLASSNAME,//Class Name
                 "Class Constructor",//Method Being Tested
                 "A test to see if the UI Displays", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        String userPass  = "r";
        
        if(run){
            theTest.hasRun();
             m_CD.setVisible(true);
            if(m_CD.isVisible()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      /**
     * Method to test the CSVReaderDialog GetSetContext() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestsetContext(boolean run){
        Test theTest = new Test(
                 "Testing if you add the hooks into the UI",//Test Title
                 CLASSNAME,//Class Name
                 "setContext",//Method Being Tested
                 "A test to see if the Set the VisualiserGUI  ", //Description
                 "VisualiserGUI", //Input Data
                 "True" //Expected output
                 );   
        
        
        
        if(run){
            theTest.hasRun();
            
            if(m_CD.setContext(VGUI)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      /**
     * Method to test the CSVReaderDialog GetFile() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestsetFile(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the file",//Test Title
                 CLASSNAME,//Class Name
                 "setFile",//Method Being Tested
                 "A test to see if the you can set a file in the class", //Description
                 "csv.csv", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(m_CD.setFile(f)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      /**
     * Method to test the CSVReaderDialog SetDataSet() method  and returns a Test object containing the 
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
            
            if(m_CD.setDataSet(new DataSet())){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       /**
     * Method to test the CSVReaderDialog GetDataSet() method  and returns a Test object containing the 
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
            m_CD.setDataSet(new DataSet());
            if(m_CD.getDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
      /**
     * Method to test the CSVReaderDialog GetContext() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestGetContext(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the VisuliserGUI",//Test Title
                 CLASSNAME,//Class Name
                 "getContext",//Method Being Tested
                 "A test to see if the you can get the VisuliserGUI from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            m_CD.setContext(VGUI);       
            if(m_CD.getContext()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    
    
     /**
     * Method to test the CSVReaderDialog GetFile() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    
    public Test TestGetFile(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the File",//Test Title
                 CLASSNAME,//Class Name
                 "getFile",//Method Being Tested
                 "A test to see if the you can get the File from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            

            m_CD.setFile(f);
        if(run){
            theTest.hasRun();
               
            if(m_CD.getFile()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    /**
     * Main method to run this test 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        boolean run = true;
        TestCSVReaderDialog TCSVR = new TestCSVReaderDialog();
        System.out.println("Test Display: "+
              TCSVR.TestCSVReaderDialogDisplay(run).getResult());
        System.out.println("Test Set Context: "+
              TCSVR.TestsetContext(run).getResult());
        System.out.println("Test Set DataSet: "+
              TCSVR.TestsetDataSet(run).getResult());
        System.out.println("Test Set File: "+
              TCSVR.TestsetFile(run).getResult());
        System.out.println("Test Get File: "+
              TCSVR.TestGetFile(run).getResult());
        System.out.println("Test Get DataSet "+
              TCSVR.TestGetDataSet(run).getResult());
        System.out.println("Test Get Context: "+
              TCSVR.TestGetContext(run).getResult());
    }
    
    
    
    
}
