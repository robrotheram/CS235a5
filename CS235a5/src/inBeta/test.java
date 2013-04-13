/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inBeta;

import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Robert
 */
public class test extends JFrame {
 private JPanel m;
  private final Color[] c = {Color.RED,Color.GREEN,Color.RED,Color.RED,Color.RED};
  
    public test(){
     this.setSize(500,500);
     m = new JPanel();
     m.setBackground(Color.yellow);
     m.setBounds(0,0, 500, 500);
     this.add(m);
     DataSet db = new DataSet();
     URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
        
        File f = new File(fileURL.getPath());
        CSVReader csvr = new CSVReader(db,f,",");
        if(csvr.ParseFile()){
          m.add( new ColumnChart(db,
                                                0,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
            
            
            
        }else{
             System.err.print("error!!!!!");
        }
     
     
     
     
 }
    
    public static void main(String[] args){
        test t = new test();
        t.setVisible(true);
    }
    
    
}
