
package TestClasses;

import TestUI.Test;
import cs235a5.DataSet;
import cs235a5.SaveDialog;
import cs235a5.TabPannel;

/** @brief This class is will Test all the methods in the SaveDialog class
 
  The Class contains a number of methods to text all the methods in the 
  * SaveDialog class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see SaveDialog.java
    @date April 2013
    */

public class TestSaveDialog {
    private final String CLASSNAME = "SaveDialog";
    private SaveDialog m_SD = new SaveDialog(new DataSet(), new TabPannel());
     /**
     * Method to test the SaveDialog SaveFile() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestSaveFile(boolean run){
            Test theTest = new Test(
                 "Test to Write the save File",//Test Title
                 CLASSNAME,//Class Name
                 "SaveFile",//Method Being Tested
                 "A test to see if the class can save the xml file for the"
                    + " program to rebuild", //Description
                 "", //Input Data
                 "True - meansing that the save the file successful" //Expected output
                 );
            if(run){
                theTest.hasRun();
                if(m_SD.SaveFile()){
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
        TestSaveDialog TSD = new TestSaveDialog();
            System.out.println("Test SaveFile"+
                TSD.TestSaveFile(true).getResult());
                
        }
    }
    

