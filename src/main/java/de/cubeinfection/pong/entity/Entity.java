package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.form.Form;
import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public abstract class Entity
{
    private Vector2 position = null;
    private boolean valid = true;
    private Vector2 velocity = null;
    private Entity parent = null;
    private Form form = null;

    public void invalidate()
    {
        this.valid = false;
    }

    public Entity getParent()
    {
        return parent;
    }

    public void setParent(Entity parent)
    {
        this.parent = parent;
    }

    public Form getForm()
    {
        return form;
    }

    public void setForm(Form form)
    {
        this.form = form;
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

    public abstract void tick();

    public void draw(Graphics g)
    {
        final Form form = this.getForm();
        if (form != null)
        {
            form.draw(this.getPosition(), g);
        }
    }
}
