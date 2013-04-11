/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import cs235a5.CSVReader;
import cs235a5.DataSet;
import java.io.File;
import java.net.URL;

/**
 *
 * @author Robert
 */
public class howtomakethedatasetfortheCHARTCLASSES {
    
    private DataSet makeDataSet(){
        URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
        DataSet db = new DataSet();
        File f = new File(fileURL.getPath());
        CSVReader csvr = new CSVReader(db,f,",");
        if(csvr.ParseFile()){
         return db;   
        }else{
             System.err.print("error!!!!!");
            return db;
           
        }
    }
    
    
}
