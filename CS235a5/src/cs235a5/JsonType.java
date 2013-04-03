package cs235a5;

public enum JsonType {
    
    LOGIN("L"),LIST("I"),GET("G"),UPLOAD("U");
    
    private String Type;
    
    private JsonType(String s) {
        Type = s;
    }
    
    
}
