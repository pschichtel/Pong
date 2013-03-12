package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;

import static java.lang.Math.round;

public class Circle extends AbstractShape
{
    public final float r;
    public final float d;

    public Circle(float r, Color color)
    {
        super(color);
        this.r = r;
        this.d = r * 2f;
    }

    @Override
    public float getWidth()
    {
        return this.d;
    }

    @Override
    public float getHeight()
    {
        return this.d;
    }

    @Override
    public void draw(Vector2 pos, Graphics2D g)
    {
        final int r = round(this.r);
        final int d = round(this.d);
        final int x = pos.getRoundedX() - r;
        final int y = pos.getRoundedY() - r;
        g.setColor(this.getColor());
        g.drawOval(x, y, d, d);
        if (this.getFilled())
        {
            g.fillOval(x, y, d, d);
        }
    }

    public float getRadius()
    {
        return this.r;
    }
}
