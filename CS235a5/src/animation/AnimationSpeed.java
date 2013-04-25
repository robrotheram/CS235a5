/**
 * \file AnimationSpeed.java
 * 
 * \author Robert Fletcher
 * 
 * \date 25/04/2013
 * 
 * \brief The class that has the enumaeration for the animation speed 
 * 
 */
package animation;

public enum AnimationSpeed {
    VERYFAST(2),FAST(5),NORMAL(10),SLOW(20);
    private int speed;

    private AnimationSpeed(int s) {
        speed = s;
    }
    /**
     * Method that gets the value of the speed enum
     * @return 
     */
    public int getValue(){
        return speed;
    }
}
