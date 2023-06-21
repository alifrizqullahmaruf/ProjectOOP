import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameGUI extends JPanel {
    private JPanel backgroundPanel;
    private JLabel backgroundLabel;
    private Bush[] bush;
    private JLabel[] bushLabels;
    private Dog dog;
    private Pig pig;
    private JLabel timeLabel;
    private Timer gameTimer;
    private int timeRemaining;

    public GameGUI() {
        setLayout(new FlowLayout());

        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(null);
        backgroundPanel.setPreferredSize(new Dimension(1280, 832));

        ImageIcon bgImage = new ImageIcon("Assets/bg.png");
        backgroundLabel = new JLabel(bgImage);
        backgroundLabel.setBounds(0, 0, 1280, 832);
        backgroundPanel.add(backgroundLabel);

        add(backgroundLabel);

        bushLabels = new JLabel[7];
        int[] bushXCoordinates = {27, 370, 690, 1040, 540, 400, 670};
        int[] bushYCoordinates = {420, 500, 540, 540, 60, 250, 210};

        ImageIcon bushImage = new ImageIcon("Assets/bush.png");
        for (int i = 0; i < bushLabels.length; i++) {
            bushLabels[i] = new JLabel(bushImage);
            bushLabels[i].setBounds(bushXCoordinates[i], bushYCoordinates[i], bushImage.getIconWidth(), bushImage.getIconHeight());
            backgroundLabel.add(bushLabels[i]);
        }

        dog = new Dog(bushLabels);
        backgroundLabel.add(dog.getAnimalLabel());


        pig = new Pig(bushLabels);
        backgroundLabel.add(pig.getAnimalLabel());

        timeLabel = new JLabel("Time: 30");
        timeLabel.setBounds(20, 20, 100, 20);
        backgroundPanel.add(timeLabel);

        add(backgroundPanel, BorderLayout.CENTER);

    }

    public void initialize() {
        setVisible(true);
        startGame();
        dog.getAnimalLabel().setVisible(true);
        pig.getAnimalLabel().setVisible(true);
        dog.moveAnimalToRandomBush();
        pig.moveAnimalToRandomBush();
    }

    public void startGame() {
        timeRemaining = 30;
        gameTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                timeLabel.setText("Time: " + timeRemaining);

                if (timeRemaining == 0) {
                    endGame();
                }
            }
        });
        gameTimer.start();
    }



    public void endGame() {
        gameTimer.stop();
        JOptionPane.showMessageDialog(this, "Game Over!");
    }
}
