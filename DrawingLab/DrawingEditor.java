import javax.swing.JFrame;

public class DrawingEditor extends JFrame
{
    private DrawingPanel canvas;
    private ControlPanel controls;
    
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    
    public DrawingEditor()
    {
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        
        this.add(canvas);
        
        this.setSuze(WIDTH, HEIGHT);
    }
}
