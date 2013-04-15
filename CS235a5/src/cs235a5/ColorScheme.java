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
/**
 *
 * \file        colorScheme.java
 * \author      Xiaoxi Gu(Wyler) 
 * 
 * \date        15/04/2013
 *
 * \brief       The Scatter Plot Chart Class generates and displays an
 *              scatter plot chart by inheriting from the Chart class.
 *
 */
interface ColorScheme {
    
    /**Sets the colour array
     * Sets an array for the colour values to be stored
     * @param cArray an array of colours
     * @return true if the array was set correctly
     */
    boolean setColourArray(Color[] cArray);
    
    /**sets the colour
     * sets the colour out of the choice given from the variable i
     * @param c colour to be set
     * @param i position in the array to set it
     * @return returns true if set
     */
    boolean setColour(Color c , int i);
    
    /**Private colour array
     * Allows access to the private colour array
     * @return an array of colour
     */
    Color[] getColourArray();
    
    /**Single colour array
     * Gets a single colour from the array
     * @param i place of colour in the array
     * @return the colour at the requested position
     */
    Color getColour(int i);
    
    /**Gets the total number of colours in an array
     * Gets the number of colours in the array for calculations etc.
     * @return 
     */
    int getNumberOfColours();
     
    
}
