package cs235a5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


/** @brief This class is will Display a dialog for importing a file

    The Program will display the dialog for importing the file
    @author Robert Fletcher
    @file CSVReaderDialog.java
    @date April 2013
    */
public final class CSVReaderDialog extends JFrame {

    /** 
    * Sets the context of this class to a context
    * @param  MS_BasicGUI context of this class
    * @return boolean true if set correctly
    */
    public boolean setContext(VisualiserGUI con){
        m_Context = con;
        return true;
    }

    /**
    * Gets the Context of this class
    * @return MS_BasicGUI 
    */
    public VisualiserGUI getContext(){
        return m_Context;
    }
    /** 
    * Set the file used in the program
    * @param  FIle File used in the MS_CSVParser
    * @return boolean true if set correctly
    */
    public boolean setFile(File f){
        if(f.exists()){
            m_File = f;  
            return true;
	  }else{
            return false;  
	  }
        
        
    }

    /**
    * Gets the File used
    * @return MS_BasicGUI 
    */
    public File getFile(){
        return m_File;
    }
    /** 
    * Sets the dataset used in the class
    * @param  MS_DataSet the dataset of this class
    * @return boolean true if set correctly
    */
    public boolean setDataSet(DataSet db){
        m_db = db;
        return true;
    }

    /**
    * Gets the Dataset of this class
    * @return MS_BasicGUI 
    */
    public DataSet getDataSet(){
        return m_db;
    }

    /**
     * calls the JFilechooser and when user has selected a file stores it.
     * @return String absolute path to the selected file
     */	
    private String getFileDialog(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(
        "CSV Files Only", "CSV"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          m_File = fileChooser.getSelectedFile();
          return m_File.getAbsolutePath();
        }else{
            return null;
        }
        
    }

    /**
     * Reads the file and outputs it in a JTextArea
     * @return boolean true if there are no errors
     */	
    private Boolean diplayFile(){
        m_SampleData.setText("");
        Boolean test = true;
        try{
            Scanner in = new Scanner(m_File);
            while(in.hasNextLine()){
                m_SampleData.append(in.nextLine()+NEWLINE);
            }
        }catch(IOException e){
            System.err.println(CLASS+".displayFile(): "+e);
            test = false;
        }
        return true;
    }
    /**
    * Instantiates the MS_CSVParser and parses the file;
    * @return boolean  true if file is parsed into the MS_DataSet correctly
    */         
    private boolean parseFile(){
        CSVReader csv = new CSVReader
                (m_db,m_File,m_delList.getSelectedItem().toString());
        return csv.ParseFile();
    }

    /**
     * This function creates the objects sets the layout of the frame and the 
     * JPanels and adds the objects to them
     * @return boolean true if swing elements are created and displayed 
     */
    public boolean init(){
        handle = new EventHandler();
        this.setBounds(FRAMESIZE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new FlowLayout((FlowLayout.LEFT)));
        m_BrowsePanel = new JPanel();
        m_BrowsePanel.setBounds(PANNELSIZE);
        m_BrowsePanel.setLayout(new FlowLayout((FlowLayout.LEFT)));

        m_ChoosePannel = new JPanel();
        m_ChoosePannel.setBounds(PANNELSIZE);
        m_ChoosePannel.setLayout(new FlowLayout((FlowLayout.LEFT)));

        m_ButtonPannel = new JPanel();
        m_ButtonPannel.setBounds(PANNELSIZE);
        m_ButtonPannel.setLayout(new FlowLayout());



        m_Sample = new JPanel();
        m_Sample.setBounds(PANNELSIZE);


        m_SampleData = new JTextArea(FILLER, TEXTAREACOLUMN,TEXTAREAROW);
        m_SampleData.setBounds(SAMPLEDATASIZE);

        m_ScrollText = new JScrollPane(m_SampleData, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        m_Sample.add(m_ScrollText,BorderLayout.CENTER);


        m_Description = new JLabel();
        m_Description.setText("Choose Delimiter:");	
        m_delList = new JComboBox(new String[]{",","|",".","-"});
        m_preButton = new JButton("Preview");
        m_preButton.addActionListener(handle);
        m_ChoosePannel.add(m_Description);
        m_ChoosePannel.add(m_delList);
        m_ChoosePannel.add(m_preButton);

        m_FilePath = new JTextField();
        m_FilePath.setColumns(COLUMN);

        m_ButtonBrowse = new JButton("Browser for csv file");
        m_ButtonBrowse.addActionListener(handle);

        m_BrowsePanel.add(m_FilePath);
        m_BrowsePanel.add(m_ButtonBrowse);

        m_ButtonAppy = new JButton("Apply");
        m_ButtonAppy.addActionListener(handle);

        m_ButtonCancel = new JButton("Cancel");
        m_ButtonCancel.addActionListener(handle);



        m_ButtonPannel.add(m_ButtonCancel);
        m_ButtonPannel.add(m_ButtonAppy);
        
        
        m_TopContent = new JPanel();
        m_TopContent.setBounds(CONTENTSIZE);
        m_TopContent.setLayout(new BorderLayout());
        
        m_iconPanel = new JPanel();
        m_iconPanel.setBounds(ICONPANELSIZE);
        m_iconPanel.setLayout(new FlowLayout((FlowLayout.LEFT)));
        
        m_Icon= new JLabel();
        m_Icon.setBounds(ICONSIZE);
        try {
            BufferedImage im = ImageIO.read(this.getClass().getResource("/assets/images/drive.png"));
            m_Icon.setIcon(new ImageIcon(im.getScaledInstance(ICONWIDTH, ICONHEIGHT, Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            
        }
        
        
        

        m_TopContent.add(m_BrowsePanel, BorderLayout.NORTH);
        m_TopContent.add(m_ChoosePannel, BorderLayout.CENTER);
        m_iconPanel.add(m_TopContent);
        m_iconPanel.add(m_Icon);
        mainContainer.add(m_iconPanel, BorderLayout.NORTH);
        mainContainer.add(m_Sample, BorderLayout.SOUTH);


        this.add(mainContainer,BorderLayout.CENTER);
       

        return  true;
    }
	
    /**
     * EventHandler class handles the just the buttons actions in this 
     * class
     * 
     */
    private class EventHandler implements ActionListener {
            
        /**
         * Overrides the actionPerformed event to do custom events 
         * depending on which button is pressed
         * @param ActionEvent event the Buttons action event
         * called when the button is pressed 
         */                   
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println(CLASS+"EventHandler.actionPerformed(): Event "
                    + "been performed ");

            if(event.getSource() == m_ButtonBrowse){
                System.out.println(CLASS+"EventHandler.actionPerformed(): "
                         + " m_ButtonBrowse been pressed ");

                if(getFileDialog()!= null){
                     m_FilePath.setText(m_File.getAbsolutePath());
                    if(diplayFile()){
                            System.out.println(CLASS+".displayFile(): File Has been"
                                    + " read no errors");
                    }else{
                        System.out.println(CLASS+".displayFile(): Error with file");
                    }
                }

            }else if(event.getSource() == m_ButtonCancel){
                System.out.println(CLASS+"EventHandler.actionPerformed():"
                        + " m_ButtonCancel been pressed");
                dispose(); 
                
            }else if(event.getSource() == m_ButtonAppy){
               System.out.println(CLASS+"EventHandler.actionPerformed():"
                       + " m_ButtonAppy been pressed");

               if(parseFile()){
                    System.out.println(CLASS+"EventHandler.actionPerformed():"
                            + " parseFile() been successful");
                    m_Context.displayTable();

               }else{
                   JOptionPane.showMessageDialog(m_TopContent, "Unable to parse file please try again");
                   System.out.println(CLASS+"EventHandler.actionPerformed():"
                           + " parseFile() has faild");
               }
                dispose(); 

            }else if(event.getSource() == m_preButton){
               if(parseFile()){
                    System.out.println(CLASS+"EventHandler.actionPerformed():"
                            + " parseFile() been successful");
                    xpnd();
                    m_Sample.removeAll();
                    m_Sample.add(new TableView(m_db,m_Sample.getBounds()),BorderLayout.CENTER);
                    m_Sample.validate();
                    m_context.add(m_ButtonPannel,BorderLayout.SOUTH);
                   
               }else{
                   JOptionPane.showMessageDialog(m_TopContent, "Unable to parse file please try again");
                   System.out.println(CLASS+"EventHandler.actionPerformed():"
                           + " parseFile() has faild");
               }
                
            }
        }
    }
   /**
    * Expand the form
    */
    private void xpnd(){
        Thread t = new expand();
                        t.start();
    }
    /**
     * Class Constructor that sets up the UI the dataset that the program is 
     * using and the reference to the Main UI Class
     * @param MS_DataSet db - the reference the the dataset stored in the 
     * program
     */
    public CSVReaderDialog (DataSet db, VisualiserGUI context){
            m_context = this;
            if(setDataSet(db)){
                System.out.println(CLASS+".setDataset():Dataset set Correctly"); 
            }else{
                System.out.println(CLASS+".setDataset():Failed to add");
            }
            if(setContext(context)){
                System.out.println(CLASS+".setContext():Context set Correctly");
            }else{
                System.out.println(CLASS+".setContext():Failed");
            }
            if(init()){
                System.out.println(CLASS+".init():Gui initiated Correctly");
            }else{
                System.out.println(CLASS+".init():Failed");
            }
            
            
    }
    /**
     * Class constructor that sets up just the UI
     */
    public CSVReaderDialog (){
        m_context = this;
        init();
    }
    
            
    // gui objects
    private JTextField m_delimiterFeild, m_FilePath;
    private JButton m_ButtonAppy, m_ButtonCancel,m_ButtonBrowse,m_preButton;
    private JPanel  m_BrowsePanel, m_ButtonPannel, m_ChoosePannel, m_Sample,
                    m_TopContent, m_iconPanel;
    private EventHandler handle;
    private JLabel m_Description, m_Icon;
    private JTextArea m_SampleData;
    private JScrollPane m_ScrollText;
    

    //data objects
    private File m_File;
    private DataSet m_db;
    private VisualiserGUI m_Context;
    private JComboBox m_delList; 
    private final CSVReaderDialog m_context;

    //Constants
    private final Rectangle PANNELSIZE = new Rectangle(0,0,400,120);
    private final Rectangle FRAMESIZE = new Rectangle(400,400,500,130);
    private final Rectangle SAMPLEDATASIZE = new Rectangle(0,0,400,400);
    private final Rectangle CONTENTSIZE = new Rectangle(0,0,400,240);
    private final Rectangle ICONPANELSIZE = new Rectangle(0,0,100,240);
    private final Rectangle ICONSIZE = new Rectangle(0,0,100,100);
    private final int MAXSIZE = 350;
    private final int REFRESHRATE = 10;  
    
    private final int COLUMNCOUNTFILE = 20;
    private final int COLUMN = 16;
    private final int COLUMNCOUNTDEL = 20;
    private final int TEXTAREACOLUMN = 10;
    private final int TEXTAREAROW = 40;
    private final int ICONWIDTH = 60;
    private final int ICONHEIGHT = 80;
    private final boolean TESTING = true;
    private final String FILLER = "Sample text are";
    private final String NEWLINE = "\n";
    private final String CLASS = "MS_CsvFileDialog()";
    
    
    public static void main(String[] args){
        CSVReaderDialog c = new CSVReaderDialog();
        c.setVisible(true);
    }
    
    
      /**
     * Thread class for UI animation
     */
    private class expand extends Thread{
    
        @Override
        /**
         * Run class that overrides the Thread.run() method. Will upload.
         */
        public void run(){
            for(int i = FRAMESIZE.height;i<MAXSIZE;i+=REFRESHRATE){
                m_context.setSize(new Dimension(FRAMESIZE.width,i));
                try {
                    this.sleep(1);//refresh 
                } catch (InterruptedException ex) {
                   
                }
            }
        }
    }

}
