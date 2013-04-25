package animation;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class SlideLeft extends Slide {
    private SlideLeft cont;

    public SlideLeft(JPanel content,JPanel cnt,AnimationSpeed s,AnimationWait w){
       super(content,cnt,s,w,AnimationType.LEFT);
       cont = this;
    }
    
    public void start(){
        super.start(new animation());
}

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