package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.form.Rectangle;
import de.cubeinfection.pong.position.Vector2;

public class Paddle extends Entity
{
    public Paddle(Vector2 pos, float width, float height)
    {
        this.setPosition(pos);
        this.setVelocity(new Vector2(0, 1));
        this.setForm(new Rectangle(width, height));
    }

    @Override
    public void tick()
    {

    }
}
