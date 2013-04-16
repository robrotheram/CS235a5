package cs235a5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
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
        setPanels(m_colourKeyList);
        
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
     * @param panels array of bufferedImages to be coloured
     * @return true if set correctly
     */
    private boolean setPanels(BufferedImage[] panels){
        for(int i = 0; i < panels.length; i++){
            for (int x = 0; x < COLOUR_KEY_SIZE; x++) {
                for (int y = 0; y < COLOUR_KEY_SIZE; y++) {
                    panels[i].setRGB(x, y, m_colorArray[i].getRGB());
                }
            }
            
        }
        if(!CreateKey(panels)){
            System.out.println("Error creating colourmap key. In SetPanels()."
                    + "CreateKey()");
            return false;
        }
        return true;
    }
    
    /**
     * Creates a single colourmap key image from the array of painted images
     * @param panels the coloured panels for each colour in the colour map
     * @return true if successful
     */
    private boolean CreateKey(BufferedImage[] panels){
        int xPos = 0;
        for(int i = 0; i < panels.length; i++){
            m_colourMap.getGraphics().drawImage(panels[i], xPos, 0, null);
            xPos += COLOUR_KEY_SIZE;
        }
        return true;
    }
    
    /** Returns the coloured panels for colourmaps
     * returns the colour panel for the class to use it
     * 
     * @return panels coloured panels matching the colour array
     */
    public ImageIcon getPanels(){
        return new ImageIcon(m_colourMap);
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
        if(setPanels(m_colourKeyList)){
            System.out.println("Colour panels set in MS_ColourMap");
        }
        else if(!setPanels(m_colourKeyList)){
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
    private final int COLOUR_KEY_SIZE = 15;
    private final int NUM_OF_COLOURS = 5;
    
    // Images for storing the colours of created colour maps
    private BufferedImage m_colour1 = new BufferedImage(COLOUR_KEY_SIZE,
            COLOUR_KEY_SIZE, BufferedImage.TYPE_INT_RGB),
            m_colour2 = new BufferedImage(COLOUR_KEY_SIZE,
            COLOUR_KEY_SIZE, BufferedImage.TYPE_INT_RGB),
            m_colour3 = new BufferedImage(COLOUR_KEY_SIZE,
            COLOUR_KEY_SIZE, BufferedImage.TYPE_INT_RGB),
            m_colour4 = new BufferedImage(COLOUR_KEY_SIZE,
            COLOUR_KEY_SIZE, BufferedImage.TYPE_INT_RGB),
            m_colour5 = new BufferedImage(COLOUR_KEY_SIZE,
            COLOUR_KEY_SIZE, BufferedImage.TYPE_INT_RGB);
    private BufferedImage m_colourMap = new BufferedImage(COLOUR_KEY_SIZE*
            NUM_OF_COLOURS, COLOUR_KEY_SIZE,BufferedImage.TYPE_INT_RGB);
    // Array of image panels for looping through and colouring
    private BufferedImage[] m_colourKeyList = new BufferedImage[] {m_colour1,
        m_colour2, m_colour3, m_colour4, m_colour5};
    
   
    
}



