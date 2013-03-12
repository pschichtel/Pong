package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.shape.Rectangle;
import de.cubeinfection.pong.position.Vector2;
import java.awt.Color;

public class Paddle extends Entity
{
    public Paddle(Vector2 pos, float width, float height)
    {
        this.setPosition(pos);
        this.setVelocity(new Vector2(5, 10));
        this.setShape(new Rectangle(width, height, Color.WHITE));
    }

    @Override
    public void tick()
    {

    }

    @Override
    public int getZIndex()
    {
        return 1;
    }
}
