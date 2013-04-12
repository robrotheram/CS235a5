/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;

import TestUI.Test;
import cs235a5.DataCell;
import cs235a5.DataSet;



/**
 *
 * @author Robert
 */
public class TestDataSet {
        private final String CLASSNAME = "DataSet";
        private DataSet m_db = new DataSet();
        
        public Test TestSetDataSetWithInt(boolean run){
            Test theTest = new Test(
                 "Test to set up the dataset",//Test Title
                 CLASSNAME,//Class Name
                 "SetDataSet",//Method Being Tested
                 "A test to see if the dataSet can be set up", //Description
                 "width = 5 height = 10", //Input Data
                 "True - meansing that the dataset has been set up correctly" //Expected output
                 );
            int w = 5;
            int h = 10;
            if(run){
                theTest.hasRun();
                if(m_db.SetDataSet(h, h)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        
        public Test TestSetDataSet(boolean run){
            Test theTest = new Test(
                 "Test to set up the dataset",//Test Title
                 CLASSNAME,//Class Name
                 "SetDataSet",//Method Being Tested
                 "A test to see if the dataSet can be set up the a 2 Dimentional DataCell Array", //Description
                 "DataCell[][]", //Input Data
                 "True - meansing that the dataset has been set up correctly" //Expected output
                 );
            DataCell[][] db = new DataCell[5][10];
            if(run){
                theTest.hasRun();
                if(m_db.SetDataSet(db)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestSetHeader(boolean run){
            Test theTest = new Test(
                 "Test to set up the Column Headers",//Test Title
                 CLASSNAME,//Class Name
                 "SetHeader",//Method Being Tested
                 "A test to see if the Column names can be set", //Description
                 "{\"Haeder A\",\"Haeder B\",\"Haeder C\",\"Haeder D\"}", //Input Data
                 "True - meansing that the dataset has been set up correctly" //Expected output
                 );
            String[] header  = {"Haeder A","Haeder B","Haeder C","Haeder D"};
            if(run){
                theTest.hasRun();
                if(m_db.SetHeader(header)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        
        public Test TestSetDataCell(boolean run){
            Test theTest = new Test(
                 "Test to set up the set a Datacell at position x,y",//Test Title
                 CLASSNAME,//Class Name
                 "SetDataCell",//Method Being Tested
                 "A test to see if the DataCell can be Set in the DataSet at position x,y", //Description
                 "DataCell(\"A String\"),x = 0, y = 0", //Input Data
                 "True" //Expected output
                 );
            int x = 0;
            DataCell dc = new DataCell("A String");
            m_db.SetDataSet(10, 10);
            if(run){
                theTest.hasRun();
                if(m_db.SetDataCell(dc, x, x)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestSetFilePath(boolean run){
            Test theTest = new Test(
                 "Test to set up the File path method",//Test Title
                 CLASSNAME,//Class Name
                 "SetDataCell",//Method Being Tested
                 "A test to see if the file path to the file used to create the dataset can be added", //Description
                 "/User/Path/To/A/File.csv", //Input Data
                 "True y" //Expected output
                 );
            int x = 0;
            String filePath = "/User/Path/To/A/File.csv";
            if(run){
                theTest.hasRun();
                if(m_db.SetFilePath(filePath)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
         public Test TestGetCell(boolean run){
            Test theTest = new Test(
                 "Test to get a cell at X , Y",//Test Title
                 CLASSNAME,//Class Name
                 "GetCell",//Method Being Tested
                 "A test to see if the a DataCell Can be returned by the dataset at X,Y", //Description
                 "X = 0, Y = 0", //Input Data
                 "A DataCell" //Expected output
                 );
            int x = 0;
            m_db.SetDataCell(new DataCell("A String"), x, x);
            if(run){
                theTest.hasRun();
                if(m_db.GetCell(x, x)!=null){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
         
         public Test TestGetDataSet(boolean run){
            Test theTest = new Test(
                 "Test to get a the entire DataSet",//Test Title
                 CLASSNAME,//Class Name
                 "GetCell",//Method Being Tested
                 "A test to see if the a DataSet can return a 2 Dimenstional array containg the entire dataset", //Description
                 "N/A", //Input Data
                 "DataCell[][]" //Expected output
                 );
            
            if(run){
                theTest.hasRun();
                if(m_db.GetDataSet() !=null){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
          public Test TestGetRow(boolean run){
            Test theTest = new Test(
                 "Test to get a the entire row of data",//Test Title
                 CLASSNAME,//Class Name
                 "GetRow",//Method Being Tested
                 "A test to see if the DataSet can return a whole row of data", //Description
                 "0", //Input Data
                 "DataCell[]" //Expected output
                 );
            
            if(run){
                theTest.hasRun();
                if(m_db.GetRow(0) !=null){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestGetHeader(boolean run){
            Test theTest = new Test(
                 "Test to see if the headers can be returned",//Test Title
                 CLASSNAME,//Class Name
                 "GeHedaer",//Method Being Tested
                 "A test to see if the DataSet can return the Headers as a String []", //Description
                 "N/A", //Input Data
                 "String[]" //Expected output
                 );
            String[] header  = {"Haeder A","Haeder B","Haeder C","Haeder D"};
            m_db.SetHeader(header);
            if(run){
                theTest.hasRun();
                if(m_db.GetHeader().equals(header)){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestGetAHeader(boolean run){
            Test theTest = new Test(
                 "Test to see if the A heder at column position X",//Test Title
                 CLASSNAME,//Class Name
                 "GetAColumnName",//Method Being Tested
                 "A test to see if the DataSet can return the  A Headers at "
                    + "position X", //Description
                 "2", //Input Data
                 "String[]" //Expected output
                 );
            String[] header  = {"Haeder A","Haeder B","Haeder C","Haeder D"};
            m_db.SetHeader(header);
            if(run){
                theTest.hasRun();
                if(m_db.GetAColumnName(2).equals(header[2])){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestGetNumRows(boolean run){
            Test theTest = new Test(
                 "Test to see if the number of rows can be returned",//Test Title
                 CLASSNAME,//Class Name
                 "GetNumOfRows",//Method Being Tested
                 "A test to see if the DataSet can return the number of rows ", //Description
                 "N/A", //Input Data
                 "int > 0" //Expected output
                 );
           
            if(run){
                theTest.hasRun();
                if(m_db.GetNumOfRows()>0){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        public Test TestGetNumColumns(boolean run){
            Test theTest = new Test(
                 "Test to see if the number of Columns can be returned",//Test Title
                 CLASSNAME,//Class Name
                 "GetNumOfColumns",//Method Being Tested
                 "A test to see if the DataSet can return the number of Columns ", //Description
                 "N/A", //Input Data
                 "int > 0" //Expected output
                 );
           
            if(run){
                theTest.hasRun();
                if(m_db.GetNumOfColumns()>0){
                    theTest.setPassed(true);
                }else{
                    theTest.setPassed(false);
                }
            }
            
        return theTest;
        }
        
        
         public Test TestGetFilePath(boolean run){
            Test theTest = new Test(
                 "Test to see if the DataSet can return the file path",//Test Title
                 CLASSNAME,//Class Name
                 "GetFilePath",//Method Being Tested
                 "A test to see if the DataSet can return return the file path "
                    + "that was used to create the dataset", //Description
                 "N/A", //Input Data
                 "String != null" //Expected output
                 );
           
            if(run){
                theTest.hasRun();
                if(m_db.getFilePath()!=null){
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
        TestDataSet TDS = new TestDataSet();
        
        
        System.out.println("Test Set up DataSet with int x, y: "+
                TDS.TestSetDataSetWithInt(run).getResult());
        System.out.println("Test Set up DataSet with DataCell[][]: "+
                TDS.TestSetDataSet(run).getResult());
        System.out.println("Test Set up Headers: "+
                TDS.TestSetHeader(run).getResult());
        System.out.println("Test Set DataCell"+
                TDS.TestSetDataCell(run).getResult());
        System.out.println("Test Set File Path: "+
                TDS.TestSetFilePath(run).getResult());
        System.out.println("Test Get Cell: "+
                TDS.TestGetCell(run).getResult());
        System.out.println("Test Get DataSet: "+
                TDS.TestGetDataSet(run).getResult());
        System.out.println("Test Get Row: "+
                TDS.TestGetRow(run).getResult());
        System.out.println("Test Get Header: "+
                TDS.TestGetHeader(run).getResult());
        System.out.println("Test Get A Header: "+
           TDS.TestGetAHeader(run).getResult());
        System.out.println("Test Get number of rows: "+
           TDS.TestGetNumRows(run).getResult());
        System.out.println("Test Get number of Columns: "+
           TDS.TestGetNumColumns(run).getResult());
        System.out.println("Test Get File Path: "+
           TDS.TestGetFilePath(run).getResult());
}
        
}
