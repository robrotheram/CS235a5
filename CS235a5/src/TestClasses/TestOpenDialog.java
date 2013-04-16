/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.DataSet;
import cs235a5.OpenDialog;
import cs235a5.TabPannel;
import cs235a5.VisualiserGUI;

/** @brief This class is will Test all the methods in the OpenDialog class
 
  The Class contains a number of methods to text all the methods in the 
  * OpenDialog class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see OpenDialog.java
    @date April 2013
    */

public class TestOpenDialog {
    private final String CLASSNAME = "OpenDialog";
    private OpenDialog m_OD = new OpenDialog(new DataSet(), new TabPannel(),new VisualiserGUI());
    
     /**
     * Method to test the OpenDialog ReadFile() method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestReadFile(boolean run){
            Test theTest = new Test(
                 "Test to Write the Open File",//Test Title
                 CLASSNAME,//Class Name
                 "OpenFile",//Method Being Tested
                 "A test to see if the class can open the xml file for the"
                    + " program to rebuild", //Description
                 "", //Input Data
                 "True - meansing that the save the file successful" //Expected output
                 );
            if(run){
                theTest.hasRun();
                try{
                if(m_OD.ReadFile()){
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
     * Main method to run this test 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        TestOpenDialog TOD = new TestOpenDialog();
            System.out.println("Test to Open File: "+
                TOD.TestReadFile(true).getResult());
                
        
    }
}
