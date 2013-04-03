/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
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
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Robert
 */
public class CloudIO {
    private final String SERVER = "http://54.243.57.127/cs235/";
    private final String UPLOAD = "upload.php?sid=";
    private final String LOGIN = "login.php";
    private final String GET = "get.php?sid=";
    private final String LIST = "list.php?sid=";
    private JSONParser parser;
    private HttpClient httpclient;
    private JsonParser jP;
    public CloudIO(){
        httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        parser = new JSONParser();
        jP = new JsonParser();
    }
    
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
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }
      
    }
    
    public String[][] List(String sid){
        try {
            HttpGet request = new HttpGet(SERVER+LIST+sid);
            HttpResponse response = httpclient.execute(request);
            Reader in = new InputStreamReader(response.getEntity().getContent());
	    Object obj = parser.parse(in);
            return jP.parse(JsonType.LIST, (JSONObject) obj);
            
        } catch (ParseException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
    }
    
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
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  
    }
    
    public String upload(String sid, File file){
        try {
            HttpClient httpclient = new DefaultHttpClient();
           httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

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
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public File DownloadFile(String path){
        try {
            String name = this.getClass().getName();  
         
            File file = new File(System.getProperty("user.dir")+"/test1234.jpg");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


            httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(SERVER+"../"+path);
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
            Logger.getLogger(CloudIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

    }
        return null;
}
 
    
}
