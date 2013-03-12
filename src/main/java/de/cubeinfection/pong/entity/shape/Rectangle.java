package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;
import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends AbstractShape
{
    private final float width;
    private final float height;

    public Rectangle(float width, float height, Color color)
    {
        super(color);
        this.width = width;
        this.height = height;
        this.setFilled(true);
    }

    @Override
    public float getWidth()
    {
        return this.width;
    }

    @Override
    public float getHeight()
    {
        return this.height;
    }

    @Override
    public void draw(Vector2 pos, Graphics2D g)
    {
        final int x = pos.getRoundedX();
        final int y = pos.getRoundedY();
        final int width = Math.round(this.width);
        final int height = Math.round(this.height);
        g.setColor(this.getColor());
        g.drawRect(x, y, width, height);
        if (this.getFilled())
        {
            g.fillRect(x, y, width, height);
        }
    }
}
