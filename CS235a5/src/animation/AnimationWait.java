
package animation;

public enum AnimationWait {
    VERYLONG(300000),LONG(60000),MEDIUM(30000),SHORT(10000),VERYSHORT(5000);
    private int time;
    private AnimationWait (int t){
        time = t;
    }
    public int getTime(){
        return time;
    }
}
