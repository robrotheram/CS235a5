package cs235a5;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Robert
 */
public class SaveDialog {

    
    public SaveDialog(DataSet db, TabPannel tp){
        if(!SetDataSet(db)){
            System.out.println("SaveDialog.SetDataSet()-Failed to"
                    + " set the DataSet");
        }
        if(!SetTabPannel(tp)){
            System.out.println("SaveDialog.SetTabPannel()-Failed to"
                    + " set the DataSet");
        }
    }
    
    public boolean SetDataSet(DataSet db){
        m_db = db;
        return true;
    }
    public boolean SetTabPannel(TabPannel tp){
        m_tp = tp;
        return true;
    
    }
    
    private File getSaveFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(
        "GMS Files Only", "GMS"));
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
         
        }else{
            return null;
        }
    }
    
    public boolean SaveFile(){
        FileWriter fw = null;
        try {
            File file = getSaveFile();
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Visulisation>\n" +
                "<Data>\n" 
            );
            bw.write("<Date>"+getDate()+"</Date>\n");
            bw.write("<File>"+m_db.getFilePath()+"</File>\n");
            bw.write("</Data>\n");
           
            for(int i =0; i<m_tp.GetNumOfCharts();i++){
                Chart c = m_tp.GetTab(i);
                ColourMap cm = c.GetColourMap();
                bw.write("<Chart>\n");
                bw.write("<ChartType>"+c.GetChartType().toString()+
                         "</ChartType>\n");
                bw.write("<XColumn>"+c.GetXColumnPosition()+"</XColumn>\n");
                bw.write("<YColumn>"+c.GetYColumnPosition()+"</YColumn>\n");
                bw.write("<ChartTitle>"+c.GetTitle()+"</ChartTitle>\n");
                bw.write("<Author>"+c.GetAuthor()+"</Author>\n");
                bw.write("<Desc>"+c.GetDescription()+"</Desc>\n");
                bw.write("<Schemme>\n");
                for(int j =0; j<cm.getNumberOfColours();j++){
                    Color cl = cm.getColour(j);
                    bw.write("<Color>");
                    bw.write(cl.getRed()+",");
                    bw.write(cl.getGreen()+",");
                    bw.write(cl.getBlue());
                    bw.write("</Color>\n");
                    
                }
                bw.write("</Schemme>\n");
                bw.write("</Chart>\n");
            }
            bw.write("</Visulisation>");
            bw.close();
            
            
            return true;
            
            
        } catch (IOException ex) {
            
            return false;
        }
    }
    
    private String getDate(){
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
 
	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   return dateFormat.format(cal.getTime());
    }
    
    private DataSet m_db;
    private TabPannel m_tp;
    
}
