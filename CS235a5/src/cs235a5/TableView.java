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
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
  * Creates a new JPanel containing a JTable
  *
  */


public class TableView extends JPanel
{

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
  private JTable GetUserData()
  {
    m_table = new JTable(m_DB.GetDataSet(),m_DB.GetHeader());
    m_table.setShowGrid(true);
    m_table.setGridColor(Color.BLACK);
    m_table.getModel().addTableModelListener(new TableModelListener() {

          @Override
          public void tableChanged(TableModelEvent tme) {
             int r = tme.getLastRow();
             int c = tme.getColumn();
             String s = (String) m_table.getModel().getValueAt(r, c);
               
               m_DB.SetDataCell(new DataCell(s), r, c);
              // System.out.println("row = "+r+" coloum = "+c+"Source + "+m_DB.GetCell(r,c).toString());
          }
      });
    return m_table;
  }





  /**
   * Creates a TableView constructed of a JScrollPane
   * containing a JTable.
   * @return A JScrollPane containing a JTable
   */
   
  private JScrollPane GetTableView()
  {
    return  new JScrollPane(GetUserData());
  }
  /**
   * Class constructor that created the table from the dataset
   * @param DataSet the DataSAet used by the class to make the table
   * @param Rectangle the size of the table
   */
  public TableView(DataSet db, Rectangle r){
       m_DB = db;
       this.setBounds(r);
       this.setLayout(new java.awt.BorderLayout());
       this.add(GetTableView(),BorderLayout.CENTER);
       this.setVisible(true);
    }
  /**
   * Class constructor to create a empty table
   */
  public TableView(DataSet db,boolean n){
    
  final JTable t = new JTable(new DefaultTableModel(
   new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    
                   }, new String [] {"Title A", "Title B", "Title C", "Title D"}
                ));
  
  //t.setEnabled(false);
        m_DB = db;
        if(n){
            int y = t.getRowCount();
            int x = t.getColumnCount();
            db.SetDataSet(y, x);
            db.SetHeader(new String [] {"Title A", "Title B", "Title C", "Title D"});
        }

        t.setFillsViewportHeight(true);
        t.setShowGrid(true);
        t.setGridColor(Color.BLACK);
        t.getModel().addTableModelListener(new TableModelListener() {

          @Override
          public void tableChanged(TableModelEvent tme) {
             int r = tme.getLastRow();
             int c = tme.getColumn();
             String s = (String) t.getModel().getValueAt(r, c);
               
               m_DB.SetDataCell(new DataCell(s), r, c);
               //System.out.println("row = "+r+" coloum = "+c+"Source + "+m_DB.GetCell(r,c).toString());
          }
      });
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(t),BorderLayout.CENTER);
  }
    
    private DataSet m_DB;
    private JTable m_table;

}

