package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.shape.Circle;
import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public class Ball extends Entity
{
    public Ball(int r)
    {
        this.setPosition(new Vector2(30, 30));
        this.setVelocity(new Vector2(1, 1));
        this.setForm(new Circle(30, Color.WHITE));
    }

    @Override
    public void onCollide(Entity entity)
    {

    }

    @Override
    public void tick()
    {
        this.getPosition().add(this.getVelocity());
    }

    @Override
    public int getZIndex()
    {
        return 1;
    }
}
