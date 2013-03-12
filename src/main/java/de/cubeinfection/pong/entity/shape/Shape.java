package de.cubeinfection.pong.entity.shape;

import de.cubeinfection.pong.position.Vector2;

import java.awt.Graphics2D;

public interface Shape
{
    void setFilled(boolean filled);
    boolean getFilled();
    void draw(Vector2 pos, Graphics2D g);
    float getWidth();
    float getHeight();
}
