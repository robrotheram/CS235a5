
package cs235a5;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonParser {
    
    private final int GETARRAYLENGTH =3;
    
    public String[][] parse(JsonType t, JSONObject jsonObject ){
        String[][] returns = null;
        System.err.println(jsonObject.toJSONString());
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
                            returns[0][0] = (String) jsonObject.get("Succseful");
                            return returns;
                        case GET:
                            returns = new String[1][1];
                            getpos = 0;
                            returns[0][0] = (String) jsonObject.get("path");
                            return returns;

                        case LIST:
                            System.out.println("json: "+jsonObject.toJSONString());
                            JSONArray msg = (JSONArray) jsonObject.get("RESULT");
                            Iterator<JSONObject> iterator = msg.iterator(); 
                            returns = new String[msg.size()][GETARRAYLENGTH];
                            int i = 0;
                            while (iterator.hasNext()) {
                                int p =0;
                                JSONObject result = iterator.next();
                                System.out.println();
                                String fileID = (String) result.get("fileID");
                                String name = (String) result.get("fileName");
                                String date = (String) result.get("fileDate");
                                returns[i][p] = fileID;
                                p++;
                                returns[i][p] = name;
                                p++;
                                returns[i][p] = date;
                                //System.out.println("\nFile id:"+fileID+"\nFile name:"+name+"\nfile Date:"+date);
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
