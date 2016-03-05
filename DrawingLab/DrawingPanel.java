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
    /** ArrayList<Shape> shapes     ArrayList of all shapes
        Shape activeShape           Shape currently selected by user
        Color currColor             Currently selected Color
        Dimension dim               Dimension of component*/
    private ArrayList<Shape> shapes;
    private Shape activeShape;
    
    private Color currColor;
    
    private Dimension dim;
    
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        //Sets background to white
        this.setBackground(Color.WHITE);
        
        //Sets starting color to blue
        currColor = Color.BLUE;
        
        shapes = new ArrayList<Shape>();
        
        //Dimension of component is 1000 by 800
        dim = new Dimension(1000, 800);
        
        this.addMouseListener(new Listener());
        this.addMouseMotionListener(new Listener());
    }
    
    /**
     * @return currColor
     */
    public Color getColor()
    {
        return currColor;
    }
    
    /**
     * @return dim
     */
    public Dimension getPreferredSize()
    {
        return dim;
    }
    
    /**
     * @post Color is what user selected or same if they press cancel
     */
    public void pickColor()
    {
        Color newColor = JColorChooser.showDialog(this, "Pick Color", currColor);
        if(newColor != null)
        {
            currColor = newColor;
        }
    }
    
    /**
     * @post adds a circle to the shapes ArrayList
     */
    public void addCircle()
    {
        shapes.add(new Circle(new Point2D.Double(600, 350), 25, currColor));
    }
    
    /**
     * @post adds a square to the shapes ArrayList
     */
    public void addSquare()
    {
        shapes.add(new Square(new Point2D.Double(600, 350), 25, currColor));
    }
    
    /**
     * @post shapes are drawn on canvas
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //iterates through and calls draw method
        for(Shape shp: shapes)
        {
            //Checks that there is an active shape to avoid NullPointerException
            shp.draw(g2, activeShape == null? true: (!(activeShape == shp)));
        }
    }
    
    public class Listener implements MouseListener, MouseMotionListener
    {
        private boolean found;
        
        public void mouseClicked(MouseEvent event){}
        
        public void mousePressed(MouseEvent event)
        {
            //Checks to see if a shape is where the mouse was clicked
            found = false;
            for(Shape shp: shapes)
            {
                if (shp.isInside(new Point2D.Double(event.getX(), event.getY())))
                {
                    //sets found to true and shape to activeShape
                    found = true;
                    activeShape = shp;
                }            
            }
            
            //if not found sets activeShape to null
            if(!found)
            {
                activeShape = null;
            }
            
            //updates
            repaint();
        }
        
        public void mouseReleased(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        
        public void mouseDragged(MouseEvent event)
        {
            //Moves shape based on mouse coordinates
            activeShape.move(event.getX(), event.getY());
            repaint();
        }
        
        public void mouseMoved(MouseEvent event){}
    }
}
