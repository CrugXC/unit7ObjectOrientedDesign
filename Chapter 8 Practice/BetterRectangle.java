import java.awt.Rectangle;


public class BetterRectangle extends Rectangle
{
    public BetterRectangle(int width, int height, int x, int y)
    {
        super();
        this.setSize(width, height);
        this.setLocation(x, y);
    }
    
    public double calcPerimeter()
    {
        return this.getHeight() * 2.0 + this.getWidth() * 2.0;
    }
    
    public double calcArea()
    {
        return this.getHeight() * this.getWidth();
    }
}
