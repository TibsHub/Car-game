/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 17/04/16 @ 16:00
 */

// Interface controlling the action of the cars and the timer
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Control
{
    private final Timer timer = new Timer( 50, new TimerHandler() );
    private final Cars car1;                // ^ Timer to drive animation
    private final Cars car2;                // < Link-up to Cars class x2
    

    // CONSTRUCTOR - A copy of the two cars to set controls to //
    public Control(Cars car1, Cars car2) {
      this.car1 = car1;
      this.car2 = car2;
      timer.start();
    } // END: CONSTRUCTOR

    // Inner class to handle action events from Timer //
    private class TimerHandler implements ActionListener {
        // Respond to Timer's event: refresh screen content
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            car1.refreshPic();
            car2.refreshPic();
        }
    }
// ************************************************************************** //
    // Player 1 - buttons W, S, A,D //
// ************************************************************************** //
    public void P1Up() {
        car1.accelerate();
    }
 
    public void P1Down() {
        car1.brake();
    }
    
    public void P1Left( boolean isPressed ) {     
        if(isPressed)   { car1.turnLeft( true );  }
        else            { car1.turnLeft( false ); }
    }
    
    public void P1Right( boolean isPressed ) {
        if(isPressed)   { car1.turnRight( true );  }
        else            { car1.turnRight( false ); }
    }
// ************************************************************************** //
    // Player 2 - buttons U, D, L, R //
// ************************************************************************** //
    public void P2Up() {
        car2.accelerate();
    }
    
    public void P2Down() {
        car2.brake();
    }
    
    public void P2Left( boolean isPressed ) {     
        if(isPressed)   { car2.turnLeft( true );  }
        else            { car2.turnLeft( false ); }
    }
    
    public void P2Right( boolean isPressed ) {
        if(isPressed)   { car2.turnRight( true );  }
        else            { car2.turnRight( false ); }
    }
} // END OF CLASS
