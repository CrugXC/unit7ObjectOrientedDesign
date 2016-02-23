import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.util.ArrayList;

// implements MouseListener, MouseMotionListener, KeyListener
/**
 * This is where most of the work is done. This class is a 
 * subclass of JPanel and it implements the MouseListener, 
 * MouseMotionListener, and KeyListener interfaces (or 
 * extends the associated adapters). In the DrawingPanel 
 * constructor, add this panel to itself as these three 
 * listeners.
 * 
 * 
 * @author Jay Rixie
 * @version 2/23/16
 */
public class DrawingPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private ArrayList<Shape> shapes;
    private Shape activeShape;
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x+y;
    }

}
