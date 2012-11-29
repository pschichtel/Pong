package de.cubeinfection.pong;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private final Game game;

    public MainFrame(int width, int height, int targetFps) throws HeadlessException
    {
        this.game = new Game(targetFps);
        this.setSize(width, height);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Pong!");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(game);
    }

    public void startGame()
    {
        this.game.start();
    }
}
