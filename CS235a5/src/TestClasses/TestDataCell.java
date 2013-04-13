
package TestClasses;

import TestUI.Test;
import cs235a5.DataCell;
import cs235a5.DataType;

/** @brief Class the contains all the methods in the DataCell Class

    This Class will contains all methods for the dataCell class and return a 
    * test class
    @author Robert Fletcher
    @file  TestDataCell.java
    @date April 2013
    */

public class TestDataCell {
    
    private final String CLASSNAME = "DataCell";
    private DataCell m_DC = new DataCell("string");
    
    /**
     * Test to set a string
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    public Test testSetDataString(boolean run){
        
        Test theTest = new Test(
                 "Testing Setting String Data",//Test Title
                 CLASSNAME,//Class Name
                 "SetData",//Method Being Tested
                 "A test to see if the class can set the data correctly", //Description
                 "String", //Input Data
                 "True - and if the DataType = String" //Expected output
                 );   
        
        String TestString = "String";
        if(run){
          theTest.hasRun();  
          if(m_DC.SetData(TestString)){
              
              if(m_DC.GetDataType()==DataType.STRING){
                  
                  theTest.setPassed(true);
              }else{
                   theTest.setPassed(false);
              }
          }else{
              theTest.setPassed(false);
          }
            
        }
        return theTest;
    }
    
    /**
     * Test to set a Double
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    public Test testSetDataDouble(boolean run){
        Test theTest = new Test(
                 "Testing Setting Double Data",
                 CLASSNAME,
                 "SetData",
                 "A test to see if the class can set the data correctly",
                 "30.4",
                 "True - and if the DataType = Double"
                 );   
        
        String TestString = "30.4";
        if(run){
          theTest.hasRun();  
          if(m_DC.SetData(TestString)){
              if(m_DC.GetDataType()==DataType.DOUBLE){
                  theTest.setPassed(true);
              }else{
                   theTest.setPassed(false);
              }
          }else{
              theTest.setPassed(false);
          }
        }  

        return theTest;
    }
    
    
    /**
     * Test to set a Integer
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    public Test testSetInteger(boolean run){
        Test theTest = new Test(
                 "Testing Setting Integer Data",
                 CLASSNAME,
                 "SetData",
                 "A test to see if the class can set the data correctly",
                 "4",
                 "True - and if the DataType = Integer"
                 );   
        
        String TestString = "4";
        if(run){
          theTest.hasRun();  
          if(m_DC.SetData(TestString)){
              if(m_DC.GetDataType()==DataType.INTEGER){
                  theTest.setPassed(true);
              }else{
                   theTest.setPassed(false);
              }
          }else{
              theTest.setPassed(false);
          }
            
        }
        return theTest;
    }
    
    /**
     * Test to set a Boolean
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
     public Test testSetBoolean(boolean run){
        Test theTest = new Test(
                 "Testing Setting Boolean Data",
                 CLASSNAME,
                 "SetData",
                 "A test to see if the class can set the data correctly",
                 "",
                 "True - and if the DataType = BO0LEAN"
                 );   
        
        String TestString = "true";
        if(run){
          theTest.hasRun();  
          if(m_DC.SetData(TestString)){
              if(m_DC.GetDataType()==DataType.BOOLEAN){
                  theTest.setPassed(true);
            }else{
              theTest.setPassed(false);
          } 
              
           
          }else{
              theTest.setPassed(false);
          }
        } 
      
        return theTest;
    }
     
     /**
     * Test to set get a string from the dataCell Class
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
     
    public Test testGetString(boolean run){
        Test theTest = new Test(
                 "Testing getting the String Data",
                 CLASSNAME,
                 "GetString",
                 "A test to see if the class can get the String correctly",
                 "N/A",
                 "True"
                 );   
        String input = "String";
        m_DC = new DataCell(input);
        if(run){
           theTest.hasRun();
            if(m_DC.GetString().equals(input)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false); 
            }
        }
     return theTest;
    }
    
    /**
     * Test to set get a Double from the dataCell Class
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    public Test testGetDouble(boolean run){
        Test theTest = new Test(
                 "Testing getting the Double Data",
                 CLASSNAME,
                 "GetString",
                 "A test to see if the class can get the Double correctly",
                 "N/A",
                 "True"
                 );   
        String input = "30.4";
        m_DC = new DataCell(input);
        if(run){
           theTest.hasRun();
            if(m_DC.GetDouble()==Double.parseDouble(input)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false); 
            }
        }
     return theTest;
    }
    
    /**
     * Test to set get a integer from the dataCell Class
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    public Test testGetInteger(boolean run){
                
        Test theTest = new Test(
                 "Testing getting the Integer Data",
                 CLASSNAME,
                 "GetString",
                 "A test to see if the class can get the Integer correctly",
                 "N/A",
                 "True"
                 );   
        String input = "5";
        m_DC = new DataCell(input);
        if(run){
           theTest.hasRun();
            if(m_DC.GetInteger()==Integer.parseInt(input)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false); 
            }
        }
     return theTest;
    }
    
    /**
     * Test to set get a Boolean from the dataCell Class
     * @param Boolean run has the test run 
     * @return Test - the info about this test
     */
    
    public Test testGetBoolen(boolean run){
                
        Test theTest = new Test(
                 "Testing getting the Boolean Data",
                 CLASSNAME,
                 "GetString",
                 "A test to see if the class can get the Boolean correctly",
                 "N/A",
                 "True"
                 );   
        String input = "5";
        m_DC = new DataCell(input);
        if(run){
           theTest.hasRun();
            if((m_DC.GetBoolean())||(!m_DC.GetBoolean())){
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
        boolean run = true;
        TestDataCell TDC = new TestDataCell();
        System.out.println("Test SetData:"
                +TDC.testSetDataString(run).getResult());
        System.out.println("Test SetData:"
                +TDC.testSetBoolean(run).getResult());
        System.out.println("Test SetData:"
                +TDC.testSetDataDouble(run).getResult());
        System.out.println("Test SetData:"
                +TDC.testSetInteger(run).getResult());
        System.out.println("Test GetBoolean: "
                +TDC.testGetBoolen(run).getResult());
        System.out.println("Test GetInteger: "
                +TDC.testGetDouble(run).getResult());
        System.out.println("Test GetInteger: "
                +TDC.testGetInteger(run).getResult());
        System.out.println("Test GetString:"+
                TDC.testGetString(run).getResult());
    }
    
}
