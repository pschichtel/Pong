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
        g.setBackground(Color.MAGENTA);
        g.setColor(Color.MAGENTA);
        g.drawString("ABC", 30, 30);
        super.draw(g);
    }
}
