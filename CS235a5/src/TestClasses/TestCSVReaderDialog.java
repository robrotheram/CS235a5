/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CSVReaderDialog;
import cs235a5.DataSet;
import cs235a5.VisualiserGUI;
import java.io.File;
import java.net.URL;





/**
 *
 * @author Robert
 */
public class TestCSVReaderDialog {
    private final String CLASSNAME = "CSVReaderDialog";
    private CSVReaderDialog m_CD = new CSVReaderDialog();
    private VisualiserGUI VGUI = new VisualiserGUI();
    
    public  TestCSVReaderDialog(){
        VGUI.setVisible(false);
    }
    
    public Test TestCloudDialogDisplay(boolean run){
        Test theTest = new Test(
                 "Testing if you can display the UI",//Test Title
                 CLASSNAME,//Class Name
                 "Class Constructor",//Method Being Tested
                 "A test to see if the UI Displays", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
        String userPass  = "r";
        
        if(run){
            theTest.hasRun();
             m_CD.setVisible(true);
            if(m_CD.isVisible()){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    public Test TestsetContext(boolean run){
        Test theTest = new Test(
                 "Testing if you add the hooks into the UI",//Test Title
                 CLASSNAME,//Class Name
                 "setContext",//Method Being Tested
                 "A test to see if the Set the VisualiserGUI  ", //Description
                 "VisualiserGUI", //Input Data
                 "True" //Expected output
                 );   
        
        
        
        if(run){
            theTest.hasRun();
            
            if(m_CD.setContext(VGUI)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
     public Test TestsetFile(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the file",//Test Title
                 CLASSNAME,//Class Name
                 "setFile",//Method Being Tested
                 "A test to see if the you can set a file in the class", //Description
                 "csv.csv", //Input Data
                 "True" //Expected output
                 );   
        
            URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
            File f = new File(fileURL.getPath());
        
        if(run){
            theTest.hasRun();
            
            if(m_CD.setFile(f)){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
      public Test TestsetDataSet(boolean run){
            Test theTest = new Test(
                 "Testing if you can set the DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "setDataSet",//Method Being Tested
                 "A test to see if the you can set the DataSet in the class", //Description
                 "DataSet", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            
            if(m_CD.setDataSet(new DataSet())){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
    public Test TestGetDataSet(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "getDataSet",//Method Being Tested
                 "A test to see if the you can get the DataSet from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            m_CD.setDataSet(new DataSet());
            if(m_CD.getDataSet()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    public Test TestGetContext(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the VisuliserGUI",//Test Title
                 CLASSNAME,//Class Name
                 "getContext",//Method Being Tested
                 "A test to see if the you can get the VisuliserGUI from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
        
        if(run){
            theTest.hasRun();
            m_CD.setContext(VGUI);       
            if(m_CD.getContext()!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
    
    
    
   
    
    public Test TestGetFile(boolean run){
            Test theTest = new Test(
                 "Testing if you can get the File",//Test Title
                 CLASSNAME,//Class Name
                 "getFile",//Method Being Tested
                 "A test to see if the you can get the File from the class", //Description
                 "N/A", //Input Data
                 "True" //Expected output
                 );   
        
            
         URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
            File f = new File(fileURL.getPath());
            m_CD.setFile(f);
        if(run){
            theTest.hasRun();
               
            if(m_CD.getFile()!=null){
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
        TestCSVReaderDialog TCSVR = new TestCSVReaderDialog();
        System.out.println("Test Display: "+
              TCSVR.TestCloudDialogDisplay(run).getResult());
        System.out.println("Test Set Context: "+
              TCSVR.TestsetContext(run).getResult());
        System.out.println("Test Set DataSet: "+
              TCSVR.TestsetDataSet(run).getResult());
        System.out.println("Test Set File: "+
              TCSVR.TestsetFile(run).getResult());
        System.out.println("Test Get File: "+
              TCSVR.TestGetFile(run).getResult());
        System.out.println("Test Get DataSet "+
              TCSVR.TestGetDataSet(run).getResult());
        System.out.println("Test Get Context: "+
              TCSVR.TestGetContext(run).getResult());
    }
    
    
    
    
}
