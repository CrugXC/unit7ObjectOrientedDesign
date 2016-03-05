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
    //Color currColor   Active Color
    private Color currColor;
    
    //DrawingPanel canvas   Allows the canvas to be edited via methods
    private DrawingPanel canvas;
    
    //JPanel colorSquare    Shows active color
    private JPanel colorSquare;
    
    //JButton colorSelect   pulls up JColorChooser to select a color
    //JButton addCircle     calls canvas method to add circle
    //JButton addRectangle  calls canvas method to add rectangle
    private JButton colorSelect;
    private JButton addCircle;
    private JButton addSquare;
    public ControlPanel(DrawingPanel canvas)
    {
        /* Creates colorSelect */
        colorSelect = new JButton("Select Color");
        colorSelect.setPreferredSize(new Dimension(150, 50));
        this.add(colorSelect);
        
        //gets current color
        currColor = canvas.getColor();
        
        //Initializes colorSquare and sets color to currColor
        colorSquare = new JPanel();
        colorSquare.setBackground(currColor);
        colorSquare.setPreferredSize(new Dimension(50, 50));
        this.add(colorSquare);
        
        //Initializes addCircle button
        addCircle = new JButton("Add Circle");
        addCircle.setPreferredSize(new Dimension(150, 50));
        this.add(addCircle);
        
        //Initializes addRectangle Button
        addSquare = new JButton("Add Square");
        addSquare.setPreferredSize(new Dimension(150, 50));
        this.add(addSquare);
        
        
        /* Adds ClickListener to each button */
        ClickListener listener = new ClickListener();
        colorSelect.addActionListener(listener);
        
        addCircle.addActionListener(listener);
        
        addSquare.addActionListener(listener);
        
        
        this.canvas = canvas;
    }

    public class ClickListener implements ActionListener
    {
        public ClickListener()
        { 
        }
        
        public void actionPerformed(ActionEvent event)
        {
            //Determines which button was clicked and runs block
            if (event.getActionCommand().equals("Select Color"))
            {
                //Changes color and updates colorSquare
                canvas.pickColor();
                currColor = canvas.getColor();
                colorSquare.setBackground(currColor);
            }
            
            else if (event.getActionCommand().equals("Add Circle"))
            {
                //Runs addCircle() on canvas
                canvas.addCircle();
            }
            
            else if (event.getActionCommand().equals("Add Square"))
            {
                //Runs addSquare() on canvas
                canvas.addSquare();
            }
            
            else
            {
                //Double checking error
                System.out.println("error");
            }
            
            //Updates canvas
            canvas.repaint();
        }
    }
    
}
