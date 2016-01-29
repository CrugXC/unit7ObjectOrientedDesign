import java.util.Scanner;
public class FillinQuestion extends Question
{
    
   public void setText(String questionText)
   {
       Scanner s1 = new Scanner(questionText);
       
       s1.useDelimiter("_");
       
       String question = s1.next();
       String answer = s1.next();
       
       question += "____________" + s1.next();
       
       super.setText(question);
       setAnswer(answer);
   }

}
