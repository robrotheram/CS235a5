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

    public Slide(JPanel content,JPanel cnt,AnimationSpeed s,AnimationWait w, AnimationType anitype){
        main = content;
        speed = s;
        wait = w.getTime();
        size = cnt;
        run = true;
        at = anitype;
    }
    
    public void start(Thread t){
        aniT = t ;
        run = true;
        aniT.start();
    }
    
    public void pause(){
        run = false;
    }
    public void resume(){
        run = true;
    }
    
    public boolean isRun(){
        return run;
    }
    public JPanel getSize(){
        return size;
    }
    public int getWait(){
        return wait;
    }
    public AnimationSpeed getSpeed(){
        return speed;
    }
    public void setWait(AnimationWait w){
        wait = w.getTime();
    }
    public void setSpeed(AnimationSpeed s){
       speed = s;
    }
    
    
    public JPanel getMain(){
        return main;
    }
    public AnimationType getAnimationType(){
        return at;
    }
    public Thread getThread(){
        return aniT;
    }
    
    
}