/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.DataSet;
import cs235a5.SaveDialog;
import cs235a5.TabPannel;

/**
 *
 * @author Robert
 */
public class TestSaveDialog {
    private final String CLASSNAME = "SaveDialod";
    private SaveDialog m_SD = new SaveDialog(new DataSet(), new TabPannel());
    
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
    

