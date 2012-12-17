package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;

import java.awt.*;

public interface Shape
{
    public void setFilled(boolean filled);
    public boolean getFilled();
    public void draw(Vector2 pos, Graphics g);
}
