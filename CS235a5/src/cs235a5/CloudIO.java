/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** @brief This class contains all the methods to communicate to the server

    This Class contains 5 methods that communicate to the server. Login() that 
    * will return the sid form the server if successful. List() list the files 
    * you have uploaded. getFilePath() that gets the file path to the csv file 
    * on the server upload() and Download() to transfer the files to and from
    * the server.
    @author Robert Fletcher
    @file CloudIO.java
    @date April 2013
    */

public class CloudIO {

    
    /**
     * Custom Constructor for this class. It sets up the httpClient and the TCP 
     * protocol being used. 
     */
    public CloudIO(){
        httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION,
                HttpVersion.HTTP_1_1);
        parser = new JSONParser();
        jP = new JsonParser();
    }
    
    
    /**
     * This Method will log into the server and will return the session ID if 
     * the login is Successful.
     * @param String User the username for the server
     * @param String  Password the password to the server
     * @return String the Session ID form the server or null
     */
    public String login(String user, String pass){
        try {
            HttpPost httppost = new HttpPost(SERVER+LOGIN);
            
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("user", user));
            nameValuePairs.add(new BasicNameValuePair("pass", pass));


            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            
            Reader in = new InputStreamReader(response.getEntity().getContent());
	    Object obj = parser.parse(in);
            
            String[][] out = jP.parse(JsonType.LOGIN, (JSONObject) obj);
            if(out == null){
                return null;
            }else{
             return out[0][0];
            }
        
        
        } catch (ParseException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, 
                    ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, 
                    ex);  
            return null;
        }
      
    }
    
   /**
    * This Method will List all the files you have uploaded.
    * @param String sid the session id you have got from the login method
    * @return String[][] the object that contains a list of the files you have
    * uploaded
    */
    public String[][] List(String sid){
        try {
            HttpGet request = new HttpGet(SERVER+LIST+sid);
            HttpResponse response = httpclient.execute(request);
            Reader in = new InputStreamReader(response.getEntity()
                    .getContent());
	    Object obj = parser.parse(in);
            return jP.parse(JsonType.LIST, (JSONObject) obj);
            
        } catch (ParseException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null,
                    ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, 
                    ex);
            return null;
        }
  
    }
    
    /**
     * This Method will return the path of the file so long as you are loged in 
     * @param String sid the session id you have got from the login method
     * @param fileID the id of the file you want to retrieve
     * @return String URL file path
     */
    public String getFilePath(String sid, String fileID){
        try {
            HttpGet request = new HttpGet(SERVER+GET+sid+"&file="+fileID);
            HttpResponse response = httpclient.execute(request);
            Reader in = new InputStreamReader(response.getEntity().getContent());
	    Object obj = parser.parse(in);
            String[][] out = jP.parse(JsonType.GET, (JSONObject) obj);
            if(out == null){
                return null;
            }else{
             return out[0][0];
            }
        } catch (ParseException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, 
                    ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, 
                    ex);
            return null;
        }
  
    }
    /**
     * This Method will List all the files you have uploaded.
     * @param String sid the session id you have got from the login method
     * @param file File you are going to upload
     * @return String will contain the word yes if upload is successful
     */
    public String upload(String sid, File file){
        try {
            HttpClient httpclient = new DefaultHttpClient();
           httpclient.getParams().setParameter(
                   CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

           HttpPost httppost = new HttpPost(SERVER+UPLOAD+sid);

           MultipartEntity mpEntity = new MultipartEntity();
           ContentBody cbFile = new FileBody(file, "image/jpeg");
           mpEntity.addPart("upload", cbFile);

           httppost.setEntity(mpEntity);
           System.out.println("executing request " + httppost.getRequestLine());
           HttpResponse response = httpclient.execute(httppost);
           HttpEntity resEntity = response.getEntity();
           
           Reader in = new InputStreamReader(response.getEntity().getContent());
           Object obj = parser.parse(in);
            String[][] out = jP.parse(JsonType.UPLOAD, (JSONObject) obj);
            if(out == null){
                return null;
            }else{
             return out[0][0];
            } 

           

        } catch (ParseException ex) {
            Logger.getLogger(
                    CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(
                    
                    CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Download the file from the path got from the getFilePath() method or a 
     * custom URL of your choosing 
     * @param String URL path to the string
     * @return file the downloaded file
     */
    public File DownloadFile(String path){
        try {
            String name = this.getClass().getName();  
            
            File file = new File(System.getProperty("user.dir")+"/"+getDate()+".csv");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(
                          CloudIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(SERVER+path);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                long len = entity.getContentLength();
                InputStream is = entity.getContent();
                OutputStream out = new FileOutputStream(file);
 
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = is.read(bytes)) != -1) {
                        out.write(bytes, 0, read);
                }

                is.close();
                out.flush();
                out.close();

               return file;
            }
        } catch (IOException ex) {
            Logger.getLogger(
                    CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

    }
        return null;
}
    /**
     * Method to get the current time and date and return it as a string
     * @return String  - the current time and Data
     */
     private String getDate(){
               DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
               //get current date time with Date()
               Date date = new Date();
               System.out.println(dateFormat.format(date));
         
               //get current date time with Calendar()
               Calendar cal = Calendar.getInstance();
               return(dateFormat.format(cal.getTime()));
               
           
           
     }    
    private final String SERVER = "http://54.243.57.127/cs235/";
    private final String UPLOAD = "upload.php?sid=";
    private final String LOGIN = "login.php";
    private final String GET = "get.php?sid=";
    private final String LIST = "list.php?sid=";
    private JSONParser parser;
    private HttpClient httpclient;
    private JsonParser jP;
}
