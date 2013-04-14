package cs235a5;

/**
 * \file    datavisualiser.java
 * \author  Anthony Dakin
 * \date    14/02/2013
 *
 * \brief   A data visualiser program to take input data and convert it
 *          into different types of graph.
 *
 */

// Import Swing Library
import java.io.IOException;
import javax.swing.*;

public class datavisualiser
{
  public static void main (String[] args) throws IOException
  {
      
    
    VisualiserGUI mainWindow = new VisualiserGUI();
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setVisible(true);
  }
}
