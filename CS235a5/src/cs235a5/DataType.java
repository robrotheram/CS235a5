package cs235a5;

/** @brief Defines the type of Data begin stored by the DataCell

    This Class defines the type of data the dataCell is being used so that there
    * would not be a type error when generating the charts and summing the data
    @author Robert Fletcher
    @file JsonParser.java
    @date April 2013
    */
public enum DataType {
    
    STRING("S"),INTEGER("I"),DOUBLE("D"),BOOLEAN("B");
    
    private String dataType;
   /**
    * Private constructor to set up the enumeration 
    * @param String string for the enumeration value
    */ 
    private DataType(String s) {
        dataType = s;
    }
}
