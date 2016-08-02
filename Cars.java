/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 17/04/16 @ 16:00
 */

// Class related to cars 1 & 2 + animation/movement
import javax.swing.*;
import java.awt.*;

public class Cars extends JPanel {

    // VARIABLES //
    private final ImageIcon[] carImage = new ImageIcon[16]; // Array of images
    private int imageIndex = 12;                             // Current image index
    private boolean doTurnLeft = false;                     // makes car turn left
    private boolean doTurnRight = false;                    //           turn right
    private double speed;                                   // the initial speed of a car (zero)
                                                            // kind of a multiplier, 0-10
    private final Collision collision = new Collision();
    
    /**
     * CONSTRUCTOR - Rotation - loads images into array depending on player number (1 or 2)
     * @param playerNr 1 for player1 pictures, 2 for player2 pictures
     */
    public Cars(int playerNr) {
        for ( int counter = 0; counter < 16; counter++ ) {
            if (playerNr == 1) {
                carImage[counter] = new ImageIcon( getClass().getResource("P1/" + counter + ".png") );
            }
            if (playerNr == 2) {
                carImage[counter] = new ImageIcon( getClass().getResource("P2/" + counter + ".png") );
            }
        }
        setOpaque(false);           // Set the background transparent
        speed = 0;                  // Set car speed variable
    } // END OF CONSTRUCTOR
   
    /**
     * Display current image based on direction key pressed/released
     * @param g image to load
     * 
     *  Checks value in parameters doTurnLeft & doTurnRight:
     *                        true  - car turns 
     *                        false - car stops turning
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // call superclass paintComponent
        carImage[ imageIndex ].paintIcon(this, g, 0, 0);

        // Set next image to be drawn while key is PRESSED DOWN / once RELEASED
        // Turn Left : image at previous index, keep below 16 (int),
        // Turn Right: image at next     index, keep above -1 (int)
        try {
            if (doTurnLeft) {
                imageIndex = (imageIndex-1) % carImage.length;
                if (imageIndex < 0) {imageIndex = 15;}
            }
            if (doTurnRight) {
                imageIndex = (imageIndex+1) % carImage.length;
                if (imageIndex > 15) {imageIndex = 0;}
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("bummer..");
        }
    }

// ************************************************************************** //
    
    // Method to switch left turn //
    public void turnLeft(boolean shouldTurnLeft) {
        doTurnLeft = shouldTurnLeft;
    }
    
    // Method to switch right turn //
    public void turnRight(boolean shouldTurnRight) {
        doTurnRight = shouldTurnRight;
    }
    
    // Raise speed multiplier by 1 (Max. is 10) //
    public void accelerate() {
        if (speed < 10) {
            speed = speed+1;
            System.out.println("Current speed: " + speed); // TEST
        } else {
            System.out.println("Top speed reached!");
        }
    }
 
    // Reduce speed multiplier by 1 (Min. is 0) //
    public void brake() {
        if (speed > 1) {
            speed = speed-1;
            System.out.println("Current speed: " + speed); // TEST
        } else {
            speed = 0;
            System.out.println("Car stopped!");
        }
    }
    
     // ************************************************************************** //
    // This methods does the work at every screen update (20pixel/sec currently)
    public void refreshPic() {
        repaint();              // refresh icon shown and move position

        // Speed is a multiplier between 0 (stopped) and 10 (top speed)
        // Move image to [ currentX +- (speedtable X-direction value for imageIndex * speed),
        //                 currentY +- (speedtable Y-direction value for imageIndex * speed) ] position
            
        // Declaring amount of pixels to move for every imageIndex a.k.a angle //
        
        if ( collision.isCollidingGrass( getX(), getY() ) ) {
            System.out.println("Car is ON the grass..");
            collisionWGrass(true);
        }
    
        if ( collision.isCollidingTrack( getX(), getY() ) ) {
            System.out.println("Car is OFF the track..");
            collisionWTrack(true);
        }
               
        if ( collision.isCollidingOtherCar() ) {}
        
        if ( imageIndex == 0 ) {    
            setLocation( (int)( getX() + 0       ),
                         (int)( getY() - 1*speed ) );
        }
        if ( imageIndex == 1 ) {
            setLocation( (int)( getX() + 0.383*speed ),
                         (int)( getY() - 0.924*speed ) );
        }
        if ( imageIndex == 2 ) {
            setLocation( (int)( getX() + 0.707*speed ),
                         (int)( getY() - 0.707*speed ) );
        }
        if ( imageIndex == 3 ) {
            setLocation( (int)( getX() + 0.924*speed ),
                         (int)( getY() - 0.383*speed ) );
        }
        if ( imageIndex == 4 ) {
            setLocation( (int)( getX() + 1*speed ),
                         (int)( getY() + 0       ) );
        }
        if ( imageIndex == 5 ) {
            setLocation( (int)( getX() + 0.924*speed ),
                         (int)( getY() + 0.383*speed ) );
        }
        if ( imageIndex == 6 ) {
            setLocation( (int)( getX() + 0.707*speed ),
                         (int)( getY() + 0.707*speed ) );
        }
        if ( imageIndex == 7 ) {
            setLocation( (int)( getX() + 0.383*speed ),
                         (int)( getY() + 0.924*speed ) );
        }
        if ( imageIndex == 8 ) {
            setLocation( (int)( getX() + 0       ),
                         (int)( getY() + 1*speed ) );
        }
        if ( imageIndex == 9 ) {
            setLocation( (int)( getX() - 0.383*speed ),
                         (int)( getY() + 0.924*speed ) );
        }
        if ( imageIndex == 10 ) {
            setLocation( (int)( getX() - 0.707*speed ),
                         (int)( getY() + 0.707*speed ) );
        }
        if ( imageIndex == 11 ) {
            setLocation( (int)( getX() - 0.924*speed ),
                         (int)( getY() + 0.383*speed ) );
        }
        if ( imageIndex == 12 ) {
            setLocation( (int)( getX() - 1*speed ),
                         (int)( getY() + 0       ) );
        }
        if ( imageIndex == 13 ) {
            setLocation( (int)( getX() - 0.924*speed ),
                         (int)( getY() - 0.383*speed ) );
        }
        if ( imageIndex == 14 ) {
            setLocation( (int)( getX() - 0.707*speed ),
                         (int)( getY() - 0.707*speed ) );
        }
        if ( imageIndex == 15 ) {
            setLocation( (int)( getX() - 0.383*speed ),
                         (int)( getY() - 0.924*speed ) );
        }
    } // END: refreshPic

// ************************************************************************** //
    /*
     * Collision handling
     */
    // Car w/ track outer edge - Speed = 0 //
    public void collisionWTrack( boolean happens ) {
        if( happens ) { speed = 0.5; }
    }
    
    // Car w/ grass area - Speed= - 2 (the car slows down marginally) //
    public void collisionWGrass( boolean happens ) {
        if( happens ) {
            if ( speed > 0 ) { speed = ( speed-0.5 ); }
            else { speed = 0; }
        }
    }
            
    // Cars w/ each other - Game ends //
    public void collisionOfCars( boolean happens ) {
        if ( happens ) { System.exit(0); }
    }
    // END: Collision handling
}
/*

Factors to consider:
how collision detection is implemented
        between a car and the edges of the track - the car’s speed becomes 0, the other car proceeds
        between the two cars                     - the game ends

Speed
    10%  ->  1px -- can be changed later
    100% -> 10px
---------------------------------------------------------------------------------
|           Speed calculation table           |      Legend of coordinates      |
|---------------------------------------------|---------------------------------|
| carImage |   angle    |    speed in px      | X (horizontal)  | Y (vertical)  |
|     no.  |  is (deg)  |   X      |   Y      | LEFT -, RIGHT + | UP -, DOWN +  |
---------------------------------------------------------------------------------
|      0   |   90       |   0      |  -1      | 
|      1   |   67.5     |   0.383  |  -0.924  |
|      2   |   45       |   0.707  |  -0.707  |
|      3   |   22.5     |   0.924  |  -0.383  |
|      4   |   0        |   1      |   0      |
|      5   |   337.5    |   0.924  |   0.383  |
|      6   |   315      |   0.707  |   0.707  |
|      7   |   292.5    |   0.383  |   0.924  |
|      8   |   270      |   0      |   1      |
|      9   |   247.5    |  -0.383  |   0.924  | SOURCES
|     10   |   225      |  -0.707  |   0.707  | -------
|     11   |   202.5    |  -0.924  |   0.383  | https://www.mathsisfun.com/
|     12   |   180      |  -1      |   0      |         sine-cosine-tangent.html
|     13   |   157.5    |  -0.924  |  -0.383  |         algebra/trig-solving-triangles.html
|     14   |   135      |  -0.707  |  -0.707  |
|     15   |   112.5    |  -0.383  |  -0.924  |
-----------------------------------------------*/
