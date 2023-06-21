import javax.swing.*;

public class Game {
    private GameGUI gameGUI;

    public Game() {
        gameGUI = new GameGUI();
    }

    public void start() {
        gameGUI.initialize();
    }
}

