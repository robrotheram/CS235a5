package cs235a5;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * \file    Visualiser
 * \author  Kerry Tolhurst
 * \date    17/03/2013
 *
 * \brief   A Visualiser class that is abstract and helps to get and set all 
 *          data needed for making different types of visualisations. Subclasses
 *          will override some of the methods laid out in this class.
 */

public abstract class Visualisation extends JPanel
{
  
  /**
   * A method used to set a string to be used as the title of a chart
   * @param title - A string representing the title of a chart
   * @return check - A boolean flag to check if title has been set correctly
   */
  public final boolean SetChartTitle(String title)
  {
    m_title = title;
    return true;
  }

  /**
   * A method used to set an integer value to be used as a scale factor for
   * the x and y axis for the graphs.
   * @param scale - An integer value representing the scale of a charts axis
   * @return check - A boolean flag to check if scale has been set correctly
   */
  public boolean SetScale(int x, int y)
  {
    m_chartScale = new Dimension(x, y);
    return true;
  }

  /**
   * A method used to set the Author of the created chart
   * @param author - A string to represent the author of the chart
   * @return check - A boolean flag to check if scale has been set correctly
   */
  public boolean SetAuthor(String author)
  {
    m_chartAuthor = author;
    boolean check = false;
    return check;
  }

  /**
   * A method used to set a description to be associated with the graph
   * @param description - A string to represent a description of a graph
   * @return check - A boolean flag to check if scale has been set correctly
   */
  public boolean SetDescription(String description)
  {
    m_chartDescription = description;
    return true;
  }
  
  /**
   * A method that allows the colour scheme for the visualisation to be set
   * @param colourScheme - A user chosen colour scheme to be applied to the 
   * visualisation
   * @return boolean - returns true if set correctly
   */
  public boolean SetColour(ColourScheme colourScheme) 
  {
      m_colourScheme = colourScheme;
      return true;
  }
  
  /**
   * A get method to return the title of a chart
   * @return m_chartTitle - Returns the chart title
   */
  public String GetChartTitle()
  {
    return m_title;
  }

  /**
   * A get method to return the Scale factor of a chart
   * @return m_chartScale - Returns the chart scale
   */
  public Dimension GetScale()
  {
    return m_chartScale;
  }

  /**
   * A get method to return the Author of a chart
   * @return m_chartAuthor - Returns the chart's Author
   */
  public String GetAuthor()
  {
    return m_chartAuthor;
  }

  /**
   * A get method to return the description of a chart
   * @return m_chartDescription - Returns the chart's description
   */
  public String GetDescription()
  {
    return m_chartDescription;
  }
  
  public String GetColourScheme()
  {
    return m_colourScheme;
  }
  /**
   * Default constructor which passes in  no parameters and displays an error
   * telling the user that they need parameters to create a visualisation.
   */
  Visualisation(){
      JOptionPane.showMessageDialog(this, "No data has been set for the"
              + " visualisation.\n Please ensure data is being set and stored"
              + "correctly.\n Visualisation(): Empty constructor.");
  }
  
  /**
   * Constructor for setting the data needed to create tables
   * @param title - The title for the data
   * @param width - To set the width of the table
   * @param height - To set the height of the table
   * @param data - The data to be displayed in the table
   */
  Visualisation(String title, int width, int height, DataSet data){
      if(SetChartTitle(title)){
          if(m_test){
              System.out.println("Title set correctly in Visualisation(): Table"
                      + " constructor");
          }
      } else if(!SetChartTitle(title)){
          JOptionPane.showMessageDialog(this, "There has been an error setting "
                  + "the chart title in Visualisation(): table constructor.");
      }
  }
  
  private String m_title; // Sets the charts title
  private Dimension m_chartScale; // Sets the size of the chart
  private String m_chartAuthor; // Allows the user to add an author
  private String m_chartDescription; // Allows the user to add a description
  private ColourScheme m_colourScheme; // Sets the colour of the charts
  private DataSet m_dataSet; // Sets the data set for the new visualisation
  private boolean m_test = false; // Flag to turn on testing for the class
}
