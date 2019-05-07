import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;


/**
 *
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The pGameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     * @param pText texte 
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText texte
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * @param pImageName nom de l'image
     */
    public void showImage( final String pImageName )
    {
        URL vImageURL = this.getClass().getClassLoader().getResource( pImageName );
        if ( vImageURL == null )
            System.out.println( "image not found" );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     * @param pOnOff on off
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff );
        if ( ! pOnOff )
            this.aEntryField.getCaret().setBlinkRate( 0 );
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "Zork" );
        this.aEntryField = new JTextField( 34 );

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        JButton vNorth= new JButton("forward");
        JButton vSouth= new JButton("behind");
        JButton vEast= new JButton("right");
        JButton vWest= new JButton("left");
        JButton vhelp= new JButton("help");
        JButton vquit= new JButton("quit");
        JButton vup= new JButton("up");
        JButton vdown= new JButton("down");
        
        
        
        
        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add(vNorth,BorderLayout.EAST);
        JPanel vPanel2 = new JPanel();
        vPanel.add(vPanel2,BorderLayout.EAST);
        BorderLayout BorderLayout2 = new BorderLayout();
        vPanel2.setLayout(BorderLayout2);
        vPanel2.add(vEast, BorderLayout2.EAST);
        vPanel2.add(vWest, BorderLayout2.WEST);
        vPanel2.add(vNorth, BorderLayout2.NORTH);
        vPanel2.add(vSouth, BorderLayout2.SOUTH);
        JPanel vPanel3 = new JPanel();
        vPanel.add(vPanel3,BorderLayout.WEST);
        BorderLayout BorderLayout3 = new BorderLayout();
        vPanel3.setLayout (BorderLayout3);
        vPanel3.add(vquit, BorderLayout2.EAST);
        vPanel3.add(vhelp, BorderLayout2.WEST);
        vPanel3.add(vup, BorderLayout2.NORTH);
        vPanel3.add(vdown, BorderLayout2.SOUTH);
        
        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );
        
        vNorth.addActionListener(this);
        vSouth.addActionListener(this);
        vEast.addActionListener(this);
        vWest.addActionListener(this);
        vdown.addActionListener(this);
        vup.addActionListener(this);
        vhelp.addActionListener(this);
        vquit.addActionListener(this);
        
        /*this.aTimer = new jLabel("timer");
        vPanel1.add(this.aTimer);*/

        this.aEntryField.addActionListener( this );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     * @param pE lien avec action command
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        if(pE.getActionCommand().equals("forward"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }else if (pE.getActionCommand().equals("behind"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }else if (pE.getActionCommand().equals("right"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }else if (pE.getActionCommand().equals("left"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }else if (pE.getActionCommand().equals("quit"))
        {
            this.aEngine.interpretCommand(pE.getActionCommand());
        }else if (pE.getActionCommand().equals("help"))
        {
            this.aEngine.interpretCommand(pE.getActionCommand());
        }else if(pE.getActionCommand().equals("up"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }
        else if(pE.getActionCommand().equals("down"))
        {
            this.aEngine.interpretCommand("go "+pE.getActionCommand());
        }
        else
        {
        this.processCommand();
        }
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
    
} // UserInterface 
