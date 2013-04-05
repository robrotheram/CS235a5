/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUI;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Robert
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
  
  

  public Test(String title, String classname, String methodName, String dec,String exp, String actutal) {
    this.title = title;
    this.description = dec;
    this.classTested = classname;
    this.methodTested = methodName;
    this.expected = exp;
    this.actual = actual;
    this.passed = false;
    this.run = false;
  }

  public void hasRun(){
      run = true;
  }
  public void setPassed(boolean p){
      passed = p;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getClassName() {
    return classTested;
  }
  
  public String getMethodName() {
    return methodTested;
  }
  
  public String getDescription() {
    return description;
  }
  
  public String getExpected() {
    return expected;
  }
  
  public String getActual() {
    return actual;
  }
  
  public String getResult(){
      if (run & passed) {
        return "Passed";
    }else if(run &!passed){
        return "Failed";
    }else{
        return "Not yet run";
    }

      
  }
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

  // Override standard toString method to give a useful result
  public String toString() {
    return title;
  }
  
  
  
}
