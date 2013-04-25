
/** @brief This class is will Test all the methods in the Slide class
 
  The Class contains a number of methods to text all the methods in the 
  * Slide 
    @author Robert Fletcher
    @file TestSlide.java
    @see Slide.java
    @date April 2013
    */
package TestClasses;

import TestUI.Test;
import animation.AnimationSpeed;
import animation.AnimationType;
import animation.AnimationWait;
import animation.Slide;
import animation.SlideLeft;
import javax.swing.JPanel;


public class TestSlide {
    private final String CLASSNAME ="Slide Left";
    private Slide sl = new Slide(new JPanel(),new JPanel(),AnimationSpeed.VERYFAST, AnimationWait.VERYSHORT,AnimationType.LEFT);
    
    /**
     * Method to test to see if Slid panel can start the treat
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestStart(boolean run){
            Test theTest = new Test(
                 "Test Pause",//Test Title
                 CLASSNAME,//Class Name
                 "start()",//Method Being Tested
                 "A test to pause", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        
        
       
        
        if(run){
            theTest.hasRun();
            try{
                sl.start(new Thread());
                theTest.setPassed(true);
            }catch(Exception e){
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     /**
     * Method to test to see if Slide panel can pause the the thread
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestPause(boolean run){
            Test theTest = new Test(
                 "Test Pause",//Test Title
                 CLASSNAME,//Class Name
                 "pause()",//Method Being Tested
                 "A test to see the thread to be paused", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        
        
       
        
        if(run){
            theTest.hasRun();
            try{
                sl.pause();
                theTest.setPassed(true);
            }catch(Exception e){
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     /**
     * Method to test to see if Slide panel can resume the thread
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test Testreume(boolean run){
            Test theTest = new Test(
                 "Test reume",//Test Title
                 CLASSNAME,//Class Name
                 "resume()",//Method Being Tested
                 "A test to see thread can be reumed ", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        
        
       
        
        if(run){
            theTest.hasRun();
            try{
                sl.resume();
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
        TestSlide TS = new TestSlide();
        System.out.println("Test to start "+
                TS.TestStart(run).getResult());
        System.out.println("Test to start "+
                TS.TestPause(run).getResult());
        System.out.println("Test to start "+
                TS.Testreume(run).getResult());
        
    }
    
}
