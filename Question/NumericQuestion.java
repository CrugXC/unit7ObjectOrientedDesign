

public class NumericQuestion extends Question
{
    private double answer;
    
    public void setAnswer(double correctResponse)
    {
        answer = correctResponse;
    }
    
    public boolean checkAnswer(String response)
    {
        double doubResponse = Double.parseDouble(response);
        
        return Math.abs(doubResponse - answer) <= .01;
    }

}
