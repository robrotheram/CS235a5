/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CSVReader;
import cs235a5.DataSet;
import java.io.File;
import java.net.URL;

/**
 *
 * @author Robert
 */
public class TestCSVReader {
    private final String CLASSNAME = "CSVReader";
    URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
    File f = new File(fileURL.getPath());
    private CSVReader m_csv = new CSVReader(new DataSet(),f,",");
    
    
    
     public Test TestsetFile(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can set the file",//Test Title
                 CLASSNAME,//Class Name
                 "setFile",//Method Being Tested
                 "A test to see if the you can set a file in the class", //Description
                 "csv.csv", //Input Data
                 "True" //Expected output
                 );   
        
            URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
            File f = new File(fileURL.getPath());
        
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
     
     
      public Test TestGetFile(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the File",//Test Title
                 CLASSNAME,//Class Name
                 "getFile",//Method Being Tested
                 "A test to see if the you can get the File from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
         URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
            File f = new File(fileURL.getPath());
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
