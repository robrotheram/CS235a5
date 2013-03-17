package cs235a5;

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

public class Visualiser
{
  private String m_chartTitle; // Sets the charts title
  private int m_chartScale; // Sets the size of the chart
  private String m_chartAuthor; // Allows the user to add an author
  private String m_chartDescription; // Allows the user to add a description
  private String m_colourScheme; // Sets the colour of the charts
  private DataSet m_dataSet; // Sets the data set for the new visualisation

  /**
   * A method used to set a string to be used as the title of a chart
   * @param title - A string representing the title of a chart
   * @return check - A boolean flag to check if title has been set correctly
   */
  public static boolean SetChartTitle(String title)
  {
    m_chartTitle = title;
    boolean check = false;
    return check;
  }

  /**
   * A method used to set a string to be used as the x axis label of a chart
   * @param label - A string representing the x axis label of a chart
   * @return check - A boolean flag to check if label has been set correctly
   */
  public static boolean SetXLabel(String label)
  {
    m_chartXLabel = label;
    boolean check = false;
    return check;
  }

  /**
   * A method used to set a string to be used as the y axis label of a chart
   * @param label - A string representing the y axis label of a chart
   * @return check - A boolean flag to check if label has been set correctly
   */
  public static boolean SetYLabel(String label)
  {
    m_chartYLabel = label;
    boolean check = false;
    return check;
  }

  /**
   * A method used to set an integer value to be used as a scale factor for
   * the x and y axis for the graphs.
   * @param scale - An integer value representing the scale of a charts axis
   * @return check - A boolean flag to check if scale has been set correctly
   */
  public static boolean SetScale(int scale)
  {
    m_chartScale = scale;
    boolean check = false;
    return check;
  }

  /**
   * A method used to set the Author of the created chart
   * @param author - A string to represent the author of the chart
   * @return check - A boolean flag to check if scale has been set correctly
   */
  public static boolean SetAuthor(String author)
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
  public static boolean SetDescription(String description)
  {
    m_chartDescription = description;
    boolean check = false;
    return check;
  }

  public static void SetColour(String colourScheme) 
  {
    if(colourScheme.equalsIgnoreCase("light")) {
	    m_colourScheme = "Light";
	}
	  
    else if(colourScheme.equalsIgnoreCase("greyscale")) {
      m_colourScheme = "Greyscale";
    }

    else {
      m_colourScheme = "Default";
    }
  }
  
  /**
   * A get method to return the title of a chart
   * @return m_chartTitle - Returns the chart title
   */
  public static String GetChartTitle()
  {
    return m_chartTitle;
  }

  /**
   * A get method to return the X axis label of a chart
   * @return m_chartXLabel - Returns the chart's x-axis label
   */
  public static String GetXLabel()
  {
    return m_chartXLabel;
  }

  /**
   * A get method to return the Y axis label of a chart
   * @return m_chartYLabel - Returns the chart's y-axis label
   */
  public static String GetYLabel()
  {
    return m_chartYLabel;
  }

  /**
   * A get method to return the Scale factor of a chart
   * @return m_chartScale - Returns the chart scale
   */
  public static int GetScale()
  {
    return m_chartScale;
  }

  /**
   * A get method to return the Author of a chart
   * @return m_chartAuthor - Returns the chart's Author
   */
  public static String GetAuthor()
  {
    return m_chartAuthor;
  }

  /**
   * A get method to return the description of a chart
   * @return m_chartDescription - Returns the chart's description
   */
  public static String GetDescription()
  {
    return m_chartDescription;
  }
  
  public static String GetColourScheme()
  {
    return m_colourScheme;
  }
}
