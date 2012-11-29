package de.cubeinfection.pong.entity.form;

import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public class Rectangle implements Form
{
    private final float a;
    private final float b;

    public Rectangle(float a, float b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(Vector2 pos, Graphics g)
    {
        g.drawRect(pos.getRoundedX(), pos.getRoundedY(), Math.round(a), Math.round(b));
    }
}
