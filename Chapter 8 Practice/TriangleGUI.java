import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class TriangleGUI extends JFrame
{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;

    private TriangleComponent comp;
    
    public TriangleGUI()
    {
        comp = new TriangleComponent(20);
        this.add(comp);
        
        comp.addMouseListener(new ClickListener());
        
        this.setSize(WIDTH, HEIGHT);
    }
    
    public static void main(String[] args)
    {
        TriangleGUI gui = new TriangleGUI();
    }
    
    public class ClickListener implements MouseListener
    {
        
        public void mouseClicked(MouseEvent event)
        {       
            comp.placeDot(event.getX(), event.getY());
        }
        
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
    }
}
