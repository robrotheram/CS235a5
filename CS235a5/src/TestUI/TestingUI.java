 package TestUI;

import TestClasses.TestCSVReader;
import TestClasses.TestCSVReaderDialog;
import TestClasses.TestCloudDialog;
import TestClasses.TestCloudIO;
import TestClasses.TestDataCell;
import TestClasses.TestDataSet;
import TestClasses.TestJsonParser;
import TestClasses.TestTabPannel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/** @brief Class the contains all the info for the Debug User interface

    This Class will contains all the info for the User interface for the test
    @author Robert Fletcher
    @file TestingUI.java
    @date April 2013
    */
public class TestingUI extends JFrame {
    
    
    
    /**
     * Class constructor to set up the ui
     */
    public TestingUI(){
        initFrame();
        initListPannel();
        initMainPannel();       
        initButtons();
        this.setVisible(true);
    }
    
    /**
     * Set up the main frame
     */
    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Data Visulisation Debug Program");
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setSize(MAINFRAMESIZE);
        
    }
    /**
     * Set up the Button listeners
     */
    private void initButtons(){
        m_runAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                
                
                m_listPanel.removeAll();
                m_runTests = true;
                m_testList = new JList(getTestList(true));
                m_testList.setCellRenderer(new ListRender());
                m_testList.addListSelectionListener(
                        new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent 
                            listSelectionEvent) {
                        Test t = (Test) m_testList.getSelectedValue();
                        textField.setText(t.getTitle());
                        textField1.setText(t.getClassName());
                        textField2.setText(t.getMethodName());
                        textField3.setText(t.getDescription());
                        textField4.setText(t.getExpected());
                        textField5.setText(t.getActual());
                        textField6.setText(t.getResult());
                    }}
                );
                
                m_listPanel.setLayout(new BorderLayout());

                m_listPanel.add(new JScrollPane(m_testList), 
                        BorderLayout.CENTER);
                m_listPanel.add(m_buttonPannel, BorderLayout.SOUTH);
                m_listPanel.setPreferredSize(LISTSIZE);   
                m_listPanel.validate(); 
                
            }
        });
        
         m_reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                
                
                m_listPanel.removeAll();
                m_runTests = true;
                m_testList = new JList(getTestList(false));
                m_testList.setCellRenderer(new ListRender());
                m_testList.addListSelectionListener(
                        new ListSelectionListener() {
                    public void valueChanged
                            (ListSelectionEvent listSelectionEvent) {
                        Test t = (Test) m_testList.getSelectedValue();
                        textField.setText(t.getTitle());
                        textField1.setText(t.getClassName());
                        textField2.setText(t.getMethodName());
                        textField3.setText(t.getDescription());
                        textField4.setText(t.getExpected());
                        textField5.setText(t.getActual());
                        textField6.setText(t.getResult());
                    }}
                );
                
                m_listPanel.setLayout(new BorderLayout());

                m_listPanel.add(new JScrollPane(m_testList), BorderLayout.CENTER);
                m_listPanel.add(m_buttonPannel, BorderLayout.SOUTH);
                m_listPanel.setPreferredSize(LISTSIZE);   
                m_listPanel.validate(); 
                
            }
        });
        
        
    }
    /**
     * Set up the main panel
     */
    private void initMainPannel(){
        
        m_contentPanel = new JPanel();
       
        int numPairs = LABELS.length;
 
        //Create and populate the panel.
         m_contentPanel= new JPanel(new SpringLayout());
         
         l = new JLabel(LABELS[0], JLabel.TRAILING);
         m_contentPanel.add(l);
         textField = new JTextField(10);
         l.setLabelFor(textField);
         m_contentPanel.add(textField);
         
         l1 = new JLabel(LABELS[1], JLabel.TRAILING);
         m_contentPanel.add(l1);
         textField1 = new JTextField(10);
         l.setLabelFor(textField1);
         m_contentPanel.add(textField1);
         
         l2 = new JLabel(LABELS[2], JLabel.TRAILING);
         m_contentPanel.add(l2);
         textField2 = new JTextField(10);
         l.setLabelFor(textField2);
         m_contentPanel.add(textField2);
         
         l3 = new JLabel(LABELS[3], JLabel.TRAILING);
         m_contentPanel.add(l3);
         textField3 = new JTextField(10);
         l.setLabelFor(textField3);
         m_contentPanel.add(textField3);
         
         l4 = new JLabel(LABELS[4], JLabel.TRAILING);
         m_contentPanel.add(l4);
         textField4 = new JTextField(10);
         l.setLabelFor(textField4);
         m_contentPanel.add(textField4);
         
         l5 = new JLabel(LABELS[5], JLabel.TRAILING);
         m_contentPanel.add(l5);
         textField5 = new JTextField(10);
         l.setLabelFor(textField5);
         m_contentPanel.add(textField5);
         
         l6 = new JLabel(LABELS[6], JLabel.TRAILING);
         m_contentPanel.add(l6);
         textField6 = new JTextField(10);
         l.setLabelFor(textField6);
         m_contentPanel.add(textField6);
         
        
 
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(m_contentPanel,
                                        numPairs, SPRINGCOL, //rows, cols
                                        SPRINGXYINT, SPRINGXYINT,        //initX, initY
                                        SPRINGXYINT, SPRINGXYINT);       //xPad, yPad
 
        //Create and set up the window.
        JFrame frame = new JFrame("SpringForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
         m_contentPanel.setOpaque(true);  //content panes must be opaque
        
        
        
        
        this.getContentPane().add(m_contentPanel, BorderLayout.CENTER); 
        
       
        
        
    }
    /**
     * Set up the list panel
     */
    private void initListPannel(){
        m_listPanel = new JPanel();
        m_listPanel.setBorder
                (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        m_buttonPannel = new JPanel();
        m_buttonPannel.setLayout(new BorderLayout());
        
        m_runAll = new JButton("Run All Tests");
        m_reset = new JButton("Reset Tests");
        m_buttonPannel.add( m_runAll, BorderLayout.WEST);
        m_buttonPannel.add( m_reset, BorderLayout.EAST);         
        
        m_listPanel.setBackground(Color.YELLOW);
        m_testList = new JList(getTestList(false));
        m_testList.setCellRenderer(new ListRender());
        m_testList.addListSelectionListener(new ListSelectionListener() {
            
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            Test t = (Test) m_testList.getSelectedValue();
            textField.setText(t.getTitle());
            textField1.setText(t.getClassName());
            textField2.setText(t.getMethodName());
            textField3.setText(t.getDescription());
            textField4.setText(t.getExpected());
            textField5.setText(t.getActual());
            textField6.setText(t.getResult());
       }}


        );
        
        
        m_listPanel.setLayout(new BorderLayout());
        
        m_listPanel.add(new JScrollPane(m_testList), BorderLayout.CENTER);
        m_listPanel.add(m_buttonPannel, BorderLayout.SOUTH);
        m_listPanel.setPreferredSize(LISTSIZE);         
        this.getContentPane().add(m_listPanel, BorderLayout.WEST); 
    }

    /**
     * Sets up the list of test that are going to be run
     * @param Boolean run all the tests
     * @return Test[] An array of tests
     */
    
     public Test[] getTestList(boolean run){
        Test[] THETESTS = 
            {
                TDC.testSetDataString(run),
                TDC.testSetBoolean(run),
                TDC.testSetDataDouble(run),
                TDC.testSetInteger(run),
                TDC.testGetBoolen(run),
                TDC.testGetDouble(run),
                TDC.testGetInteger(run),
                TDC.testGetString(run),
                TJP.TestparseLogin(run),
                TJP.TestparseList(run),
                TJP.TestparseGet(run),
                TJP.TestparseUpload(run),
                TDS.TestSetDataSetWithInt(run),
                TDS.TestSetDataSet(run),
                TDS.TestSetHeader(run),
                TDS.TestSetDataCell(run),
                TDS.TestSetFilePath(run),
                TDS.TestGetCell(run),
                TDS.TestGetDataSet(run),
                TDS.TestGetRow(run),
                TDS.TestGetHeader(run),
                TDS.TestGetAHeader(run),
                TDS.TestGetNumRows(run),
                TDS.TestGetNumColumns(run),
                TDS.TestGetFilePath(run),            
                TC.TestLogin(run),
                TC.TestList(run),
                TC.TestgetFilePath(run),
                TC.TestUpload(run),
                TC.TestDownloadFile(run),
                TCD.TestCloudDialogDisplay(run),
                TCSVR.TestCloudDialogDisplay(run),
                TCSVR.TestsetContext(run),
                TCSVR.TestsetDataSet(run),
                TCSVR.TestsetFile(run),
                TCSVR.TestGetFile(run),
                TCSVR.TestGetDataSet(run),
                TCSVR.TestGetContext(run),
                TCSV.TestsetDataSet(run),
                TCSV.TestsetFile(run),
                TCSV.TestGetFile(run),
                TCSV.TestGetDataSet(run),
                TCSV.TestGetDelimiters(run),
                TCSV.TestsetDelimiter(run),
                TCSV.TestParseFile(run),
                TTP.TestAddTab(run),
                TTP.TestGetTab(run),
                TTP.TestNumOfCharts(run)

        return THETESTS;
        
     
     }
    /* ---- Data for the tests ----*/
    
    
    /* ---- Define all the Classes that are going to be used ----*/
    private final TestDataCell TDC = new TestDataCell();
    private final TestJsonParser TJP = new TestJsonParser();
    private final TestDataSet TDS = new TestDataSet();
    private final TestCloudIO TC = new TestCloudIO();
    private final TestCloudDialog TCD = new TestCloudDialog();
    private final TestCSVReaderDialog TCSVR = new TestCSVReaderDialog();
    private final TestCSVReader TCSV = new TestCSVReader();
    private final TestTabPannel TTP = new TestTabPannel();
    /* ---- Set to run the tests --*/
    private boolean m_runTests = false;
     private JPanel  m_listPanel,m_contentPanel,m_buttonPannel, m_LabelPanel, 
                    m_textPanel;
    private JButton m_reset, m_runAll;
    private JLabel l6,l5,l4,l3,l2,l1,l;
    private JTextField  textField,textField1,textField2,textField3,textField4,
                        textField5,textField6;
    private JList m_testList;
    private final Dimension MAINFRAMESIZE = new Dimension(700,400);
    private final int LABELHEIGHT = 600;
    private final int TEXTHEIGHT = 300;
    private final int LABELWIDTH = 200;
    private final int SPRINGCOL = 2;
    private final int SPRINGXYINT = 6;
    private final Dimension LISTSIZE = new Dimension(240,this.getHeight());
    private final String[] LABELS = {
        "Test Title: ",
        "Name of Class being tested: ", 
        "Name of Method being tested: ", 
        "What is being Tested: ", 
        "Input pramaters: ",
        "reuslt: " ,  
        "Test Status (Pass|Fail|N/A): "
    };
   

    
    
}




    