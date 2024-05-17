package pacman.mainPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final Thread thread = new Thread(this);
    private final JLabel scoreLabel;
    private final PacmanPanel pacmanPanel;

    public GamePanel(PacmanPanel pacmanPanel, int displayHeight) {
        this.pacmanPanel = pacmanPanel;
        thread.start();

        setLayout(new BorderLayout());
        scoreLabel = new JLabel("0", SwingConstants.CENTER);

        JPanel displayPanel = displayPanelCreation(displayHeight);

        this.add(displayPanel, BorderLayout.NORTH);
        this.add(pacmanPanel, BorderLayout.CENTER);
    }

    @Override
    public void run() {
        while (thread != null) {


            pacmanPanel.updatePacman();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            scoreLabel.setText(String.valueOf(pacmanPanel.getSCORE()));
            repaint();
        }
    }

    private JPanel displayPanelCreation(int displayHeight) {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridLayout(2, 1));
        displayPanel.setBackground(Color.BLACK);
        displayPanel.setPreferredSize(new Dimension(getWidth(), displayHeight));
        Border border = BorderFactory.createLineBorder(Color.BLUE, 4);
        displayPanel.setBorder(border);

        Font pacFont = new Font("Pac-Font", Font.BOLD, displayHeight / 2);

        JLabel scoreText = new JLabel("SCORE:");
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);
        scoreText.setFont(pacFont);
        scoreText.setForeground(Color.WHITE);

        scoreLabel.setFont(pacFont);
        scoreLabel.setForeground(Color.WHITE);

        displayPanel.add(scoreText, BorderLayout.CENTER);
        displayPanel.add(scoreLabel, BorderLayout.SOUTH);
        return displayPanel;
    }
}
