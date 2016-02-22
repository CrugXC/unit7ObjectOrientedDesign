import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;

/**
 * Write a description of class CircleComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleComponent2 extends JComponent
{
    private int x;
    private int y;
    private int radius;
    
    public CircleComponent2()
    {
        radius = Integer.valueOf(JOptionPane.showInputDialog("Please input a radius value"));
    }

    public void paintComponent(Graphics g)
    {
        if(x == 0)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.draw(new Ellipse2D.Double(x, y, radius, radius));
        }
    }
    
    
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.repaint();
    }
}
