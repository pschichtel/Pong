package de.cubeinfection.pong.entity.form;

import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public class Circle implements Form
{
    final public float r;

    public Circle(float r)
    {
        this.r = r;
    }

    @Override
    public void draw(Vector2 pos, Graphics g)
    {
        final int r = Math.round(this.r);
        g.drawOval(pos.getRoundedX() - r, pos.getRoundedY() - r, r * 2, r * 2);
    }
}
