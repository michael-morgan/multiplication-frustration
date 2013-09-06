package game;

import java.util.Random;

/**
 *
 * @author nerdysweat
 */
public class Main implements Runnable
{
    private boolean run;
    private Thread timer;
    private static Frame frame;
    private static int timeLeft, numOne, numTwo, score;
    private static String question;
    
    public Main()
    {
        init();
    }
    
    private void init()
    {
        initVariables();
    }
    
    private void initVariables()
    {
        timeLeft = 60;
        question = "";
        numOne = 0;
        numTwo = 0;
        score = 0;
        
        frame = new Frame();
        
        run = true;
        
        timer = new Thread(this);
        timer.start();
    }
    
    
    @Override
    public void run()
    {
        while(run)
        {
            try
            {
                if(timeLeft > 0)
                {
                    timeLeft--;
                    updateTimeText();
                }
                else
                {
                   run = false;
                   Frame.getFeedback().setText("Your score: " + score);
                }
                
                timer.sleep(1000);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static int getTimeLeft()
    {
        return timeLeft;
    }
    
    public static String getQuestion()
    {
        Random random = new Random();
        numOne = random.nextInt(12);
        numTwo = random.nextInt(12);
        
        question = numOne + " * " + numTwo;
        
        return question;
    }
    
    public static int getAnswer()
    {
        return numOne * numTwo;
    }
    
    public static int getScore()
    {
        return score;
    }
    
    public static int addScore()
    {
        return score++;
    }
    
    public static void updateQuestionText()
    {
        frame.getQuestion().setText("What is: " + question);
    }
    
    public static void updateTimeText()
    {
        frame.getTime().setText("Time left: " + timeLeft);
    }
    
    public static void main(String[] args)
    {
        new Main();
    }
    
}
