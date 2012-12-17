package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public class Rectangle extends AbstractShape
{
    private final float width;
    private final float height;
    private boolean filled;
    private Color color;

    public Rectangle(float width, float height, Color color)
    {
        super(color);
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = true;
    }

    @Override
    public void draw(Vector2 pos, Graphics g)
    {
        final int x = pos.getRoundedX();
        final int y = pos.getRoundedY();
        final int width = Math.round(this.width);
        final int height = Math.round(this.height);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
        if (this.getFilled())
        {
            g.fillRect(x, y, width, height);
        }
    }
}
