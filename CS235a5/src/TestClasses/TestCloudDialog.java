/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CloudDialog;
import cs235a5.DataSet;
import cs235a5.VisualiserGUI;

/** @brief This class is will Test all the methods in the CloudDialog class
 
  The Class contains a number of methods to text all the methods in the 
  * CloudDialog class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see CloudDialog.java
    @date April 2013
    */
public class TestCloudDialog {
    private final String CLASSNAME = "CloudDialog";
    private CloudDialog m_CD;
    
      /**
     * Method to test the CloudDialog CloudDialogDisplay method  and returns a Test object containing the 
     * test tile, Class being tested, method being tested,test description, 
     * Input data expected output, if the test has been run and if the test 
     * is passed.
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestCloudDialogDisplay(boolean run){
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
            VisualiserGUI v =new VisualiserGUI();
            v.setVisible(false);
            m_CD = new CloudDialog(new DataSet(),v);
            if(m_CD.isVisible()){
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
        TestCloudDialog TCD = new TestCloudDialog();
        System.out.println("Test login: "+
               TCD.TestCloudDialogDisplay(run).getResult());
    }
    
}
