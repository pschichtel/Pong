package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.collision.Face;
import de.cubeinfection.pong.entity.shape.Shape;
import de.cubeinfection.pong.position.Vector2;
import de.cubeinfection.pong.world.World;

import java.awt.Graphics2D;

public abstract class Entity
{
    private World world;
    private Vector2 position = null;
    private boolean valid = true;
    private Vector2 velocity = null;
    private Entity parent = null;
    private Shape shape = null;

    public void invalidate()
    {
        this.valid = false;
    }

    public World getWorld()
    {
        return this.world;
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public Entity getParent()
    {
        return this.parent;
    }

    public void setParent(Entity parent)
    {
        this.parent = parent;
    }

    public Shape getShape()
    {
        return this.shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    public boolean isValid()
    {
        return this.valid;
    }

    public Vector2 getPosition()
    {
        return this.position;
    }

    public void setPosition(Vector2 vec)
    {
        this.position = vec;
    }

    public Vector2 getVelocity()
    {
        return this.velocity;
    }

    public void setVelocity(Vector2 vec)
    {
        this.velocity = vec;
    }

    public void onCollide(Entity entity)
    {}
    
    public boolean collideWith(Entity entity)
    {
        return true;
    }

    protected Face leftWorld()
    {
        if (this.getPosition().getRoundedX() < 0) return Face.LEFT;
        if (this.getPosition().getRoundedY() < 0) return Face.TOP;
        if (this.getPosition().getRoundedX() + this.getShape().getWidth() > this.getWorld().getWidth()) return Face.RIGHT;
        if (this.getPosition().getRoundedY() + this.getShape().getHeight() > this.getWorld().getHeight()) return Face.BOTTOM;

        return null;
    }

    public void tick()
    {
        this.getPosition().add(this.getVelocity());
        Face face = this.leftWorld();
        if (face != null)
        {
            this.onWorldLeft(face);
        }
    }

    public void onWorldLeft(Face face)
    {}

    public abstract int getZIndex();

    public void draw(Graphics2D g)
    {
        final Shape shape = this.getShape();
        if (shape != null)
        {
            shape.draw(this.getPosition(), g);
        }
    }
}
