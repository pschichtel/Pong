package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.collision.Face;
import de.cubeinfection.pong.entity.shape.Circle;
import de.cubeinfection.pong.position.Vector2;

import java.awt.Color;

public class Ball extends Entity
{
    public Ball(float r)
    {
        this.setPosition(new Vector2(30, 30));
        this.setVelocity(new Vector2(12, 15));
        this.setShape(new Circle(r, Color.RED));
    }

    @Override
    public void onCollide(Entity entity)
    {

    }

    @Override
    public void onWorldLeft(Face face)
    {
        Vector2 v = this.getVelocity();
        switch (face)
        {
            case TOP:
            case BOTTOM:
                v = new Vector2(v.getX(), v.getY() * -1f);
                break;
            case LEFT:
            case RIGHT:
                v = new Vector2(v.getX() * -1f, v.getY());
                break;
        }
        this.setVelocity(v);
    }

    @Override
    public int getZIndex()
    {
        return 1;
    }
}
