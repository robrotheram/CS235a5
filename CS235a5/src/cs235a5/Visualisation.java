package cs235a5;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * \file    Visualisation
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
  public final boolean SetTitle(String title)
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
    return true;
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
  public boolean SetColour(ColourMap colourMap) 
  {
      m_colourMap = colourMap;
      return true;
  }
  
  /**
  * A method that allows the dataSet for the visualisation to be set
  * @param data - The data to be used for the visualisation 
  * 
  * @return boolean - returns true if set correctly
  */
  public boolean SetData(DataSet data){
      m_dataSet = data;
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
  
  /**
   * A get method to return the colour scheme of a chart
   * @return m_colourScheme - Returns the colour scheme
   */
  public ColourMap GetColourMap()
  {
    return m_colourMap;
  }
  
  /**
   * A get method to return the data set for the visualisation
   * @return m_dataSet - the data set
   */
  public DataSet GetDataSet()
  {
      return m_dataSet;
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
      if(SetTitle(title)){
          if(m_test){
              System.out.println("Title set correctly in Visualisation(): Table"
                      + " constructor");
          }
      } else if(!SetTitle(title)){
          if(m_test){
              System.err.println("Title not set correctly in Visualisation():"
                      + " Table constructor");
          } else {
              JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the table title in Visualisation(): table"
                  + " constructor.");
          }
      }
      if(SetScale(width, height)){
          if(m_test){
              System.out.println("Table size set correctly in Visualisation():"
                  + " table constructor");
          } else if(!SetScale(width, height)){
              if(m_test){
                  System.err.println("Table size not set correctly in"
                      + " Visualisation(): table constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the table dimensions in Visualisation(): table"
                  + " constructor.");
              }
          }
      }
      if(SetData(data)){
          if(m_test){
              System.out.println("Table data has been set correctly in "
                  + "Visualisation(): table constructor");
          } else if(!SetData(data)){
              if(m_test){
                  System.err.println("Table data has not been set correctly in "
                  + "Visualisation(): table constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the table data in Visualisation(): table"
                  + " constructor.");
              }
          }
      }
  }
  /**
   * Constructor setting all the data needed for creating charts
   * @param title
   * @param width
   * @param height
   * @param data
   * @param colours
   * @param author
   * @param description 
   */
  Visualisation(String title, DataSet data,
  ColourMap colours, String author, String description){
      if(SetTitle(title)){
          if(m_test){
              System.out.println("Title set correctly in Visualisation(): Chart"
                      + " constructor");
          }
      } else if(!SetTitle(title)){
          if(m_test){
              System.err.println("Title not set correctly in Visualisation():"
                      + " Chart constructor");
          } else {
              JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the chart title in Visualisation(): Chart"
                  + " constructor.");
          }
      }
      
      if(SetData(data)){
          if(m_test){
              System.out.println("Chart data has been set correctly in "
                  + "Visualisation(): Chart constructor");
          } else if(!SetData(data)){
              if(m_test){
                  System.err.println("Chart data has not been set correctly in "
                  + "Visualisation(): Chart constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the Chart data in Visualisation(): Chart"
                  + " constructor.");
              }
          }
      }
      if(SetColour(colours)){
          if(m_test){
              System.out.println("Chart colours have been set correctly in "
                  + "Visualisation(): Chart constructor");
          } else if(!SetColour(colours)){
              if(m_test){
                  System.err.println("Chart colours have not been set correctly in "
                  + "Visualisation(): Chart constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the Chart colours in Visualisation(): Chart"
                  + " constructor.");
              }
          }
      }
      if(SetAuthor(author)){
           if(m_test){
              System.out.println("Chart author has been set correctly in "
                  + "Visualisation(): Chart constructor");
          } else if(!SetAuthor(author)){
              if(m_test){
                  System.err.println("Chart author has not been set correctly in"
                  + " Visualisation(): Chart constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the chart author in Visualisation(): Chart"
                  + " constructor.");
              }
          }
      }
      if(SetDescription(description)){
           if(m_test){
              System.out.println("Chart description has been set correctly in "
                  + "Visualisation(): Chart constructor");
          } else if(!SetDescription(description)){
              if(m_test){
                  System.err.println("Chart description has not been set correctly in"
                  + " Visualisation(): Chart constructor");
              } else {
                  JOptionPane.showMessageDialog(this, "There has been an error "
                  + "setting the chart description in Visualisation(): Chart"
                  + " constructor.");
              }
          }
      }
      
  }
  private String m_title; // Sets the charts title
  private Dimension m_chartScale; // Sets the size of the chart
  private String m_chartAuthor; // Allows the user to add an author
  private String m_chartDescription; // Allows the user to add a description
  private ColourMap m_colourMap; // Sets the colour of the charts
  private DataSet m_dataSet; // Sets the data set for the new visualisation
  private boolean m_test = false; // Flag to turn on testing for the class
}
