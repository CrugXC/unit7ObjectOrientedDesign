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
    private Rectangle2D.Double square;
    
    public Square(Point2D.Double inputCenter, double inputRadius, Color inputColor)
    {
        super(inputCenter, inputRadius, inputColor);
        square = new Rectangle2D.Double(inputCenter.getX() - inputRadius, inputCenter.getY() - inputRadius, 2*inputRadius, 2*inputRadius);
    }


    public boolean isInside(Point2D.Double point)
    {
        return square.contains(point);
    }
    
    public boolean isOnBorder(Point2D.Double point)
    {
        double compRadius = this.getRadius() * .85;
        Rectangle2D.Double comparator = new Rectangle2D.Double(this.getCenter().getX() - compRadius, this.getCenter().getY() - compRadius, 2*compRadius, 2*compRadius);
        return square.contains(point) && !comparator.contains(point);
    }
    
    public void draw(Graphics2D g2, boolean filled)
    {
        g2.draw(square);
        g2.setColor(this.getColor());
        if (filled)
        {
            g2.fill(square);
        }
    }
}
