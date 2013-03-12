package de.cubeinfection.pong.world;

import java.awt.Color;
import java.awt.Graphics2D;

public class PongField extends World
{
    public PongField(int width, int height)
    {
        super(width, height);
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.draw(g);
    }
}
