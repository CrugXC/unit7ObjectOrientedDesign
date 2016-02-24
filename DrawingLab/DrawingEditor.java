import javax.swing.JFrame;
import java.awt.BorderLayout;

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
        
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        DrawingEditor editor = new DrawingEditor();
    }
}
