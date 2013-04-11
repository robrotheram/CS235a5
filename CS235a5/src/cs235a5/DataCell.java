package cs235a5;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/** @brief This class is will Store one piece of data

    This class will parse a string to see what data it contains, convert it to
    * that data type and store in in its native data type
    @author Robert Fletcher
    @file DataCell.java
    @date April 2013
    */
public class DataCell {
    
    /**
     * Class Constructor takes a string and sends it to the SetData Method. Shows
     * a message dialog if there is an error setting the data
     * @param String a input of data
     */
    public DataCell(String input){
       if(!SetData(input)){
           JOptionPane.showMessageDialog(null,"Failed to set data: "+input,
                   "Error Message", JOptionPane.ERROR_MESSAGE);
       }
    }
    /**
     * Method that checks the String to see what is its native data type and
     * store it in theat data type. 
     * @param String - Sting input
     * @return boolean true if set correctly
     */
    public boolean SetData(String input){
        if(Pattern.matches(DOUBLEPATTERN, input)){
            m_Double = Double.parseDouble(input);
            m_String = input;
            m_DataType = DataType.DOUBLE;
            return true;
       }else if(Pattern.matches(INTPATTERN, input)){
           m_Integer = Integer.parseInt(input);
           m_String = input;
           m_DataType = DataType.INTEGER;
            return true;
 
       }else if( //Case Statements to check if the string is a Boolean
                   (input.toUpperCase().equals("T"))||
                   (input.toUpperCase().equals("TRUE"))){
               
                m_boolean = true;
                m_DataType = DataType.BOOLEAN;
                return true;
           
               
        }else if(
                   (input.toUpperCase().equals("F"))||
                   (input.toUpperCase().equals("FALSE"))
                   ){
               
                m_boolean = false;
                m_DataType = DataType.BOOLEAN;
                return true;
               
               
    }else{

                m_String = input;
            m_DataType = DataType.STRING;
                return true;
           }
        
       
        
    }
    
    /**
     * Returns the integer data that has been stored
     * @return integer
     */
    public int GetInteger(){
        return m_Integer;
    }
    
    /**
     * Returns the Double data that has been stored
     * @return Double the data stored
     */
    public double GetDouble(){
        return m_Double;  
    }
    
   /**
    * Returns the string Data
    * @return The String being stored 
    */
    public String GetString(){
        return m_String;  
    }
    
    /**
     * Return the enumeration of the data type see DataType.java
     * @return  DataType 
     */
    public DataType GetDataType(){
        
        return m_DataType;
    }
     /**
      * Return the Boolean Data that is being stored
      * @return Boolean the Data
      */
     public boolean GetBoolean(){
        
        return m_boolean;
    }
    /**
     * Overrides the toString() method and returns the what is being stored in 
     * the m_String variable
     * @return 
     */
    @Override
    public String toString(){
        return m_String;
    }
    
    
    
    
    private String m_String;
    private Integer m_Integer;
    private Double m_Double;
    private boolean m_boolean;
    private DataType m_DataType;
    
    private final String DOUBLEPATTERN = "([0-9]*)\\.([0-9]*)";  
    private final String INTPATTERN = "([0-9]*)";
    private final String STRINGPATTERN = "/^[a-zA-Z]+$/";
    
    
    
}
