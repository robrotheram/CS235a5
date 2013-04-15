package inBeta;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Robert Fletcher
 */
public class testTab extends JFrame {
  private JTabbedPane tp;

  private JLabel lblStatus;

  private int tabCounter = 0;

  public testTab() {
    super("Browser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JMenuBar mb = new JMenuBar();
    JMenu mFile = new JMenu("File");
    JMenuItem mi = new JMenuItem("Add Tab");
    ActionListener addTabl = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addTab();
      }
    };
    mi.addActionListener(addTabl);
    mFile.add(mi);
    mb.add(mFile);
    setJMenuBar(mb);

    JPanel pnlURL = new JPanel();
    tp = new JTabbedPane();
    addTab();
    addTab();
    addTab();
    getContentPane().add(tp, BorderLayout.CENTER);

    lblStatus = new JLabel(" ");
    getContentPane().add(lblStatus, BorderLayout.SOUTH);

    setSize(300, 300);
    setVisible(true);
  }

  void addTab() {
    JEditorPane ep = new JEditorPane();
    ep.setEditable(false);
    
    tp.addTab(null, new JScrollPane(ep));

    try {
            BufferedImage im = ImageIO.read(this.getClass().getResource("/assets/images/no.png"));
            ImageIcon i = new ImageIcon(im.getScaledInstance(10,10, Image.SCALE_SMOOTH));
         JButton tabCloseButton = new JButton("");
         
         tabCloseButton.setIcon(i);
         tabCloseButton.setBorder(BorderFactory.createEmptyBorder());
//removes content area
tabCloseButton.setContentAreaFilled(false);
    tabCloseButton.setActionCommand("" + tabCounter);

    ActionListener al;
    al = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        String s1 = btn.getActionCommand();
        for (int i = 0; i < tp.getTabCount(); i++) {
          JPanel pnl = (JPanel) tp.getTabComponentAt(i);
          btn = (JButton) pnl.getComponent(1);
          String s2 = btn.getActionCommand();
          if (s1.equals(s2)) {
            tp.removeTabAt(i);
            break;
          }
        }
      }
    };
    tabCloseButton.addActionListener(al);

  
      JPanel pnl = new JPanel();
      JLabel l  = new JLabel("hello all");
      pnl.add(l);
      pnl.setOpaque(false);
      
        pnl.add(tabCloseButton);
      
      tp.setTabComponentAt(tp.getTabCount() - 1, pnl);
      tp.setSelectedIndex(tp.getTabCount() - 1);
    

    tabCounter++;
    
    } catch (IOException ex) {
            
        }
   
  }

  public static void main(String[] args) {
    new testTab();

  }
}

