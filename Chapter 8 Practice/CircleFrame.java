import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CircleFrame extends JFrame
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;    
    
    private CircleComponent comp;
    
    public CircleFrame()
    {
        comp = new CircleComponent();
        this.add(comp);
        
        comp.addMouseListener(new ClickListener());
        
        this.setSize(WIDTH, HEIGHT);
    }
    
    
    public class ClickListener implements MouseListener
    {
        
        public void mouseClicked(MouseEvent event)
        {       
            comp.setXY(event.getX(), event.getY());
        }
        
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
    }
}
