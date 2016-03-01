import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Write a description of class Circle here.
 * 
 * @author Jay Rixie 
 * @version 2/29/2016
 */
public class Circle extends Shape
{
    /** description of instance variable x (add comment for each instance variable) */
    private Ellipse2D.Double circle;
    
    /**
     * Default constructor for objects of class Circle
     */
    public Circle(Point2D.Double inputCenter, double inputRadius, Color inputColor)
    {
        super(inputCenter, inputRadius, inputColor);
        circle = new Ellipse2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
    }

    public boolean isInside(Point2D.Double point)
    {
        circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
        return circle.contains(point);
    }
    
    public boolean isOnBorder(Point2D.Double point)
    {
        circle = new Ellipse2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
        double compRadius = this.getRadius() * .85;
        Ellipse2D.Double comparator = new Ellipse2D.Double(this.getCenter().getX() - compRadius, this.getCenter().getY() - compRadius, 2*compRadius, 2*compRadius);
        return circle.contains(point) && !comparator.contains(point);
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        circle = new Ellipse2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
        g2.draw(circle);
        g2.setColor(this.getColor());
        if (filled)
        {
            g2.fill(circle);
        }
    }

}
