package cs235a5;

/**
 *\file     UserColorMap.java
 *\author   Zhenjie Mu
 *\date     April 2013
 * 
 *\brief    This Class allows the user to choose their own custom color map
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    
public class UserColormap extends ColourMap{
    

/**
 * Constructor makes the User interface and sets up the variables
 * @param  null;
 */    
    public UserColormap() {  //constructor
       super(new Color[]{Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK});
        JColorChooser chooser = new JColorChooser();  // color chooser
        for(int i = 0; i < colorarray.length ; i++){
           Color color = chooser.showDialog(null,"Colormap",Color.white);
           if(color==null){
               color = Color.CYAN;
           }
           colorarray[i] = color;
   
        }
        super.setColourArray(colorarray);              
    }
        
    private Container container;  // container
    private JPanel colorPanel, color1,color2,color3,color4,color5; //panel which display selected color
    private Color[] colorarray = new Color[5];
    private JPanel[] colourKey;
    
}
