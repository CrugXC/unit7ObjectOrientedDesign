import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClickListener implements ActionListener
{
    private int count;
    
    public ClickListener()
    {
        count = 0;
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
            
            String soundName = "yourSound.wav";    
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
    }
}
