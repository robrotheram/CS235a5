package animation;

import static animation.AnimationType.LEFT;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Robert Fletcher
 */
public class Animation extends JFrame {
    private ArrayList<Slide> slide = new ArrayList<Slide>();
    private boolean run;
    private JPanel main;
    private int pos;
    private AnimationSpeed speed; 
    private AnimationWait wait;
    
    public Animation(){
        
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        main = new JPanel();
       
        main.setLayout(null);
        
        main.setBackground(Color.DARK_GRAY);
        JPanel buttonP = new JPanel();
        this.setLayout(new BorderLayout());
        buttonP.setLayout(new FlowLayout());
        final JButton start = new JButton("Begin");
        final JButton pause = new JButton("Play");
        buttonP.add(start);
        buttonP.add(pause); 
        this.add(main, BorderLayout.CENTER);
        this.add(buttonP, BorderLayout.SOUTH);
        this.validate();
        
        JPanel a1 = new JPanel();
        JPanel a2 = new JPanel();
        JPanel a3 = new JPanel();
        JPanel a4 = new JPanel();
        JPanel a5 = new JPanel();
        JPanel a6 = new JPanel();
        
        
        a1.setBackground(Color.GREEN);
        a2.setBackground(Color.BLUE);
        
        a3.setBackground(Color.GREEN);
        a4.setBackground(Color.BLUE);
        
        a5.setBackground(Color.GREEN);
        a6.setBackground(Color.BLUE);
        
        
        a1.validate();
         a2.validate();
          a3.validate();
           a4.validate();
            a5.validate();
             a5.validate();
            

        
        
        //---------------add listeners -----------/
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Thread t = new slideshow();
                t.start();
                pause.setText("Pause");
                start.setEnabled(false);
                run = true;
            }
        });
        pause.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(run){
                    run = false;
                    pause.setText("Play");
                    slide.get(pos).pause();
                }else{
                    run = true;
                    pause.setText("Pause");
                    slide.get(pos).resume();
                }
                
            }
        });   
        
    }
    public void addBiCharts(JPanel ch1,JPanel ch2,AnimationType t,AnimationSpeed s,AnimationWait w){

        JPanel c = new JPanel();
        c.setLayout(new GridLayout(1,2));
        c.add(ch1);
        c.add(ch2);
        c.validate();
        c.repaint();
      
        slide.add(new SlideLeft(c,main,s,w));    
        main.add(c);
        main.revalidate();
        main.repaint();
    }
    public void removeSlide(int pos){
        slide.remove(pos);
    }


    public void setSpeed(AnimationSpeed s){
        speed = s;
    }
    public void setWait(AnimationWait w){
        wait = w;
    }
    
    public JPanel getMain(){
        return main;
    }
    private class slideshow extends Thread{
        
        public void run(){
            for(int i = 0; i<slide.size();i++){
               Slide sld = null; 
               switch(slide.get(i).getAnimationType()){
                    case LEFT:
                            sld = slide.get(i);
                            
                            SlideLeft s = (SlideLeft) sld;
                            s.setSpeed(speed);
                            s.setWait(wait);
                            s.start();
                            main.updateUI();
                            System.out.println("Upadte main ui");
                            main.updateUI();
                            pos = i;
                            
                            break;
                } 
               while(sld.getThread().isAlive()){}
               
            }
        }
    }

}
