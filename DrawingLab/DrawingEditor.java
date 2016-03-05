import javax.swing.JFrame;
import java.awt.BorderLayout;

public class DrawingEditor extends JFrame
{
    //DrawingPanel canvas   component where shapes our drawn and edited
    //ControlPanel controls component with buttons to add shapes and select color
    private DrawingPanel canvas;
    private ControlPanel controls;
    
    //Dimensions of frame
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    
    public DrawingEditor()
    {
        canvas = new DrawingPanel();
        controls = new ControlPanel(canvas);
        
        //Sets layout with canvas in Center and controls on the bottom
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);
        
        //Creates and shows Frame
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        //Creates DrawingEditor
        DrawingEditor editor = new DrawingEditor();
    }
}
