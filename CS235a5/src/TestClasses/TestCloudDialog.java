/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CloudDialog;
import cs235a5.DataSet;

/**
 *
 * @author Robert
 */
public class TestCloudDialog {
    private final String CLASSNAME = "CloudDialog";
    private CloudDialog m_CD;
    
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
            m_CD = new CloudDialog(new DataSet());
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
