package TestClasses;

import TestUI.Test;
import cs235a5.UserColormap;

/** @brief This class is will Test all the methods in the UserColor class
 
  The Class contains a number of methods to text all the methods in the 
  * UserColor class
    @author Robert Fletcher
    @file TestCSVReader.java
    @see UserColor.java
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
                 "UserColor",//Method Being Tested
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
        TestUserColor TSD = new TestUserColor();
            System.out.println("Test UserColor"+
                TSD.TestUserColor(true).getResult());
                
        }
    }