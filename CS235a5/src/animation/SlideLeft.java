/**
 * \file  Slide.java
 * 
 * \author Robert Fletcher
 * 
 * \date 25/04/2013
 * 
 * \brief The class that extends the slide class contains spicfic methods for the animation
 * 
 */

package animation;

import java.awt.Rectangle;
import javax.swing.JPanel;

public class SlideLeft extends Slide {
    private SlideLeft cont;

    /**
     * Class Constructor that creates the slide
     * @param JPanel slide 
     * @param JPanel the panel the slide will be in 
     * @param s Animation Speed
     * @param w Animation pause time
     * @param anitype Type of animation
     */
    public SlideLeft(JPanel content,JPanel cnt,AnimationSpeed s,AnimationWait w){
       super(content,cnt,s,w,AnimationType.LEFT);
       cont = this;
    }
    /**
     * Method to start the slide in animation
     */
    public void start(){
        super.start(new animation());
}

    /**
     * class that contains the animation 
     */
private class animation extends Thread{
    
    @Override
    public void run(){
        Thread t;
        t = new SlideLeft.slidein();
        t.start();
        while(t.isAlive()){}
        try {
            animation.sleep(getWait());
        } catch (InterruptedException ex) {
            
        }
        t = new SlideLeft.slideout();
        t.start();
        while(t.isAlive()){}
        
        
        
    }
}
    
    
/**
 * class that contains the slide in animation
 */

private class slideout extends Thread{
    
    @Override
    public void run(){
        for(int i = 0; i<= cont.getSize().getWidth(); i++){
            if(cont.isRun()){
                cont.getMain().setBounds(new Rectangle(i,0,cont.getSize().getBounds().width,cont.getSize().getBounds().height));
                try {
                    slideout.sleep(cont.getSpeed().getValue());
                } catch (InterruptedException ex) {
                   
                }
                
            }else{
                i--;
            }
        }
    }
    
}

/**
 * Class that contains the animation for sliding in the Slide
 */

private class slidein extends Thread{
    
    @Override
    public void run(){
       
        for(int i = -(cont.getSize().getBounds().width); i!=0; i++){
            if(cont.isRun()){
                cont.getMain().setBounds(new Rectangle(i,0,cont.getSize().getBounds().width,cont.getSize().getBounds().height));
                try {
                    slidein.sleep(cont.getSpeed().getValue());
                } catch (InterruptedException ex) {
                    
                }
                
            }else{
                i--;
            }
        }
    }
    
}
    
    
}