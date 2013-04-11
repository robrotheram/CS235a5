
package TestUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/** @brief JList custom renderer 

    This Class will render the the list, show icons
    @author Robert Fletcher
    @file ListRender.java
    @date April 2013
    */

public class ListRender extends JLabel implements ListCellRenderer {
  private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
  private final EmptyBorder BORDER = new EmptyBorder(0,10, 10, 10);
  private final int ICONTEXTGAP = 12;
  /**
   * ListRenerder Constructor. 
   * Sets up the gap and border for the elements of the list
   */
  public ListRender() {
    setOpaque(true);
    setIconTextGap(ICONTEXTGAP);
    setBorder(BORDER);
  }
  /**
   * The renderer of the list
   * @param JList the list to have the render attached to. 
   * @param Object the element in the list
   * @param int the index file
   * @param booleam if the element is selected. 
   * @param boolean  Has the cell got Focus
   * @return Component the List component
   */

  @Override
  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    Test entry = (Test) value;
    setText(entry.getTitle());
    setIcon(entry.getImage());
    if (isSelected) {
      setBackground(HIGHLIGHT_COLOR);
      setForeground(Color.white);
    } else {
      setBackground(Color.white);
      setForeground(Color.black);
    }
    return this;
  }
}