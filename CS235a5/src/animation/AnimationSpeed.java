
package animation;

public enum AnimationSpeed {
    VERYFAST(2),FAST(5),NORMAL(10),SLOW(20);
    private int speed;

    private AnimationSpeed(int s) {
        speed = s;
    }
    public int getValue(){
        return speed;
    }
}
