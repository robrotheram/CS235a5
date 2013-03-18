/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.Color;

/**
 * Interface implemented by subclasses to ensure they implement the needed methods
 * @author Wyler
 */
interface ColorScheme {
    
    /**
     * 
     * @param cArray an array of colours
     * @return true if the array was set correctly
     */
    boolean setColourArray(Color[] cArray);
    
    /**
     * 
     * @param c colour to be set
     * @param i position in the array to set it
     * @return returns true if set
     */
    boolean setColour(Color c , int i);
    
    /**
     * Allows access to the private colour array
     * @return an array of colour
     */
    Color[] getColourArray();
    
    /**
     * Get's a single colour from the array
     * @param i place of colour in the array
     * @return the colour at the requested position
     */
    Color getColour(int i);
    
    /**
     * Get's the number of colours in the array for calculations etc.
     * @return 
     */
    int getNumberOfColours();
     
    
}
