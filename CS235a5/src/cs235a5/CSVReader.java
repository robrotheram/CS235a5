package cs235a5;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/** @brief This class is will parser a csv File 

    This Class will run through a csv file and check to see if the string is 
    * null if if it not null will add it to the dataSet
    @author Robert Fletcher
    @file CSVReader.java
    @date April 2013
    */
public class CSVReader {
     
    
     /** Sets the dataset
    * Sets the dataset used in the class
    * 
    * @param  MS_DataSet the dataset of this class
    * @return boolean true if set correctly
    */
    public boolean SetDataset(DataSet db){
        m_DB = db;
        return true;
    }
    
    /** sets a delimiter
    * Sets the delimiter used in parsing the file;
    * @param  String  the file's Delimiter
    * @return boolean true if set correctly
    */
    public boolean SetDelimiter(String del){
        m_delimitor = del;
        return true;
    }
    
        /**Gets the File being used
    * Gets the file that is currently being used by the user
    * 
    * @return MS_BasicGUI 
    */
    public File GetFile(){
        return m_File;
    }
  

    /**Gets the Dataset 
    * Gets the Dataset of this class to be used when called
    * @return MS_BasicGUI 
    */
    public DataSet GetDataSet(){
        return m_DB;
    }

    /** gets the delimiter
    * Gets the delimiter of this class
    * @return String 
    */
    public String GetDelimitor(){
        return m_delimitor;
    }
    
    
    /**Class Constructor
     * Creates a constructor to take in CSV file information
     * 
     * @param ds
     * @param file 
     */
    public CSVReader(DataSet db, File file,String delimitor){
        if(SetDataset(db)){
            System.out.println(CLASS+".setDataset():Dataset set Correctly"); 
        }else{
            System.out.println(CLASS+".setDataset():Failed to add");
        }
        if(SetDelimiter(delimitor)){
            System.out.println(
                        CLASS+".setDelimiter():Delimitor set Correctly");
        }else{
            System.out.println(CLASS+".setDelimiter():Failed");
        }
        if(SetFile(file)){
            System.out.println(CLASS+".setFile():File Set Correctly");
        }else{
            System.out.println(CLASS+".setFile():Failed");
        }
    }

    /** Sets the file
     * Sets the file the classes use to read through the CSV file
     * 
     * @param File f
     * @return Boolean true
     */
    public boolean SetFile(File f){
        if(f.exists()){
            m_File = f;  
            return true;
	  }else{
            return false;  
	  }
        
        
    }
    
 
    /** ParseFile forms the layout for subclasses to use to create charts
     * ParseFile runs through the file the first line it takes the Column names
     * The rest of the file it make a new MS_DataAtribute and adds it with 
     * Position values to the MS_DataSet class  Returns a Boolean if True no   
     * Errors have Occurred
     * 
     * @return Boolean isError 
     */
    public Boolean ParseFile(){
        m_DB.SetFilePath(m_File.getAbsolutePath());
        boolean isError = true;
        try {
            Scanner in = new Scanner(m_File);
            LineNumberReader  lnr = new LineNumberReader
                                   (new FileReader(m_File));
            
            
            String[] names  = in.nextLine().split(m_delimitor);
            lnr.skip(Long.MAX_VALUE);
            m_DB.SetDataSet(names.length, lnr.getLineNumber());
            System.err.println(CLASS+".ParseFile(): File Line vlaue = "+
                    lnr.getLineNumber());
            
            m_DB.SetHeader(names);
            int i = 0;
            while(in.hasNextLine()){
                String[] tempData = in.nextLine().split(",");
       
                if(insertData(tempData , i)){
                    i++;
                    //System.out.println(CLASS+".insertData():Complete");
                }else{
                    System.out.println(CLASS+".insertData():Failed");
                }
            }
           
        } catch (Exception e) {
           isError = false;
           System.err.println("MS_CSVParser.ParseFile() Error :"+e);
           JOptionPane.showMessageDialog(null, "Error in File Please Select a file", 
                        "Inane Error", JOptionPane.ERROR_MESSAGE);
        }
       return isError;
    }
    
    /** Checks to see if there are null values in the array
     * The function checks the array to see if it is null if not it inserts it
     * to the MS_DataSet
     * @param String[] the row of data from the csv parser
     * @param int the row position in the array
     * @return boolean True if successful  
     */
    private boolean insertData(String[] tempData, int i){
        if(checkArray(tempData)){
            int newPos =  0; 
            for(int j =0; j < tempData.length; j++ ){
                if(!tempData[j].equals("")){
                    m_DB.SetDataCell(new DataCell(tempData[j]),
                            newPos, i);
                    newPos++;
                }       
            }
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Method to check if line is empty Requires a the String[] and returns true
     * if it is <b>not </b> empty
     * @param check 
     * @return isEmpty
     */
    private Boolean checkArray(String[] check){
        Boolean isEmpty = false;
        for(int i = 0;i<check.length;i++){
            
            if(!check[i].equals("")){
                isEmpty = true;
                break;
            }
            
        }
        return isEmpty;
    } 
 
 
    private File m_File;
    private DataSet m_DB; 
    private String m_delimitor; 
    private final String CLASS = "CSVReader"; 
 
}
