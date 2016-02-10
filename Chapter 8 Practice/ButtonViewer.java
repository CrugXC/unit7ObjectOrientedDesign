import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.*;

public class ButtonViewer
{
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 300;
    
    private JFrame frame;
    private JButton button;
    private JButton button2;
    private JPanel soundBoard;
    private JLabel currSong;
    
    public ButtonViewer()
    {
        frame = new JFrame();
        soundBoard = new JPanel();
        
        button = new JButton("My Time is Now");
        button.setPreferredSize(new Dimension(300, 50));
        soundBoard.add(button);
        
        button2 = new JButton("JOHN CENA");
        button2.setPreferredSize(new Dimension(300, 50));
        soundBoard.add(button2);
        
        currSong = new JLabel();
        soundBoard.add(currSong);
        
        frame.add(soundBoard);
        
        ClickListener listener = new ClickListener("Cena.wav");
        button.addActionListener(listener);
        
        ClickListener listener2 = new ClickListener("Cena.wav");
        button.addActionListener(listener2);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        ButtonViewer view = new ButtonViewer();
    }
    
    public class ClickListener implements ActionListener
    {
        private int count;
        private Clip clip;
        private AudioInputStream audioInputStream;
        private String soundName;
        public ClickListener(String fileName)
        {
            count = 0;
            soundName = fileName;    
            try
            {
                audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                clip = AudioSystem.getClip();
            }
            catch(Exception exc)
            {
                exc.printStackTrace(System.out);
            }
        }
        
        public void actionPerformed(ActionEvent event)
        {       
            try
            {
                clip.open(audioInputStream);
                clip.start();
            }
            catch(Exception exc)
            {
                clip.close();
            }
        }
    }
}

