package cs235a5;

/**
 * \file    TableView.java
 * \author  John Rowley, Justina Onuigbo & Alex McDonough
 * \data    18/03/2013
 *
 * \brief   A TableView class to get user data and
 *          populate a JTable with that data.
 *
 */

// Import Swing Library
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.*;

/**
  * Creates a new JPanel containing a JTable
  *
  */


public class TableView extends JPanel
{
  private Object[][] m_rows;
  private Object[] m_headers;
  private JScrollPane m_sp;
  private JTable m_table;

  public TableView()
  {
    m_table = GetUserData();
  }
  
  
  
  /**
     * Set the dataset in this class
     * @param MS_DataSet db the dataset reference
     * @return Boolean True if it has been set
     */
  
   public boolean setDataSet(DataSet db){ 
        m_DB = db;
        return true;
   }
   
    /**
     * Gets the data set in this class
     * @return  MS_DataSet
     */
    public DataSet getDataSet(){ 
        return m_DB;
    }
    
    
   
   
  /**
   * Creates a JTable populated with data collected
   * from the DataSet class.
   * @return A populated JTable
   */
  public JTable GetUserData()
  {
    m_table = new JTable(DataSet.GetData(),
                         DataSet.GetHeaders());

    return m_table;
  }





  /**
   * Creates a TableView constructed of a JScrollPane
   * containing a JTable.
   * @return A JScrollPane containing a JTable
   */
   
  public JScrollPane GetTableView()
  {
    JTable t = new JTable(m_DB.getDataSet(),m_DB.getColumnNames());
        return  new JScrollPane(t);
  }


}

