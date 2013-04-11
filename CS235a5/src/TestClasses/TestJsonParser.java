/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.JsonParser;
import cs235a5.JsonType;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Robert
 */
public class TestJsonParser {
    private final String CLASSNAME = "JsonParser";
    private JsonParser m_json = new JsonParser();
    
    
    public Test TestparseLogin(boolean run) {
        Test theTest = new Test(
                 "Testing Parseing the json object if is a login data",//Test Title
                 CLASSNAME,//Class Name
                 "parse",//Method Being Tested
                 "A test to see if the class can parse the object correctly", //Description
                 "{\"sid\":\"c58a73al49pvqeofs7uhteegh6\",\"connect\":\"yes\"}", //Input Data
                 "String not null containgin the random session id from the server" //Expected output
                 );   
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse("{\"sid\":\"c58a73al49pvqeofs7uhteegh6\",\"connect\":\"yes\"}");
        } catch (ParseException ex) {
            Logger.getLogger(TestJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(run){
          theTest.hasRun();  
           String[][] out = m_json.parse(JsonType.LOGIN, (JSONObject) obj);
            if(out == null){
               theTest.setPassed(false);
            }else{
              theTest.setPassed(true);
            }  
        }
   
        return theTest;
    }
    
    public Test TestparseList(boolean run){
        Test theTest = new Test(
                 "Testing Parseing the json object if is a list data",//Test Title
                 CLASSNAME,//Class Name
                 "parse",//Method Being Tested
                 "A test to see if the class can parse the object correctly", //Description
                 "{\"RESULT\":[{\"id\":\"2\",\"userID\":\"3\",\"fileDate\""
                + ":\"31-3-2013\",\"fileID\":\"3\",\"upload_id\":\"3\","
                + "\"filePath\":\"file\\/51589d35a1aca.jpg\",\"fileName\":"
                + "\"DSC06639_40_41_tonemapped-1024x672.jpg\"},{\"id\":\"3\","
                + "\"userID\":\"3\",\"fileDate\":\"01-4-2013\",\"fileID\":\"4\","
                + "\"upload_id\":\"4\",\"filePath\":\"file\\/5156158ed22bb-hello.jpg"
                + "\",\"fileName\":\"random\"},{\"id\":\"4\",\"userID\":\"3\","
                + "\"fileDate\":\"2-4-2013\",\"fileID\":\"5\",\"upload_id\":\"5"
                + "\",\"filePath\":\"file\\/515b0e40816f4.jpg\",\"fileName\":"
                + "\"logo.png\"},{\"id\":\"5\",\"userID\":\"3\",\"fileDate\":"
                + "\"2-4-2013\",\"fileID\":\"6\",\"upload_id\":\"6\",\"filePath"
                + "\":\"file\\/515b62977b93e.jpg\",\"fileName\":\"pic.jpg\"},"
                + "{\"id\":\"6\",\"userID\":\"3\",\"fileDate\":\"2-4-2013\","
                + "\"fileID\":\"7\",\"upload_id\":\"7\",\"filePath\":\"..\\/file"
                + "\\/515b67b68d019.jpg\",\"fileName\":\"pic.jpg\"},{\"id\":\"7\""
                + ",\"userID\":\"3\",\"fileDate\":\"2-4-2013\",\"fileID\":\"8\","
                + "\"upload_id\":\"8\",\"filePath\":\"..\\/file\\/515b689497c7b.jpg\","
                + "\"fileName\":\"apocalypse.jpg\"},{\"id\":\"8\",\"userID\":\"3\","
                + "\"fileDate\":\"2-4-2013\",\"fileID\":\"9\",\"upload_id\":\"9\","
                + "\"filePath\":\"..\\/file\\/515b6d456e042.jpg\",\"fileName\":"
                + "\"pic.jpg\"},{\"id\":\"9\",\"userID\":\"3\",\"fileDate\":"
                + "\"2-4-2013\",\"fileID\":\"10\",\"upload_id\":\"10\",\"filePath\""
                + ":\"..\\/file\\/515b6d6d7788f.jpg\",\"fileName\":\"pic.jpg\"},"
                + "{\"id\":\"10\",\"userID\":\"3\",\"fileDate\":\"2-4-2013\""
                + ",\"fileID\":\"11\",\"upload_id\":\"11\",\"filePath\":\"..\\/"
                + "file\\/515b7009d640b.jpg\",\"fileName\":\"pic.jpg\"},{\"id\":"
                + "\"11\",\"userID\":\"3\",\"fileDate\":\"10-4-2013\",\"fileID\":"
                + "\"12\",\"upload_id\":\"12\",\"filePath\":\"..\\/file\\"
                + "/51658625dd18d.jpg\",\"fileName\":\"csv.csv\"},{\"id\":\"12\""
                + ",\"userID\":\"3\",\"fileDate\":\"10-4-2013\",\"fileID\":\"13\""
                + ",\"upload_id\":\"13\",\"filePath\":\"..\\/file\\"
                + "/5165cc35caaee.jpg\",\"fileName\":\"csv.csv\"}],\"connect\":"
                + "\"yes\"}", //Input Data
                 "String not null containgin the random session id from the server" //Expected output
                 );   
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(
                    "{\"RESULT\":[{\"id\":\"2\",\"userID\":\"3\",\"fileDate\""
                + ":\"31-3-2013\",\"fileID\":\"3\",\"upload_id\":\"3\","
                + "\"filePath\":\"file\\/51589d35a1aca.jpg\",\"fileName\":"
                + "\"DSC06639_40_41_tonemapped-1024x672.jpg\"},{\"id\":\"3\","
                + "\"userID\":\"3\",\"fileDate\":\"01-4-2013\",\"fileID\":\"4\","
                + "\"upload_id\":\"4\",\"filePath\":\"file\\/5156158ed22bb-hello.jpg"
                + "\",\"fileName\":\"random\"},{\"id\":\"4\",\"userID\":\"3\","
                + "\"fileDate\":\"2-4-2013\",\"fileID\":\"5\",\"upload_id\":\"5"
                + "\",\"filePath\":\"file\\/515b0e40816f4.jpg\",\"fileName\":"
                + "\"logo.png\"},{\"id\":\"5\",\"userID\":\"3\",\"fileDate\":"
                + "\"2-4-2013\",\"fileID\":\"6\",\"upload_id\":\"6\",\"filePath"
                + "\":\"file\\/515b62977b93e.jpg\",\"fileName\":\"pic.jpg\"},"
                + "{\"id\":\"6\",\"userID\":\"3\",\"fileDate\":\"2-4-2013\","
                + "\"fileID\":\"7\",\"upload_id\":\"7\",\"filePath\":\"..\\/file"
                + "\\/515b67b68d019.jpg\",\"fileName\":\"pic.jpg\"},{\"id\":\"7\""
                + ",\"userID\":\"3\",\"fileDate\":\"2-4-2013\",\"fileID\":\"8\","
                + "\"upload_id\":\"8\",\"filePath\":\"..\\/file\\/515b689497c7b.jpg\","
                + "\"fileName\":\"apocalypse.jpg\"},{\"id\":\"8\",\"userID\":\"3\","
                + "\"fileDate\":\"2-4-2013\",\"fileID\":\"9\",\"upload_id\":\"9\","
                + "\"filePath\":\"..\\/file\\/515b6d456e042.jpg\",\"fileName\":"
                + "\"pic.jpg\"},{\"id\":\"9\",\"userID\":\"3\",\"fileDate\":"
                + "\"2-4-2013\",\"fileID\":\"10\",\"upload_id\":\"10\",\"filePath\""
                + ":\"..\\/file\\/515b6d6d7788f.jpg\",\"fileName\":\"pic.jpg\"},"
                + "{\"id\":\"10\",\"userID\":\"3\",\"fileDate\":\"2-4-2013\""
                + ",\"fileID\":\"11\",\"upload_id\":\"11\",\"filePath\":\"..\\/"
                + "file\\/515b7009d640b.jpg\",\"fileName\":\"pic.jpg\"},{\"id\":"
                + "\"11\",\"userID\":\"3\",\"fileDate\":\"10-4-2013\",\"fileID\":"
                + "\"12\",\"upload_id\":\"12\",\"filePath\":\"..\\/file\\"
                + "/51658625dd18d.jpg\",\"fileName\":\"csv.csv\"},{\"id\":\"12\""
                + ",\"userID\":\"3\",\"fileDate\":\"10-4-2013\",\"fileID\":\"13\""
                + ",\"upload_id\":\"13\",\"filePath\":\"..\\/file\\"
                + "/5165cc35caaee.jpg\",\"fileName\":\"csv.csv\"}],\"connect\":"
                + "\"yes\"}"
                    );
                    } catch (ParseException ex) {
            Logger.getLogger(TestJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(run){
          theTest.hasRun();  
           String[][] out = m_json.parse(JsonType.LIST, (JSONObject) obj);
            if(out == null){
               theTest.setPassed(false);
            }else{
              theTest.setPassed(true);
            }  
        }
   
        return theTest;
    }
    
    public Test TestparseGet(boolean run){
        Test theTest = new Test(
                 "Testing Parseing the json object if is a Get File Path data",//Test Title
                 CLASSNAME,//Class Name
                 "parse",//Method Being Tested
                 "A test to see if the class can parse the object correctly", //Description
                 "{\"id\":\"13\",\"connect\":\"yes\",\"name\":\"csv.csv\",\"path\":\"..\\/file\\/5165cc35caaee.jpg\"}", //Input Data
                 "String not null containgin the random session id from the server" //Expected output
                 );   
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse("{\"id\":\"13\",\"connect\":\"yes\",\"name\":\"csv.csv\",\"path\":\"..\\/file\\/5165cc35caaee.jpg\"}");
        } catch (ParseException ex) {
            Logger.getLogger(TestJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(run){
          theTest.hasRun();  
           String[][] out = m_json.parse(JsonType.GET, (JSONObject) obj);
            if(out == null){
               theTest.setPassed(false);
            }else{
              theTest.setPassed(true);
            }  
        }
   
        return theTest;
    }
    
    public Test TestparseUpload(boolean run) {
        Test theTest = new Test(
                 "Testing Parseing the json object if is a upload data",//Test Title
                 CLASSNAME,//Class Name
                 "parse",//Method Being Tested
                 "A test to see if the class can parse the object correctly", //Description
                 "{\"Succseful\":\"yes\",\"connect\":\"yes\"}", //Input Data
                 "String not null containgin the random session id from the server" //Expected output
                 );   
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse("{\"Succseful\":\"yes\",\"connect\":\"yes\"}");
        } catch (ParseException ex) {
            Logger.getLogger(TestJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(run){
          theTest.hasRun();  
           String[][] out = m_json.parse(JsonType.UPLOAD, (JSONObject) obj);
            if(out == null){
               theTest.setPassed(false);
            }else{
              theTest.setPassed(true);
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
        TestJsonParser TJP = new TestJsonParser();
        System.out.println("Test Parse Login Data: "+
                TJP.TestparseLogin(run).getResult());
        System.out.println("Test Parse Upload Data: "+
                TJP.TestparseUpload(run).getResult());
        System.out.println("Test Parse GetData: "+
                TJP.TestparseGet(run).getResult());
        System.out.println("Test Parse List Data: "+
                TJP.TestparseList(run).getResult());
        
    }
    
    
}
