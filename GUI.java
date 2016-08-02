/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 17/04/16 @ 16:00
 */
 
// Complete GUI put together & keylistener
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame implements KeyListener { //ActionListener, 
// ************************************************************************** //
    // VARIABLES
    private final Cars car1;        // = new Cars(1);
    private final Cars car2;        // = new Cars(2);
    private final Track raceCourse; // Link-up to Track class
    private final Control control;  // Link-up to Control class
    private final Menu menu;        // Link-up to Menu class
// ************************************************************************** //    
    // CONSTRUCTOR //
// ************************************************************************** //
    public GUI() {
        setTitle("SID: 1335894 - MOD002681 test");
        setBounds(0, 0, 850, 650);          // ! SET TO original 850x650 size !
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Container contents = getContentPane();
        contents.setLayout(null);           // manually set locations on canvas
        
        // MENU - DOES NOT SHOW
        menu = new Menu();
        contents.add( menu.createMenuBar() );
        //
        
        car1 = new Cars(1);
        car1.setBounds(425, 500, 50, 50);   
        
        
        contents.add(car1);

        car2 = new Cars(2);
        car2.setBounds(425, 550, 50, 50);  
        contents.add(car2);

        control = new Control(car1, car2);  // Establish link to Control class
        
        // Track has to be last otherwise it will cover up other parts
        raceCourse = new Track();
        raceCourse.setBounds(0, 0, 850, 650);
        contents.add(raceCourse);

        this.addKeyListener(this);
        setFocusable(true);
    } // END: CONSTRUCTOR
// ************************************************************************** //
    /*
     * CAR CONTROLS
     */
    @Override // placeholder, not used/implemented
    public void keyTyped(KeyEvent ke) {/* nada */}
// ************************************************************************** //
    // LISTENING FOR KEYPRESS EVENTS --- CAR TURNS WHILE PRESSED //
// ************************************************************************** //
    @Override
    public void keyPressed(KeyEvent ke) {
        /* PLAYER/CAR 1 CONTROLS */
        if(ke.getKeyCode() == 87) // Button W - Accelerate
        {
            control.P1Up();
            System.out.println("P1 UP");
        }

        if(ke.getKeyCode() == 83) // Button S - Break
        {
            control.P1Down();
            System.out.println("P1 DOWN");
        }

        if(ke.getKeyCode() == 65 ) // Button A - Left
        {
            control.P1Left(true);
            System.out.println("P1 LEFT");
        }
        
        if(ke.getKeyCode() == 68 ) // Button D - Right
        {
            control.P1Right(true);
            System.out.println("P1 RIGHT");
        }
    // ************************************************************ //
        /* PLAYER/CAR 2 CONTROLS */
        if(ke.getKeyCode() == 38 ) // UP arrow - Accelerate
        {
            control.P2Up();
            System.out.println("P2 UP");
        }

        if(ke.getKeyCode() == 40) // DOWN arrow - Break
        {
            control.P2Down();
            System.out.println("P2 DOWN");
        }

        if(ke.getKeyCode() == 37) // LEFT arrow - Left
        {
            control.P2Left(true);
            System.out.println("P2 LEFT");
        }

        if(ke.getKeyCode() == 39) // RIGHT arrow - Right
        {
            control.P2Right(true);
            System.out.println("P2 RIGHT");
        }

        //  EXIT TO SYSTEM
        if(ke.getKeyCode() == 88) // KEY x
        {
            System.exit(0);
        }
        //throw new UnsupportedOperationException("keyPressed event");
    } // END: LISTENING FOR KEYPRESS EVENTS
// ************************************************************************** //
    // KEY RELEASE EVENTS --- CAR STOPS TURNING //
// ************************************************************************** //
    @Override
    public void keyReleased(KeyEvent ke) // Placeholder
    {
        if(ke.getKeyCode() == 65 ) // Button A - Left
        {
            control.P1Left(false);
            System.out.println("Key released: P1 LEFT");
            //car1.setLocation(car1.getX(), car1.getY() - 10);
        }
        
        if(ke.getKeyCode() == 68 ) // Button D - Right
        {
            control.P1Right(false);
            System.out.println("Key pressed: P1 RIGHT");
            //car1.setLocation(car1.getX(), car1.getY() + 10);
        }
        // ********************************************************** //
        if(ke.getKeyCode() == 37 ) // LEFT arrow - Left
        {
            control.P2Left(false);
            System.out.println("Key pressed: P2 LEFT");
        }

        if(ke.getKeyCode() == 39 ) // RIGHT arrow - Right
        {
            control.P2Right(false);
            System.out.println("Key pressed: P2 RIGHT");
        }
    /* throw new UnsupportedOperationException("keyReleased event"); */ 
    } // END: KEY RELEASE EVENTS
// ************************************************************************** //

    /**
     * TODO
     * menu
     */
    
} // EOF
