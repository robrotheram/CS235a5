 package TestUI;

import TestClasses.TestAnimation;
import TestClasses.TestAreaChart;
import TestClasses.TestBubbleChart;
import TestClasses.TestCSVReader;
import TestClasses.TestCSVReaderDialog;
import TestClasses.TestCloudDialog;
import TestClasses.TestCloudIO;
import TestClasses.TestColumnChart;
import TestClasses.TestDataCell;
import TestClasses.TestDataSet;
import TestClasses.TestJsonParser;
import TestClasses.TestLineChart;
import TestClasses.TestOpenDialog;
import TestClasses.TestPieChart;
import TestClasses.TestPolarChart;
import TestClasses.TestSaveDialog;
import TestClasses.TestScatterPlotChart;
import TestClasses.TestSlide;
import TestClasses.TestSlideLeft;
import TestClasses.TestTabPannel;
import TestClasses.TestTabelView;
import TestClasses.TestUserColor; 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
        m_test.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                int pos = m_testList.getSelectedIndex();
                if(pos > -1){
                    THETESTS[pos] = getTest(true,pos);
                     Test t = (Test) m_testList.getSelectedValue();
                    textField.setText(t.getTitle());
                    textField1.setText(t.getClassName());
                    textField2.setText(t.getMethodName());
                    textField3.setText(t.getDescription());
                    textField4.setText(t.getExpected());
                    textField5.setText(t.getActual());
                    textField6.setText(t.getResult());

                    m_testList = new JList(THETESTS);
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
            }
        });
        
        
        
        
        m_runAll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                
                
                m_listPanel.removeAll();
                m_runTests = true;
                getTestList(true);
                m_testList = new JList(THETESTS);
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
                getTestList(false);
                m_testList = new JList(THETESTS);
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
        //m_buttonPannel.setLayout(new BorderLayout());
        m_buttonPannel.setLayout(new FlowLayout());
        
        m_runAll = new JButton("Run All Tests");
        m_reset = new JButton("Reset Tests");
        m_test = new JButton("Test run a test");
         m_buttonPannel.add(m_test);
        m_buttonPannel.add( m_runAll);
        m_buttonPannel.add( m_reset); 
        m_buttonPannel.setPreferredSize(LISTBUTSIZE);
        
        m_listPanel.setBackground(Color.YELLOW);
        getTestList(false);
        m_testList = new JList(THETESTS);
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
    
     public void getTestList(boolean run){
        THETESTS = new Test[TestID.TEST168.getValue()];
        for(int i =0;i<THETESTS.length;i++){
            THETESTS[i] = getTest(run,i);
        }
        
        
     
     }
     /**
      * Method to get a test 
      * @param run
      * @param testid
      * @return the test 
      */
     public Test getTest(boolean run,int testid){
         switch(TestID.getEnum(testid)){
            case TEST0: return TDC.testSetDataString(run);
               
            case TEST1: return  TDC.testSetBoolean(run);
                
            case TEST2: return  TDC.testSetDataDouble(run);
                
            case TEST3: return  TDC.testSetInteger(run);
                
            case TEST4: return TDC.testGetBoolen(run);
                
            case TEST5: return TDC.testGetDouble(run);
                
            case TEST6: return TDC.testGetInteger(run);
                
            case TEST7: return TDC.testGetString(run);
                
            case TEST8: return TJP.TestparseLogin(run);
                
            case TEST9: return TJP.TestparseList(run);
                
            case TEST10: return TJP.TestparseGet(run);
                
            case TEST11: return TJP.TestparseUpload(run);
                
            case TEST12: return TDS.TestSetDataSetWithInt(run);
                
            case TEST13: return TDS.TestSetDataSet(run);
                
            case TEST14: return TDS.TestSetHeader(run);
                
            case TEST15: return TDS.TestSetDataCell(run);
                
            case TEST16: return TDS.TestSetFilePath(run);
                
            case TEST17: return TDS.TestGetCell(run);
                
            case TEST18: return TDS.TestGetDataSet(run);
                
            case TEST19: return  TDS.TestGetRow(run);
                
            case TEST20: return TDS.TestGetHeader(run);
                
            case TEST21: return TDS.TestGetAHeader(run);
                
            case TEST22: return TDS.TestGetNumRows(run);
                
            case TEST23: return TDS.TestGetNumColumns(run);
                
            case TEST24: return TDS.TestGetFilePath(run);
                
            case TEST25: return TC.TestLogin(run);
                
            case TEST26: return TC.TestList(run);
                
            case TEST27: return TC.TestgetFilePath(run);
                
            case TEST28: return TC.TestUpload(run);
                
            case TEST29: return TC.TestDownloadFile(run);
                
            case TEST30: return  TCD.TestCloudDialogDisplay(run);
                
            case TEST31: return TCSVR.TestCSVReaderDialogDisplay(run);
                
            case TEST32: return TCSVR.TestsetContext(run);
                
            case TEST33: return TCSVR.TestsetDataSet(run);
                
            case TEST34: return TCSVR.TestsetFile(run);
                
            case TEST35: return TCSVR.TestGetDataSet(run);
                
            case TEST36: return TCSVR.TestGetContext(run);
                
            case TEST37: return TCSV.TestsetDataSet(run);
                
            case TEST38: return TCSV.TestsetDataSet(run);
                
            case TEST39: return TCSV.TestGetDelimiters(run);
                
            case TEST40: return TCSV.TestsetDelimiter(run);
                
            case TEST41: return TCSV.TestParseFile(run);
                
            case TEST42: return TTP.TestAddTab(run);
                
            case TEST43: return TTP.TestGetTab(run);
                
            case TEST44: return TTP.TestNumOfCharts(run);
                
            case TEST45: return TSD.TestSaveFile(run);
                
            case TEST46: return TOD.TestReadFile(run);
                
            case TEST47: return TPC.TestPieChartDiplay(run);
                
            case TEST48: return TPC.TestcreateChart(run);
                
            case TEST49: return TPC.TestSetTitle(run);
                
            case TEST50: return TPC.TestGetTitle(run);
                
            case TEST51: return TPC.TestsetDataSet(run);
                
            case TEST52: return TPC.TestSetXColumnData(run);
                
            case TEST53: return TPC.TestSetYColumnData(run);
                
            case TEST54: return TPC.TestSetColourMap(run);
                
            case TEST55: return TPC.TestGetColourMap(run);
                
            case TEST56: return TPC.TestSetAuthor(run);
                
            case TEST57: return TPC.TestSetYColumnData(run);
                
            case TEST58: return TLC.TestLineChartDiplay(run);
                
            case TEST59: return TLC.TestcreateChart(run);
                
            case TEST60: return TLC.TestSetTitle(run);
                
            case TEST61: return  TLC.TestGetTitle(run);
                
            case TEST62: return TLC.TestsetDataSet(run);
                
            case TEST63: return TLC.TestSetXColumnData(run);
                
            case TEST64: return   TLC.TestGetXColumnData(run);
                
            case TEST65: return TLC.TestSetYColumnData(run);
                
            case TEST66: return TLC.TestGetYColumnData(run);
                
            case TEST67: return TLC.TestSetColourMap(run);
                
            case TEST68: return TLC.TestGetColourMap(run);
                
            case TEST69: return TLC.TestSetAuthor(run);
                
            case TEST70: return TLC.TestGetAuthor(run);
                
            case TEST71: return TLC.TestSetYColumnData(run);
                
            case TEST72: return  TLC.TestGetYColumnData(run);
                
            case TEST73: return TCC.TestColumnChartDiplay(run);
                
            case TEST74: return TCC.TestcreateChart(run);
                
            case TEST75: return  TCC.TestSetTitle(run);
                
            case TEST76: return TCC.TestGetTitle(run);
                
            case TEST77: return TCC.TestsetDataSet(run);
                
            case TEST78: return  TCC.TestSetXColumnData(run);
                
            case TEST79: return TCC.TestGetXColumnData(run);
                
            case TEST80: return TCC.TestSetYColumnData(run);
                
            case TEST81: return TCC.TestGetYColumnData(run);
                
            case TEST82: return TCC.TestSetColourMap(run);
                
            case TEST83: return  TCC.TestGetColourMap(run);
                
            case TEST84: return TCC.TestSetAuthor(run);
                
            case TEST85: return  TCC.TestGetAuthor(run);
                
            case TEST86: return TCC.TestSetYColumnData(run);
                
            case TEST87: return TCC.TestGetYColumnData(run);
                
            case TEST88: return TCPC.TestPieChartDiplay(run);
                
            case TEST89: return TCPC.TestcreateChart(run);
                
            case TEST90: return TCPC.TestSetTitle(run);
                
            case TEST91: return  TCPC.TestGetTitle(run);
                
            case TEST92: return TCPC.TestsetDataSet(run);
                
            case TEST93: return TCPC.TestSetXColumnData(run);
                
            case TEST94: return TCPC.TestSetYColumnData(run);
                
            case TEST95: return  TCPC.TestSetColourMap(run);
                
            case TEST96: return TCPC.TestGetColourMap(run);
                
            case TEST97: return  TCPC.TestSetAuthor(run);
                
            case TEST98: return TCPC.TestSetYColumnData(run);
                
            case TEST99: return TCPC.TestGetYColumnData(run);
                
            case TEST100: return TAC.TestAreaChartDiplay(run);
                
            case TEST101: return TAC.TestcreateChart(run);
                
            case TEST102: return TAC.TestSetTitle(run);
                
            case TEST103: return TAC.TestGetTitle(run);
                
            case TEST104: return TAC.TestsetDataSet(run);
                
            case TEST105: return TAC.TestSetXAreaData(run);
                
            case TEST106: return TAC.TestGetXAreaData(run);
                
            case TEST107: return TAC.TestSetYAreaData(run);
                
            case TEST108: return TAC.TestSetColourMap(run);
                
            case TEST109: return TAC.TestGetColourMap(run);
                
            case TEST110: return TAC.TestSetAuthor(run);
                
            case TEST111: return TAC.TestSetYAreaData(run);
                
            case TEST112: return TAB.TestBubbleChartDiplay(run);
                
            case TEST113: return TAB.TestcreateChart(run);
                
            case TEST114: return TAB.TestSetTitle(run);
                
            case TEST115: return  TAB.TestGetTitle(run);
                
            case TEST116: return TAB.TestsetDataSet(run);
                
            case TEST117: return TAB.TestSetXColumnData(run);
                
            case TEST118: return TAB.TestSetYColumnData(run);
                
            case TEST119: return TAB.TestSetColourMap(run);
                
            case TEST120: return TAB.TestGetColourMap(run);
                
            case TEST121: return TAB.TestSetAuthor(run);
                
            case TEST122: return TAB.TestGetAuthor(run);
                
            case TEST123: return TAB.TestSetYColumnData(run);
                
            case TEST124: return TAB.TestGetYColumnData(run);
                
            case TEST125: return TPLC.TestPolarChartDiplay(run);
                
            case TEST126: return TPLC.TestcreateChart(run);
                
            case TEST127: return TPLC.TestSetTitle(run);
                
            case TEST128: return TPLC.TestGetTitle(run);
                
            case TEST129: return TPLC.TestsetDataSet(run);
                
            case TEST130: return TPLC.TestSetXColumnData(run);
                
            case TEST131: return TPLC.TestGetXColumnData(run);
                
            case TEST132: return TPLC.TestSetYColumnData(run);
                
            case TEST133: return TPLC.TestGetYColumnData(run);
                
            case TEST134: return TPLC.TestSetColourMap(run);
                
            case TEST135: return TPLC.TestGetColourMap(run);
                
            case TEST136: return TPLC.TestSetAuthor(run);
                
            case TEST137: return TPLC.TestGetAuthor(run);
                
            case TEST138: return TPLC.TestSetYColumnData(run);
                
            case TEST139: return TPLC.TestGetYColumnData(run);
                
            case TEST140: return TSC.TestScatterPlotChartDiplay(run);
                
            case TEST141: return TSC.TestcreateChart(run);
                
            case TEST142: return TSC.TestSetTitle(run);
                
            case TEST143: return TSC.TestGetTitle(run);
                
            case TEST144: return TSC.TestsetDataSet(run);
                
            case TEST145: return TSC.TestSetXColumnData(run);
                
            case TEST146: return  TSC.TestGetXColumnData(run);
                
            case TEST147: return  TSC.TestSetYColumnData(run);
                
            case TEST148: return TSC.TestGetYColumnData(run);
                
            case TEST149: return  TSC.TestSetColourMap(run);
                
            case TEST150: return  TSC.TestGetColourMap(run);
                
            case TEST151: return  TSC.TestSetAuthor(run);
                
            case TEST152: return  TSC.TestGetAuthor(run);
                
            case TEST153: return TSC.TestSetYColumnData(run);
                
            case TEST154: return TSC.TestGetYColumnData(run);
                
            case TEST155: return TUC.TestUserColor(run);
                
            case TEST156: return TTV.TestDisplay(run);
                
            case TEST157: return TTV.TestGetDataSet(run);
                
            case TEST158: return  TTV.TestsetDataSet(run);
                
            case TEST159: return  TA.TestAddCharts(run);
                
            case TEST160: return TA.TestSetSpeed(run);
                
            case TEST161: return  TA.TestSetWait(run);
                
            case TEST162: return TA.TestRemoveSlide(run);
                
            case TEST163: return TA.TestDisplay(run);
                
            case TEST164: return TSL.TestStart(run);
                
            case TEST165: return TS.TestStart(run);
                
            case TEST166: return TS.TestPause(run);
                
            case TEST167: return  TS.Testreume(run);
              
            default:
                return null;
             
         }
         
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
    private final TestOpenDialog TOD = new  TestOpenDialog();
    private final TestSaveDialog TSD = new  TestSaveDialog();
    private final TestPieChart TPC = new TestPieChart();
    private final TestLineChart TLC = new TestLineChart();
    private final TestColumnChart TCC = new TestColumnChart();
    private final TestPieChart TCPC = new TestPieChart();
    private final TestAreaChart TAC = new TestAreaChart();
    private final TestBubbleChart TAB = new TestBubbleChart();
    private final TestPolarChart TPLC = new TestPolarChart();
    private final TestScatterPlotChart TSC = new TestScatterPlotChart();
    private final TestUserColor TUC = new TestUserColor();
    private final TestTabelView TTV = new TestTabelView();
    private final TestAnimation TA = new TestAnimation();
    private final TestSlideLeft TSL = new TestSlideLeft();
    private final TestSlide TS = new TestSlide();
    
    /* ---- Set to run the tests --*/
    private Test[] THETESTS;
    private boolean m_runTests = false;
     private JPanel  m_listPanel,m_contentPanel,m_buttonPannel, m_LabelPanel, 
                    m_textPanel;
    private JButton m_reset, m_runAll,m_test;
    private JLabel l6,l5,l4,l3,l2,l1,l;
    private JTextField  textField,textField1,textField2,textField3,textField4,
                        textField5,textField6;
    private JList m_testList;
    private final Dimension MAINFRAMESIZE = new Dimension(750,400);
    private final int LABELHEIGHT = 600;
    private final int TEXTHEIGHT = 300;
    private final int LABELWIDTH = 200;
    private final int SPRINGCOL = 2;
    private final int SPRINGXYINT = 6;
    private final Dimension LISTSIZE = new Dimension(240,this.getHeight());
    private final Dimension LISTBUTSIZE = new Dimension(240,100);
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




    