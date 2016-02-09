import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.*;
public class ClickListener implements ActionListener
{
    private int count;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private String soundName;
    public ClickListener()
    {
        count = 0;
        soundName = "Cena.wav";    
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch(Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
    
    public void actionPerformed(ActionEvent event)
    {
            count += 1;
            
            if (count == 1)
            {
                System.out.println("Hi David");
            }
            
            else
            {
                System.out.println("David stop clicking me!");
                
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
