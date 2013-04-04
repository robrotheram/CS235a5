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

/** @brief This class is used to save a file

    This class gets the user to select a file, the program will then write the 
    * file using the data from the tabPannel class
    * classes
    @author Robert Fletcher
    @file TSaveDialog.java
    @date April 2013
    */

public class SaveDialog {
 /**
     * Class Constructor 
     * @param DataSet the programs dataSet
     * @param TabPannel The programs TabPannel
     */
    
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
    
  /**
     * Sets the DataSet for the class
     * @param DataSet db
     * @return boolean True if set Correctly
     */
    public boolean SetDataSet(DataSet db){
        m_db = db;
        return true;
    }
    /**
     * Sets the Memory reference to the Programs TabPanel
     * @param TabPannel 
     * @return boolean True if set Correctly
     */
    public boolean SetTabPannel(TabPannel tp){
        m_tp = tp;
        return true;
    
    }
    
/**
    * Gets the File the user wants to open.
    * @return File - The File the program will read.
    */ 
    
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
    
    /**
     * This method will write the file in a XML format so that the openDialog 
     * class can read it.
     * @return boolean True if written  with no errors
     */
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
