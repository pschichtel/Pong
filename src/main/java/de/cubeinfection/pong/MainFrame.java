package de.cubeinfection.pong;


import javax.swing.JFrame;
import java.awt.HeadlessException;

public class MainFrame extends JFrame
{
    private final Game game;

    public MainFrame(int width, int height, int targetFps) throws HeadlessException
    {
        this.game = new Game(width, height, targetFps);
        this.setSize(width, height);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Pong!");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(game);
        //this.setBackground(Color.MAGENTA);
    }

    public void startGame()
    {
        this.game.start();
    }

    @Override
    public void dispose()
    {
        this.game.stop();
        super.dispose();
    }
}
