/**
 * \file Chart.java
 * 
 * \author Robert Fletcher
 * 
 * \date 25/04/2013
 * 
 * \brief The class that has the enumaeration for the animation type
 * 
 */
package animation;

public enum AnimationType {
    LEFT("left"),RIGHT("right"),UP("up"),DOWN("down"),ZOOM("Zoom");
    private String type;
    private AnimationType(String t){
        type = t;
    }
}
