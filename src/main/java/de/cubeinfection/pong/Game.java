package de.cubeinfection.pong;

import de.cubeinfection.pong.entity.Ball;
import de.cubeinfection.pong.entity.Entity;
import de.cubeinfection.pong.entity.Paddle;
import de.cubeinfection.pong.entity.View;
import de.cubeinfection.pong.position.Vector2;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Game extends JPanel
{
    private boolean running;
    private int     targetFps;
    private final Queue<Entity> entities;

    public Game(int targetFps)
    {
        super(true);
        this.running = false;
        this.targetFps = targetFps;
        this.entities = new PriorityQueue<Entity>(4, new Comparator<Entity>()
        {
            @Override
            public int compare(Entity e1, Entity e2) {
                return 0;
            }
        });
    }

    public void start()
    {
        this.entities.add(new View(this.getWidth(), this.getHeight()));
        this.entities.add(new Ball(20));
        this.entities.add(new Paddle(new Vector2(20, 20), 10, 30));
        this.entities.add(new Paddle(new Vector2(this.getWidth() - 30, this.getHeight() - 50), 10, 30));

        if (this.running)
        {
            throw new IllegalStateException("This game is already running!");
        }
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
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Iterator<Entity> iter = this.entities.iterator();
        Entity entity;
        while (iter.hasNext())
        {
            entity = iter.next();
            if (!entity.isValid())
            {
                iter.remove();
                continue;
            }
            entity.tick();
            entity.draw(g);
        }
    }
}
