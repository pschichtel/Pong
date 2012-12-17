package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

import static java.lang.Math.round;

public class Circle extends AbstractShape
{
    final public float r;

    public Circle(float r, Color color)
    {
        super(color);
        this.r = r;
    }

    @Override
    public void draw(Vector2 pos, Graphics g)
    {
        final int r = round(this.r);
        final int d = r * 2;
        final int x = pos.getRoundedX() - r;
        final int y = pos.getRoundedY() - r;
        g.setColor(Color.WHITE);
        g.drawOval(x, y, d, d);
        if (this.getFilled())
        {
            g.fillOval(x, y, d, d);
        }
    }
}
