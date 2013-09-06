package game;

import game.events.Button;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nerdysweat
 */
public class Frame extends JFrame
{
    private static JTextField input;
    private JButton submit;
    private static JLabel question, time, feedback;
    
    public Frame()
    {
        this.setSize(400, 300);
        this.setTitle("Multiplication Frustration || By Michael");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        init();
        
        this.setVisible(true);
    }
    
    private void init()
    {
        initComponents();
        initLayout();
    }
    
    private void initComponents()
    {
        input = new JTextField("");
        input.setPreferredSize(new Dimension(20, 100));
        
        submit = new JButton("Submit");
        submit.addActionListener(new Button());
        
        question = new JLabel("What is: " + Main.getQuestion());
        
        time = new JLabel("Time left: " + Main.getTimeLeft());
        
        feedback = new JLabel("Welcome to Multiplication Frustration!");
    }
    
    private void initLayout()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(feedback, BorderLayout.NORTH);
        topPanel.add(question, BorderLayout.SOUTH);
        
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(input, BorderLayout.NORTH);
        middlePanel.add(submit, BorderLayout.SOUTH);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(time, BorderLayout.SOUTH);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(middlePanel, BorderLayout.CENTER);
        panel.add(bottomPanel,BorderLayout.SOUTH);
        
        this.add(panel);
    }
    
    public JLabel getQuestion()
    {
        return question;
    }
    
    public static JLabel getFeedback()
    {
        return feedback;
    }
    
    public JLabel getTime()
    {
        return time;
    }
    
    public static JTextField getInput()
    {
        return input;
    }
}
