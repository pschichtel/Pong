package de.cubeinfection.pong;

import de.cubeinfection.pong.entity.Ball;
import de.cubeinfection.pong.entity.Paddle;
import de.cubeinfection.pong.position.Vector2;
import de.cubeinfection.pong.world.PongField;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class Game extends JPanel
{
    private boolean running;
    private int     targetFps;
    private final PongField field;

    public Game(int width, int height, int targetFps)
    {
        super(true);
        this.setSize(width, height);
        this.running = false;
        this.targetFps = targetFps;
        this.field = new PongField(this.getWidth(), this.getHeight());
    }

    public void start()
    {
        if (this.running)
        {
            throw new IllegalStateException("This game is already running!");
        }

        // spawn entities
        this.field.addEntity(new Ball(20));
        this.field.addEntity(new Paddle(new Vector2(20, 20), 10, 30));
        this.field.addEntity(new Paddle(new Vector2(this.getWidth() - 30, this.getHeight() - 50), 10, 30));

        this.running = true;
        final long sleepTime = Math.round(1000d / (double)this.targetFps);

        try
        {
            while (this.running)
            {
                long time = System.currentTimeMillis();
                this.repaint();
                Thread.sleep(sleepTime - ((System.currentTimeMillis() - time) % sleepTime));
            }
        }
        catch (InterruptedException ignored)
        {}
        this.running = false;
    }

    public void stop()
    {
        this.running = false;
        this.field.removeEntities();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (!(g instanceof Graphics2D)) return;

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        this.field.tick();
        this.field.draw(g2);
    }
}
