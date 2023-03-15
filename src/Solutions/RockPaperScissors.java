package Solutions;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends Applet implements ActionListener {
    private Button rockButton, paperButton, scissorsButton;
    private String playerChoice, computerChoice, result;
    private int playerScore, computerScore;

    public void init() {
        rockButton = new Button("Rock");
        paperButton = new Button("Paper");
        scissorsButton = new Button("Scissors");

        add(rockButton);
        add(paperButton);
        add(scissorsButton);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        playerScore = 0;
        computerScore = 0;
    }

    public void actionPerformed(ActionEvent e) {
        playerChoice = e.getActionCommand();

        String[] choices = { "Rock", "Paper", "Scissors" };
        Random rand = new Random();
        computerChoice = choices[rand.nextInt(choices.length)];

        // 判断胜负
        if (playerChoice.equals(computerChoice)) {
            result = "Tie";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors"))
                || (playerChoice.equals("Paper") && computerChoice.equals("Rock"))
                || (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "You win!";
            playerScore++;
        } else {
            result = "You lose!";
            computerScore++;
        }

        repaint();
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));

        g.setColor(Color.BLUE);
        g.drawString("Player: " + playerChoice, 50, 100);
        g.setColor(Color.RED);
        g.drawString("Computer: " + computerChoice, 50, 150);

        g.setColor(Color.BLACK);
        g.drawString(result, 50, 200);

        g.setColor(Color.GREEN);
        g.drawString("Player score: " + playerScore, 50, 250);
        g.setColor(Color.ORANGE);
        g.drawString("Computer score: " + computerScore, 50, 300);
    }
}
