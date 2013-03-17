package cs235a5;

/**
 *
 * \file    dataSet.java
 * \author  Saeed Mohamed, Anthony Dakin
 * \data    15/02/2013
 *
 * \brief   A DataSet class that calls the CSVInput
 *          and passes the data into an array.
 *
 */

// Import Arrays
import java.util.Arrays;

public class DataSet
{
  static ErrorHandling err = new ErrorHandling();
  private static String[][] m_dataArray;
  private static String[] m_headerArray;

  /**
   * Load Data from CSVInput
   * @param filename Path to .csv file
   * @return String Input String
   */
  private static String loadData(String filename)
  {
    CSVinput app = new CSVinput();
    app.SetInput(filename);
    return app.GetData();
  }

  /**
   * Add data to an array
   * @param filename Path to .csv file
   */
  public static void AddData(String filename)
  {
	try {
    String dataToSplit = loadData(filename);

    //Splits down the input into an array of each line
    String[] lineArr = dataToSplit.split("/");

    //Splits down the first line to create header array
    m_headerArray = lineArr[0].split(",");

    //Creates an array of the right size to store the data
    m_dataArray = new String[lineArr.length-1][m_headerArray.length-1];

    //Puts data into array
    for (int i = 1; i < lineArr.length; i++)
    {
      m_dataArray[i-1] = lineArr[i].split(",");
    }

    //Clears out any erroneous data
    for (int i = 0; i < lineArr.length - 1; i++)
    {
      if (m_headerArray.length != m_dataArray[i].length)
      {
        //Creates a new array to store the clean data
        String newArray[] = new String[m_headerArray.length];
        
        int thisCounter = 0;
        
        //Loops through the contents of the erroneous array
        for (int j = 0; j < m_dataArray[i].length; j++)
        {
          //Puts data into new array as long as it's not empty
          if (!m_dataArray[i][j].equals(""))
          {
            newArray[thisCounter] = m_dataArray[i][j];
            thisCounter++;
          }
        }
        //Stores clean array permanantly
        m_dataArray[i] = newArray;
      }
    }
	}catch (ArrayIndexOutOfBoundsException e) {
		err.WrongType();
	}
	
  }

  /**
   * Get the Headers for use with Charts
   * @return String[] An array of column headers
   */
  public static String[] GetHeaders()
  {
    return m_headerArray;
  }

  /**
   * Get the Data for use with Charts
   * @return String[] An array of data
   */
  public static String[][] GetData()
  {
    return m_dataArray;
  }
}
