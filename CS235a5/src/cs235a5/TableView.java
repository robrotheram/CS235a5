package cs235a5;

/**
 * \file    TableView.java
 * \author  John Rowley, Justina Onuigbo
 * \data    28/02/2013
 *
 * \brief   A TableView class to get user data and
 *          populate a JTable with that data.
 *
 */

// Import Swing Library
import javax.swing.*;

public class TableView
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
   * Creates a JTable populated with data collected
   * from the dataSet class.
   * @return A populated JTable
   */
  public JTable GetUserData()
  {
    m_table = new JTable(dataSet.GetData(),
                         dataSet.GetHeaders());

    return m_table;
  }

  /**
   * Creates a TableView constructed of a JScrollPane
   * containing a JTable.
   * @return A JScrollPane containing a JTable
   */
  public JScrollPane GetTableView()
  {
    m_sp = new JScrollPane(m_table);
    m_sp.setBorder(BorderFactory.createEmptyBorder());
    return m_sp;
  }
}
