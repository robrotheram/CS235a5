/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.CloudIO;
import cs235a5.DataType;
import java.io.File;
import java.net.URL;

/**
 *
 * @author Robert
 */
public class TestCloudIO {
    private final String CLASSNAME = "CloudIO";
    private CloudIO Cloud = new CloudIO();
    
    public Test TestLogin(boolean run){
        Test theTest = new Test(
                 "Testing if you can log into the server",//Test Title
                 CLASSNAME,//Class Name
                 "Login",//Method Being Tested
                 "A test to see if the Server gives you the session id if the log in is correct", //Description
                 "username r, password r", //Input Data
                 "ssid != null" //Expected output
                 );   
        
        String userPass  = "r";
        if(run){
            theTest.hasRun();
            if(Cloud.login(userPass, userPass)!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     public Test TestList(boolean run){
        Test theTest = new Test(
                 "Testing if you can List the files on the server",//Test Title
                 CLASSNAME,//Class Name
                 "List",//Method Being Tested
                 "A test to see if the Server gives you the list of files", //Description
                 "correct r,r", //Input Data
                 "List != null" //Expected output
                 );   
        
        String userPass  = "r";
        String ssid = Cloud.login(userPass, userPass);
        if(run){
            theTest.hasRun();
            if(Cloud.List(ssid) !=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
     
      public Test TestgetFilePath(boolean run){
        Test theTest = new Test(
                 "Testing if you canget the file path to a file id",//Test Title
                 CLASSNAME,//Class Name
                 "getFilePath",//Method Being Tested
                 "A test to see if the Server gives you the sfile with the id of X", //Description
                 "File id 13", //Input Data
                 "ssid != null" //Expected output
                 );   
        
        String fileid  = "13";
        String ssid = Cloud.login("r","r");
        if(run){
            theTest.hasRun();
            if(Cloud.getFilePath(ssid, fileid)!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
      public Test TestUpload(boolean run){
        Test theTest = new Test(
                 "Testing if you can log upload a file to the server",//Test Title
                 CLASSNAME,//Class Name
                 "Login",//Method Being Tested
                 "A test to see if the Server gives you the a respose = yes", //Description
                 "File", //Input Data
                 "String != null" //Expected output
                 );   
        URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
        File f = new File(fileURL.getPath());
        String ssid = Cloud.login("r","r");
        if(run){
            theTest.hasRun();
            if(Cloud.upload(ssid, f) !=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
      
      public Test TestDownloadFile(boolean run){
        Test theTest = new Test(
                 "Testing if you can download a file ",//Test Title
                 CLASSNAME,//Class Name
                 "DownLoadFile",//Method Being Tested
                 "A test to see if tyou can Download a file", //Description
                 "/path/to/file/on/server", //Input Data
                 "ssid != null" //Expected output
                 );   
        
        String userPass  = "r";
        String ssid = Cloud.login("r","r");
        String path = Cloud.getFilePath(ssid, "13");
        if(run){
            theTest.hasRun();
            if(Cloud.DownloadFile(path)!=null){
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
        TestCloudIO  TC = new TestCloudIO();
        
        
        System.out.println("Test login: "+
               TC.TestLogin(run).getResult());
        System.out.println("Test list: "+
               TC.TestList(run).getResult());
        System.out.println("Test getFilePath: "+
               TC.TestgetFilePath(run).getResult());
        System.out.println("Test Upload a file: "+
               TC.TestUpload(run).getResult());
        System.out.println("Tes Download a file "+
               TC.TestDownloadFile(run).getResult());
       

        
}
}
