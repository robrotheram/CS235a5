
package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.DataSet;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/** @brief This class is will Test all the methods in the CSVReader class
 
  The Class contains a number of methods to text all the methods in the 
  * CSVReader class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see CSVReader.java
    @date April 2013
    */

public class TestCSVReader {
    private final String CLASSNAME = "CSVReader";
    private CSVReader m_csv = new CSVReader(new DataSet(),getFile(),",");
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
     * Method to test the CSVReader SetFile() method  and returns a Test object containing the 
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
            
            if(m_csv.SetFile(f)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
       /**
     * Method to test the CSVReader GetFile() method  and returns a Test object containing the 
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
        
            

            m_csv.SetFile(f);
        if(run){
            theTest.hasRun();
               
            if(m_csv.GetFile()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
        /**
     * Method to test the CSVReader GetDataSet() method  and returns a Test object containing the 
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
            m_csv.SetDataset(new DataSet());
            if(m_csv.GetDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
        /**
     * Method to test the CSVReader SetDataSet() method  and returns a Test object containing the 
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
            
            if(m_csv.SetDataset(new DataSet())){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
        /**
     * Method to test the CSVReader GetDeliminators() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
      
      public Test TestGetDelimiters(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the Delimiters",//Test Title
                 CLASSNAME,//Class Name
                 "getDataSet",//Method Being Tested
                 "A test to see if the you can get the Delimiterst from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_csv.GetDelimitor()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
        /**
     * Method to test the CSVReader SetDelimiter() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
      public Test TestsetDelimiter(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "setDataSet",//Method Being Tested
                 "A test to see if the you can set the DataSet in the class", //Description
                 ",", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_csv.SetDelimiter(",")){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       /**
     * Method to test the CSVReader ParseFile method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */ 
     public Test TestParseFile(boolean run){
            Test theTest = new Test(
                 "Testing if ther class can parse the file",//Test Title
                 CLASSNAME,//Class Name
                 "ParseFile",//Method Being Tested
                 "A test to see if the Class can read a file and add the data"
                    + " to the dataSet", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_csv.ParseFile()){
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
        TestCSVReader TCSV = new TestCSVReader();
        
        System.out.println("Test Set DataSet: "+
              TCSV.TestsetDataSet(run).getResult());
        System.out.println("Test Set File: "+
              TCSV.TestsetFile(run).getResult());
        System.out.println("Test Get File: "+
              TCSV.TestGetFile(run).getResult());
        System.out.println("Test Get DataSet "+
              TCSV.TestGetDataSet(run).getResult());
        System.out.println("Test Get Delimiter: "+
              TCSV.TestGetDelimiters(run).getResult());
        System.out.println("Test Set Delimiter: "+
              TCSV.TestsetDelimiter(run).getResult());
         System.out.println("Test ParseFile: "+
              TCSV.TestParseFile(run).getResult());
        
    }
      
      
      
}
