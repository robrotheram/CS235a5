/** @brief This class is will Test all the methods in the Colourmap class
 
  The Class contains a number of methods to text all the methods in the C
  * ColourMap class
    @author Robert Fletcher
    @file TestChart.java
    @see Chart.java
    @date April 2013
    */
package TestClasses;

import TestUI.Test;
import cs235a5.ColourMap;
import java.awt.Color;

/**
 *
 * @author Robert
 */
public class TestColourMap {
     private final String CLASSNAME = "ColourMap";
     
     private final Color[] CLR = {Color.RED,Color.GREEN,Color.BLUE,Color.CYAN,Color.ORANGE};
     private ColourMap CM = new ColourMap(CLR);
     
     
     /**
     * Method to test the ColourMap Can Set the Color Array
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestSetColourArray(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can set the color array",//Test Title
                 CLASSNAME,//Class Name
                 "setFile",//Method Being Tested
                 "A test to see if the you can set a color array  in the class", //Description
                 "{Color}", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(CM.setColourArray(CLR)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     /**
     * Method to test the ColourMap Can Get the Color Array
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestGetColourArray(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can Get the color array",//Test Title
                 CLASSNAME,//Class Name
                 "setFile",//Method Being Tested
                 "A test to see if the you can Get a color array  in the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(CM.getColourArray()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
    /**
     * Method to test the ColourMap Can Get the Panels that have a background 
     * the color the same as the color array inputted to the colourMap
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestGetPanels(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can Get the Pannels from the color map",//Test Title
                 CLASSNAME,//Class Name
                 "getPane;s",//Method Being Tested
                 "A test to see if the you can Get a panels from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(CM.getPanels()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
     /**
     * Method to test the ColourMap Can Get a colour at a specific index in the colour array 
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestGetColorAtI(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can Get the colour at i",//Test Title
                 CLASSNAME,//Class Name
                 "getColour",//Method Being Tested
                 "A test to see if the you can Get a color from the colour array", //Description
                 "0", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(CM.getColour(0)!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    } 
     
      /**
     * Method to test the ColourMap Can Get number of colors in the array
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestGetNum(boolean run){
         
        
            Test theTest = new Test(
                 "Testing if you can Get the colour at i",//Test Title
                 CLASSNAME,//Class Name
                 "getNumberOfColours",//Method Being Tested
                 "A test to see if the you can Get the number of colours in the array", //Description
                 "0", //Input Data
                 "True" //Expected output
                 );   

        
        if(run){
            theTest.hasRun();
            
            if(CM.getColour(0)!=null){
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
        TestColourMap TCM = new TestColourMap();
        System.out.println("Test Set colour Array: "+
                TCM.TestSetColourArray(run).getResult());
         System.out.println("Test Get colour Array: "+
                TCM.TestGetColourArray(run).getResult());
          System.out.println("Test Get colour Pannels: "+
                TCM.TestGetPanels(run).getResult());
           System.out.println("Test get colour At I: "+
                TCM.TestGetColorAtI(run).getResult());
            System.out.println("Test get Number of colours "+
                TCM.TestGetNum(run).getResult());
    }
}
