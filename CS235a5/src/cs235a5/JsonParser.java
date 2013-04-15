
package cs235a5;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** @brief This class is will parser a json File and return it to the CloudIO

    The Json file is got from the server using the CloudIO.java and depending 
    * on the action will contain different tags which must be passed through
    @author Robert Fletcher
    @file JsonParser.java
    @date April 2013
    */
public class JsonParser {
    
    private final int GETARRAYLENGTH =3;
    /**
     * Parse the Json object and return an String array of the result
     * @param JsonType enumeration type from jsonType
     * @param jsonObject the json Object from the server
     * @return String[][] 2 dimensional array of the result from the server
     */
    public String[][] parse(JsonType t, JSONObject jsonObject ){
        String[][] returns = null;
        //System.err.println(jsonObject.toJSONString());
        String con = (String) jsonObject.get("connect");
        int getpos = 0;
        if(con !=null){
            if(!con.equals("fail")){
                switch (t){
                        case LOGIN: 
                          returns = new String[1][1];
                          String id = (String) jsonObject.get("sid");
                          returns[0][0]=id ;
                          return returns;
                        case UPLOAD:
                            returns = new String[1][1];
                            getpos = 0;
                            returns[0][0] = (String) 
                                    jsonObject.get("Succseful");
                            return returns;
                        case GET:
                            returns = new String[1][1];
                            getpos = 0;
                            returns[0][0] = (String) jsonObject.get("path");
                            return returns;

                        case LIST:
                            
                            JSONArray msg = (JSONArray) 
                                    jsonObject.get("RESULT");
                            Iterator<JSONObject> iterator = msg.iterator(); 
                            returns = new String[msg.size()][GETARRAYLENGTH];
                            int i = 0;
                            while (iterator.hasNext()) {
                                int p =0;
                                JSONObject result = iterator.next();
                                
                                String fileID = (String) result.get("fileID");
                                String name = (String) result.get("fileName");
                                String date = (String) result.get("fileDate");
                                returns[i][p] = fileID;
                                p++;
                                returns[i][p] = name;
                                p++;
                                returns[i][p] = date;
                                
                                i++;
                   
                            }
                            return returns;
                    }
                return null;

            }else{
                return null;
            }
        }else{
            System.err.print("cannot find connect\n");
            return null;
        }
        
        
    }

}
