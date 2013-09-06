package game.events;

import game.Frame;
import game.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nerdysweat
 */
public class Button implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(Integer.parseInt(Frame.getInput().getText()) == Main.getAnswer()
                && Main.getTimeLeft() > 0)
        {
            Frame.getFeedback().setText("Correct, loading next question..");
            Main.addScore();
            Main.getQuestion();
            Main.updateQuestionText();
        }
        else if(Integer.parseInt(Frame.getInput().getText()) != Main.getAnswer()
                && Main.getTimeLeft() > 0)
        {
            Frame.getFeedback().setText("Incorrect, try again..");
        }
    }
    
}
