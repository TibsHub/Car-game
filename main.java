/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 15/04/16 @ 17:00
 */
 
// Starts GUI instance, main entry point
public class main
{
    public static void main( String args[] ) {
        
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI test = new GUI();
                test.setVisible(true);
            }
        });
    }
}   
