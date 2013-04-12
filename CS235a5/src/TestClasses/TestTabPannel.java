/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.ColourMap;
import cs235a5.ColumnChart;
import cs235a5.DataSet;
import cs235a5.TabPannel;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Robert
 */
public class TestTabPannel {
    private final String CLASSNAME = "TabPannel";
    private TabPannel m_TP = new TabPannel();
    private final Color[] c = {Color.RED,Color.RED,Color.RED,Color.RED,Color.RED};
       public Test TestAddTab(boolean run){
        Test theTest = new Test(
                 "Testing if you can Add a chart to the TabbedPane",//Test Title
                 CLASSNAME,//Class Name
                 "AddTab",//Method Being Tested
                 "A test to see if the You can add a tab to the tabbedPane and store in the arrayList", //Description
                 "Test Panel, BarChart", //Input Data
                 "True" //Expected output
                 );   
        
       
        if(run){
            theTest.hasRun();
            
            if(m_TP.AddTab("Test Panel", new ColumnChart(new DataSet(),0,0,"title",new Rectangle(0,0,30,30),new ColourMap(c),"Author","Decription"))){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       
       
       public Test TestGetTab(boolean run){
        Test theTest = new Test(
                 "Testing if you can Get a chart from the TabbedPane",//Test Title
                 CLASSNAME,//Class Name
                 "AddTab",//Method Being Tested
                 "A test to see if the You can get a tab to the tabbedPane and retreive it from the arrayList", //Description
                 "0", //Input Data
                 "chart != null" //Expected output
                 );   
        
       
        if(run){
            theTest.hasRun();
            
            m_TP.AddTab("Test Panel", 
                            new ColumnChart(new DataSet(),
                                            0,
                                            0,
                                            "title",
                                            new Rectangle(0,0,30,30),
                                            new ColourMap(c),
                                            "Author",
                                            "Decription"
                                            ));
            
                    if(m_TP.GetTab(0)!=null){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       
       
        public Test TestNumOfCharts(boolean run){
        Test theTest = new Test(
                 "Testing if you can Get a number of chart from the TabbedPane",//Test Title
                 CLASSNAME,//Class Name
                 "AddTab",//Method Being Tested
                 "A test to see if the You can get the number of charts", //Description
                 "N/A", //Input Data
                 "0>1" //Expected output
                 );   
        
       
        if(run){
            theTest.hasRun();
                    if(m_TP.GetNumOfCharts()>=0){
                theTest.setPassed(true);
            }else{
                theTest.setPassed(false);
            }
            
        }
        return theTest;
    }
       /**
     * Main method to run this test 
     * @param String[] the command line arguments
     */
    
    public static void main(String[] args){
        boolean run = true;
        TestTabPannel TTP = new TestTabPannel();
        
        System.out.println("Test Add Tab"+
                TTP.TestAddTab(run).getResult());
        System.out.println("Test Get Tab"+
                TTP.TestGetTab(run).getResult());
        System.out.println("Test Number of Tab"+
                TTP.TestNumOfCharts(run).getResult());
        
        
    }
       
    
}



