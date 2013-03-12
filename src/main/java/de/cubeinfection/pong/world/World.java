package de.cubeinfection.pong.world;

import de.cubeinfection.pong.entity.Entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public abstract class World
{
    private final int width;
    private final int height;
    private final Queue<Entity> entities;
    private final List<Entity> newEntities;

    public World(int width, int height)
    {
        this.entities = new PriorityQueue<Entity>(4, new Comparator<Entity>(){
            @Override
            public int compare(Entity a, Entity b)
            {
                return a.getZIndex() - b.getZIndex();
            }
        });
        this.newEntities = new ArrayList<Entity>();
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public void addEntity(Entity entity)
    {
        this.newEntities.add(entity);
    }

    public void removeEntities()
    {
        Iterator<Entity> it = this.entities.iterator();
        while (it.hasNext())
        {
            it.next().setWorld(null);
            it.remove();
        }
    }

    public void tick()
    {
        Entity entity;
        Iterator<Entity> it;

        if (!this.newEntities.isEmpty())
        {
            it = this.newEntities.iterator();
            while (it.hasNext())
            {
                entity = it.next();
                this.entities.add(entity);
                entity.setWorld(this);
                it.remove();
            }
        }

        it = this.entities.iterator();
        while (it.hasNext())
        {
            entity = it.next();
            entity.tick();
            if (!entity.isValid())
            {
                it.remove();
            }
        }
    }

    protected void doCollisions()
    {
        Iterator<Entity> it = this.entities.iterator();
        Entity a, b;
        if (it.hasNext())
        {
            a = it.next();
            while (it.hasNext())
            {
                b = it.next();
                a.collideWith(b);
                a = b;
            }
        }
    }

    public void draw(Graphics2D g)
    {
        Iterator<Entity> it = this.entities.iterator();
        while (it.hasNext())
        {
            it.next().draw(g);
        }
    }
}
