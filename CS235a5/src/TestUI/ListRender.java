/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestUI;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Robert
 */
public class ListRender extends JLabel implements ListCellRenderer {
  private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
  private final EmptyBorder BORDER = new EmptyBorder(0,10, 10, 10);
  public ListRender() {
    setOpaque(true);
    setIconTextGap(12);
    setBorder(BORDER);
  }

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