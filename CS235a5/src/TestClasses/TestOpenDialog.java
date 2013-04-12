/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.DataSet;
import cs235a5.OpenDialog;
import cs235a5.TabPannel;

/**
 *
 * @author Robert
 */
public class TestOpenDialog {
    private final String CLASSNAME = "OpenDialod";
    private OpenDialog m_OD = new OpenDialog(new DataSet(), new TabPannel());
    
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
            System.out.println("Test to Open File"+
                TOD.TestReadFile(true).getResult());
                
        
    }
}
