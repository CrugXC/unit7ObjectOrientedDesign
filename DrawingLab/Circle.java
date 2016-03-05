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
    //Ellipse2D.Double circle     Ellipse representation of shape
    private Ellipse2D.Double circle;
    
    /**
     * Default constructor for objects of class Circle
     */
    public Circle(Point2D.Double inputCenter, double inputRadius, Color inputColor)
    {
        super(inputCenter, inputRadius, inputColor);
        circle = new Ellipse2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
    }
    
    /**
     * @return returns boolean if the point is inside the shape
     */
    public boolean isInside(Point2D.Double point)
    {
        circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return circle.contains(point);
    }
    
    /**
     * @return returns boolean if the point if not on smaller comparator shape but is on the larger shape
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        double compRadius = this.getRadius() * .85;
        Ellipse2D.Double comparator = new Ellipse2D.Double(this.getCenter().getX() - compRadius, this.getCenter().getY() - compRadius, 2*compRadius, 2*compRadius);
        return circle.contains(point) && !comparator.contains(point);
    }
    
    /**
     * @post shape is drawn 
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        //draws circle, and fills with color if shape is not activeShape
        circle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        g2.setColor(this.getColor());
        g2.draw(circle);
        if (filled)
        {
            g2.fill(circle);
        }
    }

}
