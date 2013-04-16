package TestClasses;

import TestUI.Test;
import cs235a5.DataSet;
import cs235a5.SaveDialog;
import cs235a5.TabPannel;
import cs235a5.UserColormap;

/** @brief This class is will Test all the methods in the SaveDialog class
 
  The Class contains a number of methods to text all the methods in the 
  * SaveDialog class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see SaveDialog.java
    @date April 2013
    */

public class TestUserColor {
    private final String CLASSNAME = "USerColormap";
   
     /**
     * Method to test the UserColorClass can be run
     * @param boolean if the method is being run
     * @return Test 
     */
    public Test TestUserColor(boolean run){
            Test theTest = new Test(
                 "Test to make A ColourMAp",//Test Title
                 CLASSNAME,//Class Name
                 "SaveFile",//Method Being Tested
                 "A test to see if the class can save the xml file for the"
                    + " program to rebuild", //Description
                 "", //Input Data
                 "True - meansing that the save the file successful" //Expected output
                 );
            if(run){
                UserColormap um = new UserColormap();
                theTest.hasRun();
                if(um.getColourArray()!=null){
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
            System.out.println("Test UserColor"+
                TSD.TestSaveFile(true).getResult());
                
        }
    }