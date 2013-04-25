/** @brief This class is will Test all the methods in the SlideLeft class
 
  The Class contains a number of methods to text all the methods in the 
  * Slide left
    @author Robert Fletcher
    @file TestSlideLeft.java
    @see SlideLeft.java
    @date April 2013
    */

package TestClasses;

import TestUI.Test;
import animation.Animation;
import animation.AnimationSpeed;
import animation.AnimationType;
import animation.AnimationWait;
import animation.SlideLeft;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Robert
 */
public class TestSlideLeft {
    private final String CLASSNAME ="Slide Left";
    private SlideLeft sl = new SlideLeft(new JPanel(),new JPanel(),AnimationSpeed.VERYFAST, AnimationWait.VERYSHORT);
    
     /**
     * Method to test to see if SlideLeft pannel can start the treat
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestStart(boolean run){
            Test theTest = new Test(
                 "Test Start",//Test Title
                 CLASSNAME,//Class Name
                 "start()",//Method Being Tested
                 "A test to seethe slide can start", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        
        
       
        
        if(run){
            theTest.hasRun();
            try{
                sl.start();
                theTest.setPassed(true);
            }catch(Exception e){
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
 
    
    /**
     * main method to run all the tests
     * @param args 
     */
    public static void main(String[] args){
        boolean run = true;
        TestSlideLeft TSL = new TestSlideLeft();
        System.out.println("Test to start "+
                TSL.TestStart(run).getResult());
        
    }
    
    
}
