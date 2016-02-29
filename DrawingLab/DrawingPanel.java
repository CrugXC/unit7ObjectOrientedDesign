import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JColorChooser;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

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
    
    private Color currColor;
    
    private Dimension dim;
    
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        currColor = Color.WHITE;
        
        shapes = new ArrayList<Shape>();
        
        dim = new Dimension(1000, 800);
    }
    
    public Color getColor()
    {
        return currColor;
    }
    
    public Dimension getPreferredSize()
    {
        return dim;
    }
    
    public void pickColor()
    {
        currColor = JColorChooser.showDialog(this, "Pick Color", currColor);
    }
    
    public void addCircle()
    {
        
    }
    
    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(100, 100), 25, currColor));
        
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for(Shape shp: shapes)
        {
            shp.draw(g2, (activeShape == shp) );
        }
    }
}
