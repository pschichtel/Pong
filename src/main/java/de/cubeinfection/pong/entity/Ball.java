package de.cubeinfection.pong.entity;

import de.cubeinfection.pong.entity.form.Circle;
import de.cubeinfection.pong.position.Vector2;

public class Ball extends Entity
{
    public Ball(int r)
    {
        this.setPosition(new Vector2(30, 30));
        this.setVelocity(new Vector2(1, 1));
        this.setForm(new Circle(30));
    }

    @Override
    public void tick()
    {
        this.getPosition().add(this.getVelocity());
    }
}
