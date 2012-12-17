package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.shape.Rectangle;
import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public class View extends Entity
{
    public View(float width, float height)
    {
        this.setPosition(new Vector2(0, 0));
        this.setVelocity(new Vector2(0, 0));
        this.setForm(new Rectangle(width, height, Color.BLACK));
    }

    @Override
    public void tick()
    {}

    @Override
    public int getZIndex()
    {
        return 0;
    }
}
