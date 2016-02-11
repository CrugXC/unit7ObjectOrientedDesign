import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;


public class TriangleComponent extends JComponent
{  
    private Ellipse2D.Double firstPoint;
    private Line2D.Double line1;
    
    private Ellipse2D.Double secondPoint;
    private Line2D.Double line2;
    
    private Ellipse2D.Double thirdPoint;
    private Line2D.Double line3;
    
    private int dotRadius;
    private int count;
    
    public TriangleComponent(int dotRad)
    {
        dotRadius = dotRad;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (firstPoint != null)
        {
            g2.draw(firstPoint);
        }
        
        if (secondPoint != null)
        {
            g2.draw(secondPoint);
            g2.draw(line1);
        }
        
        if (thirdPoint != null)
        {
            g2.draw(thirdPoint);
            g2.draw(line2);
            g2.draw(line3);
        }
    }

    public void placeDot(int x, int y)
    {
        if (count % 4 == 0)
        {
            firstPoint = new Ellipse2D.Double(x, y, dotRadius, dotRadius);
        }
        
        else if (count % 4 == 1)
        {
            secondPoint = new Ellipse2D.Double(x, y, dotRadius, dotRadius);
            line1 = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
        }
        
        else if (count % 4 == 2)
        {
            thirdPoint = new Ellipse2D.Double(x, y, dotRadius, dotRadius);
            line2 = new Line2D.Double(thirdPoint.getX(), thirdPoint.getY(), secondPoint.getX(), secondPoint.getY());
            line3 = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), thirdPoint.getX(), thirdPoint.getY());
        }
        else
        {
            firstPoint = null;
            secondPoint = null;
            thirdPoint = null;
        }
    }
}
