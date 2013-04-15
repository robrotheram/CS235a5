/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inBeta;

import cs235a5.AreaChart;
import cs235a5.BubbleChart;
import cs235a5.CSVReader;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import cs235a5.LineChart;
import cs235a5.PieChart;
import cs235a5.ScatterPlotChart;
import cs235a5.TabPannel;
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
  private final Color[] c = {Color.RED,Color.GREEN,Color.BLUE,Color.CYAN,Color.ORANGE};
  
    public test(){
     this.setSize(500,500);
     TabPannel tp  = new TabPannel();
     m = new JPanel();
     m.setBackground(Color.yellow);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     m.setBounds(0,0, 500, 500);
     this.add(m);
     DataSet db = new DataSet();
     URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
        
        File f = new File(fileURL.getPath());
        CSVReader csvr = new CSVReader(db,f,",");
        if(csvr.ParseFile()){
            tp.AddTab("testChart",  new ScatterPlotChart(db,
                                                2,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
            tp.AddTab("testChart",  new PieChart(db,
                                                2,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
            m.add(tp); 
                  
                  
                
            
            
            
        }else{
             System.err.print("error!!!!!");
        }
     
     
     
     
 }
    
    public static void main(String[] args){
        test t = new test();
        t.setVisible(true);
    }
    
    
}
