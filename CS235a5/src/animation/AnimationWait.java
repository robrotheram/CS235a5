/**
 * \file AnimationWait.java
 * 
 * \author Robert Fletcher
 * 
 * \date 25/04/2013
 * animation speed 
 * \brief The class that has the enumaeration for the Slide wait time
 * 
 */
package animation;

public enum AnimationWait {
    VERYLONG(300000),LONG(60000),MEDIUM(30000),SHORT(10000),VERYSHORT(5000);
    private int time;
    private AnimationWait (int t){
        time = t;
    }
    /**
     * get the value of the wait time
     * @return int the vlause of the wait time
     */
    public int getTime(){
        return time;
    }
}
