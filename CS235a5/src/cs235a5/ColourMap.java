package cs235a5;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * \file    ColourMap.java
 * \author  Zhenjie Mu
 * \date    April 2013
 * 
 * \brief   Colourmap class stores different colours that compose the new colour map  
 *          
 */
public class ColourMap implements ColorScheme{
    
   /** Sets the colour array method
    * The setColourArray class stores a structure for an entire color data set
    * 
    * @param cArray 
    * @return true 
    */
    @Override
    public boolean setColourArray(Color[] cArray) {
        m_colorArray = cArray;
        return true;
    }

   /** Sets colour to position i in the colour array
    * Sets Color c at the position i within the colourArray 
    * 
    * @param c the colour
    * @param i the position
    * @return true
    */
    @Override
    public boolean setColour(Color c, int i) {
        m_colorArray[i] = c;
        return true;
    }
    
    /** Sets useable panels for the colour window to use
     * Sets 5 panels sizes and colours to match the array for viewing colour
     * map colours in an interface
     * 
     * @param panels array of panels
     * @return true if set correctly
     */
    public boolean setPanels(JPanel[] panels){
        for(int i = 0; i < panels.length; i++){
            panels[i].setPreferredSize(new Dimension(30,30));
            panels[i].setBackground(m_colorArray[i]);
        }
        return true;
    }
    
    /** Returns the coloured panels for colourmaps
     * returns the colour panel for the class to use it
     * 
     * @return panels coloured panels matching the colour array
     */
    public JPanel[] getPanels(){
        return m_panels;
    }
    
    /** Get the colour array
     * returns the colourArray method to be used by the class
     * 
     * @return m_colorArray
     */
    @Override
    public Color[] getColourArray() {
        return m_colorArray;
    }

    /** Gets the colour array value
    * Get individual colours from the colour array
    * 
    * @param i an int for the location of colour in array
    * @return m_colorArray[i] the colour at position a
    */
    @Override
    public Color getColour(int i) {
        return m_colorArray[i];
    }
    
    /** Gets the total number of colours in the array
     * Returns the number of colours stored in array for calculations etc
     * 
     * @return int
     */
    @Override
    public int getNumberOfColours() {
        return m_colorArray.length;
    }
          
   /** The constructor sets the colour array
    * Constructor sets the color array for the class to make the colourMap
    * 
    * @param colorArray 
    */
    public ColourMap(Color[] colorArray){
        if(setColourArray(colorArray)){
            System.out.println("Colours set in the colour map in MS_ColourMap");
        } else if(!setColourArray(colorArray)){
            System.err.println("Unable to set colours in MS_ColourMap");
        }
        if(setPanels(m_panels)){
            System.out.println("Colour panels set in MS_ColourMap");
        }
        else if(!setPanels(m_panels)){
            System.err.println("Colour panels not set in MS_ColourMap");
        }
    }
    
    
    /*
     * New toString method for the purpose of testing
     */
    public String toString(ColourMap cm){
        String output = "";
        for(int i = 0; i < cm.getNumberOfColours(); i++){
            output = output + cm.getColour(i);
            output = output + " ";
        }  
        return output;
    }
        
    private Color[] m_colorArray = new Color[5];
    private JPanel m_colourPanel = new JPanel(), 
                     m_defaultC2 = new JPanel(),
                     m_defaultC3 = new JPanel(), 
                     m_defaultC4 = new JPanel(), 
                     m_defaultC5 = new JPanel();
    private JPanel[] m_panels = {
        m_colourPanel,
        m_defaultC2, 
        m_defaultC3, 
        m_defaultC4, 
        m_defaultC5
    };
    
}



