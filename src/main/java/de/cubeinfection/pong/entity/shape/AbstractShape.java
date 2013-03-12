package de.cubeinfection.pong.entity.shape;

import java.awt.*;

public abstract class AbstractShape implements Shape
{
    private Color color;
    private boolean filled;

    public AbstractShape(Color color)
    {
        this.color = color;
        this.filled = true;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    @Override
    public void setFilled(boolean filled)
    {
        this.filled = true;
    }

    @Override
    public boolean getFilled()
    {
        return this.filled;
    }
}
