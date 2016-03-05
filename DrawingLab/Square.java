import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * Write a description of class Rectangle here.
 * 
 * @author Jay Rixie 
 * @version 2/29/16
 */
public class Square extends Shape
{
    //Rectangle2D.Double square     Rectangle representation of shape
    private Rectangle2D.Double square;
    
    public Square(Point2D.Double inputCenter, double inputRadius, Color inputColor)
    {
        super(inputCenter, inputRadius, inputColor);
        square = new Rectangle2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
    }

    /**
     * @return returns boolean if the point is inside the shape
     */
    public boolean isInside(Point2D.Double point)
    {
        square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        return square.contains(point);
    }
    
    /**
     * @return returns boolean if the point if not on smaller comparator shape but is on the larger shape
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        //Creates another shape at 85% the size, and if it is not in the smaller one, but is in the larger one, will return true
        square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        double compRadius = this.getRadius() * .85;
        Rectangle2D.Double comparator = new Rectangle2D.Double(this.getCenter().getX() - compRadius, this.getCenter().getY() - compRadius, 2*compRadius, 2*compRadius);
        return square.contains(point) && !comparator.contains(point);
    }
    
    /**
     * @post shape is drawn 
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        //draws square, and fills with color if shape is not activeShape
        square = new Rectangle2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), 2*this.getRadius(), 2*this.getRadius());
        g2.draw(square);
        g2.setColor(this.getColor());
        if (filled)
        {
            g2.fill(square);
        }
    }
}
