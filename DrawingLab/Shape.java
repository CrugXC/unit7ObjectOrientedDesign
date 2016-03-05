import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * This abstract class implements a shape with a given
 * center, radius, and color.
 * 
 * @author Jay Rixie 
 * @version 2/24/16
 */
public abstract class Shape
{
    /** Point2D.Double center   center coordinates of shape
        double radius           length of radius
        Color color             color of the shape*/
    private Point2D.Double center;
    private double radius;
    private Color color;
    /**
     * Default constructor for objects of class Shape
     */
    public Shape(Point2D.Double inputCenter, double inputRadius, Color inputColor)
    {
        //Initializes all variables based on input parameters
        center = inputCenter;
        radius = inputRadius;
        color = inputColor;
    }
    
    /**
     * @return returns center
     */
    public Point2D.Double getCenter()
    {
        return center;
    }
    
    /**
     * @return radius
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * @post    shape is moved to new coordinates 
     */
    public void move(double x, double y)
    {
        center = new Point2D.Double(x, y); 
    }
    
    /**
     * @post    radius is updated 
     */
    public void setRadius(double r) 
    {
        radius = r;
    }

    /**
     * @return color
     */
    public Color getColor()
    {
        return color;
    }

    abstract boolean isInside(Point2D.Double point);
    abstract boolean isOnBorder(Point2D.Double point);
    abstract void draw(Graphics2D g2, boolean filled);
}
