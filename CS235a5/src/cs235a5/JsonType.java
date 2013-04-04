package cs235a5;
/** @brief a enum that defines the different json outputs being used

    Defined the different json outputs from the server
    @author Robert Fletcher
    @date April 2013
    @file JsonType
    */
public enum JsonType {
    
    LOGIN("L"),LIST("I"),GET("G"),UPLOAD("U");
    
    private String Type;
    /**
     * Sets up the enumeration 
     * @param String the value of the enumeration
     */
    private JsonType(String s) {
        Type = s;
    }
    
    
}
