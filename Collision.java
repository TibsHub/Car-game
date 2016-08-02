/*
 * @author SID: 1335894
 * Distributed Systems Programming
 * MOD002681
 * 2015/2016
 *
 * last edited: 22/04/16 @ 18:00
 */
 
// Stores coordinates of possible collision points (car & track coords)
public class Collision {
    private int minX, minY, maxX, maxY; // variables to store values of lines
    
/*
    Track                       Grass
    minX = 40;  maxX = 760;     minX = 110;   maxX = 690;
    minY = 90;  maxY = 560;     minY = 160;   maxY = 490;
*/
        
    // Cars coords reaching outer edge coords (outside big box)
    public boolean isCollidingTrack( int x, int y )
    {
        minX = 40;  maxX = 760;
        minY = 90;  maxY = 560;
        
        if( x < minX || x > maxX || y < minY || y > maxY) {
            return true;
        }
        return false;
    }
    
    // Car coords within inner edge coords (inside small box)
    public boolean isCollidingGrass( int x, int y )
    {
        minX = 110;   maxX = 690;
        minY = 160;   maxY = 490;

        while( (x > minX && x < maxX) && (y > minY && y < maxY) ) {
            return true;
        }
        return false;
    }
    
    // Two cars have the same coordinates
    public boolean isCollidingOtherCar()
    {
        return true;
    }
}
