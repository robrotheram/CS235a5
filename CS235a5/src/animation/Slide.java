/**
 * \file  Slide.java
 * 
 * \author Robert Fletcher
 * 
 * \date 25/04/2013
 * 
 * \brief The class that has superclass for all slide animation contains methods for pauseing and resule the slide show and starting the slide
 * 
 */

package animation;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Slide {
    private JPanel main;
    private AnimationSpeed speed;
    private boolean run; 
    private Thread aniT;
    private JPanel size;
    private int wait;
    private AnimationType at;
    
    /**
     * Class Constructor that creates the slide
     * @param JPanel slide 
     * @param JPanel the panel the slide will be in 
     * @param s Animation Speed
     * @param w Animation pause time
     * @param anitype Type of animation
     */

    public Slide(JPanel content,JPanel cnt,AnimationSpeed s,AnimationWait w, AnimationType anitype){
        main = content;
        speed = s;
        wait = w.getTime();
        size = cnt;
        run = true;
        at = anitype;
    }
    
    /**
     * Method to start the slide animation
     * @param Thread that is the animation
     */
    public void start(Thread t){
        aniT = t ;
        run = true;
        aniT.start();
    }
    /**
     * pause the slideshow
     */
    
   public void pause(){
        run = false;
    }
    /**
     * Reusme the slide show
     */
    
    public void resume(){
        run = true;
    }
    
    /**
     * check if the slideshow is running
     * @return boolean true if running
     */
    boolean isRun(){
        return run;
    }
    /**
     * get the size of the slideshow pane
     * @return 
     */
     JPanel getSize(){
        return size;
    }
    /**
     * Get the wait time of the animation
     * @return 
     */
     int getWait(){
        return wait;
    }
    /**
     * get the speed of the animation
     * @return 
     */
    AnimationSpeed getSpeed(){
        return speed;
    }
    /**
     * Set the wait time of the animation
     * @param AnimationWait 
     */
     void setWait(AnimationWait w){
        wait = w.getTime();
    }
    /**
     * Set the animation slide in and out speed;
     * @param AnimationSpeed s
     */
    void setSpeed(AnimationSpeed s){
       speed = s;
    }
    
    /**
     * Get the main panel;
     * @return JPanel 
     */
    JPanel getMain(){
        return main;
    }
    /**
     * Get the type of animation that is running
     * @return AnimationType
     */
    AnimationType getAnimationType(){
        return at;
    }
    /**
     * method to get the Thread that is the animation
     * @return Thread of the animation
     */
    public Thread getThread(){
        return aniT;
    }
    
    
}