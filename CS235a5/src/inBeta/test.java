/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inBeta;

import cs235a5.AreaChart;
import cs235a5.BubbleChart;
import cs235a5.CSVReader;
import cs235a5.Chart;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import cs235a5.LineChart;
import cs235a5.OpenDialog;
import cs235a5.PieChart;
import cs235a5.PolarPlot;
import cs235a5.SaveDialog;
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
     System.err.println("is Empty: "+db.isEmpty());
     URL fileURL = this.getClass().getResource("/assets/files/csv.csv");
        
        File f = new File(fileURL.getPath());
        CSVReader csvr = new CSVReader(db,f,",");
        if(csvr.ParseFile()){
        System.err.println("is Empty: "+db.isEmpty());
        
        m.add(tp);
        m.validate();
        
        OpenDialog O = new OpenDialog(db,tp);
        O.ReadFile();
        /*  
           tp.AddTab("test1", new ColumnChart(db,
                                                2,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
         tp.AddTab("test2", new ColumnChart(db,
                                                2,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
          tp.AddTab("test3", new ColumnChart(db,
                                                2,
                                                4,
                                                "title",
                                                new Rectangle(0,0,400,400),
                                                new ColourMap(c),
                                                "Author",
                                                "Decription"
                                                ));
            
           
                  
           SaveDialog s = new SaveDialog(db,tp);
           s.SaveFile();
       */
            
        }else{
             System.err.print("error!!!!!");
        }
     
     
     
     
 }
    
    public static void main(String[] args){
        test t = new test();
        t.setVisible(true);
    }
    
    
}
