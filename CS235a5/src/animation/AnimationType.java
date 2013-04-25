package animation;

public enum AnimationType {
    LEFT("left"),RIGHT("right"),UP("up"),DOWN("down"),ZOOM("Zoom");
    private String type;
    private AnimationType(String t){
        type = t;
    }
}
