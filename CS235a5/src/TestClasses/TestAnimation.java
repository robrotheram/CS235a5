/** @brief This class is will Test all the methods in the Animation class
 
  The Class contains a number of methods to text all the methods in the 
  * Animation class
    @author robert Fletcher
    @file TestAnimation.java
    @see Animation.java
    @date April 2013
    */
package TestClasses;

import TestUI.Test;
import animation.Animation;
import animation.AnimationSpeed;
import animation.AnimationType;
import animation.AnimationWait;
import cs235a5.AreaChart;
import cs235a5.ColourMap;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class TestAnimation {
    public final String CLASSNAME ="Animation";
    private Animation ain = new Animation();
    private final int NumOfTest = 5;
    
    /**
     * Method to return the number of test 
     * @return 
     */
    public int GetNumOfTest(){
        return NumOfTest;
    }
    
    /**
    
     /**
     * Method to test to see if 2 charts can be added as a slide to the animation
     * @param boolean if the method is being run
     * @return Test 
     */
     public Test TestAddCharts(boolean run){
            Test theTest = new Test(
                 "Testing if you can get add 2 JPanels to ths slide",//Test Title
                 CLASSNAME,//Class Name
                 "AddBiCharts",//Method Being Tested
                 "A test to see if the you can add 2 charts to a slide", //Description
                 "2 Panels one red on yellow", //Input Data
                 "True" //Expected output
                 );   
        
           JPanel yellow = new JPanel();
           yellow.setBackground(Color.yellow);
           JPanel red = new JPanel();
           red.setBackground(Color.red);
       
        
       
        
        if(run){
            theTest.hasRun();
            if(ain.addBiCharts(red,yellow, AnimationType.UP, AnimationSpeed.FAST, AnimationWait.LONG)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
     
 /**
  * Method to test that you can set the animation wait time
  * @param run if the test should run 
  * @return The completed test
  */
    public Test TestSetWait(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the wait of the animation",//Test Title
                 CLASSNAME,//Class Name
                 "setWait",//Method Being Tested
                 "A test to see if the you set the wait of the animation", //Description
                 "AnimationWait.Long", //Input Data
                 "True" //Expected output
                 );   
     
       
        
        if(run){
            theTest.hasRun();
            if(ain.setWait(AnimationWait.LONG)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    /**
  * Method to test that you can set the animation Speed
  * @param run if the test should run 
  * @return The completed test
  */
    public Test TestSetSpeed(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the speed of the animation",//Test Title
                 CLASSNAME,//Class Name
                 "SetSpeed",//Method Being Tested
                 "A test to see if the you set the speed of the animation", //Description
                 "AnimationSpeed.FAST", //Input Data
                 "True" //Expected output
                 );   
     
       
        
        if(run){
            theTest.hasRun();
            if(ain.setSpeed(AnimationSpeed.FAST)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
  /**
  * Method to test that you can removed a slide
  * @param run if the test should run 
  * @return The completed test
  */
    public Test TestRemoveSlide(boolean run){
            Test theTest = new Test(
                 "Remove Slide test",//Test Title
                 CLASSNAME,//Class Name
                 "removeSlide",//Method Being Tested
                 "A test to see if the you sremove a slide", //Description
                 "AnimationSpeed.FAST", //Input Data
                 "True" //Expected output
                 );   
     
       
        
        if(run){
            theTest.hasRun();
            if(ain.removeSlide(0)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
/**
  * Method to test that you can display the main ui
  * @param run if the test should run 
  * @return The completed test
  */
    public Test TestDisplay(boolean run){
            Test theTest = new Test(
                 "Display Test",//Test Title
                 CLASSNAME,//Class Name
                 "N/A",//Method Being Tested
                 "A test to see if the you Display the main Ui", //Description
                 "NA", //Input Data
                 "True" //Expected output
                 );   
     
       
        
        if(run){
            theTest.hasRun();
            try{
                ain.setVisible(true);
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
        TestAnimation TA = new TestAnimation();
        System.out.println("Test to add slide: "+
                TA.TestAddCharts(run).getResult());
         System.out.println("Test to set speed: "+
                TA.TestSetSpeed(run).getResult());
          System.out.println("Test to set Wait: "+
                TA.TestSetWait(run).getResult());
           System.out.println("Test to remove slide: "+
                TA.TestRemoveSlide(run).getResult());
            System.out.println("Test to display: "+
                TA.TestDisplay(run).getResult());
    }
    
    
    
    
}
