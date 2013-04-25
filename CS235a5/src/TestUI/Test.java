
package TestUI;

import java.net.URL;
import javax.swing.ImageIcon;

/** @brief Class the contains all the info for the test

    This Class will contains all the info for the test ie the title Description
    * input parameters
    @author Robert Fletcher
    @file Test.java
    @date April 2013
    */
public class Test {
    private String title;
    private String classTested = "test";
    private String methodTested =  "test";
    private String description = "test";
    private String expected =  "test";
    private String actual = "test";
    private ImageIcon IMAGE;
    private boolean run;
    private boolean passed;
   
  
/**
 * Test Constructor Sets up the test variables
 * @param title
 * @param classname
 * @param methodName
 * @param dec
 * @param exp
 * @param actutal 
 */
  public Test(
          String title, 
          String classname, 
          String methodName, 
          String dec,
          String exp, 
          String actutal) {
      
    this.title = title;
    this.description = dec;
    this.classTested = classname;
    this.methodTested = methodName;
    this.expected = exp;
    this.actual = actual;
    this.passed = false;
    this.run = false;
  }
  /**
   * Sets the run variable to true
   */
  public void hasRun(){
      run = true;
  }
  /**
   * Sets the pass variable to true or false;
   * @param boolean p - boolean if the test has passed (true) or failed 
   */
  public void setPassed(boolean p){
      passed = p;
  }
  /**
   * Gets the title of the test
   * @return String the title
   */
  
  public String getTitle() {
    return title;
  }
  /**
   * Gets the Class Name that the test
   * @return String the class name
   */
  public String getClassName() {
    return classTested;
  }
  /**
   * Returns the method name that the test is running on 
   * @return String the method name
   */
  public String getMethodName() {
    return methodTested;
  }
  /**
   * Get the test Description 
   * @return String The description
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * Get the input parameters
   * @return String the input parameters
   */
  public String getExpected() {
    return expected;
  }
  /**
   * return the string containing the expected results
   * @return String the expected result of the test
   */
  public String getActual() {
    return actual;
  }
  
  /**
   * Return the Reult of the test
   * @return String depending on if the test has passed and has run 
   */
  public String getResult(){
      if (run & passed) {
        return "Passed";
    }else if(run &!passed){
        return "Failed";
    }else{
        return "Not yet run";
    }

      
  }
  
  /**
   * Get the image icon depending if the test has run and if the test has passed
   * @return ImageIcon 
   */
  public ImageIcon getImage() {
    if (run & passed) {
        IMAGE = new ImageIcon(this.getClass().getResource("/assets/images/yes.png"));
    }else if(run &!passed){
        IMAGE = new ImageIcon(this.getClass().getResource("/assets/images/no.png"));
    }else{
        IMAGE = new ImageIcon(this.getClass().getResource("/assets/images/_null.png"));
    }
    return IMAGE;
  }

  /**
   * Overided the toString() method and returns the Test Title
   * @return 
   */
  public String toString() {
    return title;
  }
  
  
  
}
