/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 14/04/16 @ 14:20
 */

// Track in the background
import java.awt.*;
import javax.swing.*;

public class Track extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Middle, grassed area
        Color c1 = Color.green;
        g.setColor(c1);
        g.fillRect(150, 200, 550, 300);

        //Track edges
        Color c2 = Color.black;
        g.setColor(c2);
        g.drawRect(50, 100, 750, 500);      // outer edge
        g.drawRect(150, 200, 550, 300);     // inner edge

        // Marker in the middle of the lanes
        Color c3 = Color.orange;
        g.setColor(c3);
        g.drawRect(100, 150, 650, 400);

        // Start line
        Color c4 = Color.red;
        g.setColor(c4);
        g.drawLine(425, 500, 425, 600);
    }
}

/*
cordinates causing collision
  <Y> ^Xv  wid  hei
( 50, 100, 750, 500)      // outer edge
Left line       Right line
  50, 100       800, 100
  to            to
  50, 600       800, 600

Top line        Bottom line
 50, 100         50, 600 
 to              to
800, 100        800, 600

  (150, 200, 550, 300)      // inner edge
Left line       Right line
150, 200        700, 200
to              to
150, 500        700, 500

Top line        Bottom line
150, 200        150, 500
to              to
700, 200        700, 500
*/
