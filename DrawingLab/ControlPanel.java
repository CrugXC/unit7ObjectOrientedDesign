import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;


/**
 * ControlPanel extends JPanel. Add three buttons to it: 
 * “Pick Color,” “Add Circle,” and “Add Square.” Add a JPanel 
 * after the “Pick Color” button; its purpose is to show the
 * currently selected color. Call canvas’s getColor method to
 * obtain the initial color. Attach the appropriate listener to 
 * the “Pick Color,” “Add Circle,” and “Add Square” buttons, using 
 * the control panel itself as a listener, or, if you prefer, 
 * inner action listener classes, or anonymous inline classes. 
 * When “Pick Color” is clicked, call canvas’s pickColor method, 
 * then get the selected color back from canvas and show that 
 * color on the color display button. When “Add Circle” or “Add 
 * Square” is clicked, call canvas’s addCircle or addSquare method.
 * Extension: Don’t forget to return the keyboard focus to canvas
 * in either event 
 * 
 * @author Jay Rixie 
 * @version 2/23/16
 */
public class ControlPanel extends JPanel
{
    private Color currColor;
    
    private DrawingPanel canvas;
    
    private JPanel colorSquare;
    
    private JButton colorSelect;
    private JButton addCircle;
    private JButton addRectangle;
    public ControlPanel(DrawingPanel canvas)
    {
        /* Creates buttons */
        colorSelect = new JButton("Select Color");
        colorSelect.setPreferredSize(new Dimension(150, 50));
        this.add(colorSelect);
        
        currColor = canvas.getColor();
        
        colorSquare = new JPanel();
        colorSquare.setBackground(currColor);
        colorSquare.setPreferredSize(new Dimension(50, 50));
        this.add(colorSquare);
        
        addCircle = new JButton("Add Circle");
        addCircle.setPreferredSize(new Dimension(150, 50));
        this.add(addCircle);
        
        addRectangle = new JButton("Add Rectangle");
        addRectangle.setPreferredSize(new Dimension(150, 50));
        this.add(addRectangle);
        
        
        /* Adds ClickListener to each button */
        ClickListener listener = new ClickListener();
        colorSelect.addActionListener(listener);
        
        addCircle.addActionListener(listener);
        
        addRectangle.addActionListener(listener);
        
        
        this.canvas = canvas;
    }

    public class ClickListener implements ActionListener
    {
        public ClickListener()
        { 
        }
        
        public void actionPerformed(ActionEvent event)
        {
            if (event.getActionCommand().equals("Select Color"))
            {
                canvas.pickColor();
                System.out.println("Select Color");
                currColor = canvas.getColor();
                colorSquare.setBackground(currColor);
            }
            
            else if (event.getActionCommand().equals("Add Circle"))
            {
                canvas.addCircle();
                System.out.println("Add Circle");
            }
            
            else if (event.getActionCommand().equals("Add Rectangle"))
            {
                canvas.addSquare();
                System.out.println("Add Rectangle");
            }
            
            else
            {
                System.out.println("error");
            }
            canvas.repaint();
        }
    }
    
}
